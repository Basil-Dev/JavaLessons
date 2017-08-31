package patterns;
/*Данный шаблон представляет собой промежуточный класс обертку с требуемым интерфейсом, который по сути транслирует свои запросы другому классу. Иными словами, класс-оболочка оборачивает существующий класс, чтобы придать ему нужный интерфейс, который хочет клиент.*/
public class Adapter {
    public static void main(String[] args) {
    }
}

interface VectorGraphicsInterface {
    void drawLine();

    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Draw line");
    }

    void drawRasterSquare() {
        System.out.println("Draw square");
    }
}

/*ADAPTER*/
class VectorAdapterFromRaster extends RasterGraphics implements
        VectorGraphicsInterface {
    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

/*ADAPTER_2*/
class VectorAdapterFromRaster1 implements VectorGraphicsInterface {
    RasterGraphics rasterGraphics = new RasterGraphics();

    @Override
    public void drawLine() {
        rasterGraphics.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rasterGraphics.drawRasterSquare();
    }
}