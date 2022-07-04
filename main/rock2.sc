MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ************************************ Rock Mission One ***********************************
// *************************************** Psycho Hunt *************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME rockb2

// Mission start stuff

GOSUB mission_start_rock2

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_rock2_failed
ENDIF

GOSUB mission_cleanup_rock2

MISSION_END


// Variables for mission

// Nutter

VAR_INT nutter_rock2

VAR_INT flag_nutter_dead_rock2

VAR_INT radar_blip_nutter_rock2

VAR_INT flag_nutter_in_local1_rock2

// nutter car stuff

VAR_INT flag_car_coords_rock2

VAR_INT car_rock2

VAR_FLOAT car_x_rock2

VAR_FLOAT car_y_rock2

VAR_FLOAT car_z_rock2

// locations for the car to go to

VAR_FLOAT car_location1_x_rock2

VAR_FLOAT car_location1_y_rock2

VAR_FLOAT car_location1_z_rock2

VAR_FLOAT car_location2_x_rock2

VAR_FLOAT car_location2_y_rock2

VAR_FLOAT car_location2_z_rock2

VAR_FLOAT car_location3_x_rock2

VAR_FLOAT car_location3_y_rock2

VAR_FLOAT car_location3_z_rock2

VAR_FLOAT car_location4_x_rock2

VAR_FLOAT car_location4_y_rock2

VAR_FLOAT car_location4_z_rock2

VAR_FLOAT car_location5_x_rock2

VAR_FLOAT car_location5_y_rock2

VAR_FLOAT car_location5_z_rock2

VAR_FLOAT car_location6_x_rock2

VAR_FLOAT car_location6_y_rock2

VAR_FLOAT car_location6_z_rock2

VAR_FLOAT car_location7_x_rock2

VAR_FLOAT car_location7_y_rock2

VAR_FLOAT car_location7_z_rock2

VAR_FLOAT car_location8_x_rock2

VAR_FLOAT car_location8_y_rock2

VAR_FLOAT car_location8_z_rock2

VAR_FLOAT car_location9_x_rock2

VAR_FLOAT car_location9_y_rock2

VAR_FLOAT car_location9_z_rock2

VAR_FLOAT car_location10_x_rock2

VAR_FLOAT car_location10_y_rock2

VAR_FLOAT car_location10_z_rock2

VAR_FLOAT car_location11_x_rock2

VAR_FLOAT car_location11_y_rock2

VAR_FLOAT car_location11_z_rock2

VAR_FLOAT car_location12_x_rock2

VAR_FLOAT car_location12_y_rock2

VAR_FLOAT car_location12_z_rock2

VAR_FLOAT car_location13_x_rock2
		  
VAR_FLOAT car_location13_y_rock2

VAR_FLOAT car_location13_z_rock2

VAR_FLOAT car_location14_x_rock2

VAR_FLOAT car_location14_y_rock2

VAR_FLOAT car_location14_z_rock2

VAR_FLOAT car_location15_x_rock2

VAR_FLOAT car_location15_y_rock2
				   
VAR_FLOAT car_location15_z_rock2

VAR_FLOAT car_location16_x_rock2

VAR_FLOAT car_location16_y_rock2

VAR_FLOAT car_location16_z_rock2

VAR_FLOAT car_location17_x_rock2

VAR_FLOAT car_location17_y_rock2

VAR_FLOAT car_location17_z_rock2

VAR_FLOAT car_location18_x_rock2

VAR_FLOAT car_location18_y_rock2

VAR_FLOAT car_location18_z_rock2

// groupie1

VAR_INT groupie1_rock2

VAR_INT flag_groupie1_dead_rock2

VAR_INT flag_groupie1_in_local1_rock2

// groupie2

VAR_INT groupie2_rock2

VAR_INT flag_groupie2_dead_rock2

VAR_INT flag_groupie2_in_local1_rock2

// groupie3

VAR_INT groupie3_rock2

// Groupie 4

VAR_INT groupie4_rock2

// Security1

VAR_INT security1_rock2

// Security2

VAR_INT security2_rock2

// Ped locations for when the peds are walking past security

VAR_FLOAT ped_location1_x_rock2

VAR_FLOAT ped_location1_y_rock2

VAR_FLOAT ped_location1_z_rock2

VAR_FLOAT ped_location2_x_rock2

VAR_FLOAT ped_location2_y_rock2

VAR_FLOAT ped_location2_z_rock2

// Vehicles to cause disruption

// Trashmaster1

VAR_INT trashcar1_rock2

VAR_INT flag_truck1_created_rock2

VAR_FLOAT trashcar1_x_rock2

VAR_FLOAT trashcar1_y_rock2

VAR_FLOAT trashcar1_z_rock2

// Truck pulls out to

VAR_INT flag_truck1_moved_rock2

VAR_FLOAT trashcar1_goto_x_rock2

VAR_FLOAT trashcar1_goto_y_rock2

VAR_FLOAT trashcar1_goto_z_rock2
 
// Car stuck stuff

VAR_FLOAT close_node_x_rock2

VAR_FLOAT close_node_y_rock2

VAR_FLOAT close_node_z_rock2

VAR_INT radar_blip_coord1_rock2

// Limo stuff

VAR_INT lovefist_limo_rock2

VAR_INT limo_blip_rock2

VAR_INT flag_car_blip_on_rock2

VAR_INT flag_player_in_limo_rock2

VAR_INT cutscene_over_rock2 

// Extra groupies

VAR_INT groupie5_rock2

VAR_INT groupie6_rock2

VAR_INT groupie7_rock2

VAR_INT groupie8_rock2

VAR_INT groupie9_rock2

VAR_INT groupie10_rock2

VAR_INT groupie11_rock2

VAR_INT groupie12_rock2

VAR_INT groupie13_rock2

VAR_INT groupie14_rock2

VAR_INT groupie15_rock2

VAR_INT groupie16_rock2

VAR_INT groupie17_rock2

VAR_INT stage_rock2

// New car driving stuff

VAR_INT nutter_doing_stuff_rock1
											
VAR_INT flag_nutter_in_car_rock1

VAR_INT nutter_been_in_car_once_rock2

// ****************************************Mission Start************************************

mission_start_rock2:

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1

// nutter

flag_nutter_dead_rock2 = 0

flag_nutter_in_local1_rock2 = 0

flag_car_coords_rock2 = 0

// Groupie1

flag_groupie1_dead_rock2 = 0

flag_groupie1_in_local1_rock2 = 0

// Groupie2

flag_groupie2_dead_rock2 = 0

flag_groupie2_in_local1_rock2 = 0


// Ped Locations

ped_location1_x_rock2 = -874.345

ped_location1_y_rock2 = 752.026

ped_location1_z_rock2 = 10.09

ped_location2_x_rock2 = -873.002

ped_location2_y_rock2 = 746.816

ped_location2_z_rock2 = 10.08  

// Car

car_x_rock2 = -861.15

car_y_rock2 = 762.60

car_z_rock2 = 9.91

// Locations for the car to go to

car_location1_x_rock2 = -816.150

car_location1_y_rock2 = 754.526   

car_location1_z_rock2 = 9.92

car_location2_x_rock2 = -771.009

car_location2_y_rock2 = 751.192

car_location2_z_rock2 = 9.92 

car_location3_x_rock2 = -728.617  

car_location3_y_rock2 = 749.005 

car_location3_z_rock2 = 9.92 
 
car_location4_x_rock2 = -691.349 

car_location4_y_rock2 = 747.598

car_location4_z_rock2 = 9.92

car_location5_x_rock2 = -682.831 // Handbrake left 

car_location5_y_rock2 = 747.244 // Handbrake left  

car_location5_z_rock2 = 9.92 // Handbrake left 

car_location6_x_rock2 = -670.763  

car_location6_y_rock2 = 756.798 

car_location6_z_rock2 = 9.91  

car_location7_x_rock2 = -669.649 

car_location7_y_rock2 = 794.065

car_location7_z_rock2 = 10.26  

car_location8_x_rock2 = -668.671 

car_location8_y_rock2 = 838.437 

car_location8_z_rock2 = 10.26  

car_location9_x_rock2 = -669.402 

car_location9_y_rock2 = 874.856  

car_location9_z_rock2 = 10.26 

car_location10_x_rock2 = -670.437  // Create lorry

car_location10_y_rock2 = 921.898  // Create lorry 

car_location10_z_rock2 = 10.26  // Create lorry 

car_location11_x_rock2 = -674.578   

car_location11_y_rock2 = 973.947  

car_location11_z_rock2 = 10.26   

car_location12_x_rock2 = -680.215   

car_location12_y_rock2 = 1021.183  

car_location12_z_rock2 = 10.26  

car_location13_x_rock2 = -681.531   

car_location13_y_rock2 = 1071.533  

car_location13_z_rock2 = 10.26   

car_location14_x_rock2 = -682.642  

car_location14_y_rock2 = 1114.051  

car_location14_z_rock2 = 10.26 

car_location15_x_rock2 = -684.139   

car_location15_y_rock2 = 1159.160  
				   
car_location15_z_rock2 = 10.25 

car_location16_x_rock2 = -683.050  

car_location16_y_rock2 = 1177.357 

car_location16_z_rock2 = 9.948 

car_location17_x_rock2 = -694.014   

car_location17_y_rock2 = 1185.806 

car_location17_z_rock2 = 9.906

car_location18_x_rock2 = -610.05  

car_location18_y_rock2 = 1170.63 

car_location18_z_rock2 = 9.90

// vehicles to cause disruption

// Trashmaster1

flag_truck1_created_rock2 = 0

trashcar1_x_rock2 = -665.192

trashcar1_y_rock2 = 1110.11

trashcar1_z_rock2 = 10.08

// Truck pulls out to

flag_truck1_moved_rock2 = 0

trashcar1_goto_x_rock2 = -690.68

trashcar1_goto_y_rock2 = 1115.54

trashcar1_goto_z_rock2 = 10.07

// Car stuck stuff

close_node_x_rock2 = 0.0

close_node_y_rock2 = 0.0

close_node_z_rock2 = 0.0

// limo stuff

flag_car_blip_on_rock2 = 0

