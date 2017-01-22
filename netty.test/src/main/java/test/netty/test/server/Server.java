package test.netty.test.server;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.netty.test.object.processor.ObjectDecoder;
import test.netty.test.object.processor.ObjectEncoder;
import test.netty.test.server.config.ServerConfig;


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
//		bs.childHandler(new HelloServerInitializer());
		bs.childHandler(new ChannelInitializer<SocketChannel>(){
			@Override
			protected void initChannel(SocketChannel channel) throws Exception {
				System.out.println("ChannelInitializer.initChannel");
				ChannelPipeline pipeline = channel.pipeline();
				pipeline.addLast("decoder", new ObjectDecoder());
				pipeline.addLast("encoder", new ObjectEncoder());
				pipeline.addLast("handler", new PersonServerHandler());
			}
		});
		
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
