/*import javafx.scene.canvas.GraphicsContext;

public class Dice(gc: GraphicsContext){
    val value: Int = 1;
    def roll(): Unit = {
            value = scala.util.Random.nextInt(6) + 1
    }

    def draw(): Unit = {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 150, 150);
            gc.setFill(Color.BLACK);
            gc.fillText(value.toString, 75, 75);
            gc.strokeRect(0, 0, 150, 150);
            gc.setFill(getDiceColor(value));
            gc.fillPolygon(getDicePoints(value));
    }
    private def getDiceColor(value: Int): Color = {
            value match {
                case 1 => Color.RED
                case 2 => Color.GREEN
                case 3 => Color.BLUE
                case 4 => Color.YELLOW
                case 5 => Color.ORANGE
                case 6 => Color.PURPLE
            }
    }
    private def getDicePoints(value: Int): Array[Double] = {
         val size = 150
         val margin = 10
         val radius = (size - 2 * margin) / 2
         val angle = 2 * math.Pi / 6
         val xPoints = new Array[Double](6)
         val yPoints = new Array[Double](6)
         for (i <- 0 until 6) {
             xPoints(i) = margin + radius * math.cos(i * angle)
             yPoints(i) = margin + radius * math.sin(i * angle)
         }
         xPoints.slice(0, value) ++ yPoints.slice(0, value) ++ xPoints.slice(value, 6) ++ yPoints.slice(value, 6)
     }
}*/