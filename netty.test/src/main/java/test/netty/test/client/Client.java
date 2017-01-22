package test.netty.test.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.netty.test.client.config.ClientConfig;
import test.netty.test.object.processor.ObjectDecoder;
import test.netty.test.object.processor.ObjectEncoder;
import test.netty.test.server.PersonServerHandler;

public class Client {
	
	private static final Logger log = LoggerFactory.getLogger("client");

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventLoopGroup group = new NioEventLoopGroup();
		Bootstrap boot = new Bootstrap();
//		boot.group(group).channel(NioSocketChannel.class).handler(new HelloClientHandler());
		boot.group(group).channel(NioSocketChannel.class).handler(
				new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel channel) throws Exception {
							System.out.println("ChannelInitializer.initChannel");
							ChannelPipeline pipeline = channel.pipeline();
							pipeline.addLast("decoder", new ObjectDecoder());
							pipeline.addLast("encoder", new ObjectEncoder());
							pipeline.addLast("handler", new PersonClientHandler());
						}
        });
		
		try {
			// 连接服务端
	        Channel ch = boot.connect(ClientConfig.HOST, ClientConfig.PORT).sync().channel();

	        // 控制台输入
	            /*
	             * 向服务端发送在控制台输入的文本 并用"\r\n"结尾 之所以用\r\n结尾 是因为我们在handler中添加了
	             * DelimiterBasedFrameDecoder 帧解码。
	             * 这个解码器是一个根据\n符号位分隔符的解码器。所以每条消息的最后必须加上\n否则无法识别和解码
	             */
	        
//	        ChannelFuture result = ch.writeAndFlush("Hello world test" + "\r\n");
//	        log.info("result : " + result.isDone());
		} catch(Exception e) {
			System.err.println(e);
			log.error("exception happened!", e);
		} finally {
			try {
//				Thread.sleep(10000);
			} catch (Exception e) {
				log.error("sleep exception happened!", e);
			} finally {
				
			}
			
			group.shutdownGracefully();
		}
		
	}

}
