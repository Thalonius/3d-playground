package spr5.test;

import spr5.scene.Coordinate
import spr5.scene.SceneTriangle
import spr5.scene.Rgba
import kotlin.test.DefaultAsserter

class TestingFixture() {
    private val point1 = Coordinate(50.0f, 50.0f, 50.0f)
    private val point2 = Coordinate (100.0f, 100.0f, 100.0f)
    private val point3 = Coordinate (-50.0f, -50.0f, -50.0f)
    private val vertices = arrayOf(
            point1, point2, point3)
    private val triangleColor = Rgba(1.0f, 0.5f, 0.7f, 0.5f);
    private val triangle = SceneTriangle(vertices, triangleColor);
    // DefaultAsserter avoids dependency on JUnit or TestNG
    private val defAsserter = DefaultAsserter()
    public fun TestObjectCreation(){
        defAsserter.assertNotNull("Testing triangle not null", triangle)
    }
    public fun TestTriangleColor(){
        val wrongTestColor = Rgba(1.0f, 0.5f, 0.7f, 1.0f);
        val wrongObjectColor = Rgba(1.0f, 0.5f, 0.7f, 0.5f);
        defAsserter.assertNotEquals("Testing wrong color", wrongTestColor, triangle.color)
        defAsserter.assertNotEquals("Testing same colors but different object", wrongObjectColor, triangle.color)
        defAsserter.assertEquals("Testing right color", triangleColor, triangle.color)
    }

    public fun TestConstructionPoints(){
        val p1 = Coordinate(50.0f, 50.0f, 50.0f)
        val p2 = Coordinate (100.0f, 100.0f, 100.0f)
        val p3 = Coordinate (-50.0f, -50.0f, -50.0f)
        val vert = arrayOf(
                p1, p2, p3)

        defAsserter.assertEquals("Testing the construction points with the original points:", vertices, triangle.vertices)
        defAsserter.assertNotEquals("Testing the construction points with the same points but different object", vert, triangle.vertices)
    }

    public fun TestGetVertices(){
        val p1 = Coordinate(50.0f, 50.0f, 50.0f)
        val p2 = Coordinate (100.0f, 100.0f, 100.0f)
        val p3 = Coordinate (-50.0f, -50.0f, -50.0f)
        val vert = arrayOf(
                p1, p2, p3)

        // I would expect the getVertices returning Array<Coordinate> same as constructor param, and not Array<Float>
        defAsserter.assertNotEquals("Testing equality of size", vert.size, triangle.getVertices().size)
    }

    public fun TestGetColor(){
        val triCol = Rgba(1.0f, 0.5f, 0.7f, 0.5f);

        defAsserter.assertNotEquals("Testing equality colors, different objects", triCol, triangle.getColors())
        defAsserter.assertEquals("Testing equality colors, same objects", triangleColor, triangle.getColors())
        defAsserter.assertEquals("Testing red", triCol.red, triangle.getColors()[0])
        defAsserter.assertEquals("Testing green", triCol.green, triangle.getColors()[1])
        defAsserter.assertEquals("Testing blue", triCol.blue, triangle.getColors()[2])
        defAsserter.assertEquals("Testing alpha", triCol.alpha, triangle.getColors()[3])
        defAsserter.assertNotEquals("testing wrong Color for red", 0.9f, triangle.getColors()[0])
    }
}