flag_player_in_limo_rock2 = 0

cutscene_over_rock2 = 0

// new car driving stuff

nutter_doing_stuff_rock1 = 0
											
flag_nutter_in_car_rock1 = 0

nutter_been_in_car_once_rock2 = 0

// Gets rid of any stuff in the way

SWITCH_ROADS_OFF -875.10 1156.89 8.0 -662.04 738.48 20.0
CLEAR_AREA_OF_CARS -875.10 1156.89 8.0 -662.04 738.48 20.0
CLEAR_AREA_OF_CHARS -875.10 1156.89 8.0 -662.04 738.48 20.0
CLEAR_AREA -869.44 770.12 9.91 30.0 TRUE

WAIT 0

LOAD_MISSION_TEXT ROCK2

SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -860.688 1169.914 9.997 185.460

{
// ****************************************START OF CUTSCENE********************************
		
LOAD_SPECIAL_CHARACTER 1 CSdick
LOAD_SPECIAL_CHARACTER 2 CSjezz
LOAD_SPECIAL_CHARACTER 3 CSkent
LOAD_SPECIAL_CHARACTER 4 CSpercy
LOAD_SPECIAL_CHARACTER 5 CSplay

SET_AREA_VISIBLE VIS_STUDIO

LOAD_SCENE -880.527 1157.64 18.67

SET_EXTRA_COLOURS 17 FALSE

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_SPECIAL_CHARACTER_LOADED 5

	WAIT 0

ENDWHILE

LOAD_CUTSCENE rok_2

SET_CUTSCENE_OFFSET -879.823 1158.479 16.776
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_dick
SET_CUTSCENE_ANIM cs_dick CSdick

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_jezz
SET_CUTSCENE_ANIM cs_jezz CSjezz

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_kent
SET_CUTSCENE_ANIM cs_kent CSkent

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_percy
SET_CUTSCENE_ANIM cs_percy CSpercy

CREATE_CUTSCENE_OBJECT SPECIAL05 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CLEAR_AREA -871.90 1159.46 10.07 2.0 TRUE
SET_PLAYER_COORDINATES player1 -871.90 1159.46 10.07
SET_PLAYER_HEADING player1 270.0

DO_FADE 2000 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 1079 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_A ) 10000 1 //"Tommy, man. Am I glad to see you!"

WHILE cs_time < 2647 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_B ) 10000 1 //"What's going on?

WHILE cs_time < 3303 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_C ) 10000 1 //"Bad vibes, Tommy...."

WHILE cs_time < 4762 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_D ) 10000 1 //"Aye, I'm nae joking ken, it's heavey stuff man, heavey ken?

WHILE cs_time < 7952 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_E ) 10000 1 //"There's this cat, we hardly know him, but he knows us.

WHILE cs_time < 11003 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_F ) 10000 1 //"Like this cat. Knows all about us.

WHILE cs_time < 12952 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_G ) 10000 1 //"Knows that Willy likes ladies' underwear, eh!

WHILE cs_time < 15081 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_H ) 10000 1 //"Or that Percy likes Duran Duran!"

WHILE cs_time < 16366 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_I ) 10000 1 //"Shut up ye fool. Just 'cause Jezz bangs sheep.

WHILE cs_time < 19135 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_J ) 10000 1 //"It's a love rocket thing ken?

WHILE cs_time < 20496 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_R ) 10000 1 //"Oi Shut it!
 
WHILE cs_time < 21594 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_K ) 10000 1 //"Yeah, the love rocket thing, right, but list, this cat...."

WHILE cs_time < 24497 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_L ) 10000 1 //"yeh, yeh, the guy, he wants Love Fist dead."

WHILE cs_time < 26615 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_M ) 10000 1 //"Dead Tommy."

WHILE cs_time < 27614 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_N ) 10000 1 //"Love Fist gone. You know what they say, the good die young."

WHILE cs_time < 30209 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_O ) 10000 1 //"But Tommy, you gotta save Love Fist!"

WHILE cs_time < 31227 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_P ) 10000 1 //"We got a signing in two hours and I think..."

WHILE cs_time < 34202 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM2_Q ) 10000 1 //"And the boys think the stalker is going to try some monkey business there."

WHILE cs_time < 37248 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

DO_FADE 2000 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SET_AREA_VISIBLE VIS_MAIN_MAP

CLEAR_EXTRA_COLOURS FALSE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5

LOAD_SCENE -871.90 1159.46 10.07

SET_PLAYER_MOOD player1 PLAYER_MOOD_WISECRACKING 60000

// ****************************************END OF CUTSCENE**********************************

// Waiting for the ped models to load

REQUEST_MODEL GDa

REQUEST_MODEL SENTINEL

REQUEST_MODEL TRASH

LOAD_SPECIAL_CHARACTER 6 psycho

REQUEST_MODEL UZI

REQUEST_MODEL COLT45

REQUEST_MODEL LOVEFIST

REQUEST_MODEL WFYG1

REQUEST_MODEL WFYG2

REQUEST_MODEL WMYCR

REQUEST_ANIMATION RIOT

REQUEST_MODEL BKA

REQUEST_MODEL BKB

REQUEST_MODEL lf_mediastage

WHILE NOT HAS_MODEL_LOADED GDa
OR NOT HAS_MODEL_LOADED SENTINEL
OR NOT HAS_MODEL_LOADED uzi
OR NOT HAS_MODEL_LOADED TRASH
OR NOT HAS_SPECIAL_CHARACTER_LOADED 6
OR NOT HAS_MODEL_LOADED lf_mediastage
 	
	WAIT 0
      
ENDWHILE

LOAD_MISSION_AUDIO 1 ( ROK2_01 )

LOAD_MISSION_AUDIO 2 ( PSYCH_1 )

WHILE NOT HAS_MODEL_LOADED WFYG1
OR NOT HAS_MODEL_LOADED WFYG2 
OR NOT HAS_MODEL_LOADED LOVEFIST
OR NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
OR NOT HAS_MODEL_LOADED WMYCR 

	WAIT 0

ENDWHILE

WHILE NOT HAS_ANIMATION_LOADED RIOT
OR NOT HAS_MODEL_LOADED BKA
OR NOT HAS_MODEL_LOADED BKB
OR NOT HAS_MODEL_LOADED COLT45

	WAIT 0

ENDWHILE
// Creates the limo for the player to use

CREATE_CAR LOVEFIST -862.22 1149.87 9.75 lovefist_limo_rock2

SET_CAR_HEADING lovefist_limo_rock2 178.437

ADD_BLIP_FOR_CAR lovefist_limo_rock2 limo_blip_rock2 

// fades the screen in

SET_FADING_COLOUR 0 0 0

WAIT 500

DO_FADE 1500 FADE_IN

WHILE GET_FADING_STATUS

	WAIT 0

	IF IS_CAR_DEAD lovefist_limo_rock2
		PRINT_NOW ( RBM2_2 ) 5000 1 //"You've wrecked the bands car!"
		GOTO mission_rock2_failed
	ENDIF

ENDWHILE

PRINT_NOW ( RBM2_1 ) 5000 1 //"Drive the limo to the signing event and try and draw the psycho out!"

// Waiting for the player to get into the limo

WHILE NOT IS_PLAYER_IN_CAR player1 lovefist_limo_rock2

	WAIT 0

	IF IS_CAR_DEAD lovefist_limo_rock2
		PRINT_NOW ( RBM2_2 ) 5000 1 //"You've wrecked the bands car!"
		GOTO mission_rock2_failed
	ENDIF
	
ENDWHILE

flag_player_in_limo_rock2 = 1 

REMOVE_BLIP limo_blip_rock2

SET_MISSION_AUDIO_POSITION 1 -875.225 755.786 11.092
PLAY_MISSION_AUDIO 1 
 
// Security1

CREATE_CHAR PEDTYPE_CIVMALE GDa -876.059 750.314 10.087 security1_rock2

CLEAR_CHAR_THREAT_SEARCH security1_rock2

SET_CHAR_HEADING security1_rock2 16.0

SET_CHAR_PERSONALITY security1_rock2 PEDSTAT_TOUGH_GUY

// Creates security 2

CREATE_CHAR PEDTYPE_CIVMALE GDa -870.890 750.314 10.087 security2_rock2

CLEAR_CHAR_THREAT_SEARCH security2_rock2

SET_CHAR_HEADING security2_rock2 16.0

SET_CHAR_PERSONALITY security2_rock2 PEDSTAT_TOUGH_GUY

// Creates groupie 1

CREATE_CHAR PEDTYPE_CIVFEMALE WFYG1 -877.13 751.69 10.08 groupie1_rock2

CLEAR_CHAR_THREAT_SEARCH groupie1_rock2

SET_CHAR_HEADING groupie1_rock2 276.0

SET_CHAR_WAIT_STATE groupie1_rock2 WAITSTATE_RIOT 1000000

// Creates groupie 2

CREATE_CHAR PEDTYPE_CIVFEMALE WFYG2 -879.13 751.69 10.08 groupie2_rock2

CLEAR_CHAR_THREAT_SEARCH groupie2_rock2

SET_CHAR_HEADING groupie2_rock2 276.0

// Creates the Nutter

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL06 -881.13 751.69 10.08 nutter_rock2


CLEAR_CHAR_THREAT_SEARCH nutter_rock2

SET_CHAR_HEADING nutter_rock2 276.0

SET_CHAR_WAIT_STATE nutter_rock2 WAITSTATE_RIOT 1000000

// Creates groupie 3

CREATE_CHAR PEDTYPE_CIVFEMALE WFYG1 -881.948 754.142 10.09 groupie3_rock2

CLEAR_CHAR_THREAT_SEARCH groupie3_rock2

SET_CHAR_HEADING groupie3_rock2 171.339.0

// Creates groupie 4

CREATE_CHAR PEDTYPE_CIVFEMALE WFYG2 -881.870 756.396 10.09 groupie4_rock2

CLEAR_CHAR_THREAT_SEARCH groupie4_rock2

SET_CHAR_HEADING groupie4_rock2 189.550

SET_CHARS_CHATTING groupie4_rock2 groupie3_rock2 1000000 

