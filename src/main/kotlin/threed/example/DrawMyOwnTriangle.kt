package threed.example

import org.khronos.webgl.Float32Array
import org.khronos.webgl.WebGLRenderingContext
import org.khronos.webgl.WebGLRenderingContext.Companion.ARRAY_BUFFER
import org.khronos.webgl.WebGLRenderingContext.Companion.COLOR_BUFFER_BIT
import org.khronos.webgl.WebGLRenderingContext.Companion.FLOAT
import org.khronos.webgl.WebGLRenderingContext.Companion.FRAGMENT_SHADER
import org.khronos.webgl.WebGLRenderingContext.Companion.STATIC_DRAW
import org.khronos.webgl.WebGLRenderingContext.Companion.TRIANGLES
import org.khronos.webgl.WebGLRenderingContext.Companion.VERTEX_SHADER

fun drawMyOwnTriangle(gl: WebGLRenderingContext) {

    val vertices = arrayOf(
            -1.0f, -1.0f, 0.0f,
            1.0f, 1.0f, 0.0f,
            -1.0f, 1.0f, 0.0f
    )

    val vertexBuffer = gl.createBuffer()
    gl.bindBuffer(ARRAY_BUFFER, vertexBuffer)
    gl.bufferData(ARRAY_BUFFER, Float32Array(vertices), STATIC_DRAW)

    val vertexShaderCode  =
            """
            attribute vec3 vertices;
            void main() {
                gl_Position = vec4(vertices, 1.0);
            }
            """

    val fragmentShaderCode =
            """
            void main() {
                gl_FragColor = vec4(0.9, 0.2, 0.2, 1.0);
            }
            """

    val fragmentShader = gl.createShader(FRAGMENT_SHADER)
    gl.shaderSource(fragmentShader, fragmentShaderCode)
    gl.compileShader(fragmentShader)

    val vertexShader = gl.createShader(VERTEX_SHADER)
    gl.shaderSource(vertexShader, vertexShaderCode)
    gl.compileShader(vertexShader)

    val shaderProgram = gl.createProgram()
    gl.attachShader(shaderProgram, vertexShader)
    gl.attachShader(shaderProgram, fragmentShader)

    gl.linkProgram(shaderProgram)


    gl.useProgram(shaderProgram)
    gl.clearColor(0.0f, 0.0f, 0.0f, 1.0f)
    gl.clear(COLOR_BUFFER_BIT)

    val verticesAttribute = gl.getAttribLocation(shaderProgram, "vertices")
    gl.vertexAttribPointer(verticesAttribute, 3, FLOAT, false, 0, 0)
    gl.enableVertexAttribArray(verticesAttribute)

    gl.drawArrays(TRIANGLES, 0, 3)


}

