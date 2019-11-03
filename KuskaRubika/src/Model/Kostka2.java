package Model;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * Simple implementation of the Rubik's cube using JavaFX 3D
 * http://stackoverflow.com/questions/34001900/how-to-render-3d-graphics-properly
 * @author JosePereda
 */
public class Kostka2 extends Application {

    private static final int RED     = 0;
    private static final int GREEN   = 1;
    private static final int BLUE    = 2;
    private static final int YELLOW  = 3;
    private static final int ORANGE  = 4;
    private static final int WHITE   = 5;
    private static final int GRAY    = 6;

    private static final float X_RED     = 1f / 7f;
    private static final float X_GREEN   = 2f / 7f;
    private static final float X_BLUE    = 3f / 7f;
    private static final float X_YELLOW  = 4f / 7f;
    private static final float X_ORANGE  = 5f / 7f;
    private static final float X_WHITE   = 6f / 7f;
    private static final float X_GRAY    = 7f / 7f;

    private double mousePosX;
    private double mousePosY;
    private double mouseOldX;
    private double mouseOldY;

    public Kostka2(){}


    @Override
    public void start(Stage primaryStage) {
        Group sceneRoot = new Group();
        Scene scene = new Scene(sceneRoot, 600, 600, true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.BLACK);
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);
        camera.setTranslateZ(-10);
        scene.setCamera(camera);

        PhongMaterial mat = new PhongMaterial();
        // image can be found here http://i.stack.imgur.com/uN4dv.png
        mat.setDiffuseMap(new Image(getClass().getResourceAsStream("palette.png")));

        Group meshGroup = new Group();

        AtomicInteger cont = new AtomicInteger();
        patternFaceF.forEach(p -> {
            MeshView meshP = new MeshView();
            meshP.setMesh(createCube(p));
            meshP.setMaterial(mat);
            Point3D pt = pointsFaceF.get(cont.getAndIncrement());
            meshP.getTransforms().addAll(new Translate(pt.getX(), pt.getY(), pt.getZ()));
            meshGroup.getChildren().add(meshP);
        });

