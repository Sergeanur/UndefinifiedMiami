MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ************************************* Biker Gang Mission Two ****************************
// ************************************** Messin' With The Man *****************************
// Messing with the man
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME bike2

// Mission start stuff

GOSUB mission_start_bike2

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_bike2_failed
ENDIF

GOSUB mission_cleanup_bike2

MISSION_END


// Variables for mission

VAR_INT chaosmeter_bike2

VAR_INT flag_chaos_meter_full

VAR_INT havoc_value_bike2

VAR_INT flag_havoc_added_bike2

VAR_INT flag_player_had_message_bike2 // Tells me that the player has been told about the meter

VAR_INT wanted_multiplier_changed_bike2 // Used to set the wanted level multiplier back to normal after the player has a waned level

VAR_INT timer_bike2

// ****************************************Mission Start************************************

mission_start_bike2:

flag_player_on_mission = 1

REGISTER_MISSION_GIVEN

chaosmeter_bike2 = 0

flag_chaos_meter_full = 0

havoc_value_bike2 = 0

flag_havoc_added_bike2 = 0

flag_player_had_message_bike2 = 0

wanted_multiplier_changed_bike2 = 0 // Used to change the players wanted multiplier back to the normal level once he has one

timer_bike2 = 121000 // 2 mins

WAIT 0

LOAD_MISSION_TEXT BIKE2

SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -609.723 658.861 9.908 279.440

{

// ****************************************START OF CUTSCENE********************************

// This is the correct cutscene the names were just round the wrong ways

LOAD_SPECIAL_CHARACTER 1 CSbigm

LOAD_SPECIAL_CHARACTER 2 CSplay

LOAD_SPECIAL_CHARACTER 3 mgoona

LOAD_SPECIAL_CHARACTER 4 mserver

SET_AREA_VISIBLE VIS_BIKER_BAR

LOAD_SCENE -597.02 642.46 11.0

SET_EXTRA_COLOURS 15 FALSE

LOAD_ALL_MODELS_NOW

		 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4

	WAIT 0

ENDWHILE

LOAD_CUTSCENE bike_3

SET_CUTSCENE_OFFSET -602.052 636.289 10.636
SET_NEAR_CLIP 0.1

CREATE_CUTSCENE_OBJECT SPECIAL01 cs_bigm
SET_CUTSCENE_ANIM cs_bigm CSbigm

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_player 
SET_CUTSCENE_ANIM cs_player CSplay 
				
CREATE_CUTSCENE_OBJECT SPECIAL03 cs_mgoona
SET_CUTSCENE_ANIM cs_mgoona mgoona

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_mserver
SET_CUTSCENE_ANIM cs_mserver mserver

CLEAR_AREA -597.25 655.87 10.06 1.0 TRUE
SET_PLAYER_COORDINATES player1 -597.25 655.87 10.06
SET_PLAYER_HEADING player1 0.0

DO_FADE 2000 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 3004 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_A ) 10000 1 //"Ha ha ha, got you again.

WHILE cs_time < 5135
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_B ) 10000 1 //"Hey Vercetti.

WHILE cs_time < 6423  
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_C ) 10000 1 //"Cougar says you can handle a bike pretty good.

WHILE cs_time < 8568 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_D ) 10000 1 //"Yeah, how many more errands an I going to have to run?

WHILE cs_time < 10974 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_E ) 10000 1 //"I'm a very busy man.

WHILE cs_time < 12703 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_F ) 10000 1 //"If it's a fight that's going to settle it then just bring it on.

WHILE cs_time < 14662 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_G ) 10000 1 //"Being one of us ain't just about brawlin'. It's about being part of a family.

WHILE cs_time < 18829 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_H ) 10000 1 //"Yeah, I've been part of a family before alright. It didn't work out"

WHILE cs_time < 21584 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_I ) 10000 1 //"Yeah, right, but this family takes care of its own."

WHILE cs_time < 24017 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_J ) 10000 1 //"We don't ask one of our own to do the dirty work and then let him do fifteen years hard time."

WHILE cs_time < 28016 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_K ) 10000 1 //"Yeah, that's right. I done my homework."

WHILE cs_time < 30132 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_L ) 10000 1 //"This here's teh biggest family of misfits, outcasts and badasses."

WHILE cs_time < 34034 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_M ) 10000 1 //"Hell, some of us even been betrayed by our own country."

WHILE cs_time < 36593 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_N ) 10000 1 //"I was locked up during 'Nam. Ugly business."

