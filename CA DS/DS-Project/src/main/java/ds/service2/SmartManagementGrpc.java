package ds.service2;

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
    comments = "Source: SmartMangement.proto")
public final class SmartManagementGrpc {

  private SmartManagementGrpc() {}

  public static final String SERVICE_NAME = "service2.SmartManagement";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.service2.TableRequest,
      ds.service2.TableResponse> getSmartTableBookingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "smartTableBooking",
      requestType = ds.service2.TableRequest.class,
      responseType = ds.service2.TableResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.service2.TableRequest,
      ds.service2.TableResponse> getSmartTableBookingMethod() {
    io.grpc.MethodDescriptor<ds.service2.TableRequest, ds.service2.TableResponse> getSmartTableBookingMethod;
    if ((getSmartTableBookingMethod = SmartManagementGrpc.getSmartTableBookingMethod) == null) {
      synchronized (SmartManagementGrpc.class) {
        if ((getSmartTableBookingMethod = SmartManagementGrpc.getSmartTableBookingMethod) == null) {
          SmartManagementGrpc.getSmartTableBookingMethod = getSmartTableBookingMethod = 
              io.grpc.MethodDescriptor.<ds.service2.TableRequest, ds.service2.TableResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service2.SmartManagement", "smartTableBooking"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.TableRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.TableResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartManagementMethodDescriptorSupplier("smartTableBooking"))
                  .build();
          }
        }
     }
     return getSmartTableBookingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service2.qRequest,
      ds.service2.qResponse> getSmartQMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "smartQ",
      requestType = ds.service2.qRequest.class,
      responseType = ds.service2.qResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service2.qRequest,
      ds.service2.qResponse> getSmartQMethod() {
    io.grpc.MethodDescriptor<ds.service2.qRequest, ds.service2.qResponse> getSmartQMethod;
    if ((getSmartQMethod = SmartManagementGrpc.getSmartQMethod) == null) {
      synchronized (SmartManagementGrpc.class) {
        if ((getSmartQMethod = SmartManagementGrpc.getSmartQMethod) == null) {
          SmartManagementGrpc.getSmartQMethod = getSmartQMethod = 
              io.grpc.MethodDescriptor.<ds.service2.qRequest, ds.service2.qResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service2.SmartManagement", "smartQ"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.qRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.qResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartManagementMethodDescriptorSupplier("smartQ"))
                  .build();
          }
        }
     }
     return getSmartQMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service2.viewRequest,
      ds.service2.viewResponse> getSmartViewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "smartView",
      requestType = ds.service2.viewRequest.class,
      responseType = ds.service2.viewResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service2.viewRequest,
      ds.service2.viewResponse> getSmartViewMethod() {
    io.grpc.MethodDescriptor<ds.service2.viewRequest, ds.service2.viewResponse> getSmartViewMethod;
    if ((getSmartViewMethod = SmartManagementGrpc.getSmartViewMethod) == null) {
      synchronized (SmartManagementGrpc.class) {
        if ((getSmartViewMethod = SmartManagementGrpc.getSmartViewMethod) == null) {
          SmartManagementGrpc.getSmartViewMethod = getSmartViewMethod = 
              io.grpc.MethodDescriptor.<ds.service2.viewRequest, ds.service2.viewResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service2.SmartManagement", "smartView"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.viewRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.viewResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartManagementMethodDescriptorSupplier("smartView"))
                  .build();
          }
        }
     }
     return getSmartViewMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartManagementStub newStub(io.grpc.Channel channel) {
    return new SmartManagementStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartManagementBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SmartManagementBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartManagementFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SmartManagementFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class SmartManagementImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void smartTableBooking(ds.service2.TableRequest request,
        io.grpc.stub.StreamObserver<ds.service2.TableResponse> responseObserver) throws BookingError {
      asyncUnimplementedUnaryCall(getSmartTableBookingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Client Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.service2.qRequest> smartQ(
        io.grpc.stub.StreamObserver<ds.service2.qResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSmartQMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public void smartView(ds.service2.viewRequest request,
        io.grpc.stub.StreamObserver<ds.service2.viewResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSmartViewMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSmartTableBookingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.service2.TableRequest,
                ds.service2.TableResponse>(
                  this, METHODID_SMART_TABLE_BOOKING)))
          .addMethod(
            getSmartQMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.service2.qRequest,
                ds.service2.qResponse>(
                  this, METHODID_SMART_Q)))
          .addMethod(
            getSmartViewMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.service2.viewRequest,
                ds.service2.viewResponse>(
                  this, METHODID_SMART_VIEW)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SmartManagementStub extends io.grpc.stub.AbstractStub<SmartManagementStub> {
    private SmartManagementStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartManagementStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartManagementStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartManagementStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void smartTableBooking(ds.service2.TableRequest request,
        io.grpc.stub.StreamObserver<ds.service2.TableResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSmartTableBookingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Client Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.service2.qRequest> smartQ(
        io.grpc.stub.StreamObserver<ds.service2.qResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSmartQMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public void smartView(ds.service2.viewRequest request,
        io.grpc.stub.StreamObserver<ds.service2.viewResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSmartViewMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SmartManagementBlockingStub extends io.grpc.stub.AbstractStub<SmartManagementBlockingStub> {
    private SmartManagementBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartManagementBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartManagementBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartManagementBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public ds.service2.TableResponse smartTableBooking(ds.service2.TableRequest request) {
      return blockingUnaryCall(
          getChannel(), getSmartTableBookingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public java.util.Iterator<ds.service2.viewResponse> smartView(
        ds.service2.viewRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSmartViewMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SmartManagementFutureStub extends io.grpc.stub.AbstractStub<SmartManagementFutureStub> {
    private SmartManagementFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartManagementFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartManagementFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartManagementFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.service2.TableResponse> smartTableBooking(
        ds.service2.TableRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSmartTableBookingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SMART_TABLE_BOOKING = 0;
  private static final int METHODID_SMART_VIEW = 1;
  private static final int METHODID_SMART_Q = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SmartManagementImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SmartManagementImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SMART_TABLE_BOOKING:
          serviceImpl.smartTableBooking((ds.service2.TableRequest) request,
              (io.grpc.stub.StreamObserver<ds.service2.TableResponse>) responseObserver);
          break;
        case METHODID_SMART_VIEW:
          serviceImpl.smartView((ds.service2.viewRequest) request,
              (io.grpc.stub.StreamObserver<ds.service2.viewResponse>) responseObserver);
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
        case METHODID_SMART_Q:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.smartQ(
              (io.grpc.stub.StreamObserver<ds.service2.qResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SmartManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartManagementBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.service2.Service2Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartManagement");
    }
  }

  private static final class SmartManagementFileDescriptorSupplier
      extends SmartManagementBaseDescriptorSupplier {
    SmartManagementFileDescriptorSupplier() {}
  }

  private static final class SmartManagementMethodDescriptorSupplier
      extends SmartManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SmartManagementMethodDescriptorSupplier(String methodName) {
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
      synchronized (SmartManagementGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartManagementFileDescriptorSupplier())
              .addMethod(getSmartTableBookingMethod())
              .addMethod(getSmartQMethod())
              .addMethod(getSmartViewMethod())
              .build();
        }
      }
    }
    return result;
  }
}