        Rotate rotateX = new Rotate(30, 0, 0, 0, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(20, 0, 0, 0, Rotate.Y_AXIS);
        meshGroup.getTransforms().addAll(rotateX, rotateY);

        PointLight light = new PointLight();
        light.setTranslateX(10);
        light.setTranslateY(-20);

        PointLight light2 = new PointLight();
        light2.setTranslateY(10);
        light2.setTranslateX(-20);


        sceneRoot.getChildren().addAll(meshGroup, new AmbientLight());

        scene.setOnMousePressed(me -> {
            mouseOldX = me.getSceneX();
            mouseOldY = me.getSceneY();
        });
        scene.setOnMouseDragged(me -> {
            mousePosX = me.getSceneX();
            mousePosY = me.getSceneY();
            rotateX.setAngle(rotateX.getAngle()-(mousePosY - mouseOldY));
            rotateY.setAngle(rotateY.getAngle()+(mousePosX - mouseOldX));
            mouseOldX = mousePosX;
            mouseOldY = mousePosY;
        });

        primaryStage.setTitle("Simple Rubik's Cube - JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    // F   R   U   B   L   D
    private static final int[] FLD  = new int[]{BLUE, GRAY, GRAY, GRAY, ORANGE, WHITE};
    private static final int[] FRD  = new int[]{BLUE, RED, GRAY, GRAY, GRAY, WHITE};
    private static final int[] FLU  = new int[]{BLUE, GRAY, YELLOW, GRAY, ORANGE, GRAY};
    private static final int[] FRU  = new int[]{BLUE, RED, YELLOW, GRAY, GRAY, GRAY};

    private static final Point3D pFLD   = new Point3D(-1.1/2,  1.1/2, -1.1/2);
    private static final Point3D pFRD   = new Point3D( 1.1/2,  1.1/2, -1.1/2);
    private static final Point3D pFLU   = new Point3D(-1.1/2, -1.1/2, -1.1/2);
    private static final Point3D pFRU   = new Point3D( 1.1/2, -1.1/2, -1.1/2);

/*    private static final int[] CLD  = new int[]{GRAY, GRAY, GRAY, GRAY, ORANGE, WHITE};
    private static final int[] CRD  = new int[]{GRAY, RED, GRAY, GRAY, GRAY, WHITE};
    private static final int[] CLU  = new int[]{GRAY, GRAY, YELLOW, GRAY, ORANGE, GRAY};
    private static final int[] CRU  = new int[]{GRAY, RED, YELLOW, GRAY, GRAY, GRAY};

    private static final Point3D pCLD   = new Point3D(-1.1,  1.1, 0);
    private static final Point3D pCRD   = new Point3D( 1.1,  1.1, 0);
    private static final Point3D pCLU   = new Point3D(-1.1, -1.1, 0);
    private static final Point3D pCRU   = new Point3D( 1.1, -1.1, 0);*/

    private static final int[] BLD  = new int[]{GRAY, GRAY, GRAY, GREEN, ORANGE, WHITE};
    private static final int[] BRD  = new int[]{GRAY, RED, GRAY, GREEN, GRAY, WHITE};
    private static final int[] BLU  = new int[]{GRAY, GRAY, YELLOW, GREEN, ORANGE, GRAY};
    private static final int[] BRU  = new int[]{GRAY, RED, YELLOW, GREEN, GRAY, GRAY};

    private static final Point3D pBLD   = new Point3D(-1.1/2,  1.1/2, 1.1/2);
    private static final Point3D pBRD   = new Point3D( 1.1/2,  1.1/2, 1.1/2);
    private static final Point3D pBLU   = new Point3D(-1.1/2, -1.1/2, 1.1/2);
    private static final Point3D pBRU   = new Point3D( 1.1/2, -1.1/2, 1.1/2);

    private static final List<int[]> patternFaceF = Arrays.asList(
            FLD, FRD, FLU, FRU,
           /* CLD, CRD, CLU, CRU,*/
            BLD,  BRD, BLU, BRU);

    private static final List<Point3D> pointsFaceF = Arrays.asList(
            pFLD,  pFRD, pFLU, pFRU,
           /* pCLD, pCRD,  pCLU, pCRU,*/
            pBLD,  pBRD, pBLU, pBRU);

    private TriangleMesh createCube(int[] face) {
        TriangleMesh m = new TriangleMesh();

        // POINTS
        m.getPoints().addAll(
                 0.5f,  0.5f,  0.5f,           //0
                 0.5f, -0.5f,  0.5f,           //1
                 0.5f,  0.5f, -0.5f,           //2
                 0.5f, -0.5f, -0.5f,           //3
                -0.5f,  0.5f,  0.5f,           //4
                -0.5f, -0.5f,  0.5f,           //5
                -0.5f,  0.5f, -0.5f,           //6
                -0.5f, -0.5f, -0.5f            //7
        );

        // TEXTURES
        m.getTexCoords().addAll(
                0,          0, X_RED,       0, X_RED,       1,0,        1,//0
                X_RED,      0, X_GREEN,     0, X_GREEN,     1,X_RED,    1,//1
                X_GREEN,    0, X_BLUE,      0, X_BLUE,      1,X_GREEN,  1,//2
                X_BLUE,     0, X_YELLOW,    0, X_YELLOW,    1,X_BLUE,   1,//3
                X_YELLOW,   0, X_ORANGE,    0, X_ORANGE,    1,X_YELLOW, 1,//4
                X_ORANGE,   0, X_WHITE,     0, X_WHITE,     1,X_ORANGE, 1,//5
                X_WHITE,    0, X_GRAY,      0, X_GRAY,      1,X_WHITE,  1 //6
        );

        // FACES
        m.getFaces().addAll(
                2,4*face[0],    3,4*face[0]+1,  6,4*face[0]+3,      // F
                3,4*face[0]+1,  7,4*face[0]+2,  6,4*face[0]+3,

                0,4*face[1]+3,  1,4*face[1],    2,4*face[1]+2,      // R
                2,4*face[1]+3,  1,4*face[1]+1,  3,4*face[1],

                1,4*face[2],    5,4*face[2]+1,  3,4*face[2]+3,      // U
                5,4*face[2]+1,  7,4*face[2]+2,  3,4*face[2]+3,

                0,4*face[3],    4,4*face[3]+1,  1,4*face[3]+3,      // B
                4,4*face[3]+1,  5,4*face[3]+2,  1,4*face[3]+3,

                4,4*face[4],    6,4*face[4]+1,  5,4*face[4]+3,      // L
                6,4*face[4]+1,  7,4*face[4]+2,  5,4*face[4]+3,

                0,4*face[5],    2,4*face[5]+1,  4,4*face[5]+3,      // D
                2,4*face[5]+1,  6,4*face[5]+2,  4,4*face[5]+3
        );
        return m;
    }

    public static void main(String[] args) {
        launch(args);
    }

}