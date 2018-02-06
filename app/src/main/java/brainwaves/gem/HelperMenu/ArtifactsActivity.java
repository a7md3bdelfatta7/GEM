package brainwaves.gem.HelperMenu;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import brainwaves.gem.MainActivity;
import brainwaves.gem.R;
import brainwaves.gem.data.ArtifactsContract;
import brainwaves.gem.data.ArtifactsFavourite;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ArtifactsActivity extends AppCompatActivity {

    int artifact_num;
    ImageButton artifactAddedToTourImgButton;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_artifacts_details);

        if (Build.VERSION.SDK_INT == 23) {
            checkPermissions();
        }

        artifactAddedToTourImgButton = (ImageButton) findViewById(R.id.add_tourBtn);
        ActionBar actionBar=getSupportActionBar();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.artifacts_actionbar);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        ImageView img = (ImageView) findViewById(R.id.artifact_details);
        TextView artifactActionBar = (TextView) findViewById(R.id.artifactNameActionBar);
        TextView aritfactDetailsText = (TextView) findViewById(R.id.artifact_details_text);
        TextView aritfactDetailsTitle = (TextView) findViewById(R.id.artifact_details_title);
        artifact_num=0;
        switch (Integer.parseInt(id)){
            case R.id.artifact_1:
                artifact_num = 1;
                img.setImageResource(R.drawable.highlight_i);
                aritfactDetailsTitle.setText("TUT ANKAMUN MASK");
                artifactActionBar.setText("TUT ANKAMUN MASK");
                aritfactDetailsText.setText("This mask of Tutankhamun is an example of the high est artistic and technical achievements of the an-cient Egyptians in the New Kingdom.\n" +
                        "            \nCovering the head of the wrapped mummy in its coffin and activated by a magical spell, no.151b from the Book of the Dead, the mask ensured more pro-tection for the king's body.\n" +
                        "            \nThe exact portrayal of the king's facial features achieved here made it possible for his soul to recog nize him and return to his mummified body, thus en uring his resurrection.\n" +
                        "            \nhe head is covered by the royal headdress and the forehead bears the emblems of kingship and protec tion: the vulture and uraeus, or cobra.\n" +
                        "            \nThe gold sheets used in this wonderful mask are joinec together by heating and hammering. The eyes are of obsidian and quartz and the eyebrows and eyelids are inlaid with lapis lazuli. The broad inlaid collar of semiprecious stones and colored glass ends in falcon heads.\n" +
                        "            \n\nDimensions: Height 54 cm Width 39.3 cm\n");
                break;
            case R.id.artifact_2:
                artifact_num = 2;
                img.setImageResource(R.drawable.highlight_ii);
                aritfactDetailsTitle.setText("Sphinx of Amenhotep the Second");
                artifactActionBar.setText("Sphinx of Amenhotep the Second");
                aritfactDetailsText.setText("A sphinx has the body and strength of a lion and the head or face of a man, symbolizing wisdom and intelligence. \n" +
                        "\n" +
                        "The ancient Egyptians sculpted different kinds of sphinxes with a human head, a ram head, or a human face with the mane of a lion. Sphinxes represent various deities, especially Amun-Re, identified with the kings who reigned when the sphinxes were made. \n" +
                        "\n" +
                        "The human heads or faces usually have the facial features of these kings. This sphinx portrays King Amenhotep the Second.\n");
                break;
            case R.id.artifact_3:
                artifact_num = 3;
                img.setImageResource(R.drawable.highlight_iii);
                aritfactDetailsTitle.setText("Anubis Carrying the Moon Disk");
                artifactActionBar.setText("Anubis Carrying the Moon Disk");
                aritfactDetailsText.setText("Anubis, the black jackal, was the animal that personified the deity who was believed to protect the cemetery, and thus became the patron deity of mummification. Anubis was depicted in funerary scenes guiding the deceased to Osiris in the court of justice. Embalmers performing the mummification of the corpses wore jackal masks. \n" +
                        "\n" +
                        "In the legend of the divine birth of Queen Hatshepsut and King Amenhotep the third, Anubis is represented rolling or bringing the disk of the moon and wishing the young royal children long life. In modern times, ceremonies performed on the seventh day of a child's birth contain a step, in which the newly born child is put in a sieve and is shaken and asked to \"obey his mother and not to obey his father.\" \n" +
                        "\n" +
                        "On this cartonnage piece, the jackal-headed god comes, carrying the disk of the moon, and wishing the deceased long life. He wears a gilded collar, an unusual short kilt with a long tail hanging from the front and sandals. A long, wide white drapery hangs from behind and reaches the feet.\n" +
                        "Dimensions:  Width 13.5 cm  Height 33.5 cm\n");
                break;
            case R.id.artifact_4:
                artifact_num = 4;
                img.setImageResource(R.drawable.highlight_iv);
                aritfactDetailsTitle.setText("Shawabti of Tutankhamun");
                artifactActionBar.setText("Shawabti of Tutankhamun");
                aritfactDetailsText.setText("The Shawabti, or funerary, figures were intended to perform work in the place of the deceased in the afterlife. They were usually made of faience, wood, or pottery and were various sizes. \n" +
                        "\n" +
                        "They were divided according to their functions and to the Egyptian calendar as follows: 365 workmen, each for one day of the year, and 36 overseers, each as a chief of a week of ten days or ten workers. In the tomb of Tutankhamun, 12 supplementary foremen were added, one for each month, totaling 413. \n" +
                        "\n" +
                        "This Shawabti of gilded wood is an image of the young king wearing the Khepresh crown of ceremonies and processions and the uraeus. It is adorned with a broad collar cut in gold leaf and the two insignia of Osiris.\n");
                break;
            case R.id.artifact_5:
                artifact_num = 5;
                img.setImageResource(R.drawable.highlight_v);
                aritfactDetailsTitle.setText("Crocodile God Sobek");
                artifactActionBar.setText("Crocodile God Sobek");
                aritfactDetailsText.setText("The River Nile and the canals were the main roads of ancient Egypt, although sailing was a great risk because of the crocodiles and hippopotami. Egyptians, therefore, wanted to ward off the danger from crocodiles. They built temples for the cult of the crocodile god Sobek at Esna, Kom Ombo, the Faiyum region, and other places. Each temple had a pool or small underground chambers, in which a live crocodile was kept to receive the offerings and prayers. \n" +
                        "Sobek was associated with the sun god Re. In the Book of the Dead, spells were compiled for the deceased person \"for driving off the crocodile that comes to take away the deceased's magic from him in the realm of the dead\" (spell 31). \n" +
                        "This statue was placed in one of the god's temples by a pious worshipper. It was easy to pray and place offerings in front of the statue. The figure, together with the base, was cut from a single block. The mouth is closed, and the details of the body were carved in relief, crossed and striped. Few details, however, can be seen on the figure.\n" +
                        "Dimensions:  Length 9 cm  Height 6.5 cm\n");
                break;
            case R.id.artifact_6:
                artifact_num = 6;
                img.setImageResource(R.drawable.highlight_xv);
                aritfactDetailsTitle.setText("Goddess Isis Nursing Her Son Horus");
                artifactActionBar.setText("Goddess Isis Nursing Her Son Horus");
                aritfactDetailsText.setText("Isis was the wife of the god Osiris and mother of the falcon god Horus. The divine triad was one of the most important and famous groups of deities in ancient Egypt. Isis was often represented nursing her son Horus and became the symbol of motherhood and protection. She was also the goddess of charm and protected people from evil and from magic. \n" +
                        "\n" +
                        "This is a statue of the goddess carrying the child Horus and nursing him in a symbolic way. In this form, she was also identified with the cow Hathor, the mother goddess. There is a similarity between the statues of Isis nursing her son Horus and the later Christian images of the Madonna and Child. On the goddess's head are the two horns of the cow Hathor with the sun disk between them.\n" +
                        "\n" +
                        "Dimensions:  Height 32 cm\n");
                break;
            case R.id.artifact_7:
                artifact_num = 7;
                img.setImageResource(R.drawable.highlight__i);
                aritfactDetailsTitle.setText("Outer Coffin of Queen Meritamun");
                artifactActionBar.setText("Outer Coffin of Queen Meritamun");
                aritfactDetailsText.setText("This giant coffin of Queen Meritamun, wife of Amenhotep the First of the Eighteenth Dynasty, is considered to be one of the finest coffins ever made in Egypt. It depicts the deceased queen, wearing a long wig, the ends of which with their two locks almost reach her chest. \n" +
                        "\n" +
                        "Her arms are crossed on her chest; each hand holds a lotus scepter, which is the symbol of resurrection. A collar with incised parallel lines shows between the locks of hair. The rest of the lid is decorated with long parallel feather designs. \n" +
                        "\n" +
                        "These designs are exquisitely carved directly into the wood, rather than being modeled or inscribed on the gesso, or plaster of Paris covering, of the coffin. \n" +
                        "In the center of the lid there is a long vertical painted hieroglyphic inscription. It invokes the god Osiris to grant offerings to the queen and \"every beautiful and pure thing and the sweet breath of the North\".\n" +
                        "Dimensions:  Length 3.1 cm  Width 87 cm\n");
                break;
            case R.id.artifact_8:
                artifact_num = 8;
                img.setImageResource(R.drawable.highlight__ii);
                aritfactDetailsTitle.setText("Bust of Amenemhat the Third in Priestly Costume");
                artifactActionBar.setText("Bust of Amenemhat the Third in Priestly Costume");
                aritfactDetailsText.setText("This is the upper part of a gray granite, larger than life-size statue of King Amenemhat the Third. It depicts the king as a high priest wearing the panther skin. \n" +
                        "\n" +
                        "The high cheekbones, wrinkled face, and bitter, pouted mouth identify the statue as belonging to the Twelfth Dynasty ruler, King Amenemhat the Third. This statue had been formerly attributed to a Hyksos king of the Seventeenth Dynasty. \n" +
                        "\n" +
                        "This statue portrays the king as standard-bearer for the first time. \n" +
                        "\n" +
                        "This depiction was frequently used in the later Ramesside period.\n" +
                        "Dimensions:  Height 100 cm  Width 99 cm\n");
                break;
            case R.id.artifact_9:
                artifact_num = 9;
                img.setImageResource(R.drawable.highlight__iii);
                aritfactDetailsTitle.setText("Gold Mask Mummy Cover of King Psusennes the First");
                artifactActionBar.setText("Gold Mask Mummy Cover of King Psusennes the First");
                aritfactDetailsText.setText("In this gold mask mummy cover, Psusennes the First appears with the royal headdress surmounted by the uraeus, or royal cobra. He wears a divine plaited false beard. \n" +
                        "The mask is made of two pieces of beaten gold, soldered and joined together by five nails that can be seen from the back. \n" +
                        "\n" +
                        "The king wears the royal Nemes headdress, usually made of linen, surmounted by the sacred uraeus, the royal cobra. This protected the king against his opponents and enemies in life and after death. \n" +
                        "\n" +
                        "The king wears a divine plaited false beard, which is the symbol of dignity. He also wears a broad Usekh collar incised with floral decorations. The inlays of the eyelids and eyebrows and the straps fixing the beard are of glass paste. The eyes are made of black and white stone.\n" +
                        "\n" +
                        "Dimensions:  Height 45 cm  Width 38 cm\n");
                break;
            case R.id.artifact_10:
                artifact_num = 10;
                img.setImageResource(R.drawable.highlight__iv);
                aritfactDetailsTitle.setText("Gold Cover of Psusennes' Mummy");
                artifactActionBar.setText("Gold Cover of Psusennes' Mummy");
                aritfactDetailsText.setText("This gold sheet covered the mummy of King Psusennes the first, who lived during the Twenty-First Dynasty. His tomb, which contained amazing treasures, was discovered at Tanis. \n" +
                        "The mummy had been placed in three sarcophagi for protection. The smallest is made of silver; the second is made of black granite, and the third, and largest, is pink granite. \n" +
                        "A gold mask hid the face of the mummy and the body was covered with this sheet of gold, which is decorated in the center with a winged ram holding in his claws the shen signs, symbols of eternity. \n" +
                        "\n" +
                        "The upper part of the cover, corresponding to the torso, is decorated with two hands holding the insignia of the god Osiris: the crook and the flail. The rest of the cover is decorated with simulated mummy bandages.\n");
                break;
            case R.id.artifact_11:
                artifact_num = 11;
                img.setImageResource(R.drawable.highlight__v);
                aritfactDetailsTitle.setText("Queen Hatshepsut Offering to Osiris");
                artifactActionBar.setText("Queen Hatshepsut Offering to Osiris");
                aritfactDetailsText.setText("On this flake, the artist intended to show respect for the queen's majesty and drew her as a masculine figure, kneeling and wearing the Khepresh helmet-like crown of ceremonies. She is offering two jars of wine and cool water to the god Osiris of the underworld (not shown). \n" +
                        "The queen wears a collar and a short kilt fastened with a belt. The text refers to \"Maat-Ka-Ra (the throne name of Hatshepsut) beloved of Osiris,\" and \"offering wine and cool water\". The drawing is brightly colored and the primarily red sketch lines, and some corrections in the proportions are shown.\n" +
                        "\n" +
                        "Dimensions:  Width 8 cm  Height 15 cm\n");
                break;
            case R.id.artifact_12:
                artifact_num = 12;
                img.setImageResource(R.drawable.highlight__xv);
                aritfactDetailsTitle.setText("Fragments of Standing Statue of a King");
                artifactActionBar.setText("Fragments of Standing Statue of a King");
                aritfactDetailsText.setText("The statue portrays a king standing on a small base. His left leg is forward, in the tradition of Egyptian statuary. He wears the White Crown of Upper Egypt and the short royal kilt called the Shendyt. His left arm is by his side, the right arm is bent, and he is holding the royal mace. \n" +
                        "The artist succeeded in carving the facial features and the ceremonial beard in this hard stone. Judging by its artistic style despite the bad state of its preservation, it is possible to attribute this statuette to King Nefer-ef-Re of the Fifth Dynasty.\n" +
                        "Dimensions:  Height 21 cm\n");
                break;
            case R.id.artifact_13:
                artifact_num = 13;
                img.setImageResource(R.drawable.staff_i);
                aritfactDetailsTitle.setText("Sarcophagus of Isis");
                artifactActionBar.setText("Sarcophagus of Isis");
                aritfactDetailsText.setText("Isis was the daughter of Khonsu and probably a second wife of Khabekhnet. \n" +
                        "\n" +
                        "The coffin is made in the image of Isis. Her face is long. She wears an elaborately curled wig crowned by a wide floral headband. A large and colorful floral collar covers her entire chest and rosettes mark her breasts. Jewelry further enhances Isis's beauty. She wears earrings that are made of bone or ivory. She also has rings on her fingers and bracelets on her wrists. \n" +
                        "Isis is clothed with a long garment made of a single large piece of fringed linen. It was first wrapped around her torso, then draped over her shoulders and secured with a knot. In both hands, Isis clasps delicate tendrils of a creeper vine. This plant probably had a symbolic relationship with birth and rejuvenation. \n" +
                        "\n" +
                        "Hieroglyphic inscriptions are written around the box and the lid.\n" +
                        "Dimensions:  Length 190 cm\n");
                break;
            case R.id.artifact_14:
                artifact_num = 14;
                img.setImageResource(R.drawable.staff_ii);
                aritfactDetailsTitle.setText("Sarcophagus with Cover Depicting the Deceased");
                artifactActionBar.setText("Sarcophagus with Cover Depicting the Deceased");
                aritfactDetailsText.setText("The sarcophagus is in the shape of a mummy. The cover portrays the deceased with all his accessories and his decorated shroud. \n" +
                        "\n" +
                        "He wears a long wig reaching his chest that leaves the ears exposed. He also wears a false beard, and a large collar with many lines. Under the collar, a winged goddess and two eyes of Horus are depicted for his protection. \n" +
                        "\n" +
                        "His hands are flat on his body, which is covered with many crossed hieroglyphic bands. The bands bear the magical formula from the Book of the Dead to protect the deceased. \n" +
                        "\n" +
                        "On the bottom of the cover, Anubis, the god of mummification and the necropolis, is portrayed twice. The two depictions face each other.\n" +
                        "Dimensions:  Height 70 cm  Length 250 cm  Width 90 cm\n");
                break;
            case R.id.artifact_15:
                artifact_num = 15;
                img.setImageResource(R.drawable.staff_iii);
                aritfactDetailsTitle.setText("Sarcophagus of Queen Kawit");
                artifactActionBar.setText("Sarcophagus of Queen Kawit");
                aritfactDetailsText.setText("The sarcophagus of Queen Kawit, who was the wife of King Montuhotep the Second, was one of the most noteworthy in terms of the low-relief sculpture in the Theban court. \n" +
                        "The outer faces of this limestone sarcophagus are decorated with scenes from daily life, such as the queen applying makeup. Other scenes depict offerings and the afterlife. \n" +
                        "\n" +
                        "At the place of Queen Kawit's head, there is a palace facade with the central doors decorated with Udjat eyes to permit the deceased to communicate with the world of living. \n" +
                        "The elongated bodies and the coarse facial features reflect the Theban ideal of feminine beauty.\n" +
                        "\n" +
                        "Dimensions:  Height 119 cm  Length 262 cm  Width 119 cm\n");
                break;
            case R.id.artifact_16:
                artifact_num = 16;
                img.setImageResource(R.drawable.staff_iv);
                aritfactDetailsTitle.setText("Amulet in the Shape of Winged Vulture");
                artifactActionBar.setText("Amulet in the Shape of Winged Vulture");
                aritfactDetailsText.setText("This amulet depicts the vulture Nekhbet, patron goddess of Upper Egypt. It is in the form of a miniature wide Usekh collar and is made of beaten gold with a counterweight. It was found among many pieces of jewelry belonging to King Psusennes the First. \n" +
                        "\n" +
                        "The amulet was made to be hung on the king's garments by passing a wire or a string through a loop at the back of the amulet. \n" +
                        "\n" +
                        "The details of the vulture's feathers, the wings and claws are all elaborately incised. The claws are holding the Shen rings of the universal power.\n" +
                        "\n" +
                        "Dimensions:  Height 3.5 cm  Width 3.8 cm\n");
                break;
            case R.id.artifact_17:
                artifact_num = 17;
                img.setImageResource(R.drawable.staff_v);
                aritfactDetailsTitle.setText("Sphinx of Amenemhat the Third");
                artifactActionBar.setText("Sphinx of Amenemhat the Third");
                aritfactDetailsText.setText("Seven sphinxes of Amenemhat were found in Tanis in the eastern Delta. They were thus called the Tanite sphinxes. They evoke the superhuman power of the king and emphasize his fearful appearance. \n" +
                        "The vigorous face of the pharaoh is characterized by his prominent cheekbones, protuberant mouth and deeply furrowed cheeks, which create an effect of strength. Instead of the traditional Nemes headdress, his face is framed by a massive lion's mane that increases the sense of his majesty. \n" +
                        "The statues rest on a tall and solid base decorated with cartouches of several sovereigns such as the Hyksos king Nehsy, Ramesses the Second, Merenptah and Psusennes, who all, over the centuries, usurped the group of sphinxes, fascinated by their idea. Egyptologists had mistankenly called them \"the Hyksos sphinxes\" because of their strange visage and the different names of the usurpers containing a Hyksos ruler too.\n" +
                        "Dimensions:  Length 220 cm  Height 75 cm\n");
                break;
            case R.id.artifact_18:
                artifact_num = 18;
                img.setImageResource(R.drawable.staff_xv);
                aritfactDetailsTitle.setText("Meroitic Ba Statue of a Woman");
                artifactActionBar.setText("Meroitic Ba Statue of a Woman");
                aritfactDetailsText.setText("This Ba statue depicts the soul as a bird with a human head. The statue depicts a lady with long wings standing on a flat pedestal that is slipped into a roughly executed base. \n" +
                        "Her facial features are defined by low relief lines that indicate the eyelids, the small smiling lips, and the large ears. \n" +
                        "The three vertical cuts on each of her cheeks illustrate a Nubian custom. A round hole was cut on top of her head to hold a sun disk. \n" +
                        "She wears a painted collar around her neck. The upper part of her body is nude and a long, wide skirt reveals only the front of her sandaled feet, which are carefully portrayed. Her arms are held to her sides and her right hand holds a cylindrical object. \n" +
                        "The Ba statue was originally Egyptian, but placing this type of statue outside the tomb became common in Nubia.\n" +
                        "\n" +
                        "Dimensions:  Height 66 cm  Length 44 cm\n");
                break;
            case R.id.artifact_19:
                artifact_num = 19;
                img.setImageResource(R.drawable.staff__i);
                aritfactDetailsTitle.setText("Statue of In-Heret-Shu as a Mummy");
                artifactActionBar.setText("Statue of In-Heret-Shu as a Mummy");
                aritfactDetailsText.setText("The statue is one of several gilded wooden statues of deities found in the tomb of Tutankhamun. It depicts the god In-Heret-Shu standing on a rectangular base. \n" +
                        "\n" +
                        "He is portrayed in the form of a mummy and his body is completely enveloped in a cloak. He wears a three-part wig on his head topped by four high feathers. His arms are crossed on his chest, which is adorned by a large pectoral. His body is entirely gilded, except for his eyes, eyebrows, and false beard.\n" +
                        "\n" +
                        "Dimensions:  Height 74.5 cm\n");
                break;
            case R.id.artifact_20:
                artifact_num = 20;
                img.setImageResource(R.drawable.staff__ii);
                aritfactDetailsTitle.setText("Statue of Khufu-iam and his Wife");
                artifactActionBar.setText("Statue of Khufu-iam and his Wife");
                aritfactDetailsText.setText("Khufu-iam and his wife are shown seated on a backless seat. The husband's hands are on his knees and he holds a small staff in his left hand. He wears a short curly wig covering his ears and a short overlapping kilt with wavy pleats, which was a fashionable garment during his period. \n" +
                        "\n" +
                        "His wife sits next to him, resting her right arm on his right shoulder, a common pose in Ancient Egyptian statuary that shows strong family ties. \n" +
                        "\n" +
                        "She wears a wide wig of medium length over her natural hair, which is partly visible.\n" +
                        "Dimensions:  Height 45 cm  Width 27.5 cm\n");
                break;
            case R.id.artifact_21:
                artifact_num = 21;
                img.setImageResource(R.drawable.staff__iii);
                aritfactDetailsTitle.setText("Statue of the God Anubis with His Young Ones");
                artifactActionBar.setText("Statue of the God Anubis with His Young Ones");
                aritfactDetailsText.setText("The jackal was the sacred animal of the god Wepwawet and Anubis, the god of mummification. The sculpture of this sacred animal with his young ones is unique. \n" +
                        "\n" +
                        "The group is portrayed on a rectangular base on which the jackal is lying on his side. Two of the four young jackals are held in his paws, one sits between the paw and the tail, and the other is held under the jackal's face. \n" +
                        "\n" +
                        "A scene of this type depicts the concept of paternal or maternal protection, which was synonymous with birth.\n" +
                        "\n" +
                        "Dimensions:  Height 5 cm  Length 8 cm\n");
                break;
            case R.id.artifact_22:
                artifact_num = 22;
                img.setImageResource(R.drawable.staff__iv);
                aritfactDetailsTitle.setText("Statue of Goddess Hathor as a Cow");
                artifactActionBar.setText("Statue of Goddess Hathor as a Cow");
                aritfactDetailsText.setText("This statue of Hathor is a life-size depiction of a cow, her sacred animal. It was dedicated by Amenhotep the Second to Hathor and his father Tuthmosis the Third. \n" +
                        "\n" +
                        "The cow is represented here coming out of the marshes as if to provide the deceased king with food offerings. Between her horns are the royal cobra uraeus, the sun disk, and two feathers. The cow's body has colored spots. \n" +
                        "\n" +
                        "The small figure standing in front, beneath the cow's head, is that of the king. He is also depicted in relief being suckled by the cow to regain life and vitality.\n" +
                        "\n" +
                        "Dimensions:  Height 2.2 cm  Length 2.3 cm\n");
                break;
            case R.id.artifact_23:
                artifact_num = 23;
                img.setImageResource(R.drawable.staff__v);
                aritfactDetailsTitle.setText("Statue of a Uraeus");
                artifactActionBar.setText("Statue of a Uraeus");
                aritfactDetailsText.setText("The uraeus, or royal cobra is fixed to a base. As always, the cobra is depicted with its hood extended, rearing up to powerfully strike any enemy of the king. \n" +
                        "\n" +
                        "On its head, it wears the horns and the sun disk. In this form, the cobra is linked to the sun god Re as it surrounds his solar disk within its coils. \n" +
                        "\n" +
                        "It also represents his fiery eye, which brings destruction to the hostile snakes of the underworld that might threaten the sun god on his nightly journey. The head and body are very well modeled.\n" +
                        "\n" +
                        "Dimensions:  Length 121 cm\n");
                break;
            case R.id.artifact_24:
                artifact_num = 24;
                img.setImageResource(R.drawable.staff__xv);
                aritfactDetailsTitle.setText("Statue of King Khafra");
                artifactActionBar.setText("Statue of King Khafra");
                aritfactDetailsText.setText("Khafra was one of the most famous kings of the Old Kingdom. He had many statues made of hard stone, which exhibit the marvelous skill of the artists during that time. \n" +
                        "\n" +
                        "These statues were made to receive the offerings made to the king by his cult priests and courtiers. They were also used during funerary rituals such as the ceremonies of purification and the Opening of the Mouth. These ceremonies were performed symbolically beside the statues of the deceased king before and after his burial. \n" +
                        "\n" +
                        "Here, the king is represented on the throne with his names inscribed in a cartouche and the Serekh, or palace facade, on both sides of his legs. He is wearing the royal headdress, called the \"Nemes\" in Egyptian, and the royal Shendyt kilt.\n" +
                        "\n" +
                        "\n" +
                        "Dimensions:  Height 120 cm\n");
                break;
        }
        if(artifact_num>12)
            artifactAddedToTourImgButton.setVisibility(View.GONE);
        highlightToFavourites();
        highlightTotour();
    }

    public void shareonClick(View v) {
        Toast.makeText(this,"Done.", Toast.LENGTH_SHORT).show();
    }
    public void onButtonShowPopupWindowClick(View view) {

        // get a reference to the already created main layout
        ScrollView mainLayout = (ScrollView)
                findViewById(R.id.colltections_main_layout);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        popupWindow.showAtLocation(mainLayout, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
    public void onButtonMapPopupWindowClick(View view) {

        // get a reference to the already created main layout
        ScrollView mainLayout = (ScrollView)
                findViewById(R.id.colltections_main_layout);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_map, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        popupWindow.showAtLocation(mainLayout, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
    public void onButtonVRPopupWindowClick(View view) {

        // get a reference to the already created main layout
        ScrollView mainLayout = (ScrollView)
                findViewById(R.id.colltections_main_layout);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_vrunlock, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        popupWindow.showAtLocation(mainLayout, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
    public void unlockVR(View v) {
        String path = "/storage/emulated/0/";
        File file = new File(path, "VR.txt");
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            stream.write("1".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
                PackageManager pm = this.getPackageManager();

                try
                {
                    Intent it = pm.getLaunchIntentForPackage("com.BrainWaves.GEM");

                    if (null != it)
                        this.startActivity(it);
                }

                catch (ActivityNotFoundException e)
                {
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public void videoOnClick(View v) {
        String []artifactsVideoUrl = {"https://www.youtube.com/watch?v=FXk-NbSWDs8",
        "https://www.youtube.com/watch?v=yKGe3FcmLLg",
        "https://www.youtube.com/watch?v=lGq0dOH9qEA",
        "https://www.youtube.com/watch?v=KTrEAvqYSKQ",
        "https://www.youtube.com/watch?v=lzdTBKHjxQ4",
        "https://www.youtube.com/watch?v=lGq0dOH9qEA",
        "https://www.youtube.com/watch?v=X4gr4_aKgyI",
        "https://www.youtube.com/watch?v=wgNYtrfD1U8",
        "https://www.youtube.com/watch?v=DKO-rUJkA4M",
        "https://www.youtube.com/watch?v=DKO-rUJkA4M",
        "https://www.youtube.com/watch?v=yKGe3FcmLLg",
        "https://www.youtube.com/watch?v=BRgWQNOu6v4",
        "https://www.youtube.com/watch?v=ddazR1n7pA4",
        "https://www.youtube.com/watch?v=K6YlJwPurVg",
        "https://www.youtube.com/watch?v=6bv-XeM2l4U",
        "https://www.youtube.com/watch?v=9n62e1HXjIg",
        "https://www.youtube.com/watch?v=4j5yJRwMu0w",
        "https://www.youtube.com/watch?v=L8XcVxUeSyc",
        "https://www.youtube.com/watch?v=EnZKeNim8T8",
        "https://www.youtube.com/watch?v=kIVbqlS05BQ",
        "https://www.youtube.com/watch?v=lGq0dOH9qEA",
        "https://www.youtube.com/watch?v=lGq0dOH9qEA",
        "https://www.youtube.com/watch?v=LXrdxoWNA7M",
        "https://www.youtube.com/watch?v=5OBXPmnkNoQ"};

        String []artifactsVideoIds = {"FXk-NbSWDs8",
                "yKGe3FcmLLg",
                "lGq0dOH9qEA",
                "KTrEAvqYSKQ",
                "lzdTBKHjxQ4",
                "lGq0dOH9qEA",
                "X4gr4_aKgyI",
                "wgNYtrfD1U8",
                "DKO-rUJkA4M",
                "DKO-rUJkA4M",
                "yKGe3FcmLLg",
                "BRgWQNOu6v4",
                "ddazR1n7pA4",
                "K6YlJwPurVg",
                "6bv-XeM2l4U",
                "9n62e1HXjIg",
                "4j5yJRwMu0w",
                "L8XcVxUeSyc",
                "EnZKeNim8T8",
                "kIVbqlS05BQ",
                "lGq0dOH9qEA",
                "lGq0dOH9qEA",
                "LXrdxoWNA7M",
                "5OBXPmnkNoQ"};
//        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(artifactsVideoUrl[artifact_num-1]));
//        startActivity(browserIntent);
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + artifactsVideoIds[artifact_num-1]));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + artifactsVideoIds[artifact_num-1]));
        try {
            this.startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            this.startActivity(webIntent);
        }

    }
    public void connectionOnClick(View v) {
        String []artifactsConnectionsUrl = {"https://www.vanityfair.com/culture/2013/04/king-tut-exhibit-new-york",
                "https://www.britannica.com/biography/Amenhotep-II",
                "http://www.ancientegyptonline.co.uk/anubis.html",
                "http://www.touregypt.net/featurestories/ushabti.htm",
                "http://www.landofpyramids.org/sobek.htm",
                "https://isiopolis.com/2013/01/26/milk-the-magic-of-isis/",
                "https://www.flickr.com/photos/24729615@N00/33528187152/in/photostream/",
                "http://egypttoursinformation.blogspot.com.eg/2015/05/ing-amenemhat-iii-in-priestly-costume.html",
                "https://www.thecultureconcept.com/the-silver-pharaoh-psusennes-i-facing-the-afterlife-in-style",
                "http://ib205.tripod.com/psusennes-mummy.html",
                "http://www.egyptianmyths.net/mythhatshep.htm",
                "https://www.sav.sk/journals/uploads/05141128Magdolen.pdf",
                "http://www.globalegyptianmuseum.org/detail.aspx?id=4934",
                "http://www.touregypt.net/featurestories/coffins.htm",
                "https://www.pbslearningmedia.org/resource/xir68322/queen-kawit-at-her-toilet-from-the-sarc-xir68322-egyptian/#.WnLrZa6WYps",
                "https://www.thecultureconcept.com/the-silver-pharaoh-psusennes-i-facing-the-afterlife-in-style",
                "https://www.ancient.eu/image/3411/",
                "https://www.google.com/culturalinstitute/beta/asset/sandstone-ba-statue-of-a-woman/9wEPlxMrXHSn1A?hl=en",
                "https://www.egypttoursplus.com/tomb-of-king-tut/",
                "http://www.gizapyramids.org/pdf_library/hawass_fs_mokhtar.pdf",
                "http://www.ancientegyptonline.co.uk/anubis.html",
                "https://ancientart.as.ua.edu/head-of-a-cow-goddess-hathor/",
                "http://www.landofpyramids.org/uraeus.htm",
                "http://www.oneonta.edu/faculty/farberas/arth/arth200/Body/egypt_body.htm"};


        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(artifactsConnectionsUrl[artifact_num-1]));
        startActivity(browserIntent);


    }
    public void HighlightsAddTofavouriteonClick(View v) {
        ImageButton flashButtonOn = (ImageButton) findViewById(R.id.favouritesActionBar);
        ArtifactsFavourite artifactFavourite=new ArtifactsFavourite(getApplicationContext());

        if(artifactFavourite.artifactExist(artifact_num+"")){
            artifactFavourite.deleteArtifact(artifact_num);
            flashButtonOn.setImageResource(R.drawable.favourite_blank);
        }
        else {
            flashButtonOn.setImageResource(R.drawable.favourite_red);
            long result = artifactFavourite.addNewArtifact(artifact_num + "");
            if (result == -1) {
                Toast.makeText(this, "Failed to add! try again.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void HighlightsAddToTouronClick(View v) {
        ImageButton flashButtonOn = (ImageButton) findViewById(R.id.add_tourBtn);
        ArtifactsContract artifact=new ArtifactsContract(getApplicationContext());

        if(artifact.artifactExist(artifact_num+"")){
            artifact.deleteArtifact(artifact_num);
            flashButtonOn.setImageResource(R.drawable.add_button_i);
        }
        else {
            flashButtonOn.setImageResource(R.drawable.add_button_ii);
            long result = artifact.addNewArtifact(artifact_num + "");
            if (result == -1) {
                Toast.makeText(this, "Failed to add! try again.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void highlightToFavourites(){
        ImageButton flashButtonOn = (ImageButton) findViewById(R.id.favouritesActionBar);
        ArtifactsFavourite artifactFavourite=new ArtifactsFavourite(getApplicationContext());
        if(artifactFavourite.artifactExist(artifact_num+"")){
            flashButtonOn.setImageResource(R.drawable.favourite_red);
        }
    }
    public void highlightTotour(){
        ImageButton flashButtonOn = (ImageButton) findViewById(R.id.add_tourBtn);
        ArtifactsContract artifact =new ArtifactsContract(getApplicationContext());
        if(artifact.artifactExist(artifact_num+"")){
            flashButtonOn.setImageResource(R.drawable.add_button_ii);
        }
    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
        System.gc();
    }


    String[] permissions = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,

    };

    private boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : permissions) {
            result = ContextCompat.checkSelfPermission(this, p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 100);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == 100) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // do something
            }
            return;
        }
    }
}
