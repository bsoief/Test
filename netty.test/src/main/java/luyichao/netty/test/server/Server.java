package luyichao.netty.test.server;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import luyichao.netty.test.server.config.ServerConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 *
 */
public class Server {
	
	private static final Logger log = LoggerFactory.getLogger("server");
	
	public static void main(String[] args) throws Exception{
		log.debug("App.debug");
		log.info("App.info");
		log.warn("App.warn");
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		ServerBootstrap bs = new ServerBootstrap();
		bs.group(bossGroup, workerGroup);
		bs.channel(NioServerSocketChannel.class);
		bs.childHandler(new HelloServerInitializer());
		
		try {
			ChannelFuture cf = bs.bind(ServerConfig.PORT).sync();
			cf.channel().closeFuture().sync();
		} catch (Exception e) {
			log.error("exception happen", e);
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
