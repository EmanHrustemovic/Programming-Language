package hello

import scalafx.application.{JFXApp, JFXApp3}
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.canvas.{Canvas, GraphicsContext}
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.{HBox, Pane}
import scalafx.scene.paint.*
import scalafx.scene.paint.Color.*
import scalafx.scene.text.Text

import scala.language.implicitConversions

def renderCanvas(canvas: Canvas): Unit = {
  val graphicsContext = canvas.graphicsContext2D;
  // Set the background color
  graphicsContext.setFill(Color.LightGray)
  graphicsContext.fillRect(0, 0, 800, 800)

  // Main Outer Outline
  graphicsContext.setStroke(Color.Gray)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(100, 100, 600, 600)
  // Main Inner Outline
  graphicsContext.setStroke(Color.BLACK)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(120, 120, 560, 560)

  // Coloring The Middle Space
//  graphicsContext.setFill(Color.Red)
//  graphicsContext.fillRect(130, 130, 540, 540)
}

def home(canvas: Canvas): Unit = {
  val graphicsContext = canvas.graphicsContext2D;
  // Outer Line
  graphicsContext.setStroke(Color.White)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(280, 280, 200, 200)

  // Inner Line
  graphicsContext.setStroke(Color.White)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(320, 320, 120, 120)

  // Coloring Middle Space Black
  graphicsContext.setFill(Color.White)
  graphicsContext.fillRect(330, 330, 100, 100)

  // Printing The Text 'HOME'
  graphicsContext.setFill(Color.WHITE)
  graphicsContext.setFont(javafx.scene.text.Font.font("Arial", 20))
  graphicsContext.fillText("HOME", 335, 365)
}

def renderCircle(graphicsContext: GraphicsContext, color: Color, x: Int, y: Int, size: Int, outline: Boolean): Unit = {
  if(!outline){
    graphicsContext.setFill(color)
    graphicsContext.fillOval(x, y, size, size)
  } else {
    graphicsContext.setStroke(color)
    graphicsContext.setLineWidth(3);
    val outlineSize = size + (10 * 2)
    graphicsContext.strokeOval(x-10, y-10, outlineSize, outlineSize);
  }

}
def drawCorner(canvas: Canvas, x: Int, y: Int, color: Color): Unit = {
  val graphicsContext = canvas.graphicsContext2D;

  //outline
  renderCircle(graphicsContext, Color.Black, x, y, 100, true)

  var changedX = x + 15
  var changedY = y + 15
  //filled circles
  renderCircle(graphicsContext, color, changedX, changedY, 30, false)
  renderCircle(graphicsContext, color, changedX, changedY  + 40, 30, false)
  renderCircle(graphicsContext, color, changedX + 40, changedY, 30, false)
  renderCircle(graphicsContext, color, changedX + 40, changedY + 40, 30, false)


}


object ScalaFXHelloWorld extends JFXApp3:

  override def start(): Unit =

    //    stage = new JFXApp3.PrimaryStage :
    //      //    initStyle(StageStyle.Unified)
    //      title = "ScalaFX Hello World"
    //      scene = new Scene :
    //        fill = Color.rgb(38, 38, 38)
    //        content = new HBox :
    //          padding = Insets(50, 80, 50, 80)
    //          children = Seq(
    //            new Text :
    //              text = "Scala"
    //              style = "-fx-font: normal bold 100pt sans-serif"
    //              fill = new LinearGradient(endX = 0, stops = Stops(Red, DarkRed))
    //            ,
    //            new Text :
    //              text = "FX"
    //              style = "-fx-font: italic bold 100pt sans-serif"
    //              fill = new LinearGradient(endX = 0, stops = Stops(White, DarkGray))
    //              effect = new DropShadow :
    //                color = DarkGray
    //                radius = 15
    //                spread = 0.25
    //          )
    val canvas = new Canvas(800, 800)
    renderCanvas(canvas)

    // Wrap the Canvas in a Pane
    val rootPane = new Pane {
      children = canvas
    }

  // Create the main window
    stage = new JFXApp3.PrimaryStage {
      title = "Ludo Game"
      scene = new Scene(800, 800) {
        root = rootPane
      }
  }


    //top corners
    drawCorner(canvas, 150, 150, Color.Green)
    drawCorner(canvas, 550, 150, Color.Blue)


    //bottom corners
    drawCorner(canvas, 150, 550, Color.Red)
    drawCorner(canvas, 550, 550, Color.Yellow)

    renderCircle(canvas.graphicsContext2D, Color.Black, 360, 150, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 150, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 440, 150, 15, true)

    renderCircle(canvas.graphicsContext2D, Color.Black, 360, 200, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 400, 200, 15, true)
    renderCircle(canvas.graphicsContext2D, Color.Black, 440, 200, 15, true)

