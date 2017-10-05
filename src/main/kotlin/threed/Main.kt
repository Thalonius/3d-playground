package threed

import webgl.createWebGLRenderingContext
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.HTMLDivElement
import threed.example.drawExample
import kotlin.browser.document
import kotlin.test.*
import spr5.test.TestingFixture


fun main(args: Array<String>) {

    val container = document.getElementById("container") as HTMLDivElement
    val canvas = document.createElement("canvas") as HTMLCanvasElement
    canvas.style.height = "100%"

    val webGlContext = createWebGLRenderingContext(canvas)
    val testObject = TestingFixture()
    testObject.TestObjectCreation()
    testObject.TestTriangleColor()
    testObject.TestConstructionPoints()

    container.appendChild(canvas)

    drawExample(webGlContext)
    

}


