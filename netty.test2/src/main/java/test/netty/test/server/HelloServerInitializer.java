package test.netty.test.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
		// TODO Auto-generated method stub
		ChannelPipeline pipeline = channel.pipeline();
		

//        // 字符串解码 和 编码
//        pipeline.addLast("decoder", new StringDecoder());
        // 以("\n")为结尾分割的 解码器
//        pipeline.addLast(new LineBasedFrameDecoder(8192));
//        pipeline.addLast(new StringEncoder());

        // 自己的逻辑Handler
        pipeline.addLast("handler", new HelloServerHandler());
	}

}
