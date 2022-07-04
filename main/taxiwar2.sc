MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// ***************************************Taxi WAR 3******************************************
// ****************************************Pay back*******************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff			

GOSUB mission_start_taxiwar2

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_taxiwar2_failed
ENDIF

GOSUB mission_cleanup_taxiwar2

MISSION_END

// Variables for mission
{

// ***************************************Mission Start*************************************

mission_start_taxiwar2:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
SCRIPT_NAME taxwar2
WAIT 0

LOAD_MISSION_TEXT TAXIWA2
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -1020.8 191.1 10.5 350.0

counter_taxiwar = 0
dead_taxicab1 = 0
dead_taxicab2 = 0
dead_taxicab3 = 0
cab1_obj_set = 0
cab2_obj_set = 0
cab3_obj_set = 0
in_taxi1 = 0
in_taxi2 = 0
in_taxi3 = 0



//SET_PLAYER_CONTROL player1 OFF

LOAD_MISSION_AUDIO 1 TAX2_1
LOAD_MISSION_AUDIO 2 TAX2_2

WHILE NOT HAS_MISSION_AUDIO_LOADED	1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE

PLAY_MISSION_AUDIO 1
PRINT_NOW ( TAX2_1 ) 4000 1 

WAIT 500

TIMERA = 0

WHILE NOT TIMERA > 4000
	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_passed_taxi2_cut
	ENDIF

ENDWHILE

PLAY_MISSION_AUDIO 2
PRINT_NOW ( TAX2_2 ) 4000 1

TIMERA = 0

WHILE NOT TIMERA > 4000
	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_passed_taxi2_cut
	ENDIF

ENDWHILE

LOAD_MISSION_AUDIO 1 TAX2_3

WHILE NOT HAS_MISSION_AUDIO_LOADED	1
	WAIT 0
ENDWHILE

PLAY_MISSION_AUDIO 1
PRINT_NOW ( TAX2_3 ) 6000 1

TIMERA = 0

WHILE NOT TIMERA > 6000
	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_passed_taxi2_cut
	ENDIF

ENDWHILE

skip_passed_taxi2_cut:

SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2

REQUEST_MODEL taxi
REQUEST_MODEL WMOCA
REQUEST_MODEL uzi
REQUEST_MODEL kaufman

	WHILE NOT HAS_MODEL_LOADED taxi
	OR NOT HAS_MODEL_LOADED WMOCA
	OR NOT HAS_MODEL_LOADED uzi
	OR NOT HAS_MODEL_LOADED	kaufman
		WAIT 0

	ENDWHILE
	 
// START OF MISSION

//GIVE_WEAPON_TO_PLAYER Player1 WEAPONTYPE_SILENCED_INGRAM 300
//SET_CURRENT_PLAYER_WEAPON Player1 WEAPONTYPE_SILENCED_INGRAM
ENSURE_PLAYER_HAS_DRIVE_BY_WEAPON Player1 300
SET_PLAYER_CAN_DO_DRIVE_BY Player1 TRUE

CREATE_CAR taxi -893.3 -653.1 -100.0 taxicab1  
CREATE_CHAR_INSIDE_CAR taxicab1 PEDTYPE_CIVMALE WMOCA taximan1
//CHANGE_CAR_COLOUR taxicab1 CARCOLOUR_RED1 CARCOLOUR_ORANGE4  
ADD_BLIP_FOR_CAR taxicab1 blip1_taxicab1 
SET_CAR_CRUISE_SPEED  taxicab1 17.0
SET_CAR_DRIVING_STYLE taxicab1 DRIVINGMODE_AVOIDCARS
SET_CAR_ONLY_DAMAGED_BY_PLAYER taxicab1 TRUE
SET_CHAR_PERSONALITY taximan1 PEDSTAT_TOUGH_GUY
//SET_CAR_HEALTH taxicab1 600

CREATE_CAR taxi -978.7 -606.3 -100.0 taxicab2
CREATE_CHAR_INSIDE_CAR taxicab2 PEDTYPE_CIVMALE WMOCA taximan2
//CHANGE_CAR_COLOUR taxicab2 CARCOLOUR_RED1 CARCOLOUR_ORANGE4  
ADD_BLIP_FOR_CAR taxicab2 blip2_taxicab2
SET_CAR_CRUISE_SPEED  taxicab2 17.0
SET_CAR_DRIVING_STYLE taxicab2 DRIVINGMODE_AVOIDCARS
SET_CAR_ONLY_DAMAGED_BY_PLAYER taxicab2 TRUE
SET_CHAR_PERSONALITY taximan2 PEDSTAT_TOUGH_GUY
//SET_CAR_HEALTH taxicab2 600

CREATE_CAR taxi -1059.0 -334.8 -100.0 taxicab3
CREATE_CHAR_INSIDE_CAR taxicab3 PEDTYPE_CIVMALE WMOCA taximan3
//CHANGE_CAR_COLOUR taxicab3 CARCOLOUR_RED1 CARCOLOUR_ORANGE4  
ADD_BLIP_FOR_CAR taxicab3 blip3_taxicab3
SET_CAR_CRUISE_SPEED  taxicab3 17.0
SET_CAR_DRIVING_STYLE taxicab3 DRIVINGMODE_AVOIDCARS
SET_CAR_ONLY_DAMAGED_BY_PLAYER taxicab3 TRUE
SET_CHAR_PERSONALITY taximan3 PEDSTAT_TOUGH_GUY
//SET_CAR_HEALTH taxicab3 600



PRINT_NOW ( TAXW2_1 ) 10000 1 //KILL THE CABS

WHILE NOT counter_taxiwar = 3
	WAIT 0

		IF IS_CAR_DEAD taxicab1 
		AND dead_taxicab1 = 0
			REMOVE_BLIP blip1_taxicab1
			dead_taxicab1 = 1
			++ counter_taxiwar	
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ENDIF
	
		IF NOT IS_CAR_DEAD taxicab1 
			IF NOT IS_CAR_HEALTH_GREATER taxicab1 999
				IF NOT IS_CHAR_DEAD taximan1
					IF IS_CHAR_IN_CAR taximan1 taxicab1
						IF cab1_obj_set = 0
							SET_CAR_CRUISE_SPEED taxicab1 35.0
							SET_CAR_DRIVING_STYLE taxicab1 2
							SET_CAR_MISSION taxicab1 MISSION_RAMPLAYER_FARAWAY
							SET_CAR_ONLY_DAMAGED_BY_PLAYER taxicab1 FALSE
							cab1_obj_set = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
 
		IF NOT IS_CAR_DEAD taxicab1
			IF IS_PLAYER_IN_CAR player1 taxicab1
			AND in_taxi1 = 0
				SET_CAR_ONLY_DAMAGED_BY_PLAYER taxicab1 FALSE
				in_taxi1 = 1
			ENDIF
		ENDIF

		IF IS_CAR_DEAD taxicab2
		AND dead_taxicab2 = 0 
			REMOVE_BLIP blip2_taxicab2
			dead_taxicab2 = 1
			++ counter_taxiwar
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE 
		ENDIF
	   	
		IF NOT IS_CAR_DEAD taxicab2
			IF NOT IS_CAR_HEALTH_GREATER taxicab2 999
				IF NOT IS_CHAR_DEAD taximan2
					IF IS_CHAR_IN_CAR taximan2 taxicab2
						IF cab2_obj_set = 0
							SET_CAR_CRUISE_SPEED taxicab2 35.0
							SET_CAR_DRIVING_STYLE taxicab2 2
							SET_CAR_MISSION taxicab2 MISSION_RAMPLAYER_FARAWAY
							SET_CAR_ONLY_DAMAGED_BY_PLAYER taxicab2 FALSE
							cab2_obj_set = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD taxicab2
			IF IS_PLAYER_IN_CAR player1 taxicab2
			AND in_taxi2 = 0
				SET_CAR_ONLY_DAMAGED_BY_PLAYER taxicab2 FALSE
				in_taxi2 = 1
			ENDIF
		ENDIF

	   	IF IS_CAR_DEAD taxicab3
		AND dead_taxicab3 = 0 
			REMOVE_BLIP blip3_taxicab3
			dead_taxicab3 = 1
			++ counter_taxiwar
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ENDIF
		
		IF NOT IS_CAR_DEAD taxicab3
			IF NOT IS_CAR_HEALTH_GREATER taxicab3 999
				IF NOT IS_CHAR_DEAD taximan3
					IF IS_CHAR_IN_CAR taximan3 taxicab3
						IF cab3_obj_set = 0
							SET_CAR_CRUISE_SPEED taxicab3 35.0
							SET_CAR_DRIVING_STYLE taxicab3 2
							SET_CAR_MISSION taxicab3 MISSION_RAMPLAYER_FARAWAY
							SET_CAR_ONLY_DAMAGED_BY_PLAYER taxicab3 FALSE
							cab3_obj_set = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD taxicab3
			IF IS_PLAYER_IN_CAR player1 taxicab3
			AND in_taxi3 = 0
				SET_CAR_ONLY_DAMAGED_BY_PLAYER taxicab3 FALSE
				in_taxi3 = 1
			ENDIF
		ENDIF

		 
ENDWHILE

}

GOTO mission_taxiwar2_passed 

 // Mission taxi2 failed

mission_taxiwar2_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission taxi2 passed

mission_taxiwar2_passed:

flag_taxiwar_mission2_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 2000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 2000
REGISTER_MISSION_PASSED	TAXI_2
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT taxiwar_mission3_loop 
RETURN
		


// mission cleanup

mission_cleanup_taxiwar2:
flag_player_on_mission = 0
GET_GAME_TIMER timer_mobile_start
REMOVE_BLIP blip1_taxicab1
REMOVE_BLIP blip2_taxicab2
REMOVE_BLIP blip3_taxicab3
MARK_MODEL_AS_NO_LONGER_NEEDED taxi
MARK_MODEL_AS_NO_LONGER_NEEDED WMOCA
MARK_MODEL_AS_NO_LONGER_NEEDED uzi
MARK_MODEL_AS_NO_LONGER_NEEDED kaufman
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
MISSION_HAS_FINISHED
RETURN


