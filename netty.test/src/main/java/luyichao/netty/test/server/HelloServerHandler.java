package luyichao.netty.test.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class HelloServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg)
			throws Exception {
		// TODO Auto-generated method stub
		byte[] data = new byte[msg.readableBytes()];
		msg.readBytes(data);
		System.out.println(ctx.channel().remoteAddress() + " Say : " + data);
		for (byte d : data) {
			System.out.println(d);
		}
		// 返回客户端消息 - 我已经接收到了你的消息
        ctx.writeAndFlush("Received your message !\n");
	}

	@Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("RamoteAddress : " + ctx.channel().remoteAddress()
                + " active !");

//        ctx.writeAndFlush("Welcome to "
//                + InetAddress.getLocalHost().getHostName() + " service!\n");

        super.channelActive(ctx);
    }
}
