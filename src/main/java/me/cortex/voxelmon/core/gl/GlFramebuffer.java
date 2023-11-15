package me.cortex.voxelmon.core.gl;

import me.cortex.voxelmon.core.util.TrackedObject;
import org.lwjgl.opengl.GL30C;

import static org.lwjgl.opengl.GL45C.*;

public class GlFramebuffer extends TrackedObject {
    public final int id;
    public GlFramebuffer() {
        this.id = glCreateFramebuffers();
    }

    public GlFramebuffer bind(int attachment, GlTexture texture) {
        glNamedFramebufferTexture(this.id, attachment, texture.id, 0);
        return this;
    }

    @Override
    public void free() {
        super.free0();
        glDeleteFramebuffers(this.id);
    }

    public void verify() {
        glCheckNamedFramebufferStatus(this.id, GL_FRAMEBUFFER);
    }
}
