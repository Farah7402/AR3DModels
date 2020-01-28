package com.farah.arwithdifferentimages;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArFragment arFragment;
    private ModelRenderable bearRenderable,
            robotRenderable,
            cowRenderable,
            catRenderable,
            dogRenderable,
            elephantRenderable,
            ferretRenderable,
            wolverineRenderable,
            hippoRenderable,
            lionRenderable,
            horseRenderable,
            reindeerRenderable,
            KoalaRenderable,
            treeRenderable,
            akaiRenderable,
            alphaRenderable;

    ImageView bear,cat,cow,robot,dog,elephant,hippo,horse,koalabear,wolverine,reindeer,ferret,lion,tree,akai,alpha;

    ImageView[] arrayView;

    int selected = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment = (ArFragment)getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);

        cat= (ImageView)findViewById(R.id.cat);
        cow= (ImageView)findViewById(R.id.cow);
        dog= (ImageView)findViewById(R.id.dog);
        robot=(ImageView)findViewById(R.id.robot);
        bear= (ImageView)findViewById(R.id.bear);
        elephant= (ImageView)findViewById(R.id.elephant);
        koalabear=(ImageView)findViewById(R.id.koala_bear);
        ferret=(ImageView)findViewById(R.id.ferret);
        lion=(ImageView)findViewById(R.id.lion);
        hippo=(ImageView)findViewById(R.id.hippo);
        horse=(ImageView)findViewById(R.id.horse);
        wolverine=(ImageView)findViewById(R.id.wolverine);
        reindeer=(ImageView)findViewById(R.id.reindeer);
        tree=(ImageView)findViewById(R.id.tree);
        akai=(ImageView)findViewById(R.id.akai);
        alpha=(ImageView)findViewById(R.id.alpha);



        setArrayView();
        setClickListener();
        
        setupModel();

        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent)
            {

                    Anchor anchor = hitResult.createAnchor();
                    AnchorNode anchorNode = new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());

                    createModel(anchorNode,selected);

            }
        });

    }

    private void setupModel() {



        ModelRenderable.builder()
                .setSource(this,R.raw.bear)
                .build().thenAccept(renderable -> bearRenderable = renderable )
                .exceptionally(

                            throwable ->
                            {
                             Toast toast =   Toast.makeText(this,"bear",Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER,0,0);
                                toast.show();
                                return  null;
                            }

                );

        ModelRenderable.builder()
                .setSource(this,R.raw.robot)
                .build().thenAccept(renderable -> robotRenderable = renderable )
                .exceptionally(

                        throwable ->
                        {
                            Toast toast =   Toast.makeText(this,"bear",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return  null;
                        }

                );


        ModelRenderable.builder()
                .setSource(this,R.raw.cat)
                .build().thenAccept(renderable -> catRenderable = renderable)
                .exceptionally( throwable ->
                {
                    Toast toast =   Toast.makeText(this,"cat",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return  null;
                });

        ModelRenderable.builder()
                .setSource(this,R.raw.cow)
                .build().thenAccept(renderable -> cowRenderable = renderable)
                .exceptionally(  throwable ->
                {
                    Toast toast =   Toast.makeText(this,"cow",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return  null;
                });

        ModelRenderable.builder()
                .setSource(this,R.raw.dog)
                .build().thenAccept(renderable -> dogRenderable = renderable)
                .exceptionally(   throwable ->
                {
                    Toast toast =   Toast.makeText(this,"dog",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return  null;
                });


        ModelRenderable.builder()
                .setSource(this,R.raw.elephant)
                .build().thenAccept(renderable -> elephantRenderable = renderable)
                .exceptionally(   throwable ->
                {
                    Toast toast =   Toast.makeText(this,"elephant",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return  null;
                });

        ModelRenderable.builder()
                .setSource(this,R.raw.ferret)
                .build().thenAccept(renderable -> ferretRenderable = renderable)
                .exceptionally(    throwable ->
                {
                    Toast toast =   Toast.makeText(this,"ferret",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return  null;
                });

        ModelRenderable.builder()
                .setSource(this,R.raw.hippopotamus)
                .build().thenAccept(renderable -> hippoRenderable = renderable)
                .exceptionally(
                        throwable ->
                        {
                            Toast toast =   Toast.makeText(this,"hipppo",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return  null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this,R.raw.horse)
                .build().thenAccept(renderable -> horseRenderable = renderable)
                .exceptionally(  throwable ->
                {
                    Toast toast =   Toast.makeText(this,"horse",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return  null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.koala_bear)
                .build().thenAccept(renderable -> KoalaRenderable = renderable)
                .exceptionally(   throwable ->
                {
                    Toast toast =   Toast.makeText(this,"koala",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return  null;
                });

        ModelRenderable.builder()
                .setSource(this,R.raw.lion)
                .build().thenAccept(renderable -> lionRenderable = renderable)
                .exceptionally(
                        throwable ->
                        {
                            Toast toast =   Toast.makeText(this,"lion",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            return  null;
                        });

        ModelRenderable.builder()
                .setSource(this,R.raw.reindeer)
                .build().thenAccept(renderable -> reindeerRenderable = renderable)
                .exceptionally(throwable ->
                {
                    Toast toast =   Toast.makeText(this,"reindeer",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return  null;
                });


        ModelRenderable.builder()
                .setSource(this,R.raw.wolverine)
                .build().thenAccept(renderable -> wolverineRenderable = renderable)
                .exceptionally
                        (
            throwable ->
            {
                Toast toast = Toast.makeText(this, "wolverine", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return null;
            });

        ModelRenderable.builder()
                .setSource(this,R.raw.tree)
                .build().thenAccept(renderable -> treeRenderable = renderable)
                .exceptionally(throwable ->
                {
                    Toast toast =   Toast.makeText(this,"tree",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return  null;
                });

        ModelRenderable.builder()
                .setSource(this,R.raw.akai)
                .build().thenAccept(renderable -> akaiRenderable = renderable)
                .exceptionally(throwable ->
                {
                    Toast toast =   Toast.makeText(this,"akai",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return  null;
                });

        ModelRenderable.builder()
                .setSource(this,R.raw.alpha)
                .build().thenAccept(renderable -> alphaRenderable = renderable)
                .exceptionally(throwable ->
                {
                    Toast toast =   Toast.makeText(this,"akai",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return  null;
                });

    }

    private void createModel(AnchorNode anchorNode, int selected) {

        if(selected == 1)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 0, 1f), -45.0f ));
            bear.setParent(anchorNode);
            bear.setRenderable(bearRenderable);
            bear.select();

            if(bear!= null){
                Quaternion rotation1 = Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), 90); // rotate X axis 90 degrees
                Quaternion rotation2 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 90); // rotate Y axis 90 degrees
                bear.setLocalRotation(Quaternion.multiply(rotation1, rotation2));}

            addName(anchorNode, bear, "Bear");
        }

     if(selected == 2)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(robotRenderable);
            bear.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 0, 1f), -45.0f ));
            bear.select();

            if(bear!= null){
                Quaternion rotation1 = Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), 90); // rotate X axis 90 degrees
                Quaternion rotation2 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 90); // rotate Y axis 90 degrees
                bear.setLocalRotation(Quaternion.multiply(rotation1, rotation2));}


            addName(anchorNode, bear, "Robot");
        }

        if(selected == 3)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(catRenderable);
            bear.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 0, 1f), -45.0f ));
            bear.select();

            if(bear!= null){
                Quaternion rotation1 = Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), 90); // rotate X axis 90 degrees
                Quaternion rotation2 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 90); // rotate Y axis 90 degrees
                bear.setLocalRotation(Quaternion.multiply(rotation1, rotation2));}


            addName(anchorNode, bear, "Cat");
        }

        if(selected == 4)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(cowRenderable);
            bear.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 0, 1f), -45.0f ));
            bear.select();


            addName(anchorNode, bear, "Cow");
        }

        if(selected == 5)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(dogRenderable);
            bear.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 0, 1f), -45.0f ));
            bear.select();

            addName(anchorNode, bear, "Dog");

            if(bear!= null){
                Quaternion rotation1 = Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), 90); // rotate X axis 90 degrees
                Quaternion rotation2 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 90); // rotate Y axis 90 degrees
                bear.setLocalRotation(Quaternion.multiply(rotation1, rotation2));}

        }

        if(selected == 6)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(elephantRenderable);
            bear.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 0, 1f), -45.0f ));

            bear.select();

            addName(anchorNode, bear, "Elephant");

            if(bear!= null){
                Quaternion rotation1 = Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), 90); // rotate X axis 90 degrees
                Quaternion rotation2 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 90); // rotate Y axis 90 degrees
                bear.setLocalRotation(Quaternion.multiply(rotation1, rotation2));}

        }

      if(selected == 7)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(ferretRenderable);

            bear.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 0, 1f), -45.0f ));

            bear.select();

            addName(anchorNode, bear, "Ferret");

            if(bear!= null){
                Quaternion rotation1 = Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), 90); // rotate X axis 90 degrees
                Quaternion rotation2 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 90); // rotate Y axis 90 degrees
                bear.setLocalRotation(Quaternion.multiply(rotation1, rotation2));}

        }

        if(selected == 8)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(hippoRenderable);
            bear.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 0, 1f), -45.0f ));

            bear.select();

            addName(anchorNode, bear, "Hippo");

            if(bear!= null){
                Quaternion rotation1 = Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), 90); // rotate X axis 90 degrees
                Quaternion rotation2 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 90); // rotate Y axis 90 degrees
                bear.setLocalRotation(Quaternion.multiply(rotation1, rotation2));}
        }
       if(selected == 9)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(horseRenderable);
            bear.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 0, 1f), -45.0f ));

            bear.select();

            addName(anchorNode, bear, "Horse");

            if(bear!= null){
                Quaternion rotation1 = Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), 90); // rotate X axis 90 degrees
                Quaternion rotation2 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 90); // rotate Y axis 90 degrees
                bear.setLocalRotation(Quaternion.multiply(rotation1, rotation2));}
        }
        if(selected == 10)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(KoalaRenderable);
            bear.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 0, 1f), -45.0f ));

            bear.select();

            addName(anchorNode, bear, "Koala");
            if(bear!= null){
                Quaternion rotation1 = Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), 90); // rotate X axis 90 degrees
                Quaternion rotation2 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 90); // rotate Y axis 90 degrees
                bear.setLocalRotation(Quaternion.multiply(rotation1, rotation2));}
        }
        if(selected == 11)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(lionRenderable);
            bear.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 0, 1f), -45.0f ));

            bear.select();

            addName(anchorNode, bear, "Lion");

            if(bear!= null){
                Quaternion rotation1 = Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), 90); // rotate X axis 90 degrees
                Quaternion rotation2 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 90); // rotate Y axis 90 degrees
                bear.setLocalRotation(Quaternion.multiply(rotation1, rotation2));}
        }
     if(selected == 12)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(reindeerRenderable);
            bear.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 0, 1f), -45.0f ));

            bear.select();

            addName(anchorNode, bear, "Reindeer");
            if(bear!= null){
                Quaternion rotation1 = Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), 90); // rotate X axis 90 degrees
                Quaternion rotation2 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 90); // rotate Y axis 90 degrees
                bear.setLocalRotation(Quaternion.multiply(rotation1, rotation2));}
        }

       if(selected == 13)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(wolverineRenderable);
            bear.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 0, 1f), -45.0f ));

            bear.select();

            addName(anchorNode, bear, "Wolverine");
            if(bear!= null){
                Quaternion rotation1 = Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), 90); // rotate X axis 90 degrees
                Quaternion rotation2 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 90); // rotate Y axis 90 degrees
                bear.setLocalRotation(Quaternion.multiply(rotation1, rotation2));}
        }

        if(selected == 14)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(treeRenderable);
            bear.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 0, 1f), -45.0f ));

            bear.select();

            addName(anchorNode, bear, "Tree");
            if(bear!= null){
                Quaternion rotation1 = Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), 90); // rotate X axis 90 degrees
                Quaternion rotation2 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 90); // rotate Y axis 90 degrees
                bear.setLocalRotation(Quaternion.multiply(rotation1, rotation2));}
        }

        if(selected == 15)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(akaiRenderable);
            bear.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 0, 1f), -45.0f ));

            bear.select();

            addName(anchorNode, bear, "Akai");
            if(bear!= null){
                Quaternion rotation1 = Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), 90); // rotate X axis 90 degrees
                Quaternion rotation2 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 90); // rotate Y axis 90 degrees
                bear.setLocalRotation(Quaternion.multiply(rotation1, rotation2));}
        }

        if(selected == 15)
        {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(alphaRenderable);
            bear.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 0, 1f), -45.0f ));

            bear.select();

            addName(anchorNode, bear, "Alpha");
            if(bear!= null){
                Quaternion rotation1 = Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), 90); // rotate X axis 90 degrees
                Quaternion rotation2 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 90); // rotate Y axis 90 degrees
                bear.setLocalRotation(Quaternion.multiply(rotation1, rotation2));}
        }




    }

    private void addName(AnchorNode anchorNode, TransformableNode model, String name) {


        ViewRenderable.builder().setView(this,R.layout.name_animal)
                .build()
                .thenAccept(viewRenderable -> {

                    TransformableNode nameView = new TransformableNode(arFragment.getTransformationSystem());
                    nameView.setLocalPosition(new Vector3(0f,model.getLocalPosition().y+0.5f,0));
                    nameView.setParent(anchorNode);
                    nameView.setRenderable(viewRenderable);
                    nameView.select();

                    TextView txt_name=(TextView)viewRenderable.getView();
                    txt_name.setText(name);

                    txt_name.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            anchorNode.setParent(null);
                        }
                    });
                });




    }

    private void setClickListener() {
        for(int i=0;i<arrayView.length;i++)
        {
            arrayView[i].setOnClickListener(this);
        }
    }

    private void setArrayView() {
        arrayView = new ImageView[]{
     bear,robot,cat,cow,dog,elephant,hippo,horse,koalabear,wolverine,reindeer,ferret,lion,tree,akai,alpha

        };
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.bear)
        {
            selected =1;
            setBackground(view.getId());
        }

        if(view.getId() == R.id.robot)
        {
            selected =2;
            setBackground(view.getId());
        }

      else if(view.getId() == R.id.cat)
        {
            selected =3;
            setBackground(view.getId());
        }
       else if(view.getId() == R.id.cow)
        {
            selected =4;
            setBackground(view.getId());
        }
      else if(view.getId() == R.id.dog)
        {
            selected =5;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.elephant)
        {
            selected =6;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.ferret)
        {
            selected =7;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.hippo)
        {
            selected =8;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.horse)
        {
            selected =9;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.koala_bear)
        {
            selected =10;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.lion)
        {
            selected =11;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.reindeer)
        {
            selected =12;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.wolverine)
        {
            selected =13;
            setBackground(view.getId());
        }

        else if(view.getId() == R.id.tree)
        {
            selected =14;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.akai)
        {
            selected =15;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.alpha)
        {
            selected =16;
            setBackground(view.getId());
        }

    }

    private void setBackground(int id) {
        for (int i=0;i<arrayView.length;i++)
        {
            if (arrayView[i].getId() == id)
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639"));
            else
                arrayView[i].setBackgroundColor(Color.TRANSPARENT);
        }
    }


}
