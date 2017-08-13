package test.netty.test.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import test.netty.test.object.Person;

public class PersonServerHandler extends SimpleChannelInboundHandler<Person> {

	@Override
	protected void channelRead0(ChannelHandlerContext arg0, Person p)
			throws Exception {
		System.out.println("PersonClientHandler.channelRead0 : " + p.getId());
	}
}
