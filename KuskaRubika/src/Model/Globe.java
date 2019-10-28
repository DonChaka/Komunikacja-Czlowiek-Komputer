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
import javafx.scene.shape.Sphere;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * Simple implementation of the Rubik's cube using JavaFX 3D
 * http://stackoverflow.com/questions/34001900/how-to-render-3d-graphics-properly
 * @author JosePereda
 */
public class Globe extends Application {

    private double mousePosX;
    private double mousePosY;
    private double mouseOldX;
    private double mouseOldY;


    private static final String DIFFUSE_MAP =
            "http://planetmaker.wthr.us/img/earth_gebco8_texture_8192x4096.jpg";
    private static final String NORMAL_MAP =
            "http://planetmaker.wthr.us/img/earth_normalmap_flat_8192x4096.jpg";
    private static final String SPECULAR_MAP =
            "http://planetmaker.wthr.us/img/earth_specularmap_flat_8192x4096.jpg";

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
        mat.setDiffuseMap(new Image(DIFFUSE_MAP)
        );
        mat.setBumpMap(new Image(NORMAL_MAP)
        );
        mat.setSpecularMap(new Image(SPECULAR_MAP)
        );


        Sphere ziemia = new Sphere(2);
        ziemia.setMaterial(mat);

        Rotate rotateX = new Rotate(30, 0, 0, 0, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(20, 0, 0, 0, Rotate.Y_AXIS);
        ziemia.getTransforms().addAll(rotateX, rotateY);

        PointLight light = new PointLight();
        light.setTranslateX(100);
        light.setTranslateY(-100);

        sceneRoot.getChildren().addAll(ziemia, light);

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
    /*// F   R   U   B   L   D

    private static final List<int[]> patternFaceF = Arrays.asList();

    private static final List<Point3D> pointsFaceF = Arrays.asList();

    private TriangleMesh createSphere(int[] face) {
        TriangleMesh m = new TriangleMesh();

        // POINTS
        m.getPoints().addAll(
                0.5f,  0.5f,  0.5f,
                0.5f, -0.5f,  0.5f,
                0.5f,  0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                -0.5f,  0.5f,  0.5f,
                -0.5f, -0.5f,  0.5f,
                -0.5f,  0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f
        );

        // TEXTURES
        m.getTexCoords().addAll(
                X_RED, 0.5f,
                X_GREEN, 0.5f,
                X_BLUE, 0.5f,
                X_YELLOW, 0.5f,
                X_ORANGE, 0.5f,
                X_WHITE, 0.5f,
                X_GRAY, 0.5f
        );

        // FACES
        m.getFaces().addAll(
                2,face[0],3,face[0],6,face[0],      // F
                3,face[0],7,face[0],6,face[0],

                0,face[1],1,face[1],2,face[1],      // R
                2,face[1],1,face[1],3,face[1],

                1,face[2],5,face[2],3,face[2],      // U
                5,face[2],7,face[2],3,face[2],

                0,face[3],4,face[3],1,face[3],      // B
                4,face[3],5,face[3],1,face[3],

                4,face[4],6,face[4],5,face[4],      // L
                6,face[4],7,face[4],5,face[4],

                0,face[5],2,face[5],4,face[5],      // D
                2,face[5],6,face[5],4,face[5]
        );
        return m;
    }*/

    public static void main(String[] args) {
        launch(args);
    }

}