/**
 * @author User
 * Java NIO 由以下几个核心部分组成：
 * Channels
 * Buffers
 * Selectors
 * 
 * Channel
 * 基本上，所有的IO在NIO中都从一个Channel开始。Channel有点象流， 但又有些不同：
 * 1.既可以从Channel(通道)中读取数据到Buffer（缓冲区），又可以写数据到通道。但流的读写通常是单向的。
 * 2.通道可以异步地读写。
 * 3.通道中的数据总是要先读到一个Buffer，或者总是要从一个Buffer中写入。（从通道读取数据到缓冲区，从缓冲区写入数据到通道。）
 *  
 * JAVA NIO中的一些主要Channel的实现：
 * FileChannel 从文件中读写数据
 * DatagramChannel 能通过UDP读写网络中的数据
 * SocketChannel 能通过TCP读写网络中的数据
 * ServerSocketChannel 可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。
 * 
 * 
 * 
 * Buffer
 * 
 * Java NIO里关键的Buffer实现：
 * ByteBuffer
 * CharBuffer
 * DoubleBuffer
 * FloatBuffer
 * IntBuffer
 * LongBuffer
 * ShortBuffer
 * MappedByteBuffer 用于表示内存映射文件
 * 
 * Selector
 * Selector允许单线程处理多个 Channel。如果你的应用打开了多个连接（通道），
 * 但每个连接的流量都很低，使用Selector就会很方便。
 * 要使用Selector，得向Selector注册Channel，然后调用它的select()方法。
 * 这个方法会一直阻塞到某个注册的通道有事件就绪。
 * 一旦这个方法返回，线程就可以处理这些事件，事件的例子有如新连接进来，数据接收等。
 * 
 * 
 *
 */
package com.denlaku.nio;