// Creates groupie 5

CREATE_CHAR PEDTYPE_CIVFEMALE WFYG1 -873.030 757.606 10.09 groupie5_rock2

CLEAR_CHAR_THREAT_SEARCH groupie5_rock2

SET_CHAR_HEADING groupie5_rock2 59.35

// Creates groupie 6

CREATE_CHAR PEDTYPE_CIVFEMALE WFYG2 -875.061 758.918 10.09 groupie6_rock2

CLEAR_CHAR_THREAT_SEARCH groupie6_rock2

SET_CHAR_HEADING groupie6_rock2 238.128

SET_CHARS_CHATTING groupie6_rock2 groupie5_rock2 1000000

// Creates groupie 7

CREATE_CHAR PEDTYPE_CIVFEMALE WFYG1 -878.734 755.467 10.09 groupie7_rock2

CLEAR_CHAR_THREAT_SEARCH groupie7_rock2

SET_CHAR_HEADING groupie7_rock2 0.0

// Creates groupie 8

CREATE_CHAR PEDTYPE_CIVFEMALE WFYG2 -878.106 756.674 10.09 groupie8_rock2

CLEAR_CHAR_THREAT_SEARCH groupie8_rock2

SET_CHAR_HEADING groupie8_rock2 0.0

SET_CHARS_CHATTING groupie7_rock2 groupie8_rock2 1000000

// Creates groupie 9

CREATE_CHAR PEDTYPE_CIVFEMALE WFYG1 -880.432 761.017 10.09 groupie9_rock2

CLEAR_CHAR_THREAT_SEARCH groupie9_rock2

SET_CHAR_HEADING groupie9_rock2 211.157

SET_CHAR_WAIT_STATE groupie9_rock2 WAITSTATE_RIOT 1000000

// Creates groupie 10

CREATE_CHAR PEDTYPE_CIVFEMALE WFYG2 -880.529 758.980 10.09 groupie10_rock2

CLEAR_CHAR_THREAT_SEARCH groupie10_rock2

SET_CHAR_HEADING groupie10_rock2 191.085

SET_CHAR_WAIT_STATE groupie10_rock2 WAITSTATE_RIOT 1000000

// Creates groupie 11 ( bloke who uses riot anim )

CREATE_CHAR PEDTYPE_CIVMALE WMYCR -877.909 758.973 10.09 groupie11_rock2

CLEAR_CHAR_THREAT_SEARCH groupie11_rock2

SET_CHAR_HEADING groupie11_rock2 207.253

SET_CHAR_WAIT_STATE groupie11_rock2 WAITSTATE_RIOT 1000000

// Creates groupie 12 ( bloke who uses riot anim )

CREATE_CHAR PEDTYPE_CIVMALE WMYCR -874.309 756.278 10.09 groupie12_rock2

CLEAR_CHAR_THREAT_SEARCH groupie12_rock2

SET_CHAR_HEADING groupie12_rock2 205.828

SET_CHAR_WAIT_STATE groupie12_rock2 WAITSTATE_RIOT 1000000

// Creates groupie 13

CREATE_CHAR PEDTYPE_CIVFEMALE WFYG2 -868.406 754.232 10.09 groupie13_rock2

CLEAR_CHAR_THREAT_SEARCH groupie13_rock2

SET_CHAR_HEADING groupie13_rock2 141.694

SET_CHAR_WAIT_STATE groupie13_rock2 WAITSTATE_RIOT 1000000

// Creates groupie 14

CREATE_CHAR PEDTYPE_CIVFEMALE WFYG1 -869.254 756.061 10.09 groupie14_rock2

CLEAR_CHAR_THREAT_SEARCH groupie14_rock2

SET_CHAR_HEADING groupie14_rock2 165.718

SET_CHAR_WAIT_STATE groupie14_rock2 WAITSTATE_RIOT 1000000

// Creates groupie 15

CREATE_CHAR PEDTYPE_CIVMALE BKB -871.932 758.940 10.09 groupie15_rock2

CLEAR_CHAR_THREAT_SEARCH groupie15_rock2

SET_CHAR_HEADING groupie15_rock2 175.0

SET_CHAR_WAIT_STATE groupie15_rock2 WAITSTATE_RIOT 1000000

// Creates groupie 16

CREATE_CHAR PEDTYPE_CIVMALE BKA -870.592 756.081 10.09 groupie16_rock2

CLEAR_CHAR_THREAT_SEARCH groupie16_rock2

SET_CHAR_HEADING groupie16_rock2 186.374

SET_CHAR_WAIT_STATE groupie16_rock2 WAITSTATE_RIOT 1000000

// Creates groupie 17

CREATE_CHAR PEDTYPE_CIVMALE BKB -870.124 757.097 10.09 groupie17_rock2

CLEAR_CHAR_THREAT_SEARCH groupie17_rock2

SET_CHAR_HEADING groupie17_rock2 150.524

SET_CHAR_WAIT_STATE groupie17_rock2 WAITSTATE_RIOT 1000000

// Creates the media stage

CREATE_OBJECT lf_mediastage -868.367 753.316 10.09 stage_rock2

SET_OBJECT_HEADING stage_rock2 180.0


// Waiting for the player to locate outside the area

ADD_BLIP_FOR_COORD -869.44 770.12 9.91 radar_blip_coord1_rock2

blob_flag = 1 

WHILE NOT LOCATE_STOPPED_PLAYER_IN_CAR_3D player1 -869.44 770.12 9.91 6.0 4.0 8.0 blob_flag
OR flag_player_in_limo_rock2 = 0

	WAIT 0

	IF IS_CHAR_DEAD nutter_rock2
		PRINT_NOW ( RBM2_7 ) 5000 1 //"The fans have been attacked, the psycho won't show!"
		GOTO mission_rock2_failed	
	ENDIF

	IF IS_CHAR_DEAD groupie1_rock2
		PRINT_NOW ( RBM2_7 ) 5000 1 //"The fans have been attacked, the psycho won't show!"
		GOTO mission_rock2_failed	
	ENDIF
	
	IF IS_CHAR_DEAD groupie2_rock2
		PRINT_NOW ( RBM2_7 ) 5000 1 //"The fans have been attacked, the psycho won't show!"
		GOTO mission_rock2_failed	
	ENDIF

	IF IS_CHAR_DEAD groupie3_rock2
		PRINT_NOW ( RBM2_7 ) 5000 1 //"The fans have been attacked, the psycho won't show!"
		GOTO mission_rock2_failed	
	ENDIF

	IF IS_CHAR_DEAD groupie4_rock2
		PRINT_NOW ( RBM2_7 ) 5000 1 //"The fans have been attacked, the psycho won't show!"
		GOTO mission_rock2_failed	
	ENDIF

	IF IS_CHAR_DEAD groupie5_rock2
		PRINT_NOW ( RBM2_7 ) 5000 1 //"The fans have been attacked, the psycho won't show!"
		GOTO mission_rock2_failed	
	ENDIF

	IF IS_CHAR_DEAD groupie6_rock2
		PRINT_NOW ( RBM2_7 ) 5000 1 //"The fans have been attacked, the psycho won't show!"
		GOTO mission_rock2_failed	
	ENDIF

	IF IS_CHAR_DEAD groupie7_rock2
		PRINT_NOW ( RBM2_7 ) 5000 1 //"The fans have been attacked, the psycho won't show!"
		GOTO mission_rock2_failed	
	ENDIF

	IF IS_CHAR_DEAD groupie8_rock2
		PRINT_NOW ( RBM2_7 ) 5000 1 //"The fans have been attacked, the psycho won't show!"
		GOTO mission_rock2_failed	
	ENDIF

	IF IS_CHAR_DEAD groupie9_rock2
		PRINT_NOW ( RBM2_7 ) 5000 1 //"The fans have been attacked, the psycho won't show!"
		GOTO mission_rock2_failed	
	ENDIF

	IF IS_CHAR_DEAD groupie10_rock2
		PRINT_NOW ( RBM2_7 ) 5000 1 //"The fans have been attacked, the psycho won't show!"
		GOTO mission_rock2_failed	
	ENDIF

	IF IS_CHAR_DEAD groupie11_rock2
		PRINT_NOW ( RBM2_7 ) 5000 1 //"The fans have been attacked, the psycho won't show!"
		GOTO mission_rock2_failed	
	ENDIF

	IF IS_CHAR_DEAD groupie12_rock2
		PRINT_NOW ( RBM2_7 ) 5000 1 //"The fans have been attacked, the psycho won't show!"
		GOTO mission_rock2_failed	
	ENDIF
	
	IF IS_CHAR_DEAD security1_rock2
		PRINT_NOW ( RBM2_8 ) 5000 1 //"The security guards have been attacked, the psycho won't show!"
		GOTO mission_rock2_failed	
	ENDIF
	
	IF IS_CHAR_DEAD security2_rock2
		PRINT_NOW ( RBM2_8 ) 5000 1 //"The security guards have been attacked, the psycho won't show!
		GOTO mission_rock2_failed	
	ENDIF 

	IF IS_CAR_DEAD lovefist_limo_rock2
		PRINT_NOW ( RBM2_2 ) 5000 1 //"You've wrecked the bands car!"
		GOTO mission_rock2_failed
	ELSE
		
		IF NOT IS_PLAYER_IN_CAR player1 lovefist_limo_rock2  
		
			IF flag_car_blip_on_rock2 = 0
				REMOVE_BLIP radar_blip_coord1_rock2
				ADD_BLIP_FOR_CAR lovefist_limo_rock2 limo_blip_rock2
				PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the vehicle
				blob_flag = 0
				flag_player_in_limo_rock2 = 0
				flag_car_blip_on_rock2 = 1
			ENDIF

		ELSE

			IF flag_car_blip_on_rock2 = 1 
				REMOVE_BLIP limo_blip_rock2
				ADD_BLIP_FOR_COORD -869.44 770.12 9.91 radar_blip_coord1_rock2
				PRINT_NOW ( RBM2_3 ) 5000 1 //"Get to the signing!"
				blob_flag = 1
				flag_player_in_limo_rock2 = 1
				flag_car_blip_on_rock2 = 0
			ENDIF
			
		ENDIF
		
	ENDIF 
	  
