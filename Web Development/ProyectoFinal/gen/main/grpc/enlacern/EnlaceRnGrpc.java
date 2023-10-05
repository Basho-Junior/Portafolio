package enlacern;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: EnlaceRn.proto")
public final class EnlaceRnGrpc {

  private EnlaceRnGrpc() {}

  public static final String SERVICE_NAME = "enlacern.EnlaceRn";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<enlacern.EnlaceRnOuterClass.usuarioRequest,
      enlacern.EnlaceRnOuterClass.usuarioResponse> getAutentificacionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "autentificacion",
      requestType = enlacern.EnlaceRnOuterClass.usuarioRequest.class,
      responseType = enlacern.EnlaceRnOuterClass.usuarioResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<enlacern.EnlaceRnOuterClass.usuarioRequest,
      enlacern.EnlaceRnOuterClass.usuarioResponse> getAutentificacionMethod() {
    io.grpc.MethodDescriptor<enlacern.EnlaceRnOuterClass.usuarioRequest, enlacern.EnlaceRnOuterClass.usuarioResponse> getAutentificacionMethod;
    if ((getAutentificacionMethod = EnlaceRnGrpc.getAutentificacionMethod) == null) {
      synchronized (EnlaceRnGrpc.class) {
        if ((getAutentificacionMethod = EnlaceRnGrpc.getAutentificacionMethod) == null) {
          EnlaceRnGrpc.getAutentificacionMethod = getAutentificacionMethod =
              io.grpc.MethodDescriptor.<enlacern.EnlaceRnOuterClass.usuarioRequest, enlacern.EnlaceRnOuterClass.usuarioResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "autentificacion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  enlacern.EnlaceRnOuterClass.usuarioRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  enlacern.EnlaceRnOuterClass.usuarioResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnlaceRnMethodDescriptorSupplier("autentificacion"))
              .build();
        }
      }
    }
    return getAutentificacionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<enlacern.EnlaceRnOuterClass.linkRequest,
      enlacern.EnlaceRnOuterClass.linkResponse> getMakeLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "makeLink",
      requestType = enlacern.EnlaceRnOuterClass.linkRequest.class,
      responseType = enlacern.EnlaceRnOuterClass.linkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<enlacern.EnlaceRnOuterClass.linkRequest,
      enlacern.EnlaceRnOuterClass.linkResponse> getMakeLinkMethod() {
    io.grpc.MethodDescriptor<enlacern.EnlaceRnOuterClass.linkRequest, enlacern.EnlaceRnOuterClass.linkResponse> getMakeLinkMethod;
    if ((getMakeLinkMethod = EnlaceRnGrpc.getMakeLinkMethod) == null) {
      synchronized (EnlaceRnGrpc.class) {
        if ((getMakeLinkMethod = EnlaceRnGrpc.getMakeLinkMethod) == null) {
          EnlaceRnGrpc.getMakeLinkMethod = getMakeLinkMethod =
              io.grpc.MethodDescriptor.<enlacern.EnlaceRnOuterClass.linkRequest, enlacern.EnlaceRnOuterClass.linkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "makeLink"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  enlacern.EnlaceRnOuterClass.linkRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  enlacern.EnlaceRnOuterClass.linkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnlaceRnMethodDescriptorSupplier("makeLink"))
              .build();
        }
      }
    }
    return getMakeLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<enlacern.EnlaceRnOuterClass.visitantesRequest,
      enlacern.EnlaceRnOuterClass.linkResponse> getGetLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getLink",
      requestType = enlacern.EnlaceRnOuterClass.visitantesRequest.class,
      responseType = enlacern.EnlaceRnOuterClass.linkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<enlacern.EnlaceRnOuterClass.visitantesRequest,
      enlacern.EnlaceRnOuterClass.linkResponse> getGetLinkMethod() {
    io.grpc.MethodDescriptor<enlacern.EnlaceRnOuterClass.visitantesRequest, enlacern.EnlaceRnOuterClass.linkResponse> getGetLinkMethod;
    if ((getGetLinkMethod = EnlaceRnGrpc.getGetLinkMethod) == null) {
      synchronized (EnlaceRnGrpc.class) {
        if ((getGetLinkMethod = EnlaceRnGrpc.getGetLinkMethod) == null) {
          EnlaceRnGrpc.getGetLinkMethod = getGetLinkMethod =
              io.grpc.MethodDescriptor.<enlacern.EnlaceRnOuterClass.visitantesRequest, enlacern.EnlaceRnOuterClass.linkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getLink"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  enlacern.EnlaceRnOuterClass.visitantesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  enlacern.EnlaceRnOuterClass.linkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnlaceRnMethodDescriptorSupplier("getLink"))
              .build();
        }
      }
    }
    return getGetLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<enlacern.EnlaceRnOuterClass.enlace,
      enlacern.EnlaceRnOuterClass.listaLink> getGetLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getLinks",
      requestType = enlacern.EnlaceRnOuterClass.enlace.class,
      responseType = enlacern.EnlaceRnOuterClass.listaLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<enlacern.EnlaceRnOuterClass.enlace,
      enlacern.EnlaceRnOuterClass.listaLink> getGetLinksMethod() {
    io.grpc.MethodDescriptor<enlacern.EnlaceRnOuterClass.enlace, enlacern.EnlaceRnOuterClass.listaLink> getGetLinksMethod;
    if ((getGetLinksMethod = EnlaceRnGrpc.getGetLinksMethod) == null) {
      synchronized (EnlaceRnGrpc.class) {
        if ((getGetLinksMethod = EnlaceRnGrpc.getGetLinksMethod) == null) {
          EnlaceRnGrpc.getGetLinksMethod = getGetLinksMethod =
              io.grpc.MethodDescriptor.<enlacern.EnlaceRnOuterClass.enlace, enlacern.EnlaceRnOuterClass.listaLink>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getLinks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  enlacern.EnlaceRnOuterClass.enlace.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  enlacern.EnlaceRnOuterClass.listaLink.getDefaultInstance()))
              .setSchemaDescriptor(new EnlaceRnMethodDescriptorSupplier("getLinks"))
              .build();
        }
      }
    }
    return getGetLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<enlacern.EnlaceRnOuterClass.visitantesRequest,
      enlacern.EnlaceRnOuterClass.visitanteReponse> getGetVisitantesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getVisitantes",
      requestType = enlacern.EnlaceRnOuterClass.visitantesRequest.class,
      responseType = enlacern.EnlaceRnOuterClass.visitanteReponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<enlacern.EnlaceRnOuterClass.visitantesRequest,
      enlacern.EnlaceRnOuterClass.visitanteReponse> getGetVisitantesMethod() {
    io.grpc.MethodDescriptor<enlacern.EnlaceRnOuterClass.visitantesRequest, enlacern.EnlaceRnOuterClass.visitanteReponse> getGetVisitantesMethod;
    if ((getGetVisitantesMethod = EnlaceRnGrpc.getGetVisitantesMethod) == null) {
      synchronized (EnlaceRnGrpc.class) {
        if ((getGetVisitantesMethod = EnlaceRnGrpc.getGetVisitantesMethod) == null) {
          EnlaceRnGrpc.getGetVisitantesMethod = getGetVisitantesMethod =
              io.grpc.MethodDescriptor.<enlacern.EnlaceRnOuterClass.visitantesRequest, enlacern.EnlaceRnOuterClass.visitanteReponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getVisitantes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  enlacern.EnlaceRnOuterClass.visitantesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  enlacern.EnlaceRnOuterClass.visitanteReponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnlaceRnMethodDescriptorSupplier("getVisitantes"))
              .build();
        }
      }
    }
    return getGetVisitantesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EnlaceRnStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnlaceRnStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnlaceRnStub>() {
        @java.lang.Override
        public EnlaceRnStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnlaceRnStub(channel, callOptions);
        }
      };
    return EnlaceRnStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EnlaceRnBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnlaceRnBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnlaceRnBlockingStub>() {
        @java.lang.Override
        public EnlaceRnBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnlaceRnBlockingStub(channel, callOptions);
        }
      };
    return EnlaceRnBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EnlaceRnFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnlaceRnFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnlaceRnFutureStub>() {
        @java.lang.Override
        public EnlaceRnFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnlaceRnFutureStub(channel, callOptions);
        }
      };
    return EnlaceRnFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class EnlaceRnImplBase implements io.grpc.BindableService {

    /**
     */
    public void autentificacion(enlacern.EnlaceRnOuterClass.usuarioRequest request,
        io.grpc.stub.StreamObserver<enlacern.EnlaceRnOuterClass.usuarioResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAutentificacionMethod(), responseObserver);
    }

    /**
     */
    public void makeLink(enlacern.EnlaceRnOuterClass.linkRequest request,
        io.grpc.stub.StreamObserver<enlacern.EnlaceRnOuterClass.linkResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMakeLinkMethod(), responseObserver);
    }

    /**
     */
    public void getLink(enlacern.EnlaceRnOuterClass.visitantesRequest request,
        io.grpc.stub.StreamObserver<enlacern.EnlaceRnOuterClass.linkResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLinkMethod(), responseObserver);
    }

    /**
     */
    public void getLinks(enlacern.EnlaceRnOuterClass.enlace request,
        io.grpc.stub.StreamObserver<enlacern.EnlaceRnOuterClass.listaLink> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLinksMethod(), responseObserver);
    }

    /**
     */
    public void getVisitantes(enlacern.EnlaceRnOuterClass.visitantesRequest request,
        io.grpc.stub.StreamObserver<enlacern.EnlaceRnOuterClass.visitanteReponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVisitantesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAutentificacionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                enlacern.EnlaceRnOuterClass.usuarioRequest,
                enlacern.EnlaceRnOuterClass.usuarioResponse>(
                  this, METHODID_AUTENTIFICACION)))
          .addMethod(
            getMakeLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                enlacern.EnlaceRnOuterClass.linkRequest,
                enlacern.EnlaceRnOuterClass.linkResponse>(
                  this, METHODID_MAKE_LINK)))
          .addMethod(
            getGetLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                enlacern.EnlaceRnOuterClass.visitantesRequest,
                enlacern.EnlaceRnOuterClass.linkResponse>(
                  this, METHODID_GET_LINK)))
          .addMethod(
            getGetLinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                enlacern.EnlaceRnOuterClass.enlace,
                enlacern.EnlaceRnOuterClass.listaLink>(
                  this, METHODID_GET_LINKS)))
          .addMethod(
            getGetVisitantesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                enlacern.EnlaceRnOuterClass.visitantesRequest,
                enlacern.EnlaceRnOuterClass.visitanteReponse>(
                  this, METHODID_GET_VISITANTES)))
          .build();
    }
  }

  /**
   */
  public static final class EnlaceRnStub extends io.grpc.stub.AbstractAsyncStub<EnlaceRnStub> {
    private EnlaceRnStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnlaceRnStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnlaceRnStub(channel, callOptions);
    }

    /**
     */
    public void autentificacion(enlacern.EnlaceRnOuterClass.usuarioRequest request,
        io.grpc.stub.StreamObserver<enlacern.EnlaceRnOuterClass.usuarioResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAutentificacionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void makeLink(enlacern.EnlaceRnOuterClass.linkRequest request,
        io.grpc.stub.StreamObserver<enlacern.EnlaceRnOuterClass.linkResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMakeLinkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLink(enlacern.EnlaceRnOuterClass.visitantesRequest request,
        io.grpc.stub.StreamObserver<enlacern.EnlaceRnOuterClass.linkResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLinkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLinks(enlacern.EnlaceRnOuterClass.enlace request,
        io.grpc.stub.StreamObserver<enlacern.EnlaceRnOuterClass.listaLink> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLinksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getVisitantes(enlacern.EnlaceRnOuterClass.visitantesRequest request,
        io.grpc.stub.StreamObserver<enlacern.EnlaceRnOuterClass.visitanteReponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVisitantesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EnlaceRnBlockingStub extends io.grpc.stub.AbstractBlockingStub<EnlaceRnBlockingStub> {
    private EnlaceRnBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnlaceRnBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnlaceRnBlockingStub(channel, callOptions);
    }

    /**
     */
    public enlacern.EnlaceRnOuterClass.usuarioResponse autentificacion(enlacern.EnlaceRnOuterClass.usuarioRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAutentificacionMethod(), getCallOptions(), request);
    }

    /**
     */
    public enlacern.EnlaceRnOuterClass.linkResponse makeLink(enlacern.EnlaceRnOuterClass.linkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMakeLinkMethod(), getCallOptions(), request);
    }

    /**
     */
    public enlacern.EnlaceRnOuterClass.linkResponse getLink(enlacern.EnlaceRnOuterClass.visitantesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLinkMethod(), getCallOptions(), request);
    }

    /**
     */
    public enlacern.EnlaceRnOuterClass.listaLink getLinks(enlacern.EnlaceRnOuterClass.enlace request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLinksMethod(), getCallOptions(), request);
    }

    /**
     */
    public enlacern.EnlaceRnOuterClass.visitanteReponse getVisitantes(enlacern.EnlaceRnOuterClass.visitantesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVisitantesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EnlaceRnFutureStub extends io.grpc.stub.AbstractFutureStub<EnlaceRnFutureStub> {
    private EnlaceRnFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnlaceRnFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnlaceRnFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<enlacern.EnlaceRnOuterClass.usuarioResponse> autentificacion(
        enlacern.EnlaceRnOuterClass.usuarioRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAutentificacionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<enlacern.EnlaceRnOuterClass.linkResponse> makeLink(
        enlacern.EnlaceRnOuterClass.linkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMakeLinkMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<enlacern.EnlaceRnOuterClass.linkResponse> getLink(
        enlacern.EnlaceRnOuterClass.visitantesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLinkMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<enlacern.EnlaceRnOuterClass.listaLink> getLinks(
        enlacern.EnlaceRnOuterClass.enlace request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLinksMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<enlacern.EnlaceRnOuterClass.visitanteReponse> getVisitantes(
        enlacern.EnlaceRnOuterClass.visitantesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVisitantesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AUTENTIFICACION = 0;
  private static final int METHODID_MAKE_LINK = 1;
  private static final int METHODID_GET_LINK = 2;
  private static final int METHODID_GET_LINKS = 3;
  private static final int METHODID_GET_VISITANTES = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EnlaceRnImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EnlaceRnImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUTENTIFICACION:
          serviceImpl.autentificacion((enlacern.EnlaceRnOuterClass.usuarioRequest) request,
              (io.grpc.stub.StreamObserver<enlacern.EnlaceRnOuterClass.usuarioResponse>) responseObserver);
          break;
        case METHODID_MAKE_LINK:
          serviceImpl.makeLink((enlacern.EnlaceRnOuterClass.linkRequest) request,
              (io.grpc.stub.StreamObserver<enlacern.EnlaceRnOuterClass.linkResponse>) responseObserver);
          break;
        case METHODID_GET_LINK:
          serviceImpl.getLink((enlacern.EnlaceRnOuterClass.visitantesRequest) request,
              (io.grpc.stub.StreamObserver<enlacern.EnlaceRnOuterClass.linkResponse>) responseObserver);
          break;
        case METHODID_GET_LINKS:
          serviceImpl.getLinks((enlacern.EnlaceRnOuterClass.enlace) request,
              (io.grpc.stub.StreamObserver<enlacern.EnlaceRnOuterClass.listaLink>) responseObserver);
          break;
        case METHODID_GET_VISITANTES:
          serviceImpl.getVisitantes((enlacern.EnlaceRnOuterClass.visitantesRequest) request,
              (io.grpc.stub.StreamObserver<enlacern.EnlaceRnOuterClass.visitanteReponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EnlaceRnBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EnlaceRnBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return enlacern.EnlaceRnOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EnlaceRn");
    }
  }

  private static final class EnlaceRnFileDescriptorSupplier
      extends EnlaceRnBaseDescriptorSupplier {
    EnlaceRnFileDescriptorSupplier() {}
  }

  private static final class EnlaceRnMethodDescriptorSupplier
      extends EnlaceRnBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EnlaceRnMethodDescriptorSupplier(String methodName) {
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
      synchronized (EnlaceRnGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EnlaceRnFileDescriptorSupplier())
              .addMethod(getAutentificacionMethod())
              .addMethod(getMakeLinkMethod())
              .addMethod(getGetLinkMethod())
              .addMethod(getGetLinksMethod())
              .addMethod(getGetVisitantesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
