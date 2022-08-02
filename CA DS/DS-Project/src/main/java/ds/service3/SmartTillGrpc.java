package ds.service3;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: SmartTill.proto")
public final class SmartTillGrpc {

  private SmartTillGrpc() {}

  public static final String SERVICE_NAME = "service3.SmartTill";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.service3.tillRequest,
      ds.service3.tillResponse> getSmartTillMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "smartTill",
      requestType = ds.service3.tillRequest.class,
      responseType = ds.service3.tillResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service3.tillRequest,
      ds.service3.tillResponse> getSmartTillMethod() {
    io.grpc.MethodDescriptor<ds.service3.tillRequest, ds.service3.tillResponse> getSmartTillMethod;
    if ((getSmartTillMethod = SmartTillGrpc.getSmartTillMethod) == null) {
      synchronized (SmartTillGrpc.class) {
        if ((getSmartTillMethod = SmartTillGrpc.getSmartTillMethod) == null) {
          SmartTillGrpc.getSmartTillMethod = getSmartTillMethod = 
              io.grpc.MethodDescriptor.<ds.service3.tillRequest, ds.service3.tillResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service3.SmartTill", "smartTill"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.tillRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.tillResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartTillMethodDescriptorSupplier("smartTill"))
                  .build();
          }
        }
     }
     return getSmartTillMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service3.seatRequest,
      ds.service3.seatResponse> getSeatManagerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "seatManager",
      requestType = ds.service3.seatRequest.class,
      responseType = ds.service3.seatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.service3.seatRequest,
      ds.service3.seatResponse> getSeatManagerMethod() {
    io.grpc.MethodDescriptor<ds.service3.seatRequest, ds.service3.seatResponse> getSeatManagerMethod;
    if ((getSeatManagerMethod = SmartTillGrpc.getSeatManagerMethod) == null) {
      synchronized (SmartTillGrpc.class) {
        if ((getSeatManagerMethod = SmartTillGrpc.getSeatManagerMethod) == null) {
          SmartTillGrpc.getSeatManagerMethod = getSeatManagerMethod = 
              io.grpc.MethodDescriptor.<ds.service3.seatRequest, ds.service3.seatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service3.SmartTill", "seatManager"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.seatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.seatResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartTillMethodDescriptorSupplier("seatManager"))
                  .build();
          }
        }
     }
     return getSeatManagerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartTillStub newStub(io.grpc.Channel channel) {
    return new SmartTillStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartTillBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SmartTillBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartTillFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SmartTillFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class SmartTillImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * bi-directional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.service3.tillRequest> smartTill(
        io.grpc.stub.StreamObserver<ds.service3.tillResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSmartTillMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void seatManager(ds.service3.seatRequest request,
        io.grpc.stub.StreamObserver<ds.service3.seatResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSeatManagerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSmartTillMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.service3.tillRequest,
                ds.service3.tillResponse>(
                  this, METHODID_SMART_TILL)))
          .addMethod(
            getSeatManagerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.service3.seatRequest,
                ds.service3.seatResponse>(
                  this, METHODID_SEAT_MANAGER)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SmartTillStub extends io.grpc.stub.AbstractStub<SmartTillStub> {
    private SmartTillStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartTillStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartTillStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartTillStub(channel, callOptions);
    }

    /**
     * <pre>
     * bi-directional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.service3.tillRequest> smartTill(
        io.grpc.stub.StreamObserver<ds.service3.tillResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSmartTillMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void seatManager(ds.service3.seatRequest request,
        io.grpc.stub.StreamObserver<ds.service3.seatResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSeatManagerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SmartTillBlockingStub extends io.grpc.stub.AbstractStub<SmartTillBlockingStub> {
    private SmartTillBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartTillBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartTillBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartTillBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public ds.service3.seatResponse seatManager(ds.service3.seatRequest request) {
      return blockingUnaryCall(
          getChannel(), getSeatManagerMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SmartTillFutureStub extends io.grpc.stub.AbstractStub<SmartTillFutureStub> {
    private SmartTillFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartTillFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartTillFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartTillFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.service3.seatResponse> seatManager(
        ds.service3.seatRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSeatManagerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEAT_MANAGER = 0;
  private static final int METHODID_SMART_TILL = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SmartTillImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SmartTillImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEAT_MANAGER:
          serviceImpl.seatManager((ds.service3.seatRequest) request,
              (io.grpc.stub.StreamObserver<ds.service3.seatResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SMART_TILL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.smartTill(
              (io.grpc.stub.StreamObserver<ds.service3.tillResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SmartTillBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartTillBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.service3.Service3Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartTill");
    }
  }

  private static final class SmartTillFileDescriptorSupplier
      extends SmartTillBaseDescriptorSupplier {
    SmartTillFileDescriptorSupplier() {}
  }

  private static final class SmartTillMethodDescriptorSupplier
      extends SmartTillBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SmartTillMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SmartTillGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartTillFileDescriptorSupplier())
              .addMethod(getSmartTillMethod())
              .addMethod(getSeatManagerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
