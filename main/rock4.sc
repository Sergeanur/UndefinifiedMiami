MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ************************************ Rock Mission One ***********************************
// ************************************** The Concert **************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME rockb4

// Mission start stuff

GOSUB mission_start_rock4

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_rock4_failed
ENDIF

GOSUB mission_cleanup_rock4

MISSION_END


// Variables for mission

VAR_INT psycho_rock4

VAR_INT radar_blip_coord1_rock4

VAR_INT flag_psycho_dead_rock4

VAR_INT radar_blip_psycho_rock4 



// ****************************************Mission Start************************************

mission_start_rock4:

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1

flag_psycho_dead_rock4 = 0

WAIT 0

{


// ****************************************START OF CUTSCENE********************************

/*
IF CAN_PLAYER_START_MISSION player1
	MAKE_PLAYER_SAFE_FOR_CUTSCENE player1
ELSE
	GOTO mission_assin_failed
ENDIF

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSkent

//LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
//LOAD_SPECIAL_MODEL cut_obj2 LAWYERH

//LOAD_SCENE 1218.4 -314.5 28.9

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2

//OR NOT HAS_MODEL_LOADED cut_obj1
//OR NOT HAS_MODEL_LOADED cut_obj2
	WAIT 0

ENDWHILE

LOAD_CUTSCENE rok_4a

SET_CUTSCENE_OFFSET 476.972 -65.499 8.943
SET_NEAR_CLIP 0.1

CREATE_CUTSCENE_OBJECT SPECIAL01 cs_play
SET_CUTSCENE_ANIM cs_play CSplay				

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_kent
SET_CUTSCENE_ANIM cs_kent CSkent

//CREATE_CUTSCENE_HEAD cs_ken CUT_OBJ2 cs_kenhead
//SET_CUTSCENE_HEAD_ANIM cs_kenhead lawyer

//CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
//SET_CUTSCENE_HEAD_ANIM cs_playerhead player1

CLEAR_AREA 495.12 -83.39 9.02 1.0 TRUE
SET_PLAYER_COORDINATES player1 495.12 -83.39 9.02
SET_PLAYER_HEADING player1 223.21

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time


WHILE cs_time < 171
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM1_A ) 10000 1 // Mission brief


CLEAR_PRINTS


WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0

ENDWHILE

DO_FADE 1500 FADE_OUT


CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

*/


// ****************************************END OF CUTSCENE**********************************

// fades the screen in

SET_FADING_COLOUR 0 0 0

WAIT 500

DO_FADE 1500 FADE_IN


// Waiting for the ped models to load

REQUEST_MODEL HMOCA 

//REQUEST_MODEL BAT 

WHILE NOT HAS_MODEL_LOADED HMOCA
//OR NOT HAS_MODEL_LOADED BAT

	WAIT 0
      
ENDWHILE

PRINT_NOW ( RBM4_1 ) 5000 1 //"Go and deal with the psycho stalking the band, make sure you finsh the job this time!

// Creates the psycho

CREATE_CHAR PEDTYPE_CIVFEMALE HMOCA -874.6 1053.0 10.1 psycho_rock4

CLEAR_CHAR_THREAT_SEARCH psycho_rock4

//GIVE_WEAPON_TO_CHAR psycho_rock4 WEAPONTYPE_BASEBALLBAT 1

CHAR_WANDER_DIR psycho_rock4 -1

ADD_BLIP_FOR_CHAR psycho_rock4 radar_blip_psycho_rock4  

WHILE flag_psycho_dead_rock4 = 0

	WAIT 0

	IF flag_psycho_dead_rock4 = 0

		IF IS_CHAR_DEAD psycho_rock4
			REMOVE_BLIP radar_blip_psycho_rock4
			flag_psycho_dead_rock4 = 1
		ELSE
			
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 psycho_rock4 20.0 20.0 20.0 FALSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT psycho_rock4 player1
			ELSE
				SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_TILL_SAFE psycho_rock4 player1
			ENDIF 	

		ENDIF

	ENDIF

ENDWHILE

REMOVE_BLIP radar_blip_psycho_rock4

GOTO mission_rock4_passed


} 

// ****************************************** Mission Failed *******************************

mission_rock4_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN


   

// *************************************** Mission Passed **********************************

mission_rock4_passed:

flag_rock_mission4_passed = 1
//REGISTER_MISSION_PASSED ( )
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
CLEAR_WANTED_LEVEL player1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 1000 5000 1 //"Mission Passed!"
ADD_SCORE player1 1000
REMOVE_BLIP rock_contact_blip  // mission strand has ended so remove the contact blip
RETURN
	


// *************************************** Mission Cleanup *********************************

mission_cleanup_rock4:

flag_player_on_mission = 0
REMOVE_BLIP radar_blip_psycho_rock4
MARK_MODEL_AS_NO_LONGER_NEEDED HMOCA
//MARK_MODEL_AS_NO_LONGER_NEEDED BAT
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN
		