ENDWHILE                                      

REMOVE_BLIP radar_blip_coord1_rock2

// camera stuff to go in here

SWITCH_WIDESCREEN ON
SET_PLAYER_CONTROL player1 OFF
SET_POLICE_IGNORE_PLAYER player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 ON


CLEAR_AREA -871.706 752.216 10.415 1.0 FALSE
SET_FIXED_CAMERA_POSITION -871.706 752.216 10.415 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -872.667 752.154 10.683 JUMP_CUT 
//SET_FIXED_CAMERA_POSITION -868.630 752.707 13.136 0.0 0.0 0.0
//POINT_CAMERA_AT_POINT -869.607 752.724 12.926 JUMP_CUT

WHILE cutscene_over_rock2 = 0

	WAIT 0
	
// Groupie1

	IF flag_groupie1_dead_rock2 = 0

		IF flag_groupie1_in_local1_rock2 < 4

			IF IS_CHAR_DEAD groupie1_rock2
				PRINT_NOW ( RBM2_7 ) 5000 1 //"One of the groupies has been killed
				GOTO mission_rock2_failed 
				flag_groupie1_dead_rock2 = 1
			ELSE
				
				IF flag_groupie1_in_local1_rock2 = 0

					CLEAR_AREA ped_location1_x_rock2 ped_location1_y_rock2 ped_location1_z_rock2 2.0 FALSE
					CLEAR_AREA ped_location2_x_rock2 ped_location2_y_rock2 ped_location2_z_rock2 2.0 FALSE
					CLEAR_AREA -877.13 751.69 10.08 2.0 FALSE // ped 1 location
					CLEAR_AREA -879.13 751.69 10.08	2.0	FALSE // ped 2 location
					CLEAR_AREA -881.13 751.69 10.08	2.0 FALSE // nutter location
										
					IF NOT IS_CHAR_DEAD security1_rock2
						SET_CHAR_WAIT_STATE security1_rock2 WAITSTATE_PLAYANIM_CHAT 2000
					ELSE
						PRINT_NOW ( RBM2_8 ) 5000 1 //"The security guards have been attacked, the psycho won't show!
						GOTO mission_rock2_failed
					ENDIF  

					CLEAR_CHAR_WAIT_STATE groupie1_rock2
					CLEAR_ALL_CHAR_ANIMS groupie1_rock2
					SET_CHAR_OBJ_GOTO_COORD_ON_FOOT groupie1_rock2 ped_location1_x_rock2 ped_location1_y_rock2
					timera = 0
					timerb = 0
					flag_groupie1_in_local1_rock2 = 1
				ENDIF

				IF flag_groupie1_in_local1_rock2 = 1

					IF timerb >= 6000

						IF NOT LOCATE_CHAR_ON_FOOT_2D groupie1_rock2 ped_location1_x_rock2 ped_location1_y_rock2 0.5 0.5 FALSE 
							SET_CHAR_COORDINATES groupie1_rock2 ped_location1_x_rock2 ped_location1_y_rock2 ped_location1_z_rock2
						ENDIF

					ENDIF 
										
					IF LOCATE_CHAR_ON_FOOT_2D groupie1_rock2 ped_location1_x_rock2 ped_location1_y_rock2 0.5 0.5 FALSE
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT groupie1_rock2 ped_location2_x_rock2 ped_location2_y_rock2
						timerb = 0
						flag_groupie1_in_local1_rock2 = 2
					ENDIF

				ENDIF

				IF flag_groupie1_in_local1_rock2 = 2

					IF timerb >= 6000

						IF NOT LOCATE_CHAR_ON_FOOT_2D groupie1_rock2 ped_location2_x_rock2 ped_location2_y_rock2 0.5 0.5 FALSE 
							SET_CHAR_COORDINATES groupie1_rock2 ped_location2_x_rock2 ped_location2_y_rock2 ped_location2_z_rock2
						ENDIF

					ENDIF 
					
					IF LOCATE_CHAR_ON_FOOT_2D groupie1_rock2 ped_location2_x_rock2 ped_location2_y_rock2 0.5 0.5 FALSE
					   	CHAR_SET_IDLE groupie1_rock2
					   	timerb = 0  		  
						flag_groupie1_in_local1_rock2 = 3
					ENDIF

				ENDIF
							   	
			ENDIF

		ENDIF

	ENDIF

	IF flag_groupie1_in_local1_rock2 = 3
		DELETE_CHAR groupie1_rock2
		flag_groupie1_in_local1_rock2 = 4
						
	ENDIF
	
// Groupie2

	IF flag_groupie2_dead_rock2 = 0

		IF flag_groupie2_in_local1_rock2 < 4

			IF IS_CHAR_DEAD groupie2_rock2
				PRINT_NOW ( RBM2_7 ) 5000 1 //"One of the groupies has been killed
				GOTO mission_rock2_failed
				flag_groupie2_dead_rock2 = 1
			ELSE
			
				IF flag_groupie1_in_local1_rock2 >= 1

					IF flag_groupie2_in_local1_rock2 < 4
					
						IF flag_groupie2_in_local1_rock2 = 0

							IF timera > 350
								CLEAR_CHAR_WAIT_STATE groupie2_rock2
								CLEAR_ALL_CHAR_ANIMS groupie2_rock2 
								SET_CHAR_OBJ_GOTO_COORD_ON_FOOT groupie2_rock2 ped_location1_x_rock2 ped_location1_y_rock2
								timera = 0
								timerb = 0
								flag_groupie2_in_local1_rock2 = 1
							ENDIF

						ENDIF

						IF flag_groupie2_in_local1_rock2 = 1

							IF timerb >= 6000

								IF NOT LOCATE_CHAR_ON_FOOT_2D groupie2_rock2 ped_location1_x_rock2 ped_location1_y_rock2 0.5 0.5 FALSE 
									SET_CHAR_COORDINATES groupie2_rock2 ped_location1_x_rock2 ped_location1_y_rock2 ped_location1_z_rock2
								ENDIF

							ENDIF
						
							IF LOCATE_CHAR_ON_FOOT_2D groupie2_rock2 ped_location1_x_rock2 ped_location1_y_rock2 0.5 0.5 FALSE
								SET_CHAR_OBJ_GOTO_COORD_ON_FOOT groupie2_rock2 ped_location2_x_rock2 ped_location2_y_rock2
								timerb = 0
								flag_groupie2_in_local1_rock2 = 2
							ENDIF

						ENDIF

						IF flag_groupie2_in_local1_rock2 = 2

							IF timerb >= 6000
								
								IF NOT LOCATE_CHAR_ON_FOOT_2D groupie2_rock2 ped_location2_x_rock2 ped_location2_y_rock2 0.5 0.5 FALSE
									SET_CHAR_COORDINATES groupie2_rock2 ped_location2_x_rock2 ped_location2_y_rock2 ped_location2_z_rock2
								ENDIF
								
							ENDIF  
						
							IF LOCATE_CHAR_ON_FOOT_2D groupie2_rock2 ped_location2_x_rock2 ped_location2_y_rock2 0.5 0.5 FALSE 		  
								timerb = 0
								flag_groupie2_in_local1_rock2 = 3
							ENDIF

						ENDIF
											   
					ENDIF

				ENDIF

			ENDIF

		ENDIF

		IF flag_groupie2_in_local1_rock2 = 3
			DELETE_CHAR groupie2_rock2
			flag_groupie2_in_local1_rock2 = 4
		ENDIF  
		
	ENDIF

