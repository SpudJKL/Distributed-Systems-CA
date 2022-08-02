package ds.service1;

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
    comments = "Source: SmartLighting.proto")
public final class SmartLightingGrpc {

  private SmartLightingGrpc() {}

  public static final String SERVICE_NAME = "service1.SmartLighting";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.service1.lightRequest,
      ds.service1.lightResponse> getSmartLightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "smartLights",
      requestType = ds.service1.lightRequest.class,
      responseType = ds.service1.lightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service1.lightRequest,
      ds.service1.lightResponse> getSmartLightsMethod() {
    io.grpc.MethodDescriptor<ds.service1.lightRequest, ds.service1.lightResponse> getSmartLightsMethod;
    if ((getSmartLightsMethod = SmartLightingGrpc.getSmartLightsMethod) == null) {
      synchronized (SmartLightingGrpc.class) {
        if ((getSmartLightsMethod = SmartLightingGrpc.getSmartLightsMethod) == null) {
          SmartLightingGrpc.getSmartLightsMethod = getSmartLightsMethod = 
              io.grpc.MethodDescriptor.<ds.service1.lightRequest, ds.service1.lightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service1.SmartLighting", "smartLights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.lightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.lightResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartLightingMethodDescriptorSupplier("smartLights"))
                  .build();
          }
        }
     }
     return getSmartLightsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service1.autoLightsRequest,
      ds.service1.autoLightsResponse> getAutoLightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "autoLights",
      requestType = ds.service1.autoLightsRequest.class,
      responseType = ds.service1.autoLightsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.service1.autoLightsRequest,
      ds.service1.autoLightsResponse> getAutoLightsMethod() {
    io.grpc.MethodDescriptor<ds.service1.autoLightsRequest, ds.service1.autoLightsResponse> getAutoLightsMethod;
    if ((getAutoLightsMethod = SmartLightingGrpc.getAutoLightsMethod) == null) {
      synchronized (SmartLightingGrpc.class) {
        if ((getAutoLightsMethod = SmartLightingGrpc.getAutoLightsMethod) == null) {
          SmartLightingGrpc.getAutoLightsMethod = getAutoLightsMethod = 
              io.grpc.MethodDescriptor.<ds.service1.autoLightsRequest, ds.service1.autoLightsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service1.SmartLighting", "autoLights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.autoLightsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.autoLightsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartLightingMethodDescriptorSupplier("autoLights"))
                  .build();
          }
        }
     }
     return getAutoLightsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service1.lightMusicRequest,
      ds.service1.lightMusicResponse> getLightMusicMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lightMusic",
      requestType = ds.service1.lightMusicRequest.class,
      responseType = ds.service1.lightMusicResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service1.lightMusicRequest,
      ds.service1.lightMusicResponse> getLightMusicMethod() {
    io.grpc.MethodDescriptor<ds.service1.lightMusicRequest, ds.service1.lightMusicResponse> getLightMusicMethod;
    if ((getLightMusicMethod = SmartLightingGrpc.getLightMusicMethod) == null) {
      synchronized (SmartLightingGrpc.class) {
        if ((getLightMusicMethod = SmartLightingGrpc.getLightMusicMethod) == null) {
          SmartLightingGrpc.getLightMusicMethod = getLightMusicMethod = 
              io.grpc.MethodDescriptor.<ds.service1.lightMusicRequest, ds.service1.lightMusicResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service1.SmartLighting", "lightMusic"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.lightMusicRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.lightMusicResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartLightingMethodDescriptorSupplier("lightMusic"))
                  .build();
          }
        }
     }
     return getLightMusicMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartLightingStub newStub(io.grpc.Channel channel) {
    return new SmartLightingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartLightingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SmartLightingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartLightingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SmartLightingFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class SmartLightingImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * bi-directional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.service1.lightRequest> smartLights(
        io.grpc.stub.StreamObserver<ds.service1.lightResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSmartLightsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void autoLights(ds.service1.autoLightsRequest request,
        io.grpc.stub.StreamObserver<ds.service1.autoLightsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAutoLightsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public void lightMusic(ds.service1.lightMusicRequest request,
        io.grpc.stub.StreamObserver<ds.service1.lightMusicResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLightMusicMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSmartLightsMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.service1.lightRequest,
                ds.service1.lightResponse>(
                  this, METHODID_SMART_LIGHTS)))
          .addMethod(
            getAutoLightsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.service1.autoLightsRequest,
                ds.service1.autoLightsResponse>(
                  this, METHODID_AUTO_LIGHTS)))
          .addMethod(
            getLightMusicMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.service1.lightMusicRequest,
                ds.service1.lightMusicResponse>(
                  this, METHODID_LIGHT_MUSIC)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SmartLightingStub extends io.grpc.stub.AbstractStub<SmartLightingStub> {
    private SmartLightingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartLightingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartLightingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartLightingStub(channel, callOptions);
    }

    /**
     * <pre>
     * bi-directional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.service1.lightRequest> smartLights(
        io.grpc.stub.StreamObserver<ds.service1.lightResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSmartLightsMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void autoLights(ds.service1.autoLightsRequest request,
        io.grpc.stub.StreamObserver<ds.service1.autoLightsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAutoLightsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public void lightMusic(ds.service1.lightMusicRequest request,
        io.grpc.stub.StreamObserver<ds.service1.lightMusicResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getLightMusicMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SmartLightingBlockingStub extends io.grpc.stub.AbstractStub<SmartLightingBlockingStub> {
    private SmartLightingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartLightingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartLightingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartLightingBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public ds.service1.autoLightsResponse autoLights(ds.service1.autoLightsRequest request) {
      return blockingUnaryCall(
          getChannel(), getAutoLightsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public java.util.Iterator<ds.service1.lightMusicResponse> lightMusic(
        ds.service1.lightMusicRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getLightMusicMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SmartLightingFutureStub extends io.grpc.stub.AbstractStub<SmartLightingFutureStub> {
    private SmartLightingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartLightingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartLightingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartLightingFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.service1.autoLightsResponse> autoLights(
        ds.service1.autoLightsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAutoLightsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AUTO_LIGHTS = 0;
  private static final int METHODID_LIGHT_MUSIC = 1;
  private static final int METHODID_SMART_LIGHTS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SmartLightingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SmartLightingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUTO_LIGHTS:
          serviceImpl.autoLights((ds.service1.autoLightsRequest) request,
              (io.grpc.stub.StreamObserver<ds.service1.autoLightsResponse>) responseObserver);
          break;
        case METHODID_LIGHT_MUSIC:
          serviceImpl.lightMusic((ds.service1.lightMusicRequest) request,
              (io.grpc.stub.StreamObserver<ds.service1.lightMusicResponse>) responseObserver);
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
        case METHODID_SMART_LIGHTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.smartLights(
              (io.grpc.stub.StreamObserver<ds.service1.lightResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SmartLightingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartLightingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.service1.Service1Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartLighting");
    }
  }

  private static final class SmartLightingFileDescriptorSupplier
      extends SmartLightingBaseDescriptorSupplier {
    SmartLightingFileDescriptorSupplier() {}
  }

  private static final class SmartLightingMethodDescriptorSupplier
      extends SmartLightingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SmartLightingMethodDescriptorSupplier(String methodName) {
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
      synchronized (SmartLightingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartLightingFileDescriptorSupplier())
              .addMethod(getSmartLightsMethod())
              .addMethod(getAutoLightsMethod())
              .addMethod(getLightMusicMethod())
              .build();
        }
      }
    }
    return result;
  }
}
