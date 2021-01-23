package imgui.nodeditor;

import imgui.binding.ImGuiStructDestroyable;

public final class ImNodeEditorContext extends ImGuiStructDestroyable {
    public ImNodeEditorContext() {
    }

    public ImNodeEditorContext(final ImNodeEditorConfig config) {
        this(nCreate(config.ptr));
    }

    public ImNodeEditorContext(final long ptr) {
        super(ptr);
    }

    /*JNI
        #include <imgui.h>
        #include <imgui_node_editor.h>
        #include "jni_binding_struct.h"

        namespace ed = ax::NodeEditor;

        #define IM_NODE_EDITOR_CONTEXT ((ed::EditorContext*)STRUCT_PTR)
     */

    @Override
    protected long create() {
        return nCreate();
    }

    @Override
    public void destroy() {
        nDestroyEditorContext();
    }

    private native long nCreate(); /*
        return (intptr_t)ed::CreateEditor();
    */

    private static native long nCreate(long cfgPtr); /*
        return (intptr_t)ed::CreateEditor((ed::Config*)cfgPtr);
    */

    private native void nDestroyEditorContext(); /*
       ed::DestroyEditor(IM_NODE_EDITOR_CONTEXT);
    */
}
