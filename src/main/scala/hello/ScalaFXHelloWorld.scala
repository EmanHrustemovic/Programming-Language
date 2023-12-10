package hello

import scalafx.application.{JFXApp, JFXApp3}
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.{HBox, Pane}
import scalafx.scene.paint.*
import scalafx.scene.paint.Color.*
import scalafx.scene.text.Text

import scala.language.implicitConversions

def renderCanvas(canvas: Canvas): Unit = {
  val graphicsContext = canvas.graphicsContext2D;
  // Set the background color
  graphicsContext.setFill(Color.DARKGRAY)
  graphicsContext.fillRect(0, 0, 800, 800)

  // Main Outer Outline
  graphicsContext.setStroke(Color.BLACK)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(100, 100, 600, 600)
  // Main Inner Outline
  graphicsContext.setStroke(Color.BLACK)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(120, 120, 560, 560)

  // Coloring The Middle Space
  graphicsContext.setFill(Color.BLACK)
  graphicsContext.fillRect(130, 130, 540, 540)
}


def redCorner(canvas: Canvas): Unit = {
  val graphicsContext = canvas.graphicsContext2D;
  // Outer Line
  graphicsContext.setStroke(Color.RED)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(120, 120, 280, 280)

  // Inner Line
  graphicsContext.setStroke(Color.RED)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(160, 160, 200, 200)

  // Circles
  graphicsContext.setFill(Color.RED)
  graphicsContext.fillOval(200, 200, 80, 80)
  graphicsContext.fillOval(320, 200, 80, 80)
  graphicsContext.fillOval(200, 320, 80, 80)
  graphicsContext.fillOval(320, 320, 80, 80)

  // Rectangle Red
  graphicsContext.setFill(Color.RED)
  graphicsContext.fillRect(130, 130, 150, 150)

  // Circle Red
  graphicsContext.setFill(Color.RED)
  graphicsContext.fillOval(210, 210, 60, 60)
  graphicsContext.fillOval(330, 210, 60, 60)
  graphicsContext.fillOval(210, 330, 60, 60)
  graphicsContext.fillOval(330, 330, 60, 60)

  // White
  graphicsContext.setFill(Color.WHITE)
  graphicsContext.fillRect(170, 170, 70, 70)
}

def blueCorner(canvas: Canvas): Unit = {
  val graphicsContext = canvas.graphicsContext2D;
  // Outer Line
  graphicsContext.setStroke(Color.BLUE)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(520, 120, 280, 280)

  // Inner Line
  graphicsContext.setStroke(Color.BLUE)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(560, 160, 200, 200)

  // Circles
  graphicsContext.setFill(Color.BLUE)
  graphicsContext.fillOval(600, 200, 80, 80)
  graphicsContext.fillOval(720, 200, 80, 80)
  graphicsContext.fillOval(600, 320, 80, 80)
  graphicsContext.fillOval(720, 320, 80, 80)

  // Rectangle Blue
  graphicsContext.setFill(Color.BLUE)
  graphicsContext.fillRect(530, 130, 150, 150)

  // Circle Blue
  graphicsContext.setFill(Color.BLUE)
  graphicsContext.fillOval(610, 210, 60, 60)
  graphicsContext.fillOval(730, 210, 60, 60)
  graphicsContext.fillOval(610, 330, 60, 60)
  graphicsContext.fillOval(730, 330, 60, 60)

  // White
  graphicsContext.setFill(Color.WHITE)
  graphicsContext.fillRect(570, 170, 70, 70)
}

def greenCorner(canvas: Canvas): Unit = {
  val graphicsContext = canvas.graphicsContext2D;
  // Outer Line
  graphicsContext.setStroke(Color.GREEN)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(120, 520, 280, 280)

  // Inner Line
  graphicsContext.setStroke(Color.GREEN)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(160, 560, 200, 200)

  // Circles
  graphicsContext.setFill(Color.GREEN)
  graphicsContext.fillOval(200, 600, 80, 80)
  graphicsContext.fillOval(320, 600, 80, 80)
  graphicsContext.fillOval(200, 720, 80, 80)
  graphicsContext.fillOval(320, 720, 80, 80)

  // Rectangle Green
  graphicsContext.setFill(Color.GREEN)
  graphicsContext.fillRect(130, 530, 150, 150)

  // Circle Green
  graphicsContext.setFill(Color.GREEN)
  graphicsContext.fillOval(210, 610, 60, 60)
  graphicsContext.fillOval(330, 610, 60, 60)
  graphicsContext.fillOval(210, 730, 60, 60)
  graphicsContext.fillOval(330, 730, 60, 60)

  // White
  graphicsContext.setFill(Color.WHITE)
  graphicsContext.fillRect(170, 570, 70, 70)
}

def yellowCorner(canvas: Canvas): Unit = {
  val graphicsContext = canvas.graphicsContext2D;
  // Outer Line
  graphicsContext.setStroke(Color.YELLOW)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(520, 520, 280, 280)

  // Inner Line
  graphicsContext.setStroke(Color.YELLOW)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(560, 560, 200, 200)

  // Circles
  graphicsContext.setFill(Color.YELLOW)
  graphicsContext.fillOval(600, 600, 80, 80)
  graphicsContext.fillOval(720, 600, 80, 80)
  graphicsContext.fillOval(600, 720, 80, 80)
  graphicsContext.fillOval(720, 720, 80, 80)

  // Rectangle Yellow
  graphicsContext.setFill(Color.YELLOW)
  graphicsContext.fillRect(530, 530, 150, 150)

  // Circle Yellow
  graphicsContext.setFill(Color.YELLOW)
  graphicsContext.fillOval(610, 610, 60, 60)
  graphicsContext.fillOval(730, 610, 60, 60)
  graphicsContext.fillOval(610, 730, 60, 60)
  graphicsContext.fillOval(730, 730, 60, 60)

  // White
  graphicsContext.setFill(Color.WHITE)
  graphicsContext.fillRect(570, 570, 70, 70)
}

def home(canvas: Canvas): Unit = {
  val graphicsContext = canvas.graphicsContext2D;
  // Outer Line
  graphicsContext.setStroke(Color.BLACK)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(280, 280, 200, 200)

  // Inner Line
  graphicsContext.setStroke(Color.BLACK)
  graphicsContext.setLineWidth(10)
  graphicsContext.strokeRect(320, 320, 120, 120)

  // Coloring Middle Space Black
  graphicsContext.setFill(Color.BLACK)
  graphicsContext.fillRect(330, 330, 100, 100)

  // Printing The Text 'HOME'
  graphicsContext.setFill(Color.WHITE)
  graphicsContext.setFont(javafx.scene.text.Font.font("Arial", 20))
  graphicsContext.fillText("HOME", 335, 365)
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
    redCorner(canvas)
    blueCorner(canvas)
    greenCorner(canvas)
    yellowCorner(canvas)
    home(canvas)
