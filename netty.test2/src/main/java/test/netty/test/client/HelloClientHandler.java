package test.netty.test.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import test.netty.test.object.Person;

public class HelloClientHandler extends SimpleChannelInboundHandler<Object> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Server say : " + (msg instanceof Person));
		System.out.println("Server say : " + msg);
	}

	@Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client active ");
        final ByteBuf time = ctx.alloc().buffer(4); // (2)
//        int data = (int) (System.currentTimeMillis() / 1000L + 2208988800L);
//        System.out.println("data : " + data);
//        time.writeInt(data);
        // 写入字符串
        byte[] data = "a".getBytes();
        for (byte d : data) {
        	System.out.println(d);
        }

        final ChannelFuture f = ctx.writeAndFlush(data); // (3)
        f.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture future) {
                assert f == future;
                ctx.close();
            }
        }); // (4)
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client close ");
        super.channelInactive(ctx);
    }
}