// Nutter

	IF flag_nutter_dead_rock2 = 0
	
		IF IS_CHAR_DEAD nutter_rock2
			PRINT_NOW ( RBM2_7 ) 5000 1 //"One of the groupies has been killed
			GOTO mission_rock2_failed
			flag_nutter_dead_rock2 = 1
		ELSE
					    			
			IF flag_groupie2_in_local1_rock2 >= 1

				IF flag_nutter_in_local1_rock2 = 0

					IF timera > 450
						CLEAR_CHAR_WAIT_STATE nutter_rock2
						CLEAR_ALL_CHAR_ANIMS nutter_rock2
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT nutter_rock2 ped_location1_x_rock2 ped_location1_y_rock2
						timera = 0
						timerb = 0
						flag_nutter_in_local1_rock2 = 1
					   //	SET_FIXED_CAMERA_POSITION -871.706 752.216 10.415 0.0 0.0 0.0
					   //	POINT_CAMERA_AT_POINT -872.667 752.154 10.683 JUMP_CUT
					ENDIF

				ENDIF

				IF flag_nutter_in_local1_rock2 = 1

					IF timerb >= 6000

						IF NOT LOCATE_CHAR_ON_FOOT_2D nutter_rock2 ped_location1_x_rock2 ped_location1_y_rock2 1.0 1.0 FALSE
							SET_CHAR_COORDINATES nutter_rock2 ped_location1_x_rock2 ped_location1_y_rock2 ped_location1_z_rock2
						ENDIF
					
					ENDIF  
				
					IF LOCATE_CHAR_ON_FOOT_2D nutter_rock2 ped_location1_x_rock2 ped_location1_y_rock2 1.0 1.0 FALSE
						CHAR_SET_IDLE nutter_rock2

						IF NOT IS_CHAR_DEAD security1_rock2
							TURN_CHAR_TO_FACE_CHAR nutter_rock2 security1_rock2
						ENDIF
						flag_nutter_in_local1_rock2 = 2
					ENDIF

				ENDIF
											
			   	IF flag_nutter_in_local1_rock2 = 2

					CLEAR_AREA car_x_rock2 car_y_rock2 car_z_rock2 1.0 FALSE 
					CREATE_CAR  SENTINEL car_x_rock2 car_y_rock2 car_z_rock2 car_rock2
					SET_CAR_HEADING car_rock2 260.0
					SET_CAR_ONLY_DAMAGED_BY_PLAYER car_rock2 TRUE
					PLAY_MISSION_AUDIO 2
					PRINT_NOW ( PSYCH_1 ) 5000 1 //"Love fist ruined my life!"
					GIVE_WEAPON_TO_CHAR nutter_rock2 WEAPONTYPE_PISTOL 30000 // Infinate ammo
					
					IF NOT IS_CHAR_DEAD security2_rock2
						SET_CHAR_HEALTH security2_rock2 20
						TURN_CHAR_TO_FACE_CHAR security2_rock2 nutter_rock2 
					ENDIF
					
			   		IF NOT IS_CHAR_DEAD security1_rock2
						TURN_CHAR_TO_FACE_CHAR security1_rock2 nutter_rock2
						SET_CHAR_HEALTH security1_rock2 20 
			   		 	SET_CHAR_OBJ_KILL_CHAR_ON_FOOT nutter_rock2 security1_rock2
						SET_CHAR_WAIT_STATE security1_rock2 WAITSTATE_PLAYANIM_HANDSUP 2000 
			   			flag_nutter_in_local1_rock2 = 3
			   		ENDIF

			   	ENDIF

			   	IF flag_nutter_in_local1_rock2 = 3

					IF HAS_MISSION_AUDIO_FINISHED 2
						CLEAR_THIS_PRINT ( PSYCH_1 )
						LOAD_MISSION_AUDIO 2 ( PSYCH_2 )
						flag_nutter_in_local1_rock2 = 4
					ENDIF
									   	   	   		   
			   		IF NOT IS_CHAR_DEAD security2_rock2
						CLEAR_ALL_CHAR_ANIMS security2_rock2 
			   			SET_CHAR_OBJ_FLEE_CHAR_ON_FOOT_ALWAYS security2_rock2 nutter_rock2
			   		ENDIF
			   		
			   	ENDIF

				IF flag_nutter_in_local1_rock2 = 4
				
					IF HAS_MISSION_AUDIO_LOADED 2
						flag_nutter_in_local1_rock2 = 5
					ENDIF
					
				ENDIF	 
				
				IF flag_nutter_in_local1_rock2 = 5
					SET_CHAR_HEADING nutter_rock2 288.184
					PLAY_MISSION_AUDIO 2
					PRINT_NOW ( PSYCH_2 ) 5000 1 //"Kill love fist!"
					SET_FIXED_CAMERA_POSITION -873.219 752.811 11.062 0.0 0.0 0.0
					POINT_CAMERA_AT_POINT -874.159 752.585 11.319 JUMP_CUT
					SET_CHAR_WAIT_STATE nutter_rock2 WAITSTATE_PLAYANIM_CHAT 1000000
					flag_nutter_in_local1_rock2 = 6
				ENDIF

				IF flag_nutter_in_local1_rock2 = 6

					IF HAS_MISSION_AUDIO_FINISHED 2
						CLEAR_THIS_PRINT ( PSYCH_2 )
						SET_CHAR_WAIT_STATE nutter_rock2 WAITSTATE_FALSE 1
						CLEAR_ALL_CHAR_ANIMS nutter_rock2 
						flag_nutter_in_local1_rock2 = 7
					ENDIF

				ENDIF
							  					
				IF flag_nutter_in_local1_rock2 = 7

					IF NOT IS_CAR_DEAD car_rock2
						SET_CHAR_RUNNING nutter_rock2 TRUE
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER nutter_rock2 car_rock2
						timerb = 0
						flag_nutter_in_local1_rock2 = 8
					ELSE
						GOTO mission_rock2_failed
					ENDIF
				
				ENDIF

				IF flag_nutter_in_local1_rock2 = 8

					IF timerb > 1200
				
						IF NOT IS_CAR_DEAD car_rock2
							//WARP_CHAR_INTO_CAR nutter_rock2 car_rock2
							CLEAR_AREA -871.587 751.170 12.45 1.0 FALSE
							SET_FIXED_CAMERA_POSITION -871.587 751.170 12.45 0.0 0.0 0.0
							POINT_CAMERA_AT_POINT -870.721 751.668 12.40 JUMP_CUT
							flag_nutter_in_local1_rock2 = 9
						ELSE
							GOTO mission_rock2_failed
						ENDIF
						
					ENDIF
					
				ENDIF
				
				IF flag_nutter_in_local1_rock2 = 9
				
					IF NOT IS_CAR_DEAD car_rock2  

						IF IS_CHAR_IN_CAR nutter_rock2 car_rock2
							//SET_CAR_CHANGE_LANE car_rock2 FALSE 
							//SET_CHAR_CANT_BE_DRAGGED_OUT nutter_rock2 TRUE
							ADD_STUCK_CAR_CHECK car_rock2 0.5 2000
							ADD_UPSIDEDOWN_CAR_CHECK car_rock2
							ADD_BLIP_FOR_CHAR_OLD nutter_rock2 GREEN MARKER_ONLY radar_blip_nutter_rock2
							nutter_been_in_car_once_rock2 = 1
							flag_nutter_in_car_rock1 = 1 
							flag_nutter_in_local1_rock2 = 10
						ENDIF

					ELSE
						GOTO mission_rock2_failed
					ENDIF
					
				ENDIF

				IF flag_nutter_in_local1_rock2 = 10
					
					cutscene_over_rock2 = 1
				ENDIF	

			ENDIF	  
												
		ENDIF

	ENDIF

	IF flag_nutter_in_local1_rock2 = 3
		CLEAR_MISSION_AUDIO 1

		IF NOT IS_CHAR_DEAD groupie3_rock2
			CLEAR_CHAR_WAIT_STATE groupie3_rock2
			CLEAR_ALL_CHAR_ANIMS groupie3_rock2 
			SET_CHAR_PERSONALITY groupie3_rock2 PEDSTAT_COWARD
			SET_CHAR_OBJ_FLEE_CHAR_ON_FOOT_ALWAYS groupie3_rock2 nutter_rock2
		ENDIF

		IF NOT IS_CHAR_DEAD groupie4_rock2
			CLEAR_CHAR_WAIT_STATE groupie4_rock2
			CLEAR_ALL_CHAR_ANIMS groupie4_rock2
			SET_CHAR_PERSONALITY groupie4_rock2 PEDSTAT_COWARD
			SET_CHAR_OBJ_FLEE_CHAR_ON_FOOT_ALWAYS groupie4_rock2 nutter_rock2
		ENDIF

		IF NOT IS_CHAR_DEAD groupie5_rock2
			CLEAR_CHAR_WAIT_STATE groupie5_rock2
			CLEAR_ALL_CHAR_ANIMS groupie5_rock2
			SET_CHAR_PERSONALITY groupie5_rock2 PEDSTAT_COWARD
			SET_CHAR_OBJ_FLEE_CHAR_ON_FOOT_ALWAYS groupie5_rock2 nutter_rock2
		ENDIF

		IF NOT IS_CHAR_DEAD groupie6_rock2
			CLEAR_CHAR_WAIT_STATE groupie6_rock2
			CLEAR_ALL_CHAR_ANIMS groupie6_rock2
			SET_CHAR_PERSONALITY groupie6_rock2 PEDSTAT_COWARD
			SET_CHAR_OBJ_FLEE_CHAR_ON_FOOT_ALWAYS groupie6_rock2 nutter_rock2
		ENDIF

		IF NOT IS_CHAR_DEAD groupie7_rock2
			CLEAR_CHAR_WAIT_STATE groupie7_rock2
			CLEAR_ALL_CHAR_ANIMS groupie7_rock2
			SET_CHAR_PERSONALITY groupie7_rock2 PEDSTAT_COWARD
			SET_CHAR_OBJ_FLEE_CHAR_ON_FOOT_ALWAYS groupie7_rock2 nutter_rock2
		ENDIF

		IF NOT IS_CHAR_DEAD groupie8_rock2
			CLEAR_CHAR_WAIT_STATE groupie8_rock2
			CLEAR_ALL_CHAR_ANIMS groupie8_rock2
			SET_CHAR_PERSONALITY groupie8_rock2 PEDSTAT_COWARD
			SET_CHAR_OBJ_FLEE_CHAR_ON_FOOT_ALWAYS groupie8_rock2 nutter_rock2
		ENDIF

		IF NOT IS_CHAR_DEAD groupie9_rock2
			CLEAR_CHAR_WAIT_STATE groupie9_rock2
			CLEAR_ALL_CHAR_ANIMS groupie9_rock2
			SET_CHAR_PERSONALITY groupie9_rock2 PEDSTAT_COWARD
			SET_CHAR_OBJ_FLEE_CHAR_ON_FOOT_ALWAYS groupie9_rock2 nutter_rock2
		ENDIF

		IF NOT IS_CHAR_DEAD groupie10_rock2
			CLEAR_CHAR_WAIT_STATE groupie10_rock2
			CLEAR_ALL_CHAR_ANIMS groupie10_rock2
			SET_CHAR_PERSONALITY groupie10_rock2 PEDSTAT_COWARD
			SET_CHAR_OBJ_FLEE_CHAR_ON_FOOT_ALWAYS groupie10_rock2 nutter_rock2
		ENDIF

		IF NOT IS_CHAR_DEAD groupie11_rock2
			CLEAR_CHAR_WAIT_STATE groupie11_rock2
			CLEAR_ALL_CHAR_ANIMS groupie11_rock2
			SET_CHAR_PERSONALITY groupie11_rock2 PEDSTAT_COWARD 
			SET_CHAR_OBJ_FLEE_CHAR_ON_FOOT_ALWAYS groupie11_rock2 nutter_rock2
		ENDIF

		IF NOT IS_CHAR_DEAD groupie12_rock2
			CLEAR_CHAR_WAIT_STATE groupie12_rock2
			CLEAR_ALL_CHAR_ANIMS groupie12_rock2
			SET_CHAR_PERSONALITY groupie12_rock2 PEDSTAT_COWARD
			SET_CHAR_OBJ_FLEE_CHAR_ON_FOOT_ALWAYS groupie12_rock2 nutter_rock2
		ENDIF
		
		IF NOT IS_CHAR_DEAD groupie13_rock2
			CLEAR_CHAR_WAIT_STATE groupie13_rock2
			CLEAR_ALL_CHAR_ANIMS groupie13_rock2
			SET_CHAR_PERSONALITY groupie13_rock2 PEDSTAT_COWARD
			SET_CHAR_OBJ_FLEE_CHAR_ON_FOOT_ALWAYS groupie13_rock2 nutter_rock2
		ENDIF

		IF NOT IS_CHAR_DEAD groupie14_rock2
			CLEAR_CHAR_WAIT_STATE groupie14_rock2
			CLEAR_ALL_CHAR_ANIMS groupie14_rock2
			SET_CHAR_PERSONALITY groupie14_rock2 PEDSTAT_COWARD
			SET_CHAR_OBJ_FLEE_CHAR_ON_FOOT_ALWAYS groupie14_rock2 nutter_rock2
		ENDIF

		IF NOT IS_CHAR_DEAD groupie15_rock2
			CLEAR_CHAR_WAIT_STATE groupie15_rock2
			CLEAR_ALL_CHAR_ANIMS groupie15_rock2
			SET_CHAR_PERSONALITY groupie15_rock2 PEDSTAT_COWARD
			SET_CHAR_OBJ_FLEE_CHAR_ON_FOOT_ALWAYS groupie15_rock2 nutter_rock2
		ENDIF

		IF NOT IS_CHAR_DEAD groupie16_rock2
			CLEAR_CHAR_WAIT_STATE groupie16_rock2
			CLEAR_ALL_CHAR_ANIMS groupie16_rock2
			SET_CHAR_PERSONALITY groupie16_rock2 PEDSTAT_COWARD
			SET_CHAR_OBJ_FLEE_CHAR_ON_FOOT_ALWAYS groupie16_rock2 nutter_rock2
		ENDIF

		IF NOT IS_CHAR_DEAD groupie17_rock2
			CLEAR_CHAR_WAIT_STATE groupie17_rock2
			CLEAR_ALL_CHAR_ANIMS groupie17_rock2
			SET_CHAR_PERSONALITY groupie17_rock2 PEDSTAT_COWARD
			SET_CHAR_OBJ_FLEE_CHAR_ON_FOOT_ALWAYS groupie17_rock2 nutter_rock2
		ENDIF
		
	ENDIF
			
