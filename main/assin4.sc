MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// ****************************************ASSASIN 4****************************************
// ********************************check out at the check in********************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
{
SCRIPT_NAME assin4

// Mission start stuff
GOSUB mission_start_assin4

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_assin4_failed
ENDIF

GOSUB mission_cleanup_assin4

MISSION_END
 
// Variables for mission
VAR_INT woman
VAR_INT womanblip
VAR_INT mantgt
VAR_INT sniperifle
VAR_INT sniperifleblip
VAR_INT briefcase_playerhastoget briefcase_playerhastogetblip
VAR_INT bodyguard1_am4
VAR_INT bodyguardstoplooking
VAR_INT mantgtdeaddropdacase

VAR_INT assassin4flag takecasetoammu_a4 ammunationblip_a4

//flags
VAR_INT has_sniper_been_picked_up
VAR_INT woman_started_moving
VAR_INT sniper_flag
VAR_INT otherweapon_flag womancango


VAR_FLOAT mantgtdestx mantgtdesty mantgtdestz

VAR_FLOAT playerintialx playerintialy playerintialz
VAR_FLOAT womanlocationx womanlocationy womanlocationz womanheading_a3
VAR_FLOAT mantgtlocationx mantgtlocationy mantgtlocationz mantgtheading
VAR_FLOAT sniperiflex sniperifley sniperiflez
VAR_FLOAT mantgtlastx mantgtlasty mantgtlastz
VAR_FLOAT destinationx_am4 destinationy_am4 destinationz_am4
VAR_FLOAT bodyguard1_am4x bodyguard1_am4y bodyguard1_am4z bodyguard1_am4h 

 



VAR_INT playerhasbeenseen_am4

VAR_INT has_char_been_damage_flag heli_am4


//distance stuff
VAR_INT displaybar_am4 displaydistancebar_am4 charnowrun_am4 intdistancebar_am4
VAR_FLOAT distancebar_am4 distancecalc_am4
VAR_FLOAT playerxdist_am4 playerydist_am4 playerzdist_am4
VAR_FLOAT mandistx_am4 mandisty_am4 mandistz_am4 
VAR_FLOAT distance_am4 

//distance

VAR_INT chasecar1_am4 chasecar2_am4 chasecar3_am4 players_car1_am4


VAR_FLOAT chasecar1x_am4
VAR_FLOAT chasecar1y_am4
VAR_FLOAT chasecar1z_am4
VAR_FLOAT chasecar1heading_am4
VAR_INT chasecar1_am4ready
VAR_INT chasedriver1_am4
VAR_INT chaseshooter1_am4

VAR_FLOAT chasecar2x_am4
VAR_FLOAT chasecar2y_am4
VAR_FLOAT chasecar2z_am4
VAR_FLOAT chasecar2heading_am4
VAR_INT chasecar2_am4ready
VAR_INT chasedriver2_am4
VAR_INT chaseshooter2_am4

VAR_FLOAT chasecar3x_am4
VAR_FLOAT chasecar3y_am4
VAR_FLOAT chasecar3z_am4
VAR_FLOAT chasecar3heading_am4
VAR_INT chasecar3_am4ready
VAR_INT chasedriver3_am4
VAR_INT chaseshooter3_am4

VAR_INT killplayeronfoot1
VAR_INT killplayeronfoot2
VAR_INT killplayeronfoot3

VAR_INT targetwalk_am4




// **************************************** Mission Start **********************************

mission_start_assin4:				  


flag_player_on_mission = 1

REGISTER_MISSION_GIVEN


WAIT 0

LOAD_MISSION_TEXT ASSIN4 

/////////////////////////////////////////////////////////////////////////////////////cutscene
//request models

REQUEST_MODEL WMORI
REQUEST_MODEL HFYBU
REQUEST_MODEL UZI
REQUEST_MODEL cellphone


WHILE NOT HAS_MODEL_LOADED WMORI
	OR NOT HAS_MODEL_LOADED HFYBU	
	OR NOT HAS_MODEL_LOADED cellphone
	OR NOT HAS_MODEL_LOADED UZI
	WAIT 0
ENDWHILE


LOAD_SPECIAL_CHARACTER 1 BGa
LOAD_SPECIAL_CHARACTER 2 BGb

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
	OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
WAIT 0
ENDWHILE
									 

SET_PED_DENSITY_MULTIPLIER 0.0
SET_CAR_DENSITY_MULTIPLIER 0.0

SWITCH_WIDESCREEN ON		  

CLEAR_AREA 38.396473 -1023.987854 9.450843 4.0 FALSE
CLEAR_AREA_OF_CHARS -1475.2427 -832.872 10.164 -1489.9095 819.0943 18.669

SET_PLAYER_COORDINATES player1 -1482.1144 -825.2285 13.8377 
SET_PLAYER_HEADING player1 100.2630

 
SET_FIXED_CAMERA_POSITION -1479.543823 -825.329487 15.017683 0.0 0.0 0.0
POINT_CAMERA_AT_PLAYER player1 FOLLOWPED JUMP_CUT
SET_CAMERA_BEHIND_PLAYER
SET_CHAR_ANSWERING_MOBILE scplayer TRUE

LOAD_MISSION_AUDIO 1 JOB4_1
LOAD_MISSION_AUDIO 2 JOB4_2

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 


DO_FADE 1000 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PRINT_NOW ( ASM4_A ) 10000 1 
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD scplayer
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endasm4cs
	ENDIF
ENDWHILE
CLEAR_THIS_PRINT ASM4_A
CLEAR_MISSION_AUDIO 1

CLEAR_AREA -1474.531030 -826.005554 15.007619 3.0 FALSE
SET_FIXED_CAMERA_POSITION -1475.931030 -826.005554 15.007619 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -1476.763478 -825.451660 14.993659 JUMP_CUT 

PRINT_NOW ( ASM4_B ) 10000 1 
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD scplayer
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endasm4cs
	ENDIF
ENDWHILE
CLEAR_THIS_PRINT ASM4_B
CLEAR_MISSION_AUDIO 2

LOAD_MISSION_AUDIO 1 JOB4_3

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE 

SET_FIXED_CAMERA_POSITION -1484.055 -825.312 16.729959 0.0 0.0 0.0
POINT_CAMERA_AT_PLAYER player1 FIXED JUMP_CUT

PRINT_NOW ( ASM4_C ) 10000 1 
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD scplayer
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endasm4cs
	ENDIF
ENDWHILE
CLEAR_THIS_PRINT ASM4_C
CLEAR_MISSION_AUDIO 1


endasm4cs:

CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
CLEAR_SMALL_PRINTS

WAIT 500

SET_CHAR_ANSWERING_MOBILE scplayer FALSE
MARK_MODEL_AS_NO_LONGER_NEEDED cellphone

DO_FADE 1000 FADE_OUT


SET_PED_DENSITY_MULTIPLIER 1.0
SET_CAR_DENSITY_MULTIPLIER 1.0

TIMERA = 0 

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_BEHIND_PLAYER

DO_FADE 1000 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


SET_PLAYER_CONTROL player1 ON



//////////////////////////////////////////////////////////////////////////////////////

//values for variables
playerintialx = -1493.219
playerintialy =	-798.9757
playerintialz =	14.868
				   
//woman's location
womanlocationx = -1421.1810//-1437.637939 
womanlocationy = -874.6884//-875.918457
womanlocationz = 19.8471//19.862872			   
womanheading_a3 = 289.0250

//mans location
mantgtlocationx = -1388.917725
mantgtlocationy = -865.028259
mantgtlocationz	= 13.877681 
mantgtheading = 50.33542

//mans destination
mantgtdestx = -1360.6705 //-1504.8539     
mantgtdesty = -930.4258//-919.8127
mantgtdestz	= 19.8531//19.9131


//bodyguard1 location
bodyguard1_am4x = -1387.584473
bodyguard1_am4y = -865.244819
bodyguard1_am4z	= 13.877681
bodyguard1_am4h = 65.236931


//sniper rifles location
sniperiflex = -1484.7800 
sniperifley = -807.7946
sniperiflez	= 14.878

//destination blip
destinationx_am4 = -676.240548//-853.163330 
destinationy_am4 = 1197.764//-83.990456
destinationz_am4 = 10.07//10.844421




//flags
has_sniper_been_picked_up = 0
woman_started_moving = 0
sniper_flag = 0
otherweapon_flag = 0
assassin4flag = 0
womancango = 0
bodyguardstoplooking = 0
mantgtdeaddropdacase = 0
takecasetoammu_a4 = 0
playerhasbeenseen_am4 = 0


charnowrun_am4 = 0
displaybar_am4 = 0
displaydistancebar_am4 = 0

has_char_been_damage_flag = 0
targetwalk_am4 = 0
TIMERA = 0

//chasecars
//chasing cars
chasecar1x_am4 = -1152.279
chasecar1y_am4 = -939.467
chasecar1z_am4 = 14.688
chasecar1heading_am4 = 88.806
chasecar1_am4ready = 0

chasecar2x_am4 = -1163.085693
chasecar2y_am4 = -948.913147
chasecar2z_am4 = 14.681449
chasecar2heading_am4 = 89.2464 
chasecar2_am4ready = 0

chasecar3x_am4 = -1139.196899
chasecar3y_am4 = -1086.208195
chasecar3z_am4 = 14.716681
chasecar3heading_am4 = 295.4019852
chasecar3_am4ready = 0

killplayeronfoot1 =	0
killplayeronfoot2 =	0
killplayeronfoot3 = 0




//create sniper rifle
CREATE_PICKUP_WITH_AMMO SNIPER PICKUP_ONCE 10 sniperiflex sniperifley sniperiflez sniperifle
ADD_BLIP_FOR_PICKUP sniperifle sniperifleblip 

PRINT_NOW ( ASM4_15 ) 5000 2	//get the rifle

SET_ZONE_PED_INFO TERMINL DAY   (50) 0 0 0 0 25 0 0 0 0 10    
SET_ZONE_PED_INFO TERMINL NIGHT (50) 0 0 0 0 25 0 0 0 0 10 

SWITCH_PED_ROADS_OFF -1424.0383 -876.6656 10.8537 -1422.4224 -873.6301 29.8434 
SWITCH_PED_ROADS_OFF -1407.0588 -869.3946 -5.8549 -1408.6564 -873.5172 23.8402
SWITCH_PED_ROADS_OFF -1385.1227 -855.1205 10.0263 -1383.9521 -853.1511 28.5218
SWITCH_PED_ROADS_OFF -1386.2469 -863.7204 8.8377 -1393.2700 -859.9062 16.8377



assin4loop:

WAIT 0

//has player collected sniper rifle
IF assassin4flag = 0
	IF HAS_PICKUP_BEEN_COLLECTED sniperifle
		    
 						
			SWITCH_WIDESCREEN ON
			SET_PLAYER_CONTROL player1 OFF

			//create woman
			CREATE_CHAR PEDTYPE_CIVMALE HFYBU womanlocationx womanlocationy womanlocationz woman
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER woman TRUE
			SET_CHAR_HEADING woman womanheading_a3
			ADD_BLIP_FOR_CHAR woman womanblip
			CLEAR_CHAR_THREAT_SEARCH woman
			SET_CHAR_AS_PLAYER_FRIEND woman player1 TRUE
			SET_CHAR_WAIT_STATE woman WAITSTATE_LOOK_ABOUT 15000
			
			//create target
			CREATE_CHAR PEDTYPE_CIVMALE WMORI mantgtlocationx mantgtlocationy mantgtlocationz mantgt
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER mantgt TRUE
			SET_CHAR_HEADING mantgt mantgtheading
			SET_CHAR_WAIT_STATE mantgt WAITSTATE_LOOK_ABOUT 50000
			CLEAR_CHAR_THREAT_SEARCH mantgt
			SET_CHAR_STAY_IN_SAME_PLACE mantgt TRUE 

			//create bodyguard1
			CREATE_CHAR PEDTYPE_SPECIAL SPECIAL01 bodyguard1_am4x bodyguard1_am4y bodyguard1_am4z bodyguard1_am4
			SET_CHAR_HEADING bodyguard1_am4 bodyguard1_am4h  
			GIVE_WEAPON_TO_CHAR bodyguard1_am4 WEAPONTYPE_UZI 300000
			SET_CHAR_AS_LEADER bodyguard1_am4 mantgt
			SET_CHAR_PERSONALITY bodyguard1_am4 PEDSTAT_TOUGH_GUY
			CLEAR_CHAR_THREAT_SEARCH bodyguard1_am4
			SET_CHAR_STAY_IN_SAME_PLACE bodyguard1_am4 TRUE
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER bodyguard1_am4 TRUE

		   	SET_FIXED_CAMERA_POSITION -1488.089478 -811.891785 16.87549 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT -1487.585083 -812.754456 16.912481 JUMP_CUT

			// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 		   	
			// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 
			// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 
			CLEAR_AREA womanlocationx womanlocationy womanlocationz	75.0 FALSE
			CLEAR_AREA mantgtlocationx mantgtlocationy mantgtlocationz	75.0 FALSE
			// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX
			// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 
			// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX  

		   	TIMERA = 0

		    WHILE TIMERA < 5000
		   			   
		    WAIT 0
		
		    PRINT_NOW ( ASM4_16 ) 5000 2	//watch the woman
					
				IF IS_BUTTON_PRESSED PAD1 cross
					GOTO end_of_assassin4_cutscene
				ENDIF
				
		    ENDWHILE

			SET_FIXED_CAMERA_POSITION -1419.44557 -874.218567 21.14 0.0 0.0 0.0
			IF NOT IS_CHAR_DEAD woman
				POINT_CAMERA_AT_CHAR woman FIXED JUMP_CUT
			ENDIF
		   	 	
			TIMERA = 0

		    WHILE TIMERA < 5000
		   			   
		    WAIT 0
		
		    PRINT_NOW ( ASM4_17 ) 5000 2	//only once the...
					
				IF IS_BUTTON_PRESSED PAD1 cross
					GOTO end_of_assassin4_cutscene
				ENDIF
				
		    ENDWHILE

			SET_FIXED_CAMERA_POSITION -1407.900635 -847.959961 19.56 0.0 0.0 0.0
			IF NOT IS_CHAR_DEAD woman
				POINT_CAMERA_AT_CHAR woman FIXED JUMP_CUT
			ENDIF
				
			TIMERA = 0

		    WHILE TIMERA < 5000
		   			   
		    WAIT 0
		
		    PRINT_NOW ( ASM4_18 ) 5000 2	//once target is dead take case...
					
				IF IS_BUTTON_PRESSED PAD1 cross
					GOTO end_of_assassin4_cutscene
				ENDIF
				
		    ENDWHILE

			SET_FIXED_CAMERA_POSITION -1443.797119 -858.372863 19.361 0.0 0.0 0.0
			IF NOT IS_CHAR_DEAD woman
				POINT_CAMERA_AT_CHAR woman FIXED JUMP_CUT
			ENDIF

			TIMERA = 0

		    WHILE TIMERA < 6000
		   			   
		    WAIT 0
		
		    PRINT_NOW ( ASM4_19 ) 6000 2	//distance bar
		    					
				IF IS_BUTTON_PRESSED PAD1 cross
					GOTO end_of_assassin4_cutscene
				ENDIF
				
		    ENDWHILE

			TIMERA = 0

		    WHILE TIMERA < 5000
		   			   
		    WAIT 0
		
		    PRINT_NOW ( ASM4_20 ) 5000 2	//distance bar
		    					
				IF IS_BUTTON_PRESSED PAD1 cross
					GOTO end_of_assassin4_cutscene
				ENDIF
				
		    ENDWHILE



end_of_assassin4_cutscene:
			
			CLEAR_PRINTS
			SWITCH_WIDESCREEN OFF
			SET_PLAYER_CONTROL player1 ON
			RESTORE_CAMERA_JUMPCUT
			
			assassin4flag = 1
    		TIMERA = 0
	ENDIF
ENDIF

//woman walks to man
IF assassin4flag = 1
	IF TIMERA > 15000
		IF NOT IS_CHAR_DEAD woman
			IF NOT IS_CHAR_DEAD mantgt
				SET_CHAR_OBJ_WALK_TO_CHAR woman mantgt
				TIMERA = 0
				assassin4flag = 2
			ENDIF
		ENDIF
	ENDIF
ENDIF

//they talk for 20 seconds 			   
IF assassin4flag = 2
	IF NOT IS_CHAR_DEAD woman
		IF NOT IS_CHAR_DEAD mantgt
			IF NOT IS_CHAR_DEAD bodyguard1_am4
				IF IS_CHAR_OBJECTIVE_PASSED woman
				OR TIMERA > 120000
					SET_CHAR_OBJ_NO_OBJ woman
					SET_CHAR_WAIT_STATE mantgt WAITSTATE_FALSE 100 
					CHAR_LOOK_AT_CHAR_ALWAYS bodyguard1_am4 woman
					SET_CHARS_CHATTING woman mantgt 5000
					TIMERA = 0
					assassin4flag = 3
					womancango = 1
					bodyguardstoplooking = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF


//stop the bodyguards from looking at the woman when she goes
IF TIMERA > 5000
	IF bodyguardstoplooking = 1
		IF NOT IS_CHAR_DEAD bodyguard1_am4
			STOP_CHAR_LOOKING bodyguard1_am4
			SET_CHAR_STAY_IN_SAME_PLACE bodyguard1_am4 FALSE
			bodyguardstoplooking = 2
		ENDIF
	ENDIF
ENDIF


	
IF TIMERA > 5000	   //woman gets off after 20 seconds to her own business
	IF womancango = 1
		IF NOT IS_CHAR_DEAD woman
			CHAR_WANDER_DIR woman -1
			REMOVE_BLIP womanblip
			womancango = 2
		ENDIF
	ENDIF
ENDIF


IF assassin4flag = 3	//man walks away
	IF NOT IS_CHAR_DEAD mantgt
		IF TIMERA > 4999
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mantgt -1389.7546 -859.1885
			TIMERB = 0
			assassin4flag = 4
		ENDIF
	ENDIF
ENDIF
  

		   // calling it everysecond just to make sure
IF NOT IS_CHAR_DEAD mantgt
	IF assassin4flag > 3
									
			IF targetwalk_am4 = 0
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mantgt -1392.8293 -862.1075
				targetwalk_am4 = 1
			ENDIF

			IF targetwalk_am4 = 1
				IF LOCATE_STOPPED_CHAR_ON_FOOT_2D mantgt -1392.8293 -862.1075 1.0 1.0 FALSE
					SET_CHAR_WAIT_STATE mantgt WAITSTATE_CROSS_ROAD_LOOK 1000
					TIMERA = 0
					targetwalk_am4 = 2
				ENDIF
			ENDIF

			IF targetwalk_am4 = 2
				IF TIMERA > 1000
					SET_CHAR_WAIT_STATE mantgt WAITSTATE_FALSE 100
					SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mantgt -1389.6743 -859.1384
					targetwalk_am4 = 3
				ENDIF
			ENDIF

			IF targetwalk_am4 = 3
				IF LOCATE_STOPPED_CHAR_ON_FOOT_2D mantgt -1389.6743 -859.1384 1.0 1.0 FALSE
					SET_CHAR_WAIT_STATE mantgt WAITSTATE_CROSS_ROAD_LOOK 2000
					TIMERA = 0
					targetwalk_am4 = 4
				ENDIF
			ENDIF
			
			IF targetwalk_am4 = 4
				IF TIMERA > 2000
					SET_CHAR_WAIT_STATE mantgt WAITSTATE_FALSE 100
					SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mantgt -1380.3147 -850.1871
					targetwalk_am4 = 5
				ENDIF
			ENDIF

			IF targetwalk_am4 = 5
				IF LOCATE_STOPPED_CHAR_ON_FOOT_2D mantgt -1380.3147 -850.1871 1.0 1.0 FALSE
					targetwalk_am4 = 6
				ENDIF
			ENDIF
			
			IF charnowrun_am4 = 0
				IF targetwalk_am4 = 6
					IF TIMERB > 1000
						CHAR_FOLLOW_PATH mantgt mantgtdestx mantgtdesty mantgtdestz	2.0 WALK
						TIMERB = 0
					ENDIF
				ENDIF
			ENDIF

			IF charnowrun_am4 = 1
				IF targetwalk_am4 = 6
					IF TIMERB > 1000
						CHAR_FOLLOW_PATH mantgt mantgtdestx mantgtdesty mantgtdestz	2.0 RUN
						TIMERB = 0
					ENDIF
				ENDIF
			ENDIF
		
	ENDIF
ENDIF


  
IF assassin4flag > 3
	IF NOT IS_CHAR_DEAD mantgt	//get his coords so we can place the briefcase
		GET_CHAR_COORDINATES mantgt mantgtlastx mantgtlasty mantgtlastz
	ENDIF
ENDIF

IF assassin4flag > 3	   //if he dies leave the briefcase and get the bodyguards on the player
	IF IS_CHAR_DEAD mantgt
		IF mantgtdeaddropdacase = 0
			CREATE_PICKUP BRIEFCASE PICKUP_ONCE mantgtlastx mantgtlasty mantgtlastz briefcase_playerhastoget
			ADD_BLIP_FOR_PICKUP briefcase_playerhastoget briefcase_playerhastogetblip 
			PRINT_NOW ( ASM4_21 ) 5000 2
			CLEAR_ONSCREEN_COUNTER intdistancebar_am4
			ALTER_WANTED_LEVEL player1 2
			SET_PLAYER_MOOD player1 PLAYER_MOOD_ANGRY 300000
			
			SET_ZONE_PED_INFO TERMINL DAY   (13) 0 0 0 0 5 0 0 0 0 5   
			SET_ZONE_PED_INFO TERMINL NIGHT (4 ) 0 0 0 0 5 0 0 0 0 5  
			
				IF NOT IS_CHAR_DEAD bodyguard1_am4
					LEAVE_GROUP bodyguard1_am4
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard1_am4 player1
				ENDIF	
				
			assassin4flag = -1
			takecasetoammu_a4 = 1
			mantgtdeaddropdacase = 1
		ENDIF
	ENDIF
ENDIF

//Display distance bar
IF assassin4flag = 1
	IF displaydistancebar_am4 = 1
		IF displaybar_am4 =0
			DISPLAY_ONSCREEN_COUNTER_WITH_STRING intdistancebar_am4 COUNTER_DISPLAY_BAR ( ASM4_12 )
			displaydistancebar_am4 = 2
			displaybar_am4 = 1
		ENDIF
	ENDIF
ENDIF 


//Distance bar
IF assassin4flag > 0
	IF NOT IS_CHAR_DEAD mantgt

		GET_PLAYER_COORDINATES player1 playerxdist_am4 playerydist_am4 playerzdist_am4
		GET_CHAR_COORDINATES mantgt mandistx_am4 mandisty_am4 mandistz_am4
		GET_DISTANCE_BETWEEN_COORDS_2D playerxdist_am4 playerydist_am4 mandistx_am4 mandisty_am4 distance_am4
		
		IF distance_am4 > 69.0
			distance_am4 = 70.0
		ENDIF				  
		
		IF distance_am4 < 36.0
			distance_am4 = 35.0
		ENDIF

		distancecalc_am4 = 70.0 - distance_am4
		distancebar_am4 = distancecalc_am4/0.35
		intdistancebar_am4 =# distancebar_am4 
		 
		displaydistancebar_am4 = 1

	ENDIF
ENDIF  
				 

//if player is seen by char after conversation
IF assassin4flag > 3
	IF NOT IS_CHAR_DEAD mantgt
		IF intdistancebar_am4 > 97
			IF charnowrun_am4 = 0

				PRINT_NOW ( ASM4_23 ) 5000 2
				CLEAR_ONSCREEN_COUNTER intdistancebar_am4

				IF NOT IS_CHAR_DEAD bodyguard1_am4
					LEAVE_GROUP bodyguard1_am4
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard1_am4 player1
				ENDIF	
				
				charnowrun_am4 = 1
			ENDIF
		ENDIF
	ENDIF
ENDIF


//player fires sniper rifle in area and misses after he gets the case
IF assassin4flag > 3

		IF NOT IS_CHAR_DEAD mantgt
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 mantgt 40.0 40.0 20.0 FALSE
				IF IS_PLAYER_SHOOTING player1
					IF charnowrun_am4 = 0
						
						PRINT_NOW ( ASM4_23 ) 5000 2
						CLEAR_ONSCREEN_COUNTER intdistancebar_am4
				 											
						IF NOT IS_CHAR_DEAD bodyguard1_am4
							LEAVE_GROUP bodyguard1_am4
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard1_am4 player1
						ENDIF	
						
						charnowrun_am4 = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF

ENDIF

//player damages one of the bodyguards
IF assassin4flag > 3
	IF has_char_been_damage_flag = 0
	
	
			IF HAS_CHAR_BEEN_DAMAGED_BY_CHAR bodyguard1_am4 scplayer

				PRINT_NOW ( ASM4_23 ) 5000 2

				IF NOT IS_CHAR_DEAD bodyguard1_am4
					LEAVE_GROUP bodyguard1_am4
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard1_am4 player1
					
				ENDIF	
				
				IF NOT IS_CHAR_DEAD bodyguard1_am4
			   		CLEAR_CHAR_LAST_DAMAGE_ENTITY bodyguard1_am4
				ENDIF

				CLEAR_ONSCREEN_COUNTER intdistancebar_am4
				charnowrun_am4 = 1
				has_char_been_damage_flag = 1

			ENDIF
		   		   		   		
			IF HAS_CHAR_BEEN_DAMAGED_BY_CHAR mantgt scplayer

				PRINT_NOW ( ASM4_23 ) 5000 2

				IF NOT IS_CHAR_DEAD bodyguard1_am4
					LEAVE_GROUP bodyguard1_am4
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard1_am4 player1
				ENDIF	
								
				IF NOT IS_CHAR_DEAD mantgt
			   		CLEAR_CHAR_LAST_DAMAGE_ENTITY mantgt
				ENDIF

				CLEAR_ONSCREEN_COUNTER intdistancebar_am4
				charnowrun_am4 = 1
				has_char_been_damage_flag = 1

			ENDIF
		
	
	ENDIF
ENDIF


//character runs after picks up briefcase 
//IF TIMERB > 1000		   // calling it everysecond just to make sure
//	IF NOT IS_CHAR_DEAD mantgt
//		IF charnowrun_am4 = 1
//			IF assassin4flag > 3
//				CHAR_FOLLOW_PATH mantgt mantgtdestx mantgtdesty mantgtdestz	2.0 RUN
//				TIMERB = 0
//			ENDIF
//		ENDIF
//	ENDIF
//ENDIF


		//////////////////////////////////////////////////////////	GETTING BACK TO AMMUNATION /////////////////////////////////////////////////////

//add the blip for ammunation and create cars
IF takecasetoammu_a4 = 1
	IF HAS_PICKUP_BEEN_COLLECTED briefcase_playerhastoget

		MARK_MODEL_AS_NO_LONGER_NEEDED WMORI
		MARK_MODEL_AS_NO_LONGER_NEEDED HFYBU
		MARK_CHAR_AS_NO_LONGER_NEEDED mantgt

		REQUEST_MODEL maverick
		REQUEST_MODEL admiral

		WHILE NOT HAS_MODEL_LOADED maverick
			OR NOT HAS_MODEL_LOADED admiral
			WAIT 0
		ENDWHILE
		
		CREATE_CAR maverick -1369.4320 -1256.7871 17.3662 heli_am4
		SET_CAR_HEADING heli_am4 308.4397

		REMOVE_BLIP briefcase_playerhastogetblip
				
		PRINT_NOW ( ASM4_22 ) 5000 2

		ADD_BLIP_FOR_COORD destinationx_am4 destinationy_am4 destinationz_am4 ammunationblip_a4


		//1st car in car park
		CREATE_CAR admiral chasecar1x_am4 chasecar1y_am4 chasecar1z_am4 chasecar1_am4
		CHANGE_CAR_COLOUR chasecar1_am4 CARCOLOUR_BLACK CARCOLOUR_BLACK
		SET_CAR_HEADING chasecar1_am4 chasecar1heading_am4
		CREATE_CHAR_INSIDE_CAR chasecar1_am4 PEDTYPE_CIVMALE SPECIAL01 chasedriver1_am4
		SET_CHAR_CAN_BE_SHOT_IN_VEHICLE chasedriver1_am4 FALSE
		CREATE_CHAR_AS_PASSENGER chasecar1_am4 PEDTYPE_CIVMALE SPECIAL02 0 chaseshooter1_am4 
		CAR_SET_IDLE chasecar1_am4
		LOCK_CAR_DOORS chasecar1_am4 CARLOCK_LOCKED
		SET_CAR_ONLY_DAMAGED_BY_PLAYER chasecar1_am4 TRUE
		chasecar1_am4ready = 1
		
		//2nd car in car park
		CREATE_CAR admiral chasecar2x_am4 chasecar2y_am4 chasecar2z_am4 chasecar2_am4
		CHANGE_CAR_COLOUR chasecar2_am4 CARCOLOUR_BLACK CARCOLOUR_BLACK
		SET_CAR_HEADING chasecar2_am4 chasecar2heading_am4
		CREATE_CHAR_INSIDE_CAR chasecar2_am4 PEDTYPE_CIVMALE SPECIAL02 chasedriver2_am4
		SET_CHAR_CAN_BE_SHOT_IN_VEHICLE chasedriver2_am4 FALSE
		CREATE_CHAR_AS_PASSENGER chasecar2_am4 PEDTYPE_CIVMALE SPECIAL01 0 chaseshooter2_am4 
		CAR_SET_IDLE chasecar2_am4
		LOCK_CAR_DOORS chasecar2_am4 CARLOCK_LOCKED
		chasecar2_am4ready = 1
		
		//3rd car waiting near junction near car park
		CREATE_CAR admiral chasecar3x_am4 chasecar3y_am4 chasecar3z_am4 chasecar3_am4
		CHANGE_CAR_COLOUR chasecar3_am4 CARCOLOUR_BLACK CARCOLOUR_BLACK
		SET_CAR_HEADING chasecar3_am4 chasecar3heading_am4
		CREATE_CHAR_INSIDE_CAR chasecar3_am4 PEDTYPE_CIVMALE SPECIAL02 chasedriver3_am4
		SET_CHAR_CAN_BE_SHOT_IN_VEHICLE chasedriver3_am4 FALSE
		CREATE_CHAR_AS_PASSENGER chasecar3_am4 PEDTYPE_CIVMALE SPECIAL01 0 chaseshooter3_am4 
		CAR_SET_IDLE chasecar3_am4
		LOCK_CAR_DOORS chasecar3_am4 CARLOCK_LOCKED
		SET_CAR_ONLY_DAMAGED_BY_PLAYER chasecar3_am4 TRUE
		chasecar3_am4ready = 1
		
		takecasetoammu_a4 = 2
		
	ENDIF
ENDIF


IF takecasetoammu_a4 = 2

	////////////////////////////////////////////////////////////	1ST CHASING CAR		///////////////////////////////////////////////////		 
	IF chasecar1_am4ready = 1
		IF NOT IS_CAR_DEAD chasecar1_am4
			IF IS_PLAYER_IN_AREA_2D player1 -1212.973 -828.562 -1187.989 -985.38 FALSE
			OR NOT IS_CAR_HEALTH_GREATER chasecar1_am4 998		
			  	IF NOT IS_CHAR_DEAD chasedriver1_am4
			  		IF NOT IS_CHAR_DEAD chaseshooter1_am4
			  			IF IS_CHAR_IN_ANY_CAR chasedriver1_am4 
			  				IF IS_CHAR_IN_ANY_CAR chaseshooter1_am4 
			  					SET_CAR_CRUISE_SPEED chasecar1_am4 70.0
			  					CAR_GOTO_COORDINATES_ACCURATE chasecar1_am4 -1202.134766 -937.37207 14.65
			  					SET_CAR_HEAVY chasecar1_am4 TRUE
			  					chasecar1_am4ready = 2
			  				ENDIF
			  			ENDIF
			  		ENDIF
			  	ENDIF
			ENDIF
		ENDIF
	ENDIF
							
	IF chasecar1_am4ready = 2
		IF NOT IS_CHAR_DEAD chasedriver1_am4
			IF NOT IS_CHAR_DEAD chaseshooter1_am4
				IF NOT IS_CAR_DEAD chasecar1_am4
					IF IS_CHAR_IN_ANY_CAR chasedriver1_am4 
						IF IS_CHAR_IN_ANY_CAR chaseshooter1_am4
							IF LOCATE_CAR_2D chasecar1_am4 -1202.134766 -937.37207 7.0 7.0 FALSE
								SET_CAR_MISSION chasecar1_am4 MISSION_BLOCKPLAYER_FARAWAY
								chasecar1_am4ready = 3
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF chasecar1_am4ready = 3
		IF NOT IS_CHAR_DEAD chasedriver1_am4
			IF NOT IS_CHAR_DEAD chaseshooter1_am4
				IF NOT IS_CAR_DEAD chasecar1_am4
					IF IS_CHAR_IN_ANY_CAR chasedriver1_am4 
						IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 chasecar1_am4 30.0 30.0 FALSE
							GET_CAR_COORDINATES chasecar1_am4 chasecar1x_am4 chasecar1y_am4 chasecar1z_am4
							DELETE_CHAR chaseshooter1_am4
							chasecar1z_am4 = chasecar1z_am4 - 20.0
							CREATE_CHAR PEDTYPE_CIVMALE SPECIAL01 chasecar1x_am4 chasecar1y_am4 chasecar1z_am4 chaseshooter1_am4
							ATTACH_CHAR_TO_CAR chaseshooter1_am4 chasecar1_am4 0.0 -0.3 0.8 FACING_FORWARD 360.0 WEAPONTYPE_UZI
							ADD_AMMO_TO_CHAR chaseshooter1_am4 WEAPONTYPE_UZI 3000
							SET_CHAR_PERSONALITY chaseshooter1_am4 PEDSTAT_TOUGH_GUY
							SET_CHAR_STAY_IN_SAME_PLACE chaseshooter1_am4 TRUE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT chaseshooter1_am4 player1
							SET_CAR_DRIVING_STYLE chasecar1_am4 DRIVINGMODE_AVOIDCARS
							SET_CAR_MISSION chasecar1_am4 MISSION_BLOCKPLAYER_FARAWAY
							chasecar1_am4ready = 4
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF 
	 
						
	IF chasecar1_am4ready = 4
		IF NOT IS_CHAR_DEAD chaseshooter1_am4

			IF killplayeronfoot1 = 0
				IF IS_PLAYER_IN_ANY_CAR player1
					STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_car1_am4
					SET_CHAR_OBJ_DESTROY_CAR chaseshooter1_am4 players_car1_am4
					killplayeronfoot1 = 1
				ENDIF
			ENDIF
			
			IF killplayeronfoot1 = 1
				IF NOT IS_PLAYER_IN_ANY_CAR player1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT chaseshooter1_am4 player1
					killplayeronfoot1 = 0
				ENDIF
			ENDIF

		ENDIF
	ENDIF				
			////////////////////////////////////////////////////////////	2ND CHASING CAR		///////////////////////////////////////////////////		 
	IF chasecar2_am4ready = 1
		IF NOT IS_CAR_DEAD chasecar2_am4
			IF IS_PLAYER_IN_AREA_2D player1 -1212.973 -828.562 -1187.989 -985.38 FALSE
			OR NOT IS_CAR_HEALTH_GREATER chasecar2_am4 998	
				IF NOT IS_CHAR_DEAD chasedriver2_am4
					IF NOT IS_CHAR_DEAD chaseshooter2_am4
						IF IS_CHAR_IN_ANY_CAR chasedriver2_am4 
							IF IS_CHAR_IN_ANY_CAR chaseshooter2_am4 
								SET_CAR_CRUISE_SPEED chasecar2_am4 70.0
								CAR_GOTO_COORDINATES chasecar2_am4 -1202.935 -947.956 14.534
								chasecar2_am4ready = 2
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
							
	IF chasecar2_am4ready = 2
		IF NOT IS_CHAR_DEAD chasedriver2_am4
			IF NOT IS_CHAR_DEAD chaseshooter2_am4
				IF NOT IS_CAR_DEAD chasecar2_am4
					IF IS_CHAR_IN_ANY_CAR chasedriver2_am4 
						IF IS_CHAR_IN_ANY_CAR chaseshooter2_am4
							IF LOCATE_CAR_2D chasecar2_am4 -1202.935 -947.956 10.0 10.0 FALSE
								SET_CAR_MISSION chasecar2_am4 MISSION_RAMPLAYER_FARAWAY
								chasecar2_am4ready = 3
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF chasecar2_am4ready = 3
		IF NOT IS_CHAR_DEAD chasedriver2_am4
			IF NOT IS_CHAR_DEAD chaseshooter2_am4
				IF NOT IS_CAR_DEAD chasecar2_am4
					IF IS_CHAR_IN_ANY_CAR chasedriver2_am4 
						IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 chasecar2_am4 30.0 30.0 FALSE
							GET_CAR_COORDINATES chasecar2_am4 chasecar2x_am4 chasecar2y_am4 chasecar2z_am4
							DELETE_CHAR chaseshooter2_am4
							chasecar2z_am4 = chasecar2z_am4 - 20.0
							CREATE_CHAR PEDTYPE_CIVMALE SPECIAL01 chasecar2x_am4 chasecar2y_am4 chasecar2z_am4 chaseshooter2_am4
							ATTACH_CHAR_TO_CAR chaseshooter2_am4 chasecar2_am4 0.0 -0.3 0.8 FACING_FORWARD 360.0 WEAPONTYPE_UZI
							ADD_AMMO_TO_CHAR chaseshooter2_am4 WEAPONTYPE_UZI 3000
							SET_CHAR_PERSONALITY chaseshooter2_am4 PEDSTAT_TOUGH_GUY
							SET_CHAR_STAY_IN_SAME_PLACE chaseshooter2_am4 TRUE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT chaseshooter2_am4 player1
							SET_CAR_MISSION chasecar2_am4 MISSION_RAMPLAYER_FARAWAY
							chasecar2_am4ready = 4
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF 
	 
	IF chasecar2_am4ready = 4
		IF NOT IS_CHAR_DEAD chaseshooter2_am4

			IF killplayeronfoot2 = 0
				IF IS_PLAYER_IN_ANY_CAR player1
					STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_car1_am4
					SET_CHAR_OBJ_DESTROY_CAR chaseshooter2_am4 players_car1_am4
					killplayeronfoot2 = 1
				ENDIF
			ENDIF
			
			IF killplayeronfoot2 = 1
				IF NOT IS_PLAYER_IN_ANY_CAR player1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT chaseshooter2_am4 player1
					killplayeronfoot2 = 0
				ENDIF
			ENDIF

		ENDIF
	ENDIF				


		//////////////////////////////////////////////////////////////	3rd CAR WAITING FOR PLAYER	////////////////////////////////////////////////////	 	
		
	IF chasecar3_am4ready = 1
		IF NOT IS_CHAR_DEAD chasedriver3_am4
			IF NOT IS_CAR_DEAD chasecar3_am4
				IF IS_CHAR_IN_ANY_CAR chasedriver3_am4 
					IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 chasecar3_am4 25.0 25.0 FALSE
					OR NOT IS_CAR_HEALTH_GREATER chasecar3_am4 998  
						SET_CAR_CRUISE_SPEED chasecar3_am4 70.0
						SET_CAR_DRIVING_STYLE chasecar3_am4 DRIVINGMODE_AVOIDCARS
						SET_CAR_MISSION chasecar3_am4 MISSION_RAMPLAYER_FARAWAY
						SET_CAR_HEAVY chasecar3_am4 TRUE
						chasecar3_am4ready = 2
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
							

	IF chasecar3_am4ready = 2
		IF NOT IS_CHAR_DEAD chasedriver3_am4
			IF NOT IS_CHAR_DEAD chaseshooter3_am4
				IF NOT IS_CAR_DEAD chasecar3_am4
					IF IS_CHAR_IN_ANY_CAR chasedriver3_am4 
						IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 chasecar3_am4 25.0 25.0 FALSE
							GET_CAR_COORDINATES chasecar3_am4 chasecar3x_am4 chasecar3y_am4 chasecar3z_am4
							DELETE_CHAR chaseshooter3_am4
							chasecar3z_am4 = chasecar3z_am4 - 20.0
							CREATE_CHAR PEDTYPE_CIVMALE SPECIAL01 chasecar3x_am4 chasecar3y_am4 chasecar3z_am4 chaseshooter3_am4
							ATTACH_CHAR_TO_CAR chaseshooter3_am4 chasecar3_am4 0.0 -0.3 0.8 FACING_FORWARD 360.0 WEAPONTYPE_UZI
							ADD_AMMO_TO_CHAR chaseshooter3_am4 WEAPONTYPE_UZI 3000
							SET_CHAR_PERSONALITY chaseshooter3_am4 PEDSTAT_TOUGH_GUY
							SET_CHAR_STAY_IN_SAME_PLACE chaseshooter3_am4 TRUE
							SET_CHAR_ACCURACY chaseshooter3_am4 90
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT chaseshooter3_am4 player1
							SET_CAR_MISSION chasecar3_am4 MISSION_BLOCKPLAYER_FARAWAY
							chasecar3_am4ready = 3
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF 
	 
	IF chasecar3_am4ready = 4
		IF NOT IS_CHAR_DEAD chaseshooter3_am4

			IF killplayeronfoot3 = 0
				IF IS_PLAYER_IN_ANY_CAR player1
					STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_car1_am4
					SET_CHAR_OBJ_DESTROY_CAR chaseshooter3_am4 players_car1_am4
					killplayeronfoot3 = 1
				ENDIF
			ENDIF
			
			IF killplayeronfoot3 = 1
				IF NOT IS_PLAYER_IN_ANY_CAR player1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT chaseshooter3_am4 player1
					killplayeronfoot3 = 0
				ENDIF
			ENDIF

		ENDIF
	ENDIF	


	//remove models etc.
	IF IS_CHAR_DEAD bodyguard1_am4
		MARK_CHAR_AS_NO_LONGER_NEEDED bodyguard1_am4
	ENDIF
	
	IF IS_CHAR_DEAD chasedriver1_am4
		MARK_CHAR_AS_NO_LONGER_NEEDED chasedriver1_am4
	ENDIF
	
	IF IS_CHAR_DEAD chaseshooter1_am4
		MARK_CHAR_AS_NO_LONGER_NEEDED chaseshooter1_am4
	ENDIF
	
	IF IS_CHAR_DEAD chasedriver2_am4
		MARK_CHAR_AS_NO_LONGER_NEEDED chasedriver2_am4
	ENDIF
	
	IF IS_CHAR_DEAD chaseshooter2_am4
		MARK_CHAR_AS_NO_LONGER_NEEDED chaseshooter2_am4
	ENDIF

	IF IS_CHAR_DEAD chasedriver3_am4
		MARK_CHAR_AS_NO_LONGER_NEEDED chasedriver3_am4
	ENDIF
	
	IF IS_CHAR_DEAD chaseshooter3_am4
		MARK_CHAR_AS_NO_LONGER_NEEDED chaseshooter3_am4
	ENDIF

	IF IS_CAR_DEAD chasecar1_am4 
		MARK_CAR_AS_NO_LONGER_NEEDED chasecar1_am4
	ENDIF

	IF IS_CAR_DEAD chasecar2_am4 
		MARK_CAR_AS_NO_LONGER_NEEDED chasecar2_am4
	ENDIF
	
	IF IS_CAR_DEAD chasecar3_am4 
		MARK_CAR_AS_NO_LONGER_NEEDED chasecar3_am4
	ENDIF
ENDIF

			//////////////////////////////////////////////////////////	PASS AND FAIL CONDITIONS	/////////////////////////////////////////////////////

/*
Watch the woman on the balcony, she will walk down the escalators and ask someone the time.
Once the conversation has finished kill the person she spoke to, but do not kill her.
Once the target is dead retrieve his case and take it to AmmuNation in Downtown.
*/

//lose conditions
//if woman is killed
IF assassin4flag > 0
OR assassin4flag = -1
	IF IS_CHAR_DEAD woman
		PRINT_NOW ( ASM4_25 ) 5000 1
		GOTO mission_assin4_failed
	ENDIF
ENDIF

//player kills man before conversation ends
IF assassin4flag > 0
	IF assassin4flag < 4
		IF IS_CHAR_DEAD mantgt

			PRINT_NOW ( ASM4_29 ) 5000 1
			
			IF NOT IS_CHAR_DEAD bodyguard1_am4
				LEAVE_GROUP bodyguard1_am4
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard1_am4 player1
			ENDIF	
						
			GOTO mission_assin4_failed
		ENDIF
	ENDIF
ENDIF

//damages
//player damages one of the bodyguards
IF assassin4flag < 4
AND assassin4flag > 0
	IF has_char_been_damage_flag = 0
	
	
			IF HAS_CHAR_BEEN_DAMAGED_BY_CHAR bodyguard1_am4 scplayer

				IF NOT IS_CHAR_DEAD bodyguard1_am4
					LEAVE_GROUP bodyguard1_am4
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard1_am4 player1
				ENDIF	
											   	
				IF NOT IS_CHAR_DEAD bodyguard1_am4
			   		CLEAR_CHAR_LAST_DAMAGE_ENTITY bodyguard1_am4
				ENDIF
			   				   	
			   	PRINT_NOW ( ASM4_28 ) 5000 1	//seen you
				has_char_been_damage_flag = 1
				GOTO mission_assin4_failed

			ENDIF
		   
		   	IF HAS_CHAR_BEEN_DAMAGED_BY_CHAR mantgt scplayer

				IF NOT IS_CHAR_DEAD bodyguard1_am4
					LEAVE_GROUP bodyguard1_am4
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard1_am4 player1
				ENDIF	

			   	IF NOT IS_CHAR_DEAD mantgt
			   		CLEAR_CHAR_LAST_DAMAGE_ENTITY mantgt
				ENDIF

				PRINT_NOW ( ASM4_28 ) 5000 1	//seen you
				has_char_been_damage_flag = 1
				GOTO mission_assin4_failed

			ENDIF
		
	
	ENDIF
ENDIF



//player fires sniper rifle in area and misses before he gets case
IF assassin4flag > 0
	IF assassin4flag < 4
		IF NOT IS_CHAR_DEAD mantgt
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 mantgt 40.0 40.0 20.0 FALSE
				IF IS_PLAYER_SHOOTING player1

					PRINT_NOW ( ASM4_28 ) 5000 1	//heard you firing your weapon
					
					IF NOT IS_CHAR_DEAD bodyguard1_am4
						LEAVE_GROUP bodyguard1_am4
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard1_am4 player1
					ENDIF	
								
				 	GOTO mission_assin4_failed

				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

//if player is seen by char
IF assassin4flag > 0
	IF assassin4flag < 4
		IF intdistancebar_am4 > 97
			
			PRINT_NOW ( ASM4_27 ) 5000 1	//seen you 

			IF NOT IS_CHAR_DEAD bodyguard1_am4
				LEAVE_GROUP bodyguard1_am4
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard1_am4 player1
			ENDIF	
			
			GOTO mission_assin4_failed

		ENDIF
	ENDIF
ENDIF
	
//if he gets to his location
IF NOT IS_CHAR_DEAD mantgt
	IF LOCATE_CHAR_ANY_MEANS_2D	mantgt mantgtdestx mantgtdesty 5.0 5.0 FALSE
		PRINT_NOW ( ASM4_26 ) 5000 1//he has boarded....

		IF NOT IS_CHAR_DEAD bodyguard1_am4
			LEAVE_GROUP bodyguard1_am4
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard1_am4 player1
		ENDIF	
		
		GOTO mission_assin4_failed
	ENDIF
ENDIF 


//pass
IF takecasetoammu_a4 > 1 
	IF LOCATE_PLAYER_ON_FOOT_3D player1 destinationx_am4 destinationy_am4 destinationz_am4 3.0 3.0 3.0 TRUE
		GOTO mission_assin4_passed
	ENDIF
ENDIF
	
GOTO assin4loop



 // **************************************** Mission haitian3 failed ************************

mission_assin4_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// **************************************** mission haitian3 passed ************************

mission_assin4_passed:

flag_assin_mission4_passed = 1
REGISTER_MISSION_PASSED ( JOB_4 )
PRINT_WITH_NUMBER_BIG ( M_PASS ) 8000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 8000
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
ADD_NUMBER_OF_ASSASSINATIONS 1
REMOVE_BLIP assasin_contact_blip
RETURN
		


// ********************************** mission cleanup **************************************

mission_cleanup_assin4:

flag_player_on_mission = 0
REMOVE_BLIP ammunationblip_a4
REMOVE_BLIP briefcase_playerhastogetblip
REMOVE_BLIP	sniperifleblip
REMOVE_BLIP womanblip

REMOVE_PICKUP briefcase_playerhastoget
REMOVE_PICKUP sniperifle 

MARK_MODEL_AS_NO_LONGER_NEEDED WMORI
MARK_MODEL_AS_NO_LONGER_NEEDED HFYBU
MARK_MODEL_AS_NO_LONGER_NEEDED admiral
MARK_MODEL_AS_NO_LONGER_NEEDED maverick
MARK_MODEL_AS_NO_LONGER_NEEDED UZI

REMOVE_CHAR_ELEGANTLY bodyguard1_am4
REMOVE_CHAR_ELEGANTLY mantgt
REMOVE_CHAR_ELEGANTLY chasedriver1_am4
REMOVE_CHAR_ELEGANTLY chaseshooter1_am4
REMOVE_CHAR_ELEGANTLY chasedriver2_am4
REMOVE_CHAR_ELEGANTLY chaseshooter2_am4
REMOVE_CHAR_ELEGANTLY chasedriver3_am4
REMOVE_CHAR_ELEGANTLY chaseshooter3_am4

CLEAR_ONSCREEN_COUNTER intdistancebar_am4

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

SET_ZONE_PED_INFO TERMINL DAY   (13) 0 0 0 0 50 0 0 0 0 20   
SET_ZONE_PED_INFO TERMINL NIGHT (4 ) 0 0 0 0 50 0 0 0 0 10 

SWITCH_PED_ROADS_ON -1424.0383 -876.6656 10.8537 -1422.4224 -873.6301 29.8434 
SWITCH_PED_ROADS_ON -1407.0588 -869.3946 -5.8549 -1408.6564 -873.5172 23.8402
SWITCH_PED_ROADS_ON -1385.1227 -855.1205 10.0263 -1383.9521 -853.1511 28.5218
SWITCH_PED_ROADS_ON -1386.2469 -863.7204 8.8377 -1393.2700 -859.9062 16.8377

GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN
}