WHILE cs_time < 38862 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_O ) 10000 1 //"Which is why I'm gonna ask you to mess with the man.

WHILE cs_time < 41401 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_P ) 10000 1 //"This whole goddamn country needs a kick in the ass, and we're the ones that deliver it.

WHILE cs_time < 44782 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_Q ) 10000 1 //"So get out there, grab a bike, show this city how pissed you are!

WHILE cs_time < 49441
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM2_R ) 10000 1 //"Alright.

WHILE cs_time < 50560
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

DO_FADE 2000 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4

SET_AREA_VISIBLE VIS_MAIN_MAP

CLEAR_EXTRA_COLOURS FALSE

LOAD_SCENE -597.25 655.87 10.06


// ****************************************END OF CUTSCENE**********************************

SET_PLAYER_MOOD player1 PLAYER_MOOD_ANGRY 60000

// fades the screen in 

SET_FADING_COLOUR 0 0 0

WAIT 500

DO_FADE 1500 FADE_IN

PRINT_NOW ( BM2_2 ) 5000 1 //"You must fill the Chaos Meter to show us how cool you are!"

DISPLAY_ONSCREEN_COUNTER_WITH_STRING chaosmeter_bike2 COUNTER_DISPLAY_BAR ( BM2_1 )

SET_WANTED_MULTIPLIER 3.0 

timera = 0

DISPLAY_ONSCREEN_TIMER timer_bike2 TIMER_DOWN

WHILE flag_chaos_meter_full = 0

	WAIT 0

	IF timer_bike2 = 0
		PRINT_NOW ( BM2_4 ) 5000 1 //"You failed to impress us!"
		GOTO mission_bike2_failed
	ENDIF

	IF wanted_multiplier_changed_bike2 = 0

		IF IS_WANTED_LEVEL_GREATER player1 2
			SET_WANTED_MULTIPLIER 1.0
			wanted_multiplier_changed_bike2 = 1
		ENDIF

	ENDIF	

	IF chaosmeter_bike2 = 100
		flag_chaos_meter_full = 1
	ENDIF

	GET_HAVOC_CAUSED_BY_PLAYER player1 havoc_value_bike2
	
	IF havoc_value_bike2 >= 25

		IF flag_havoc_added_bike2 = 0

			IF chaosmeter_bike2 <= 99
				chaosmeter_bike2 = chaosmeter_bike2 + 5
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			ELSE
				chaosmeter_bike2 = 100
			ENDIF
			
			IF flag_player_had_message_bike2 = 0
				PRINT_NOW ( BM2_3 ) 5000 1 //"Continue to fill the meter!"
				flag_player_had_message_bike2 = 1
			ENDIF
			
			flag_havoc_added_bike2 = 1
		ENDIF

		IF flag_havoc_added_bike2 = 1
			RESET_HAVOC_CAUSED_BY_PLAYER player1
			flag_havoc_added_bike2 = 0
		ENDIF 
		
	ENDIF
      	  	  
ENDWHILE

GOTO mission_bike2_passed

// ****************************************** Mission Failed *******************************

mission_bike2_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN

// *************************************** Mission Passed **********************************

mission_bike2_passed:

flag_bikers_mission2_passed = 1
REGISTER_MISSION_PASSED ( BIKE_2 )
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1

IF biker_bar_sound1_added = 1
	REMOVE_SOUND bike_bar_loop1
	biker_bar_sound1_added = 0
ENDIF

IF biker_bar_sound2_added = 1
	REMOVE_SOUND bike_bar_loop2
	biker_bar_sound2_added = 0
ENDIF

IF biker_bar_sound3_added = 1
	REMOVE_SOUND bike_bar_loop3
	biker_bar_sound3_added = 0
ENDIF

IF biker_bar_sound3_added = 0
	ADD_CONTINUOUS_SOUND -596.018 640.916 12.0 SOUND_NEW_BUILDING_BAR_3 bike_bar_loop3	//Biker bar
	biker_bar_sound3_added = 1
ENDIF

PRINT_WITH_NUMBER_BIG ( M_PASS ) 2000 5000 1 //"Mission Passed!"
ADD_SCORE player1 2000
START_NEW_SCRIPT bikers_mission3_loop
RETURN

// *************************************** Mission Cleanup *********************************

mission_cleanup_bike2:

flag_player_on_mission = 0
CLEAR_ONSCREEN_TIMER timer_bike2
CLEAR_ONSCREEN_COUNTER chaosmeter_bike2
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN
		
}