ENDWHILE

IF NOT IS_CHAR_DEAD security1_rock2
	CLEAR_ALL_CHAR_ANIMS security1_rock2
	CLEAR_CHAR_WAIT_STATE security1_rock2 
ENDIF

IF NOT IS_CHAR_DEAD security2_rock2
	CLEAR_ALL_CHAR_ANIMS security2_rock2
	CLEAR_CHAR_WAIT_STATE security2_rock2 
ENDIF

IF NOT IS_CHAR_DEAD groupie1_rock2
	CLEAR_ALL_CHAR_ANIMS groupie1_rock2
	CLEAR_CHAR_WAIT_STATE groupie1_rock2 
ENDIF

IF NOT IS_CHAR_DEAD groupie2_rock2
	CLEAR_ALL_CHAR_ANIMS groupie2_rock2
	CLEAR_CHAR_WAIT_STATE groupie2_rock2 
ENDIF

IF NOT IS_CHAR_DEAD groupie3_rock2
	CLEAR_ALL_CHAR_ANIMS groupie3_rock2
	CLEAR_CHAR_WAIT_STATE groupie3_rock2 
ENDIF

IF NOT IS_CHAR_DEAD groupie4_rock2
	CLEAR_ALL_CHAR_ANIMS groupie4_rock2
	CLEAR_CHAR_WAIT_STATE groupie4_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie5_rock2
	CLEAR_ALL_CHAR_ANIMS groupie5_rock2
	CLEAR_CHAR_WAIT_STATE groupie5_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie6_rock2
	CLEAR_ALL_CHAR_ANIMS groupie6_rock2
	CLEAR_CHAR_WAIT_STATE groupie6_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie7_rock2
	CLEAR_ALL_CHAR_ANIMS groupie7_rock2
	CLEAR_CHAR_WAIT_STATE groupie7_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie8_rock2
	CLEAR_ALL_CHAR_ANIMS groupie8_rock2
	CLEAR_CHAR_WAIT_STATE groupie8_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie9_rock2
	CLEAR_ALL_CHAR_ANIMS groupie9_rock2
	CLEAR_CHAR_WAIT_STATE groupie9_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie10_rock2
	CLEAR_ALL_CHAR_ANIMS groupie10_rock2
	CLEAR_CHAR_WAIT_STATE groupie10_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie11_rock2
	CLEAR_ALL_CHAR_ANIMS groupie11_rock2
	CLEAR_CHAR_WAIT_STATE groupie11_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie12_rock2
	CLEAR_ALL_CHAR_ANIMS groupie12_rock2
	CLEAR_CHAR_WAIT_STATE groupie12_rock2
ENDIF
		
IF NOT IS_CHAR_DEAD groupie13_rock2
	CLEAR_ALL_CHAR_ANIMS groupie13_rock2
	CLEAR_CHAR_WAIT_STATE groupie13_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie14_rock2
	CLEAR_ALL_CHAR_ANIMS groupie14_rock2
	CLEAR_CHAR_WAIT_STATE groupie14_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie15_rock2
	CLEAR_ALL_CHAR_ANIMS groupie15_rock2
	CLEAR_CHAR_WAIT_STATE groupie15_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie16_rock2
	CLEAR_ALL_CHAR_ANIMS groupie16_rock2
	CLEAR_CHAR_WAIT_STATE groupie16_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie17_rock2
	CLEAR_ALL_CHAR_ANIMS groupie17_rock2
	CLEAR_CHAR_WAIT_STATE groupie17_rock2
ENDIF
   
MARK_CHAR_AS_NO_LONGER_NEEDED security1_rock2
MARK_CHAR_AS_NO_LONGER_NEEDED security2_rock2
MARK_CHAR_AS_NO_LONGER_NEEDED groupie1_rock2 
MARK_CHAR_AS_NO_LONGER_NEEDED groupie2_rock2 
MARK_CHAR_AS_NO_LONGER_NEEDED groupie3_rock2 
MARK_CHAR_AS_NO_LONGER_NEEDED groupie4_rock2
MARK_CHAR_AS_NO_LONGER_NEEDED groupie5_rock2
MARK_CHAR_AS_NO_LONGER_NEEDED groupie6_rock2
MARK_CHAR_AS_NO_LONGER_NEEDED groupie7_rock2
MARK_CHAR_AS_NO_LONGER_NEEDED groupie8_rock2
MARK_CHAR_AS_NO_LONGER_NEEDED groupie9_rock2
MARK_CHAR_AS_NO_LONGER_NEEDED groupie10_rock2
MARK_CHAR_AS_NO_LONGER_NEEDED groupie11_rock2
MARK_CHAR_AS_NO_LONGER_NEEDED groupie12_rock2
MARK_CHAR_AS_NO_LONGER_NEEDED groupie13_rock2
MARK_CHAR_AS_NO_LONGER_NEEDED groupie14_rock2
MARK_CHAR_AS_NO_LONGER_NEEDED groupie15_rock2
MARK_CHAR_AS_NO_LONGER_NEEDED groupie16_rock2
MARK_CHAR_AS_NO_LONGER_NEEDED groupie17_rock2
MARK_MODEL_AS_NO_LONGER_NEEDED lf_mediastage

REMOVE_ANIMATION RIOT

PRINT_NOW ( RBM2_4 ) 5000 1 //"Get the Psycho don't let him escape!"
SWITCH_WIDESCREEN OFF
SET_CAMERA_BEHIND_PLAYER
RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SET_POLICE_IGNORE_PLAYER player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 OFF
// waiting for the player to kill the psycho 

WHILE flag_nutter_dead_rock2 = 0

	WAIT 0
		
	IF NOT IS_CHAR_DEAD nutter_rock2

		IF nutter_been_in_car_once_rock2 = 1 

			IF NOT IS_CHAR_IN_ANY_CAR nutter_rock2
				GIVE_WEAPON_TO_CHAR nutter_rock2 WEAPONTYPE_UZI 30000 // Infinate ammo
				nutter_been_in_car_once_rock2 = 0
			ENDIF

		ENDIF

		IF NOT IS_CHAR_ON_SCREEN nutter_rock2
	
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 nutter_rock2 200.0 200.0 FALSE
				PRINT_NOW ( RBM2_5 ) 5000 1 //"You lost him you idiot!"
				GOTO mission_rock2_failed
			ENDIF

		ENDIF
		
	ELSE
		REMOVE_BLIP radar_blip_nutter_rock2
		flag_nutter_dead_rock2 = 1
	ENDIF

	IF nutter_been_in_car_once_rock2 = 1 
			 	
		IF NOT IS_CAR_DEAD car_rock2

			IF NOT IS_CHAR_DEAD nutter_rock2
			
				IF IS_CHAR_IN_CAR nutter_rock2 car_rock2   

					IF flag_car_coords_rock2 < 19
						GOSUB car_drive_rock2
						GOSUB car_stuck_rock2
					ENDIF
					
				ELSE
					SET_CAR_CRUISE_SPEED car_rock2 0.0
					CAR_SET_IDLE car_rock2
				ENDIF

			ENDIF

		ENDIF

	ENDIF

