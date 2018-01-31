package brainwaves.gem.HelperMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import brainwaves.gem.Map;
import brainwaves.gem.R;
import brainwaves.gem.data.ArtifactsContract;
import brainwaves.gem.data.TourContract;

public class GroupTourActivity extends AppCompatActivity {


    int[] imgs={
            R.drawable.highlight_i,
            R.drawable.highlight_ii,
            R.drawable.highlight_iii,
            R.drawable.highlight_iv,
            R.drawable.highlight_v,
            R.drawable.highlight_xv,
            R.drawable.highlight__i,
            R.drawable.highlight__ii,
            R.drawable.highlight__iii,
            R.drawable.highlight__iv,
            R.drawable.highlight__v,
            R.drawable.highlight__xv
    };

    String []statues={
            "TUT ANKAMUN MASK","Sphinx of Amenhotep the Second","Anubis Carrying the Moon Disk","Shawabti of Tutankhamun","Crocodile God Sobek",
            "Goddess Isis Nursing Her Son Horus","Outer Coffin of Queen Meritamun","Bust of Amenemhat the Third in Priestly Costume",
            "Gold Mask Mummy Cover of King Psusennes the First",
            "Gold Cover of Psusennes' Mummy","Queen Hatshepsut Offering to Osiris","Fragments of Standing Statue of a King","Statue 12"
    };

    ArrayList<String> tour_artifacts=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_tour);

        ArtifactsContract artifact=new ArtifactsContract(getApplicationContext());
        ArrayList<String> arts=artifact.getSelectedArtifacts();
        LinearLayout contentView=(LinearLayout)findViewById(R.id.artifact_content);


        for(int i=0;i<arts.size();i++) {
           // ImageButton img = (ImageButton) contentView.findViewWithTag(arts.get(i));
           // img.setVisibility(View.VISIBLE);

            int value=Integer.parseInt(arts.get(i))-1;
            ImageButton myArtifact=null;

            if(i==0){
                myArtifact=(ImageButton)findViewById(R.id.artifact_1);
            }else if(i==1){
                myArtifact=(ImageButton)findViewById(R.id.artifact_2);
            }
            else if(i==2){
                myArtifact=(ImageButton)findViewById(R.id.artifact_3);
            }
            else if(i==3){
                myArtifact=(ImageButton)findViewById(R.id.artifact_4);
            }
            else if(i==4){
                myArtifact=(ImageButton)findViewById(R.id.artifact_5);
            }
            else if(i==5){
                myArtifact=(ImageButton)findViewById(R.id.artifact_6);
            }
            else if(i==6){
                myArtifact=(ImageButton)findViewById(R.id.artifact_7);
            }
            else if(i==7){
                myArtifact=(ImageButton)findViewById(R.id.artifact_8);
            }
            else if(i==8){
                myArtifact=(ImageButton)findViewById(R.id.artifact_9);
            }
            else if(i==9){
                myArtifact=(ImageButton)findViewById(R.id.artifact_10);
            }
            else if(i==10){
                myArtifact=(ImageButton)findViewById(R.id.artifact_11);
            }
            else if(i==11){
                myArtifact=(ImageButton)findViewById(R.id.artifact_12);
            }


            myArtifact.setVisibility(View.VISIBLE);
            myArtifact.setImageResource(imgs[value]);
            myArtifact.setTag(arts.get(i));


        }





    }



    public void viewMap(View v){
        Intent intent=new Intent(GroupTourActivity.this,Map.class);
        startActivity(intent);
    }

    public void startTour(View v){
        Toast.makeText(this, "Tour Started", Toast.LENGTH_SHORT).show();
    }

    public void buildTour(View v){

        EditText tourName=(EditText)findViewById(R.id.tour_name);
        if(tourName.getText().toString().length()>0) {
            TourContract tour=new TourContract(getApplicationContext());
            long result=tour.addNewTour(tourName.getText().toString(),tour_artifacts);

            if(result!=-1) {

                Intent intent =new Intent(GroupTourActivity.this,ViewTourActivity.class);
                intent.putExtra("tourName",tourName.getText().toString());
                startActivity(intent);
                finish();
            }

        }else{
            Toast.makeText(this, "Please Enter Tour Name!", Toast.LENGTH_SHORT).show();
        }

    }

    public void addArtifactToTour(View v){

        String x = statues[Integer.parseInt(v.getTag().toString()) - 1];
        if(tour_artifacts.indexOf(v.getTag().toString())==-1) {
            Toast.makeText(this, x, Toast.LENGTH_SHORT).show();

            TextView added_artifacts = (TextView) findViewById(R.id.added_artifacts);
            added_artifacts.append(x + "\n");
            tour_artifacts.add(v.getTag().toString());
        }else{
            Toast.makeText(this,x+" Aready Added!.", Toast.LENGTH_SHORT).show();
        }
    }


    public void inviteClient(View v){

        EditText invitedUserNameEditText=(EditText)findViewById(R.id.invited_user_name);
        String invitedUserName=invitedUserNameEditText.getText().toString();

        if(invitedUserName.length()>0){
            TextView invitedClients=(TextView)findViewById(R.id.invited_clients);
            invitedClients.append(invitedUserName+"\n");
            invitedUserNameEditText.setText("");

        }else{
            Toast.makeText(this,"Enter UserName", Toast.LENGTH_SHORT).show();
        }

    }





}
