// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SmartMangement.proto

package ds.service2;

public final class Service2Impl {
  private Service2Impl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_TableRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_TableRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_TableResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_TableResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_qRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_qRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_qResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_qResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_viewRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_viewRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_viewResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_viewResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024SmartMangement.proto\022\010service2\"5\n\014Tabl" +
      "eRequest\022\022\n\ntableInput\030\001 \001(\005\022\021\n\ttimeInpu" +
      "t\030\002 \001(\001\"8\n\rTableResponse\022\023\n\013tableOutput\030" +
      "\001 \001(\t\022\022\n\ntimeOutput\030\002 \001(\001\"(\n\010qRequest\022\016\n" +
      "\006qOrder\030\001 \001(\t\022\014\n\004time\030\002 \001(\005\" \n\tqResponse" +
      "\022\023\n\013qSuccessful\030\001 \001(\t\"&\n\013viewRequest\022\027\n\017" +
      "bookingsRequest\030\001 \001(\t\"%\n\014viewResponse\022\025\n" +
      "\rbookingsTotal\030\001 \001(\t2\320\001\n\017SmartManagement" +
      "\022F\n\021smartTableBooking\022\026.service2.TableRe" +
      "quest\032\027.service2.TableResponse\"\000\0225\n\006smar" +
      "tQ\022\022.service2.qRequest\032\023.service2.qRespo" +
      "nse\"\000(\001\022>\n\tsmartView\022\025.service2.viewRequ" +
      "est\032\026.service2.viewResponse\"\0000\001B\035\n\013ds.se" +
      "rvice2B\014Service2ImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_service2_TableRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_service2_TableRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_TableRequest_descriptor,
        new java.lang.String[] { "TableInput", "TimeInput", });
    internal_static_service2_TableResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_service2_TableResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_TableResponse_descriptor,
        new java.lang.String[] { "TableOutput", "TimeOutput", });
    internal_static_service2_qRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_service2_qRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_qRequest_descriptor,
        new java.lang.String[] { "QOrder", "Time", });
    internal_static_service2_qResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_service2_qResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_qResponse_descriptor,
        new java.lang.String[] { "QSuccessful", });
    internal_static_service2_viewRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_service2_viewRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_viewRequest_descriptor,
        new java.lang.String[] { "BookingsRequest", });
    internal_static_service2_viewResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_service2_viewResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_viewResponse_descriptor,
        new java.lang.String[] { "BookingsTotal", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
