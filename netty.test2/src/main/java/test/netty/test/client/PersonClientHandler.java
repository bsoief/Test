package test.netty.test.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import test.netty.test.object.Person;

public class PersonClientHandler extends SimpleChannelInboundHandler<Person> {

	@Override
	protected void channelRead0(ChannelHandlerContext arg0, Person p)
			throws Exception {
		System.out.println("PersonClientHandler.channelRead0 : " + p.getId());
	}
	
	@Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client active ");
        final ByteBuf time = ctx.alloc().buffer(4); // (2)
//        int data = (int) (System.currentTimeMillis() / 1000L + 2208988800L);
//        System.out.println("data : " + data);
//        time.writeInt(data);
        // 写入字符串
//        byte[] data = "a".getBytes();
//        for (byte d : data) {
//        	System.out.println(d);
//        }
        
        // 写入对象
        Person p = new Person();
        p.setId("001");
        p.setName("test1");
        p.setAge(10);

        final ChannelFuture f = ctx.writeAndFlush(p); // (3)
        f.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture future) {
                assert f == future;
                ctx.close();
            }
        }); // (4)
        super.channelActive(ctx);
    }
}