// Psycho out of car stuff
	
	IF NOT IS_CHAR_DEAD nutter_rock2
									    						
		IF nutter_doing_stuff_rock1 = 0 
								  				
			IF NOT IS_CHAR_IN_ANY_CAR nutter_rock2

				IF IS_CHAR_ON_SCREEN nutter_rock2
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS nutter_rock2 player1
					nutter_doing_stuff_rock1 = 1
				ENDIF
										
			ENDIF

		ENDIF
						
		IF flag_nutter_in_car_rock1 = 0
				
			IF IS_CHAR_IN_ANY_CAR nutter_rock2
				SET_CHAR_OBJ_NO_OBJ nutter_rock2
				STORE_CAR_CHAR_IS_IN nutter_rock2 car_rock2
				ADD_UPSIDEDOWN_CAR_CHECK car_rock2
				ADD_STUCK_CAR_CHECK car_rock2 0.1 2000
				SET_CAR_CRUISE_SPEED car_rock2 30.0
				SET_CAR_DRIVING_STYLE car_rock2 2
				CAR_WANDER_RANDOMLY car_rock2
				nutter_doing_stuff_rock1 = 0
				flag_nutter_in_car_rock1 = 1
			ENDIF

		ENDIF
						
		IF flag_nutter_in_car_rock1 = 1

			IF NOT IS_CAR_DEAD car_rock2

				IF IS_CAR_STUCK_ON_ROOF car_rock2
				OR IS_CAR_STUCK car_rock2
				OR IS_CAR_ON_FIRE car_rock2
					SET_CHAR_OBJ_LEAVE_CAR nutter_rock2 car_rock2
					nutter_doing_stuff_rock1 = 0
				ENDIF
				
			ENDIF

		ENDIF

		IF flag_nutter_in_car_rock1 = 1
					
			IF NOT IS_CHAR_IN_ANY_CAR nutter_rock2
				REMOVE_UPSIDEDOWN_CAR_CHECK car_rock2
				REMOVE_STUCK_CAR_CHECK car_rock2
				MARK_CAR_AS_NO_LONGER_NEEDED car_rock2
				nutter_been_in_car_once_rock2 = 0
				nutter_doing_stuff_rock1 = 0
				flag_nutter_in_car_rock1 = 0
			ENDIF
						
		ENDIF	 
							
	ENDIF
   						
// truck driving across player stuff

	IF flag_truck1_created_rock2 = 0
		
		IF flag_car_coords_rock2 >= 13
			CREATE_CAR TRASH trashcar1_x_rock2 trashcar1_y_rock2 trashcar1_z_rock2 trashcar1_rock2
			SET_CAR_HEADING trashcar1_rock2 93.0
			flag_truck1_created_rock2 = 1
		ENDIF
		
	ENDIF 

	IF flag_truck1_created_rock2 = 1

		IF NOT IS_CAR_DEAD trashcar1_rock2 

			IF flag_truck1_moved_rock2 = 0

				IF flag_car_coords_rock2 >= 13 
		
					IF IS_PLAYER_IN_AREA_3D player1 -717.148 1014.399 8.0 -655.46 1172.155 15.0 FALSE
						SET_CAR_CRUISE_SPEED trashcar1_rock2 40.0
						CAR_GOTO_COORDINATES trashcar1_rock2 trashcar1_goto_x_rock2 trashcar1_goto_y_rock2 trashcar1_goto_z_rock2
						flag_truck1_moved_rock2 = 1
					ENDIF

				ENDIF

			ENDIF

			IF flag_truck1_moved_rock2 = 1
			
				IF NOT IS_CAR_DEAD trashcar1_rock2
					
					IF LOCATE_CAR_3D trashcar1_rock2 trashcar1_goto_x_rock2 trashcar1_goto_y_rock2 trashcar1_goto_z_rock2 2.0 2.0 2.0 FALSE
						SET_CAR_CRUISE_SPEED trashcar1_rock2 20.0
						CAR_WANDER_RANDOMLY trashcar1_rock2
						MARK_CAR_AS_NO_LONGER_NEEDED trashcar1_rock2
						flag_truck1_moved_rock2 = 2 
					ENDIF
					
				ENDIF
				
			ENDIF
			
		ENDIF   

	ENDIF
			
ENDWHILE

REMOVE_BLIP radar_blip_nutter_rock2

GOTO mission_rock2_passed

// ****************************************** Mission Failed *******************************

mission_rock2_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN

// *************************************** Mission Passed **********************************

mission_rock2_passed:

flag_rock_mission2_passed = 1
REGISTER_MISSION_PASSED ( ROCK_2 )
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
CLEAR_WANTED_LEVEL player1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 4000 5000 1 //"Mission Passed!"
ADD_SCORE player1 4000
START_NEW_SCRIPT rock_mission3_loop
RETURN
	


// *************************************** Mission Cleanup *********************************

mission_cleanup_rock2:
IF NOT IS_CAR_DEAD lovefist_limo_rock2 
	MARK_CAR_AS_NO_LONGER_NEEDED lovefist_limo_rock2
ENDIF

IF NOT IS_CHAR_DEAD security1_rock2
	CLEAR_ALL_CHAR_ANIMS security1_rock2
	CLEAR_CHAR_WAIT_STATE security1_rock2 
ENDIF

IF NOT IS_CHAR_DEAD security2_rock2
	CLEAR_ALL_CHAR_ANIMS security2_rock2
	CLEAR_CHAR_WAIT_STATE security2_rock2 
ENDIF

IF NOT IS_CHAR_DEAD groupie1_rock2
	CLEAR_ALL_CHAR_ANIMS groupie1_rock2
	CLEAR_CHAR_WAIT_STATE groupie1_rock2 
ENDIF

IF NOT IS_CHAR_DEAD groupie2_rock2
	CLEAR_ALL_CHAR_ANIMS groupie2_rock2
	CLEAR_CHAR_WAIT_STATE groupie2_rock2 
ENDIF

IF NOT IS_CHAR_DEAD groupie3_rock2
	CLEAR_ALL_CHAR_ANIMS groupie3_rock2
	CLEAR_CHAR_WAIT_STATE groupie3_rock2 
ENDIF

IF NOT IS_CHAR_DEAD groupie4_rock2
	CLEAR_ALL_CHAR_ANIMS groupie4_rock2
	CLEAR_CHAR_WAIT_STATE groupie4_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie5_rock2
	CLEAR_ALL_CHAR_ANIMS groupie5_rock2
	CLEAR_CHAR_WAIT_STATE groupie5_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie6_rock2
	CLEAR_ALL_CHAR_ANIMS groupie6_rock2
	CLEAR_CHAR_WAIT_STATE groupie6_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie7_rock2
	CLEAR_ALL_CHAR_ANIMS groupie7_rock2
	CLEAR_CHAR_WAIT_STATE groupie7_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie8_rock2
	CLEAR_ALL_CHAR_ANIMS groupie8_rock2
	CLEAR_CHAR_WAIT_STATE groupie8_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie9_rock2
	CLEAR_ALL_CHAR_ANIMS groupie9_rock2
	CLEAR_CHAR_WAIT_STATE groupie9_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie10_rock2
	CLEAR_ALL_CHAR_ANIMS groupie10_rock2
	CLEAR_CHAR_WAIT_STATE groupie10_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie11_rock2
	CLEAR_ALL_CHAR_ANIMS groupie11_rock2
	CLEAR_CHAR_WAIT_STATE groupie11_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie12_rock2
	CLEAR_ALL_CHAR_ANIMS groupie12_rock2
	CLEAR_CHAR_WAIT_STATE groupie12_rock2
ENDIF
		
IF NOT IS_CHAR_DEAD groupie13_rock2
	CLEAR_ALL_CHAR_ANIMS groupie13_rock2
	CLEAR_CHAR_WAIT_STATE groupie13_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie14_rock2
	CLEAR_ALL_CHAR_ANIMS groupie14_rock2
	CLEAR_CHAR_WAIT_STATE groupie14_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie15_rock2
	CLEAR_ALL_CHAR_ANIMS groupie15_rock2
	CLEAR_CHAR_WAIT_STATE groupie15_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie16_rock2
	CLEAR_ALL_CHAR_ANIMS groupie16_rock2
	CLEAR_CHAR_WAIT_STATE groupie16_rock2
ENDIF

IF NOT IS_CHAR_DEAD groupie17_rock2
	CLEAR_ALL_CHAR_ANIMS groupie17_rock2
	CLEAR_CHAR_WAIT_STATE groupie17_rock2
ENDIF

IF NOT IS_CHAR_DEAD nutter_rock2
	CLEAR_ALL_CHAR_ANIMS nutter_rock2
	CLEAR_CHAR_WAIT_STATE nutter_rock2
ENDIF 

REMOVE_ANIMATION RIOT
REMOVE_CHAR_ELEGANTLY nutter_rock2
CLEAR_MISSION_AUDIO 1 

flag_player_on_mission = 0
SWITCH_ROADS_ON -875.10 1156.89 8.0 -662.04 738.48 20.0
REMOVE_BLIP radar_blip_nutter_rock2
REMOVE_BLIP radar_blip_coord1_rock2
REMOVE_BLIP limo_blip_rock2
UNLOAD_SPECIAL_CHARACTER 6
MARK_MODEL_AS_NO_LONGER_NEEDED GDa
MARK_MODEL_AS_NO_LONGER_NEEDED SENTINEL
MARK_MODEL_AS_NO_LONGER_NEEDED TRASH
MARK_MODEL_AS_NO_LONGER_NEEDED UZI
MARK_MODEL_AS_NO_LONGER_NEEDED COLT45
MARK_MODEL_AS_NO_LONGER_NEEDED WFYG1
MARK_MODEL_AS_NO_LONGER_NEEDED WFYG2
MARK_MODEL_AS_NO_LONGER_NEEDED LOVEFIST
MARK_MODEL_AS_NO_LONGER_NEEDED WMYCR
MARK_MODEL_AS_NO_LONGER_NEEDED BKA
MARK_MODEL_AS_NO_LONGER_NEEDED BKB
MARK_MODEL_AS_NO_LONGER_NEEDED lf_mediastage
GET_GAME_TIMER timer_mobile_start

IF NOT IS_CAR_DEAD car_rock2
	REMOVE_UPSIDEDOWN_CAR_CHECK car_rock2
	REMOVE_STUCK_CAR_CHECK car_rock2
ENDIF

MISSION_HAS_FINISHED
RETURN

 			
// TELLS THE CAR TO DRIVE

car_drive_rock2:

IF IS_CAR_DEAD car_rock2
	
	IF flag_nutter_dead_rock2 = 0
	
		IF IS_CHAR_DEAD nutter_rock2
			REMOVE_BLIP radar_blip_nutter_rock2
			flag_nutter_dead_rock2 = 1
		ENDIF

	ENDIF
	
