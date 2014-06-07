/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sqltotxtconverter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Michi
 */
public class MainGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        setLocationByPlatform(true);
        setTitle("Sql Converter");
        setResizable(false);
        initComponents();
        
        ButtonGroup gruppe = new ButtonGroup();
        gruppe.add(jRadioButton1);
        gruppe.add(jRadioButton2);
        
        jRadioButton1.setSelected(true);
    }
    
    private void createSql() {
        String entry = pfadBox.getText();
        if(entry.isEmpty()) {
            return;
        }
        
        String SqlStruct = new String(
            "SET FOREIGN_KEY_CHECKS=0;\n" +
            "\n" +
            "-- ----------------------------\n" +
            "-- Table structure for mob_proto\n" +
            "-- ----------------------------\n" +
            "DROP TABLE IF EXISTS `mob_proto`;\n" +
            "CREATE TABLE `mob_proto` (\n" +
            "  `vnum` int(11) NOT NULL DEFAULT '0',\n" +
            "  `name` varchar(24) NOT NULL DEFAULT 'Noname',\n" +
            "  `locale_name` varbinary(24) NOT NULL DEFAULT 'Noname',\n" +
            "  `rank` tinyint(2) NOT NULL DEFAULT '0',\n" +
            "  `type` tinyint(2) NOT NULL DEFAULT '0',\n" +
            "  `battle_type` tinyint(1) NOT NULL DEFAULT '0',\n" +
            "  `level` smallint(3) NOT NULL DEFAULT '1',\n" +
            "  `size` enum('SMALL','MEDIUM','BIG') DEFAULT 'SMALL',\n" +
            "  `ai_flag` set('AGGR','NOMOVE','COWARD','NOATTSHINSU','NOATTCHUNJO','NOATTJINNO','ATTMOB','BERSERK','STONESKIN','GODSPEED','DEATHBLOW','REVIVE') DEFAULT NULL,\n" +
            "  `mount_capacity` tinyint(2) NOT NULL DEFAULT '0',\n" +
            "  `setRaceFlag` set('ANIMAL','UNDEAD','DEVIL','HUMAN','ORC','MILGYO','INSECT','FIRE','ICE','DESERT') NOT NULL DEFAULT '',\n" +
            "  `setImmuneFlag` set('STUN','SLOW','FALL','CURSE','POISON','TERROR') NOT NULL DEFAULT '',\n" +
            "  `empire` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `folder` varchar(100) NOT NULL DEFAULT '',\n" +
            "  `on_click` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `st` smallint(5) unsigned NOT NULL DEFAULT '0',\n" +
            "  `dx` smallint(5) unsigned NOT NULL DEFAULT '0',\n" +
            "  `ht` smallint(5) unsigned NOT NULL DEFAULT '0',\n" +
            "  `iq` smallint(5) unsigned NOT NULL DEFAULT '0',\n" +
            "  `damage_min` smallint(5) unsigned NOT NULL DEFAULT '0',\n" +
            "  `damage_max` smallint(5) unsigned NOT NULL DEFAULT '0',\n" +
            "  `max_hp` int(10) unsigned NOT NULL DEFAULT '0',\n" +
            "  `regen_cycle` tinyint(3) unsigned NOT NULL DEFAULT '0',\n" +
            "  `regen_percent` tinyint(3) unsigned NOT NULL DEFAULT '0',\n" +
            "  `gold_min` int(11) NOT NULL DEFAULT '0',\n" +
            "  `gold_max` int(11) NOT NULL DEFAULT '0',\n" +
            "  `exp` int(10) unsigned NOT NULL DEFAULT '0',\n" +
            "  `def` smallint(5) unsigned NOT NULL DEFAULT '0',\n" +
            "  `attack_speed` smallint(6) unsigned NOT NULL DEFAULT '100',\n" +
            "  `move_speed` smallint(6) unsigned NOT NULL DEFAULT '100',\n" +
            "  `aggressive_hp_pct` tinyint(3) unsigned NOT NULL DEFAULT '0',\n" +
            "  `aggressive_sight` smallint(10) unsigned NOT NULL DEFAULT '0',\n" +
            "  `attack_range` smallint(5) unsigned NOT NULL DEFAULT '0',\n" +
            "  `drop_item` int(10) unsigned NOT NULL DEFAULT '0',\n" +
            "  `resurrection_vnum` int(10) unsigned NOT NULL DEFAULT '0',\n" +
            "  `enchant_curse` tinyint(4) unsigned NOT NULL DEFAULT '0',\n" +
            "  `enchant_slow` tinyint(4) unsigned NOT NULL DEFAULT '0',\n" +
            "  `enchant_poison` tinyint(4) unsigned NOT NULL DEFAULT '0',\n" +
            "  `enchant_stun` tinyint(3) unsigned NOT NULL DEFAULT '0',\n" +
            "  `enchant_critical` tinyint(3) unsigned NOT NULL DEFAULT '0',\n" +
            "  `enchant_penetrate` tinyint(3) unsigned NOT NULL DEFAULT '0',\n" +
            "  `resist_sword` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `resist_twohand` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `resist_dagger` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `resist_bell` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `resist_fan` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `resist_bow` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `resist_fire` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `resist_elect` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `resist_magic` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `resist_wind` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `resist_poison` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `dam_multiply` float DEFAULT NULL,\n" +
            "  `summon` int(11) DEFAULT NULL,\n" +
            "  `drain_sp` int(11) DEFAULT NULL,\n" +
            "  `mob_color` int(10) unsigned DEFAULT NULL,\n" +
            "  `polymorph_item` int(10) unsigned NOT NULL DEFAULT '0',\n" +
            "  `skill_level0` tinyint(3) unsigned DEFAULT NULL,\n" +
            "  `skill_vnum0` int(10) unsigned DEFAULT NULL,\n" +
            "  `skill_level1` tinyint(3) unsigned DEFAULT NULL,\n" +
            "  `skill_vnum1` int(10) unsigned DEFAULT NULL,\n" +
            "  `skill_level2` tinyint(3) unsigned DEFAULT NULL,\n" +
            "  `skill_vnum2` int(10) unsigned DEFAULT NULL,\n" +
            "  `skill_level3` tinyint(3) unsigned DEFAULT NULL,\n" +
            "  `skill_vnum3` int(10) unsigned DEFAULT NULL,\n" +
            "  `skill_level4` tinyint(3) unsigned DEFAULT NULL,\n" +
            "  `skill_vnum4` int(10) unsigned DEFAULT NULL,\n" +
            "  `sp_berserk` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `sp_stoneskin` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `sp_godspeed` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `sp_deathblow` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  `sp_revive` tinyint(4) NOT NULL DEFAULT '0',\n" +
            "  PRIMARY KEY (`vnum`)\n" +
            ") ENGINE=MyISAM DEFAULT CHARSET=latin1;"  
        );
        try {
            Writer fw = new FileWriter("mob_proto.sql");
            fw.write(SqlStruct + "\n\n\n");
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pfadBox = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        convertButton = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        browseButton.setText("Browse...");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        convertButton.setText("Convert");
        convertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertButtonActionPerformed(evt);
            }
        });

        jRadioButton1.setText("mob_proto");

        jRadioButton2.setText("item_proto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pfadBox, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addComponent(convertButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfadBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(convertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        int rueckgabeWert = chooser.showOpenDialog(null);
        
        if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
        {
            pfadBox.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    
    private String trim(String ddd) {
        String[] blah = ddd.split(",");
        String lol = "";
        for(int k = 0; k < blah.length; ++k)
            lol += blah[k] + " | ";
                                
        lol = lol.substring(0, lol.length() - 3);
                                
        return lol;
    }
    
    private String convertHexToString(String hex){
        
          if(!hex.contains("0x")) {
              return hex.substring(1, hex.length() - 1);
          }
          StringBuilder output = new StringBuilder();
          for (int i = 2; i < hex.length(); i+=2) {
              String str = hex.substring(i, i+2);
              output.append((char)Integer.parseInt(str, 16));
          }
          
          return output.toString();
  }
    
    private void createMobTxt() {
        String entry = pfadBox.getText();
        if(entry.isEmpty()) {
            return;
        }
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(entry));
            Writer fw = new FileWriter("mob_proto.txt");
            Writer fw2 = new FileWriter("mob_names.txt");
            String line;
            String asdf;
            
            String[] ranks = new String[]{
                "PAWN",
                "PAWN",
                "S_PAWN",
                "S_KNIGHT",
                "BOSS",
                "KING"
            };
            
            String[] types = new String[]{
                "MONSTER", // 0
                "NPC", // 1
                "STONE", // 2
                "WARP", // 3
                "DOOR", // 4
                "BUILDING", // 5
                "", // 6
                "", // 7
                "", // 8
                "GOTO", // 9
            };
            
            String[] battletypes = new String[]{
                "MELEE", // 0
                "RANGE", // 1
                "MAGIC", // 2
                "SPECIAL", // 3
                "POWER", // 4
                "TANKER", // 5
            };
            
            while((line = br.readLine()) != null) {
                if(line.contains("INSERT INTO")) {
                    asdf = line.split("VALUES")[1].substring(2,line.split("VALUES")[1].lastIndexOf(";")-1);
                    String[] entries = asdf.split(", ");
                    String uff = entries[0].substring(1, entries[0].length() - 1) + "\t";
                    for(int i = 1; i < entries.length; ++i) {
                        if(i != 2) {
                            String ddd = entries[i].substring(1, entries[i].length() - 1);
                            
                            if(i == 3)
                                ddd = ranks[Integer.parseInt(ddd)];
                            
                            if(i == 4)
                                ddd = types[Integer.parseInt(ddd)];
                            
                            if(i == 5)
                                ddd = battletypes[Integer.parseInt(ddd)];
                            
                            if(i == 8 && ddd.contains(",")) {
                                ddd = trim(ddd);
                            }
                            
                            if(i == 11 && ddd.contains(",")) {
                                ddd = trim(ddd);
                            }
                            
                            uff += ddd + "\t";
                        }
                    }
                    fw.append(uff + "\n");
                    fw2.append(entries[0].substring(1, entries[0].length() - 1) + "\t" + convertHexToString(entries[2]) + "\n");
                }
            }
            fw.flush();
            fw.close();
            fw2.flush();
            fw2.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void createItemTxt() throws FileNotFoundException, IOException {
        String entry = pfadBox.getText();
        if(entry.isEmpty()) {
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader(entry));
        Writer fw = new FileWriter("item_proto.txt");
        Writer fw2 = new FileWriter("item_names.txt");
        String line;
        
        String[] effects = new String[]{
            "APPLY_NONE",
            "APPLY_MAX_HP",
            "APPLY_MAX_SP",
            "APPLY_CON",		
            "APPLY_INT",		
            "APPLY_STR",		
            "APPLY_DEX",		
            "APPLY_ATT_SPEED",	
            "APPLY_MOV_SPEED",	
            "APPLY_CAST_SPEED",	
            "APPLY_HP_REGEN",		
            "APPLY_SP_REGEN",		
            "APPLY_POISON_PCT",	
            "APPLY_STUN_PCT",		
            "APPLY_SLOW_PCT",	
            "APPLY_CRITICAL_PCT",	
            "APPLY_PENETRATE_PCT",
            "APPLY_ATTBONUS_HUMAN",
            "APPLY_ATTBONUS_ANIMAL",
            "APPLY_ATTBONUS_ORC",	
            "APPLY_ATTBONUS_MILGYO",
            "APPLY_ATTBONUS_UNDEAD",
            "APPLY_ATTBONUS_DEVIL",	
            "APPLY_STEAL_HP",		
            "APPLY_STEAL_SP",		
            "APPLY_MANA_BURN_PCT",	
            "APPLY_DAMAGE_SP_RECOVER",	
            "APPLY_BLOCK",		
            "APPLY_DODGE",		
            "APPLY_RESIST_SWORD",	
            "APPLY_RESIST_TWOHAND",	
            "APPLY_RESIST_DAGGER",	
            "APPLY_RESIST_BELL",		
            "APPLY_RESIST_FAN",		
            "APPLY_RESIST_BOW",		
            "APPLY_RESIST_FIRE",		
            "APPLY_RESIST_ELEC",	
            "APPLY_RESIST_MAGIC",	
            "APPLY_RESIST_WIND",	
            "APPLY_REFLECT_MELEE",	
            "APPLY_REFLECT_CURSE",	
            "APPLY_POISON_REDUCE",	
            "APPLY_KILL_SP_RECOVER",	
            "APPLY_EXP_DOUBLE_BONUS",	
            "APPLY_GOLD_DOUBLE_BONUS",	
            "APPLY_ITEM_DROP_BONUS",	
            "APPLY_POTION_BONUS",	
            "APPLY_KILL_HP_RECOVER",
            "APPLY_IMMUNE_STUN",		
            "APPLY_IMMUNE_SLOW",		
            "APPLY_IMMUNE_FALL",		
            "APPLY_SKILL",	
            "APPLY_BOW_DISTANCE",	
            "APPLY_ATT_GRADE_BONUS",	
            "APPLY_DEF_GRADE_BONUS",	
            "APPLY_MAGIC_ATT_GRADE",	
            "APPLY_MAGIC_DEF_GRADE",	
            "APPLY_CURSE_PCT",		
            "APPLY_MAX_STAMINA",	
            "APPLY_ATTBONUS_WARRIOR",
            "APPLY_ATTBONUS_ASSASSIN",
            "APPLY_ATTBONUS_SURA",	
            "APPLY_ATTBONUS_SHAMAN",	
            "APPLY_ATTBONUS_MONSTER",	
            "APPLY_MALL_EXPBONUS", 
            "APPLY_MAX_HP_PCT",  
            "APPLY_MAX_SP_PCT",  
            "APPLY_MALL_DEFBONUS", 
            "APPLY_NORMAL_HIT_DEFEND_BONUS"
        };
        
        String[] types = new String[]{
            "NONE", // 0
            "ITEM_WEAPON", // 1
            "ITEM_ARMOR", // 2
            "ITEM_USE", // 3
            "", // 4
            "ITEM_MATERIAL", // 5
            "ITEM_SPECIAL", // 6
            "ITEM_LOTTERY", // 7
            "ITEM_ELK", // 9 ----
            "ITEM_METIN", // 10
            "ITEM_CONTAINER", // 11----
            "ITEM_FISH", // 12
            "ITEM_ROD", // 13 ----
            "ITEM_RESOURCE", // 14 
            "ITEM_CAMPFIRE", // 15 ----
            "ITEM_USE", // 16
            "ITEM_SKILLBOOK", // 17 ----
            "ITEM_QUEST", // 18 ----
            "ITEM_POLYMORPH", // 19 ----
            "ITEM_TREASURE_BOX", // 20 ----
            "ITEM_TREASURE_KEY", // 21 ----
            "ITEM_SKILLFORGET", // 22 ----
            "ITEM_GIFTBOX", // 23 ----
            "ITEM_PICK", // 24 ----
            "", "", // 25 26
            "ITEM_BLEND", // 27 ----
            "ITEM_COSTUME", // 28
            "ITEM_DS", // 29
            "","","","", // 30 31 32 33
            "ITEM_BELT", // 34
        };
        
        String[] belt_subtypes = new String[]{
            "USE_POTION", // 0
        };
        
        String[] ds_subtypes = new String[]{
            "DS_SLOT1", // 0
            "DS_SLOT2", // 1
            "DS_SLOT3", // 2
            "DS_SLOT4", // 3
            "DS_SLOT5", // 4
            "DS_SLOT6", // 5
        };
        
        String[] costume_subtypes = new String[]{
            "COSTUME_BODY", // 0
            "COSTUME_HAIR", // 1  
        };
        
        String[] use2_subtypes = new String[]{
            "USE_AFFECT", // 0
            "UNIQUE_SPECIAL_RIDE", // 2
            "ITEM_UNIQUE", // 10
        };
        
        String[] resource_subtypes = new String[]{
            "RESOURCE_FISHBONE", // 0
            "RESOURCE_WATERSTONEPIECE", // 1
            "RESOURCE_WATERSTONE", // 2
            "RESOURCE_BLOOD_PEARL", // 3
            "RESOURCE_BLUE_PEARL", // 4
            "RESOURCE_WHITE_PEARL", // 5
            "RESOURCE_BUCKET", // 6
            "RESOURCE_CRYSTAL", // 7
            "RESOURCE_GEM", // 8
            "RESOURCE_STONE", // 9
            "RESOURCE_METIN", // 10
            "RESOURCE_ORE", // 11
        };
        
        String[] fish_subtypes = new String[]{
            "FISH_ALIVE", // 0
            "FISH_DEAD", // 1
            
        };
        
        String[] metin_subtypes = new String[]{
            "METIN_NORMAL", // 0
        };
        
        String[] weapon_subtypes = new String[]{
            "WEAPON_SWORD", // 0
            "WEAPON_DAGGER", // 1
            "ARMOR_SHIELD", // 2
            "WEAPON_TWO_HANDED", // 3
            "WEAPON_BELL", // 4
            "WEAPON_FAN", // 5
            "WEAPON_ARROW", // 6
        };
        
        String[] armor_subtypes = new String[]{
            "ARMOR_BODY", // 0
            "ARMOR_HEAD", // 1
            "ARMOR_SHIELD", // 2
            "ARMOR_WRIST", // 3
            "ARMOR_FOOTS", // 4
            "ARMOR_NECK", // 5
            "ARMOR_EAR", // 6
        };
        
        String[] use_subtypes = new String[]{
            "USE_POTION", // 0
            "USE_TALISMAN", // 1
            "USE_TUNING", // 2
            "", "", "",
            "USE_BAIT", // 6
            "USE_ABILITY_UP", // 7
            "USE_AFFECT", // 8
            "", // 8
            "USE_SPECIAL", // 10
            "USE_POTION_NODELAY", // 11
            "USE_CLEAR", // 12
            "USE_INVISIBILITY", // 13
            "USE_DETACHMENT", // 14
            "","", // 15 16
            "USE_CLEAN_SOCKET", // 17
            "USE_CHANGE_ATTRIBUTE", // 18
            "USE_ADD_ATTRIBUTE", // 19
            "", // 20
            "USE_PUT_INTO_ACCESSORY_SOCKET", // 21
            "USE_ADD_ATTRIBUTE2", // 22
            "USE_RECIPE", // 23
            "","","", // 24 25 26
            "USE_TIME_CHARGE_PER", // 27
            "USE_TIME_CHARGE_FIX", // 28
            "USE_PUT_INTO_BELT_SOCKET", // 29
        };
        
        String[] material_subtypes = new String[]{
            "MATERIAL_LEATHER", // 0 
            "", // 1
            "", // 2
            "", // 3
            "", // 4
            "MATERIAL_DS_REFINE_NORMAL", // 5
        };
        
        String[] special_subtypes = new String[]{
            "SPECIAL_MAP", // 0  
        };
        
        String[] lottery_subtypes = new String[]{
            "LOTTERY_TICKET", // 0
        };
        
    }
    
    private void convertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertButtonActionPerformed
        //createMobProto();
        if(jRadioButton1.isSelected())
            createMobTxt();
        else
            try {
                createItemTxt();
        } catch (IOException ex) {
            
        }
        
    }//GEN-LAST:event_convertButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } 
        catch (UnsupportedLookAndFeelException e) {
           // handle exception
        }
        catch (ClassNotFoundException e) {
           // handle exception
        }
        catch (InstantiationException e) {
           // handle exception
        }
        catch (IllegalAccessException e) {
           // handle exception
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JButton convertButton;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField pfadBox;
    // End of variables declaration//GEN-END:variables
}
