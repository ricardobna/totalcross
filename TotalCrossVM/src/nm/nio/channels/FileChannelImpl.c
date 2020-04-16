#include "FileChannelImpl.h"
#include "xtypes.h"

TC_API void jncFCI_read(NMParams p) {
    TCObject fileChannel = p->obj[0];
    int32 fd = FileChannelImpl_nfd(fileChannel);
    int32 buffer;
    int32 ret = read(fd, &buffer, 4);
    p->retI = buffer;
}

TC_API void jncFCI_read_b(NMParams p) {
    TCObject fileChannel = p->obj[0];
    TCObject byteBuffer = p->obj[1];
    int32 fd = FileChannelImpl_nfd(fileChannel);
    TCObject byteBufferArray = ByteBuffer_array(byteBuffer);
    int32 byteBufferOffset = ByteBuffer_offset(byteBuffer);
    int32 byteBufferLength = ByteBuffer_length(byteBuffer);
    void* arrayStart = ARRAYOBJ_START(byteBufferArray);
    int32 ret = read(fd, arrayStart, byteBufferLength);
    p->retI = ret;
}

TC_API void jncFCI_read_Bii(NMParams p) {
    TCObject fileChannel = p->obj[0];
    TCObject byteBuffer = p->obj[1];
    int32 offset = p->i32[0];
    int32 length = p->i32[1];
    int32 fd = FileChannelImpl_nfd(fileChannel);
    void* arrayStart = ARRAYOBJ_START(byteBuffer) + offset;
    int32 ret = read(fd, arrayStart, length);
    p->retI = ret;
}

TC_API void jncFCI_write_Bii(NMParams p) {
    TCObject fileChannel = p->obj[0];
    TCObject byteBuffer = p->obj[1];
    int32 offset = p->i32[0];
    int32 length = p->i32[1];
    int32 fd = FileChannelImpl_nfd(fileChannel);
    void* arrayStart = ARRAYOBJ_START(byteBuffer) + offset;
    int32 ret = write(fd, arrayStart, length);
    p->retI = ret;
}