ELSE
      	
	IF flag_car_coords_rock2 = 0
		SET_CAR_CRUISE_SPEED car_rock2 40.0  //40.0
		SET_CAR_DRIVING_STYLE car_rock2 DRIVINGMODE_AVOIDCARS // 2
		CAR_GOTO_COORDINATES car_rock2 car_location1_x_rock2 car_location1_y_rock2 car_location1_z_rock2
	 	flag_car_coords_rock2 = 1			   
	ENDIF

	IF flag_car_coords_rock2 = 1
		
		IF LOCATE_CAR_2D car_rock2 car_location1_x_rock2 car_location1_y_rock2 6.0 4.0 FALSE
			CAR_GOTO_COORDINATES car_rock2 car_location2_x_rock2 car_location2_y_rock2 car_location2_z_rock2 
			flag_car_coords_rock2 = 2
		ENDIF
		
	ENDIF
	
	IF flag_car_coords_rock2 = 2
		
		IF LOCATE_CAR_2D car_rock2 car_location2_x_rock2 car_location2_y_rock2 6.0 4.0 FALSE
			CAR_GOTO_COORDINATES car_rock2 car_location3_x_rock2 car_location3_y_rock2 car_location3_z_rock2
			flag_car_coords_rock2 = 3
		ENDIF
		
	ENDIF

	IF flag_car_coords_rock2 = 3
	
		IF LOCATE_CAR_2D car_rock2 car_location3_x_rock2 car_location3_y_rock2 6.0 4.0 FALSE  
			CAR_GOTO_COORDINATES car_rock2 car_location4_x_rock2 car_location4_y_rock2 car_location4_z_rock2
			flag_car_coords_rock2 = 4
		ENDIF

	ENDIF

	IF flag_car_coords_rock2 = 4
	
		IF LOCATE_CAR_2D car_rock2 car_location4_x_rock2 car_location4_y_rock2 6.0 4.0 FALSE
			CAR_GOTO_COORDINATES car_rock2 car_location5_x_rock2 car_location5_y_rock2 car_location5_z_rock2
			flag_car_coords_rock2 = 5
		ENDIF

	ENDIF
	
	IF flag_car_coords_rock2 = 5
	
		IF LOCATE_CAR_2D car_rock2 car_location5_x_rock2 car_location5_y_rock2 6.0 4.0 FALSE
			SET_CAR_TEMP_ACTION car_rock2 TEMPACT_HANDBRAKETURNLEFT 5  
		   	CAR_GOTO_COORDINATES car_rock2 car_location6_x_rock2 car_location6_y_rock2 car_location6_z_rock2
			flag_car_coords_rock2 = 6
		ENDIF

	ENDIF
	
	IF flag_car_coords_rock2 = 6
	
		IF LOCATE_CAR_2D car_rock2 car_location6_x_rock2 car_location6_y_rock2 6.0 4.0 FALSE  
			CAR_GOTO_COORDINATES car_rock2 car_location7_x_rock2 car_location7_y_rock2 car_location7_z_rock2
			flag_car_coords_rock2 = 7
		ENDIF

	ENDIF

	IF flag_car_coords_rock2 = 7
	
		IF LOCATE_CAR_2D car_rock2 car_location7_x_rock2 car_location7_y_rock2 6.0 4.0 FALSE
			CAR_GOTO_COORDINATES car_rock2 car_location8_x_rock2 car_location8_y_rock2 car_location8_z_rock2
			flag_car_coords_rock2 = 8
		ENDIF

	ENDIF

	IF flag_car_coords_rock2 = 8
	
		IF LOCATE_CAR_2D car_rock2 car_location8_x_rock2 car_location8_y_rock2 6.0 4.0 FALSE
			CAR_GOTO_COORDINATES car_rock2 car_location9_x_rock2 car_location9_y_rock2 car_location9_z_rock2
			flag_car_coords_rock2 = 9
		ENDIF

	ENDIF

// Creates the truck obstruction
	
	IF flag_car_coords_rock2 = 9
	
		IF LOCATE_CAR_2D car_rock2 car_location9_x_rock2 car_location9_y_rock2 6.0 4.0 FALSE
			CAR_GOTO_COORDINATES car_rock2 car_location10_x_rock2 car_location10_y_rock2 car_location10_z_rock2
			flag_car_coords_rock2 = 10
		ENDIF

	ENDIF
	
	IF flag_car_coords_rock2 = 10
	
		IF LOCATE_CAR_2D car_rock2 car_location10_x_rock2 car_location10_y_rock2 6.0 4.0 FALSE
			CAR_GOTO_COORDINATES car_rock2 car_location11_x_rock2 car_location11_y_rock2 car_location11_z_rock2
			flag_car_coords_rock2 = 11
		ENDIF

	ENDIF

	IF flag_car_coords_rock2 = 11
	
		IF LOCATE_CAR_2D car_rock2 car_location11_x_rock2 car_location11_y_rock2 6.0 4.0 FALSE
			CAR_GOTO_COORDINATES car_rock2 car_location12_x_rock2 car_location12_y_rock2 car_location12_z_rock2
			flag_car_coords_rock2 = 12
		ENDIF

	ENDIF

	IF flag_car_coords_rock2 = 12
	
		IF LOCATE_CAR_2D car_rock2 car_location12_x_rock2 car_location12_y_rock2 6.0 4.0 FALSE  
			CAR_GOTO_COORDINATES car_rock2 car_location13_x_rock2 car_location13_y_rock2 car_location13_z_rock2
			flag_car_coords_rock2 = 13
		ENDIF

	ENDIF

	IF flag_car_coords_rock2 = 13
	
		IF LOCATE_CAR_2D car_rock2 car_location13_x_rock2 car_location13_y_rock2 6.0 4.0 FALSE
		   	CAR_GOTO_COORDINATES car_rock2 car_location14_x_rock2 car_location14_y_rock2 car_location14_z_rock2
			flag_car_coords_rock2 = 14
		ENDIF

	ENDIF

	IF flag_car_coords_rock2 = 14
	
		IF LOCATE_CAR_2D car_rock2 car_location14_x_rock2 car_location14_y_rock2 6.0 4.0 FALSE  
			CAR_GOTO_COORDINATES car_rock2 car_location15_x_rock2 car_location15_y_rock2 car_location15_z_rock2
			flag_car_coords_rock2 = 15
		ENDIF

	ENDIF

	IF flag_car_coords_rock2 = 15
	
		IF LOCATE_CAR_2D car_rock2 car_location15_x_rock2 car_location15_y_rock2 6.0 4.0 FALSE
			CAR_GOTO_COORDINATES car_rock2 car_location16_x_rock2 car_location16_y_rock2 car_location16_z_rock2
			flag_car_coords_rock2 = 16
		ENDIF

	ENDIF

	IF flag_car_coords_rock2 = 16
	
		IF LOCATE_CAR_2D car_rock2 car_location16_x_rock2 car_location16_y_rock2 6.0 4.0 FALSE  
			CAR_GOTO_COORDINATES car_rock2 car_location17_x_rock2 car_location17_y_rock2 car_location17_z_rock2
			flag_car_coords_rock2 = 17
		ENDIF

	ENDIF
	
	IF flag_car_coords_rock2 = 17
	
		IF LOCATE_CAR_2D car_rock2 car_location17_x_rock2 car_location17_y_rock2 6.0 4.0 FALSE
			CAR_GOTO_COORDINATES car_rock2 car_location18_x_rock2 car_location18_y_rock2 car_location18_z_rock2
			flag_car_coords_rock2 = 18
		ENDIF

	ENDIF

	IF flag_car_coords_rock2 = 18
	
		IF LOCATE_CAR_2D car_rock2 car_location18_x_rock2 car_location18_y_rock2 6.0 4.0 FALSE
			CAR_WANDER_RANDOMLY car_rock2  
			flag_car_coords_rock2 = 19
		ENDIF

	ENDIF
			
ENDIF
	
RETURN

// Checks to see if the car is stuck

car_stuck_rock2:

IF NOT IS_CAR_DEAD car_rock2

	IF IS_CAR_UPSIDEDOWN car_rock2
	
		IF NOT IS_CAR_ON_SCREEN car_rock2

			GET_CAR_COORDINATES car_rock2 car_x_rock2 car_y_rock2 car_z_rock2
			GET_CLOSEST_CAR_NODE car_x_rock2 car_y_rock2 car_z_rock2 close_node_x_rock2 close_node_y_rock2 close_node_z_rock2

			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY close_node_x_rock2 close_node_y_rock2 close_node_z_rock2 4.0 4.0 3.0

				IF NOT IS_POINT_ON_SCREEN close_node_x_rock2 close_node_y_rock2 close_node_z_rock2 4.0
					SET_CAR_COORDINATES car_rock2 close_node_x_rock2 close_node_y_rock2 close_node_z_rock2

					IF flag_car_coords_rock2 >= 19
						SET_CAR_CRUISE_SPEED car_rock2 40.0  //40.0
						SET_CAR_DRIVING_STYLE car_rock2 DRIVINGMODE_AVOIDCARS // 2
						CAR_WANDER_RANDOMLY car_rock2
					ENDIF
					
				ENDIF
				
			ENDIF

		ENDIF

	ENDIF
	
   	IF IS_CAR_STUCK car_rock2 
			 	
		IF NOT IS_CAR_ON_SCREEN car_rock2

			GET_CAR_COORDINATES car_rock2 car_x_rock2 car_y_rock2 car_z_rock2
			GET_CLOSEST_CAR_NODE car_x_rock2 car_y_rock2 car_z_rock2 close_node_x_rock2 close_node_y_rock2 close_node_z_rock2

			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY close_node_x_rock2 close_node_y_rock2 close_node_z_rock2 4.0 4.0 3.0

				IF NOT IS_POINT_ON_SCREEN close_node_x_rock2 close_node_y_rock2 close_node_z_rock2 4.0
					SET_CAR_COORDINATES car_rock2 close_node_x_rock2 close_node_y_rock2 close_node_z_rock2

					IF flag_car_coords_rock2 >= 19
						SET_CAR_CRUISE_SPEED car_rock2 40.0  //40.0
						SET_CAR_DRIVING_STYLE car_rock2 DRIVINGMODE_AVOIDCARS // 2
						CAR_WANDER_RANDOMLY car_rock2
					ENDIF
										
				ENDIF
																
			ENDIF

		ENDIF

	ENDIF

ENDIF

RETURN

}
