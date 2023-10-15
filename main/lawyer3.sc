MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Lawyer mission 3**************************************
// ****************************************JURY FURY******************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_lawyer3

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_lawyer3_failed
ENDIF

GOSUB mission_cleanup_lawyer3

MISSION_END


// Variables for mission
{
VAR_INT jury_bloke1 jury_bloke2	talk_guy talk_guy_punched_juror_flee jury_car_is_dead smash_up_car_help_played
VAR_INT all_been_given_a_cunting beaten_to_a_bloody_mess1 beaten_to_a_bloody_mess2 any_vehicle_law3
VAR_INT jury_bloke1_blip jury_bloke2_blip jury_car random_samples jury_car_smash player_shooting_in_area
VAR_INT wacked_by_weapon1 wacked_by_weapon2 hardware_blip jury_car2	scream_sound_for_juror1
VAR_FLOAT law_World_X law_World_Y law_World_Z 
VAR_FLOAT talk_guyX talk_guyY talk_guyZ hammer_blokeX hammer_blokeY hammer_blokeZ
LVAR_INT hit_n_run_car hammer_bloke	played_smash_print hammer_blokes_hammer	hammer_blokes_hammer_created
LVAR_INT jury_bloke1_first_hit jury_bloke1_second_hit jury_bloke1_third_hit set_chars_chatting
LVAR_INT jury_bloke1_run_to_car talk_guy_ran_away spand_driver hammer1 hammer2 unfreeze_car	hit_n_run_bloke


// ***************************************Mission Start*************************************

mission_start_lawyer3:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
SCRIPT_NAME LAWYER3

WAIT 0

LOAD_MISSION_TEXT LAWYER3
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION 110.6 -824.2 9.6 327.9

jury_bloke1_run_to_car = 0
set_chars_chatting = 0
talk_guy_ran_away = 0
jury_car_is_dead = 0
random_samples = 0
talk_guy_punched_juror_flee = 0
scream_sound_for_juror1 = 0
played_smash_print = 0
hammer_blokes_hammer_created = 0
unfreeze_car = 0
player_shooting_in_area = 0
smash_up_car_help_played = 0

CLEAR_HELP

LOAD_MISSION_AUDIO 1 MONO15

SET_AREA_VISIBLE  VIS_LAWYERS 

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSken
LOAD_SPECIAL_MODEL CUTOBJ01 lwchara
LOAD_SPECIAL_MODEL CUTOBJ02 lwcharb
LOAD_SPECIAL_MODEL CUTOBJ03 lcfan
LOAD_SPECIAL_MODEL CUTOBJ04 lawdoor

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
OR NOT HAS_MODEL_LOADED CUTOBJ03
OR NOT HAS_MODEL_LOADED CUTOBJ04
	WAIT 0

ENDWHILE

LOAD_SCENE 140.6 -1367.4 13.1

LOAD_CUTSCENE law_3
SET_CUTSCENE_OFFSET 141.441 -1366.722 12.163
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken CSken

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_lwchara
SET_CUTSCENE_ANIM cs_lwchara lwchara

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_lwcharb
SET_CUTSCENE_ANIM cs_lwcharb lwcharb

CREATE_CUTSCENE_OBJECT CUTOBJ03 cs_lcfan
SET_CUTSCENE_ANIM_TO_LOOP lcfan
SET_CUTSCENE_ANIM cs_lcfan lcfan

CREATE_CUTSCENE_OBJECT CUTOBJ04 cs_lawdoor
SET_CUTSCENE_ANIM cs_lawdoor lawdoor


CLEAR_AREA 119.0 -826.8 9.8 0.5 TRUE
SET_PLAYER_COORDINATES player1 119.0 -826.8 9.8
SET_PLAYER_HEADING player1 60.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 3008

	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW3_A ) 10000 1 // Mission brief

WHILE cs_time < 9424
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW3_B ) 10000 1 // Mission brief

WHILE cs_time < 13402
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW3_C ) 10000 1 // Mission brief

WHILE cs_time < 15408
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW3_D ) 10000 1 // Mission brief

WHILE cs_time < 18308
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW3_E ) 10000 1 // Mission brief

WHILE cs_time < 22306
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW3_F ) 10000 1 // Mission brief

WHILE cs_time < 24656
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW3_G ) 10000 1 // Mission brief

WHILE cs_time < 26240
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW3_H ) 10000 1 // Mission brief

WHILE cs_time < 30832
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW3_I ) 10000 1 // Mission brief

WHILE cs_time < 33842
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW3_J ) 10000 1 // Mission brief

WHILE cs_time < 38624
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW3_K ) 10000 1 // Mission brief

WHILE cs_time < 40752
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW3_L ) 10000 1 // Mission brief

WHILE cs_time < 43488
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW3_M ) 10000 1 // Mission brief

WHILE cs_time < 49133
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW3_N ) 10000 1 // Mission brief

WHILE cs_time < 51776 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 52896 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

CLEAR_PRINTS

WAIT 1000

IF NOT WAS_CUTSCENE_SKIPPED
	IF HAS_MISSION_AUDIO_LOADED	1
		PLAY_MISSION_AUDIO 1
	ENDIF
ENDIF

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ03
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ04

REQUEST_MODEL HMORI	//Suiy guy
REQUEST_MODEL BMYBU
REQUEST_MODEL Admiral 
REQUEST_MODEL BFYBE	//sun bathe ped
REQUEST_MODEL spand
REQUEST_MODEL glendale
REQUEST_MODEL HMYAP	//Dock worker
REQUEST_MODEL hammer
REQUEST_MODEL sentinel
REQUEST_MODEL WMOGO
LOAD_SPECIAL_CHARACTER 4 spandxa

beaten_to_a_bloody_mess1 = 0
beaten_to_a_bloody_mess2 = 0
jury_bloke1_first_hit = 0
jury_bloke1_second_hit = 0
jury_bloke1_third_hit = 0
wacked_by_weapon1 = 0
wacked_by_weapon2 = 0
all_been_given_a_cunting = 0

WHILE NOT HAS_MODEL_LOADED HMORI
OR NOT HAS_MODEL_LOADED Admiral  
OR NOT HAS_MODEL_LOADED BFYBE
OR NOT HAS_MODEL_LOADED spand
OR NOT HAS_MODEL_LOADED glendale
OR NOT HAS_MODEL_LOADED BMYBU
	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED HMYAP
OR NOT HAS_MODEL_LOADED sentinel
OR NOT HAS_MODEL_LOADED WMOGO
	WAIT 0

ENDWHILE

// START OF MISSION

SET_AREA_VISIBLE VIS_MAIN_MAP
LOAD_SCENE 117.1 -825.6 9.8

LOAD_MISSION_AUDIO 1 LAW3_24

WAIT 0

SWITCH_WIDESCREEN ON
SET_PLAYER_CONTROL player1 OFF
SET_CAMERA_IN_FRONT_OF_PLAYER

DO_FADE 1000 FADE_IN

SET_FIXED_CAMERA_POSITION 110.714 -816.945 14.589 0.0 0.0 0.0 //crossing road bloke
POINT_CAMERA_AT_POINT 111.238 -817.658 14.123 JUMP_CUT

CLEAR_AREA 95.8 -843.2 10.0 20.0 TRUE

CREATE_CAR glendale 95.8 -843.2 10.0 hit_n_run_car
CREATE_CHAR_INSIDE_CAR hit_n_run_car PEDTYPE_CIVMALE WMOGO hit_n_run_bloke

SET_CAR_HEADING hit_n_run_car 316.0

CLEAR_AREA 113.7 -825.0 9.7 10.0 TRUE
CREATE_CHAR PEDTYPE_CIVMALE HMYAP 113.7 -825.0 9.7 hammer_bloke //Death only awaits me
SET_CHAR_HEADING hammer_bloke 67.0

CLEAR_CHAR_THREAT_SEARCH hammer_bloke
//SET_CHAR_PERSONALITY hammer_bloke PEDSTAT_COWARD
SET_CHAR_WAIT_STATE hammer_bloke WAITSTATE_CROSS_ROAD_LOOK 3000
//GIVE_WEAPON_TO_CHAR hammer_bloke WEAPONTYPE_HAMMER 0

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


WAIT 1000

IF NOT IS_CHAR_DEAD	hammer_bloke
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT hammer_bloke 104.0 -819.8
ENDIF

IF NOT IS_CAR_DEAD hit_n_run_car
	SET_CAR_CRUISE_SPEED hit_n_run_car 40.0
	SET_CAR_DRIVING_STYLE hit_n_run_car DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED hit_n_run_car 20.0
	GET_CHAR_COORDINATES hammer_bloke talk_guyX talk_guyY talk_guyZ
	CAR_GOTO_COORDINATES_ACCURATE hit_n_run_car talk_guyX talk_guyY talk_guyZ
ENDIF

TIMERA = 0

WHILE NOT TIMERA > 3000
	WAIT 0

	IF IS_CHAR_DEAD	hammer_bloke
		IF hammer_blokes_hammer_created = 0
			GET_DEAD_CHAR_PICKUP_COORDS	hammer_bloke hammer_blokeX hammer_blokeY hammer_blokeZ
			hammer_blokeZ = hammer_blokeZ + 0.5
			CREATE_PICKUP hammer PICKUP_ONCE hammer_blokeX hammer_blokeY hammer_blokeZ hammer_blokes_hammer
			hammer_blokes_hammer_created = 1
		ENDIF
	ENDIF

ENDWHILE

IF NOT IS_CHAR_DEAD hit_n_run_bloke
	IF NOT IS_CAR_DEAD hit_n_run_car
		SET_CHAR_OBJ_LEAVE_CAR hit_n_run_bloke hit_n_run_car
		SET_CHAR_PERSONALITY hit_n_run_bloke PEDSTAT_COWARD
	ENDIF
ENDIF

SET_FIXED_CAMERA_POSITION 110.834 -827.258 12.204 0.0 0.0 0.0 //Look at hammer
POINT_CAMERA_AT_POINT 111.632 -826.843 11.761 JUMP_CUT
PRINT_NOW ( LAW3_24 ) 3000 2 //Hammer looks useful 

TIMERA = 0

WHILE NOT TIMERA > 3000
	WAIT 0

	IF NOT IS_CHAR_DEAD hit_n_run_bloke
		IF NOT IS_CAR_DEAD hit_n_run_car 
			IF NOT IS_CHAR_IN_CAR hit_n_run_bloke hit_n_run_car
				SET_CHAR_OBJ_RUN_TO_COORD hit_n_run_bloke 137.6 -786.9
			ENDIF
		ENDIF
	ENDIF

ENDWHILE

IF HAS_MISSION_AUDIO_LOADED	1
	PLAY_MISSION_AUDIO 1
ENDIF

ADD_SPRITE_BLIP_FOR_COORD hard1X hard1Y hard1Z RADAR_SPRITE_HARDWARE hardware_blip

SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_IN_FRONT_OF_PLAYER

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 4
	WAIT 0

ENDWHILE

MARK_MODEL_AS_NO_LONGER_NEEDED glendale
MARK_MODEL_AS_NO_LONGER_NEEDED WMOGO
MARK_MODEL_AS_NO_LONGER_NEEDED HMYAP
MARK_CHAR_AS_NO_LONGER_NEEDED hit_n_run_bloke

CLEAR_AREA 191.4 -1026.7 9.4 2.0 TRUE	
CREATE_CHAR PEDTYPE_CIVMALE HMORI 191.4 -1026.7 9.4 jury_bloke1 
SET_CHAR_PERSONALITY jury_bloke1 PEDSTAT_COWARD
SET_CHAR_ONLY_DAMAGED_BY_PLAYER jury_bloke1 TRUE
ADD_BLIP_FOR_CHAR jury_bloke1 jury_bloke1_blip 
SET_CHAR_HEALTH jury_bloke1 300
SET_CHAR_HEADING jury_bloke1 202.0
CLEAR_CHAR_THREAT_SEARCH jury_bloke1
SET_CHAR_RUNNING jury_bloke1 TRUE

CLEAR_AREA 189.3 -1033.0 10.2 4.0 TRUE
CREATE_CAR Admiral 189.3 -1033.0 9.4 jury_car
SET_CAR_HEADING jury_car 261.0 
LOCK_CAR_DOORS jury_car	CARLOCK_LOCKOUT_PLAYER_ONLY
SET_CAR_HEAVY jury_car TRUE
SET_CAN_BURST_CAR_TYRES	jury_car FALSE

CREATE_CHAR PEDTYPE_CIVMALE BFYBE 191.6 -1028.0 9.4 talk_guy //chatting bloke
SET_CHAR_PERSONALITY talk_guy PEDSTAT_COWARD
CLEAR_CHAR_THREAT_SEARCH talk_guy

CLEAR_AREA 536.4 217.4 13.6 4.0 TRUE					
CREATE_CAR sentinel 536.4 217.4 13.6 jury_car2
SET_CAR_HEADING jury_car2 270.0
LOCK_CAR_DOORS jury_car2 CARLOCK_LOCKOUT_PLAYER_ONLY 
ADD_BLIP_FOR_CAR jury_car2 jury_bloke2_blip
SET_CAR_CRUISE_SPEED jury_car2 0.0
SET_CAR_HEAVY jury_car2 TRUE

PRINT_NOW ( LAW3_7 ) 15000 2  //BEAT UP THE JURY

WAIT 4000

IF NOT IS_CAR_DEAD jury_car
	FREEZE_CAR_POSITION jury_car TRUE
ENDIF
IF NOT IS_CAR_DEAD jury_car2
	FREEZE_CAR_POSITION jury_car2 TRUE
ENDIF
IF NOT IS_CHAR_DEAD jury_bloke1
	FREEZE_CHAR_POSITION jury_bloke1 TRUE
ENDIF
IF NOT IS_CHAR_DEAD talk_guy
	FREEZE_CHAR_POSITION talk_guy TRUE
ENDIF

PRINT_HELP ( HELP23	) //Go to hardware blip
FLASH_HUD_OBJECT HUD_FLASH_RADAR

WAIT 2000

FLASH_HUD_OBJECT -1

TIMERB = 0

GENERATE_RANDOM_INT_IN_RANGE 0 6 random_samples 
 
GOSUB load_random_samples

TIMERA = 0


WHILE NOT all_been_given_a_cunting = 2
	WAIT 0

	IF beaten_to_a_bloody_mess1 = 0
		IF IS_CHAR_DEAD	jury_bloke1	//Car bloke********************************************************************
			PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
			GOTO mission_lawyer3_failed
		ELSE
			IF IS_CHAR_LEAVING_VEHICLE_TO_DIE jury_bloke1
				PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
				GOTO mission_lawyer3_failed
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CAR_DEAD jury_car

		IF unfreeze_car = 0	   
			IF LOCATE_PLAYER_ANY_MEANS_CAR_2D Player1 jury_car 30.0 30.0 FALSE
				IF NOT IS_CAR_DEAD jury_car
					FREEZE_CAR_POSITION jury_car FALSE
					IF NOT IS_CHAR_DEAD	jury_bloke1
						FREEZE_CHAR_POSITION jury_bloke1 FALSE
					ENDIF
					IF NOT IS_CHAR_DEAD	talk_guy
						FREEZE_CHAR_POSITION talk_guy FALSE
					ENDIF
				ENDIF
				unfreeze_car = 1
			ENDIF
		ENDIF
		
		IF NOT IS_CHAR_DEAD jury_bloke1
			IF NOT IS_CAR_DEAD jury_car	
				IF IS_CHAR_IN_CAR jury_bloke1 jury_car
					
					IF NOT IS_CAR_HEALTH_GREATER jury_car 700
						SET_CHAR_OBJ_LEAVE_CAR jury_bloke1 jury_car
						LOCK_CAR_DOORS jury_car	CARLOCK_UNLOCKED	
						jury_bloke1_run_to_car = 1
						jury_car_is_dead = 1		
					ENDIF

					IF jury_bloke1_run_to_car = 0 
					AND beaten_to_a_bloody_mess1 = 0
						
						IF IS_PLAYER_IN_ANY_CAR	player1
							STORE_CAR_PLAYER_IS_IN Player1 any_vehicle_law3
						
							IF NOT IS_CAR_DEAD any_vehicle_law3
								IF LOCATE_PLAYER_IN_CAR_3D player1 197.1 -1033.8 10.2 8.0 6.0 4.0 FALSE
									SET_CAR_COORDINATES any_vehicle_law3 201.9 -1020.8 9.4
									SET_CAR_HEADING any_vehicle_law3 180.0
								ENDIF
							ENDIF
						ENDIF

						IF NOT IS_CAR_DEAD jury_car
							SET_CAR_HEAVY jury_car FALSE
						ENDIF

						LOCK_CAR_DOORS jury_car	CARLOCK_LOCKED_BUT_CAN_BE_DAMAGED
						SET_PLAYER_CONTROL player1 OFF
						SWITCH_WIDESCREEN ON
						SET_CAR_CRUISE_SPEED jury_car 0.0
						SET_FIXED_CAMERA_POSITION 183.803 -1029.408 11.956 0.0 0.0 0.0 //CAR CRASH
						POINT_CAMERA_AT_POINT 184.615 -1029.963 11.780 JUMP_CUT
						
						CLEAR_AREA 189.3 -1033.0 10.2 10.0 TRUE
						CLEAR_AREA 208.8 -1008.1 9.5 10.0 TRUE
						CREATE_CAR spand 208.8 -1008.1 9.5 jury_car_smash
						CREATE_CHAR_INSIDE_CAR jury_car_smash PEDTYPE_CIVMALE SPECIAL04 spand_driver
						SET_CHAR_PERSONALITY spand_driver PEDSTAT_GEEK_GUY
						SET_CAR_HEADING jury_car_smash 165.0 
						SET_CAR_CRUISE_SPEED jury_car_smash 40.0
						SET_CAR_FORWARD_SPEED jury_car_smash 19.0
						SET_CAR_DRIVING_STYLE jury_car_smash DRIVINGMODE_PLOUGHTHROUGH
						CAR_GOTO_COORDINATES jury_car_smash 203.5 -1037.7 10.1
						SET_CAR_HEAVY jury_car_smash TRUE
						CLEAR_AREA 202.8 -1035.7 10.1 10.0 TRUE
						CAR_GOTO_COORDINATES jury_car 202.8 -1035.7 10.1
						SET_CAR_CRUISE_SPEED jury_car 50.0
						SET_CAR_DRIVING_STYLE jury_car DRIVINGMODE_PLOUGHTHROUGH
						TIMERB = 0
						
						WHILE NOT TIMERB > 1200
							WAIT 0

							IF IS_CHAR_DEAD	jury_bloke1	//Car bloke********************************************************************
								PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
								GOTO mission_lawyer3_failed
							ELSE
								IF IS_CHAR_LEAVING_VEHICLE_TO_DIE jury_bloke1
									PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
									GOTO mission_lawyer3_failed
								ENDIF
							ENDIF

						ENDWHILE

						IF NOT IS_CAR_DEAD jury_car
							SET_CAN_BURST_CAR_TYRES	jury_car TRUE
							BURST_CAR_TYRE jury_car FRONT_LEFT_WHEEL
							POP_CAR_BOOT_USING_PHYSICS jury_car
							IF NOT IS_CAR_DEAD jury_car_smash
								POP_CAR_BOOT_USING_PHYSICS jury_car_smash							
							ENDIF
							CAR_SET_IDLE jury_car
							SET_CAR_CRUISE_SPEED jury_car 0.0
							IF NOT IS_CAR_DEAD jury_car_smash
								SET_CAR_CRUISE_SPEED jury_car_smash 0.0
							ENDIF
						ENDIF

						TIMERB = 0

						WHILE NOT TIMERB > 250
							WAIT 0

							IF IS_CHAR_DEAD	jury_bloke1	//Car bloke********************************************************************
								PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
								GOTO mission_lawyer3_failed
							ELSE
								IF IS_CHAR_LEAVING_VEHICLE_TO_DIE jury_bloke1
									PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
									GOTO mission_lawyer3_failed
								ENDIF
							ENDIF

						ENDWHILE

						IF NOT IS_CAR_DEAD jury_car_smash
							GET_OFFSET_FROM_CAR_IN_WORLD_COORDS jury_car_smash 0.0 -3.0 0.0 law_World_X law_World_Y law_World_Z
							CREATE_PICKUP hammer PICKUP_ONCE law_World_X law_World_Y law_World_Z hammer1
						ENDIF

						WHILE NOT TIMERB > 500
							WAIT 0

							IF IS_CHAR_DEAD	jury_bloke1	//Car bloke********************************************************************
								PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
								GOTO mission_lawyer3_failed
							ELSE
								IF IS_CHAR_LEAVING_VEHICLE_TO_DIE jury_bloke1
									PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
									GOTO mission_lawyer3_failed
								ENDIF
							ENDIF

						ENDWHILE

						IF NOT IS_CAR_DEAD jury_car_smash
							GET_OFFSET_FROM_CAR_IN_WORLD_COORDS jury_car_smash 0.0 -3.0 0.0 law_World_X law_World_Y law_World_Z
							CREATE_PICKUP hammer PICKUP_ONCE law_World_X law_World_Y law_World_Z hammer2
						ENDIF

						TIMERB = 0

						WHILE NOT TIMERB > 1500
							WAIT 0

							IF IS_CHAR_DEAD	jury_bloke1	//Car bloke********************************************************************
								PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
								GOTO mission_lawyer3_failed
							ELSE
								IF IS_CHAR_LEAVING_VEHICLE_TO_DIE jury_bloke1
									PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
									GOTO mission_lawyer3_failed
								ENDIF
							ENDIF

						ENDWHILE

						SWITCH_WIDESCREEN OFF
						SET_FIXED_CAMERA_POSITION 206.657 -1030.398 13.139 0.0 0.0 0.0 //CAR CRASH
						POINT_CAMERA_AT_POINT 206.057 -1031.136 12.829 JUMP_CUT

						IF smash_up_car_help_played = 0
							PRINT_HELP ( HELP40	) //You can smash cars up by using the hammer or a similar weapon
							TIMERA = 0
							smash_up_car_help_played = 1
						ELSE
							PRINT_NOW ( LAW3_9 ) 4000 2 //Smash his car up!
						ENDIF

						TIMERB = 0

						WHILE NOT TIMERB > 4000
							WAIT 0

							IF IS_CHAR_DEAD	jury_bloke1	//Car bloke********************************************************************
								PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
								GOTO mission_lawyer3_failed
							ELSE
								IF IS_CHAR_LEAVING_VEHICLE_TO_DIE jury_bloke1
									PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
									GOTO mission_lawyer3_failed
								ENDIF
							ENDIF


							IF IS_BUTTON_PRESSED PAD1 cross
								WHILE IS_BUTTON_PRESSED	PAD1 cross
									WAIT 0
									IF TIMERB > 4000
										GOTO skip_to_shot_of_ammu
									ENDIF
										
									IF IS_CHAR_DEAD	jury_bloke1	//Car bloke********************************************************************
										PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
										GOTO mission_lawyer3_failed
									ELSE
										IF IS_CHAR_LEAVING_VEHICLE_TO_DIE jury_bloke1
											PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
											GOTO mission_lawyer3_failed
										ENDIF
									ENDIF

								ENDWHILE
								GOTO skip_to_shot_of_ammu
							ENDIF

						ENDWHILE

						skip_to_shot_of_ammu:

						IF NOT IS_CHAR_DEAD jury_bloke1
							SET_CHAR_HEALTH jury_bloke1 300
						ENDIF
						IF NOT IS_CAR_DEAD jury_car_smash
							SET_CAR_HEAVY jury_car_smash FALSE
						ENDIF
						SET_PLAYER_CONTROL player1 ON
						SWITCH_WIDESCREEN OFF
						RESTORE_CAMERA_JUMPCUT
						PRINT_NOW ( LAW3_9 ) 6000 2 //Smash his car up!

						jury_bloke1_run_to_car = 1
					ENDIF		
				ENDIF
			ENDIF
		ENDIF

	ENDIF

	IF IS_CAR_DEAD jury_car
		GOSUB cut_scene_juror1
	ELSE

		IF NOT IS_CAR_DEAD jury_car 

			IF NOT IS_CHAR_DEAD	jury_bloke1
				IF player_shooting_in_area = 0
					IF LOCATE_PLAYER_ANY_MEANS_CAR_2D Player1 jury_car 20.0 20.0 FALSE
						IF IS_PLAYER_SHOOTING Player1
						OR NOT IS_CHAR_HEALTH_GREATER jury_bloke1 299
						OR IS_PLAYER_TARGETTING_CHAR player1 jury_bloke1
							IF NOT IS_CAR_DEAD jury_car
								IF NOT IS_CHAR_DEAD	jury_bloke1
									SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER jury_bloke1 jury_car
									SET_CHAR_ONLY_DAMAGED_BY_PLAYER jury_bloke1 TRUE
									SET_CHAR_HEALTH jury_bloke1 300
								ENDIF
								IF NOT IS_CHAR_DEAD	talk_guy
									//SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS talk_guy player1
									SET_CHAR_OBJ_RUN_TO_COORD talk_guy 227.2 -1040.8
									talk_guy_ran_away = 1
								ENDIF
							ENDIF
							player_shooting_in_area = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF
										  
			IF NOT LOCATE_CAR_3D jury_car 189.3 -1033.0 9.4 2.0 2.0 2.0 FALSE 
				IF NOT IS_CAR_HEALTH_GREATER jury_car 600
					IF NOT IS_CHAR_DEAD	jury_bloke1
						jury_bloke1_run_to_car = 1
						jury_car_is_dead = 1
					ENDIF
				ENDIF
			ENDIF

			IF beaten_to_a_bloody_mess1 = 0

				IF NOT IS_CAR_DEAD jury_car
					IF NOT IS_CHAR_DEAD jury_bloke1
						IF IS_CHAR_IN_CAR jury_bloke1 jury_car
							IF NOT IS_CAR_HEALTH_GREATER jury_car 950
								IF scream_sound_for_juror1 = 0
									LOAD_MISSION_AUDIO 2 LAW3_11
									WHILE NOT HAS_MISSION_AUDIO_LOADED	2
										WAIT 0

										IF IS_CAR_DEAD jury_car
											GOSUB cut_scene_juror1
										ENDIF

										IF IS_CHAR_DEAD	jury_bloke1	//Car bloke********************************************************************
											PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
											GOTO mission_lawyer3_failed
										ELSE
											IF IS_CHAR_LEAVING_VEHICLE_TO_DIE jury_bloke1
												PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
												GOTO mission_lawyer3_failed
											ENDIF
										ENDIF

									ENDWHILE
									PLAY_MISSION_AUDIO 2
									scream_sound_for_juror1 = 1
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF

				IF NOT IS_CAR_DEAD jury_car
					IF NOT IS_CHAR_DEAD jury_bloke1
						IF IS_CHAR_IN_CAR jury_bloke1 jury_car
							IF NOT IS_CAR_HEALTH_GREATER jury_car 850
								IF scream_sound_for_juror1 = 1
									LOAD_MISSION_AUDIO 2 LAW3_13
									WHILE NOT HAS_MISSION_AUDIO_LOADED	2
										WAIT 0

										IF IS_CAR_DEAD jury_car
											GOSUB cut_scene_juror1
										ENDIF

										IF IS_CHAR_DEAD	jury_bloke1	//Car bloke********************************************************************
											PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
											GOTO mission_lawyer3_failed
										ELSE
											IF IS_CHAR_LEAVING_VEHICLE_TO_DIE jury_bloke1
												PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
												GOTO mission_lawyer3_failed
											ENDIF
										ENDIF

									ENDWHILE
									PLAY_MISSION_AUDIO 2
									scream_sound_for_juror1 = 2
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF

				IF NOT IS_CAR_DEAD jury_car
					IF NOT IS_CHAR_DEAD jury_bloke1
						IF IS_CHAR_IN_CAR jury_bloke1 jury_car
							IF NOT IS_CAR_HEALTH_GREATER jury_car 750
								IF scream_sound_for_juror1 = 2
									LOAD_MISSION_AUDIO 2 LAW3_12
									WHILE NOT HAS_MISSION_AUDIO_LOADED	2
										WAIT 0
											
										IF IS_CAR_DEAD jury_car
											GOSUB cut_scene_juror1
										ENDIF

										IF IS_CHAR_DEAD	jury_bloke1	//Car bloke********************************************************************
											PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
											GOTO mission_lawyer3_failed
										ELSE
											IF IS_CHAR_LEAVING_VEHICLE_TO_DIE jury_bloke1
												PRINT_NOW ( LAW3_8 ) 5000 2	//YOU KILLED HIM!
												GOTO mission_lawyer3_failed
											ENDIF
										ENDIF

									ENDWHILE
									PLAY_MISSION_AUDIO 2
									scream_sound_for_juror1 = 3
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF

			ENDIF

		ENDIF

	ENDIF

	IF NOT IS_CHAR_DEAD talk_guy
		IF talk_guy_ran_away = 0
			IF NOT IS_CHAR_HEALTH_GREATER talk_guy 99
			OR jury_bloke1_first_hit = 1
				SET_CHAR_OBJ_RUN_TO_COORD talk_guy 227.2 -1040.8
				IF NOT IS_CHAR_DEAD	jury_bloke1
					SET_CHAR_ONLY_DAMAGED_BY_PLAYER jury_bloke1 TRUE
					SET_CHAR_HEALTH jury_bloke1 300
				ENDIF
				talk_guy_ran_away = 1
			ENDIF 
		ENDIF
	ELSE
		talk_guy_ran_away = 1
	ENDIF


	IF NOT IS_CHAR_DEAD jury_bloke1			

		IF NOT IS_CHAR_DEAD talk_guy 
			IF set_chars_chatting = 0
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player1 jury_bloke1 50.0 50.0 FALSE
				   	TURN_CHAR_TO_FACE_CHAR jury_bloke1 talk_guy
					TURN_CHAR_TO_FACE_CHAR talk_guy jury_bloke1
					SET_CHARS_CHATTING jury_bloke1 talk_guy 999999999
					SET_CHARS_CHATTING talk_guy jury_bloke1 999999999
					set_chars_chatting = 1
				ENDIF
			ENDIF
		ENDIF

		IF talk_guy_ran_away = 1
			IF jury_bloke1_first_hit = 0
				IF talk_guy_punched_juror_flee = 0 
					CLEAR_CHAR_LAST_WEAPON_DAMAGE jury_bloke1
					IF NOT IS_CAR_DEAD jury_car
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER jury_bloke1 jury_car
					ENDIF
					talk_guy_punched_juror_flee = 1
				ENDIF
			ENDIF
		ENDIF
		
		IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON jury_bloke1 WEAPONTYPE_ANYMELEE
		OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON jury_bloke1 WEAPONTYPE_RUNOVERBYCAR
		OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON jury_bloke1 WEAPONTYPE_RAMMEDBYCAR
			IF jury_bloke1_first_hit = 0
				wacked_by_weapon1 ++
				CLEAR_CHAR_LAST_WEAPON_DAMAGE jury_bloke1
				IF jury_car_is_dead = 0
					IF NOT IS_CAR_DEAD jury_car
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER jury_bloke1 jury_car
					ENDIF
				ENDIF
				SET_CHAR_HEALTH jury_bloke1 300
				jury_bloke1_first_hit = 1
			ENDIF
		ENDIF

		IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON jury_bloke1 WEAPONTYPE_ANYMELEE
		OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON jury_bloke1 WEAPONTYPE_RUNOVERBYCAR
		OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON jury_bloke1 WEAPONTYPE_RAMMEDBYCAR
			IF jury_bloke1_second_hit = 0
				wacked_by_weapon1 ++
				CLEAR_CHAR_LAST_WEAPON_DAMAGE jury_bloke1
				IF jury_car_is_dead = 0
					IF NOT IS_CAR_DEAD jury_car
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER jury_bloke1 jury_car
					ENDIF
				ENDIF
				SET_CHAR_HEALTH jury_bloke1 300
				jury_bloke1_second_hit = 1
			ENDIF
		ENDIF

		IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON jury_bloke1 WEAPONTYPE_ANYMELEE
		OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON jury_bloke1 WEAPONTYPE_RUNOVERBYCAR
		OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON jury_bloke1 WEAPONTYPE_RAMMEDBYCAR
			IF jury_bloke1_third_hit = 0
				wacked_by_weapon1 ++
				CLEAR_CHAR_LAST_WEAPON_DAMAGE jury_bloke1
				IF jury_car_is_dead = 0
					IF NOT IS_CAR_DEAD jury_car
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER jury_bloke1 jury_car
					ENDIF
				ENDIF
				SET_CHAR_HEALTH jury_bloke1 300
				jury_bloke1_third_hit = 1
			ENDIF
		ENDIF
		
		IF wacked_by_weapon1 = 3
 			GOSUB cut_scene_juror1 
		ENDIF

		IF jury_bloke1_run_to_car = 1
			IF NOT IS_CHAR_DEAD	jury_bloke1
				IF NOT IS_CAR_DEAD jury_car
					IF NOT IS_CHAR_IN_CAR jury_bloke1 jury_car
			 			GOSUB cut_scene_juror1 
					ENDIF
				ENDIF
			ENDIF
		ENDIF

	ENDIF

	IF smash_up_car_help_played = 1
		IF TIMERA > 5000
			PRINT_HELP HELP53 //Press ~h~L2~w~ or ~h~R2~w~ to cycle through your available weapons.
			smash_up_car_help_played = 2
		ENDIF
	ENDIF


	// Idle car bloke***************************************************
	IF IS_CAR_DEAD jury_car2
		GOTO juror2_cut_scene
	ENDIF

	IF NOT IS_CAR_DEAD jury_car2

		IF played_smash_print = 0	   
			IF LOCATE_PLAYER_ANY_MEANS_CAR_2D Player1 jury_car2 20.0 20.0 FALSE
				PRINT_NOW ( LAW3_20 ) 15000 2 //~g~Smash up the Jurors car!
				IF NOT IS_CAR_DEAD jury_car2
					FREEZE_CAR_POSITION jury_car2 FALSE
				ENDIF
				IF smash_up_car_help_played = 0
					PRINT_HELP ( HELP40	) //You can smash cars up by using the hammer or a similar weapon
					TIMERA = 0
					smash_up_car_help_played = 1
				ENDIF
				played_smash_print = 1
			ENDIF
		ENDIF

		IF NOT IS_CAR_HEALTH_GREATER jury_car2 600
			
			juror2_cut_scene:
			IF beaten_to_a_bloody_mess2  = 0
				DO_FADE 500	FADE_OUT
				//SET_MUSIC_DOES_FADE FALSE
				LOAD_MISSION_AUDIO 2 LAW3_20
				WHILE GET_FADING_STATUS
					WAIT 0
				ENDWHILE

				LOAD_SCENE 551.8 194.5 13.6

				SET_PLAYER_CONTROL player1 OFF
				SWITCH_WIDESCREEN ON

				IF NOT IS_CAR_DEAD jury_car2
					LOCK_CAR_DOORS jury_car2 CARLOCK_UNLOCKED
				ENDIF

				CLEAR_AREA 542.0 207.8 13.8 1.0 TRUE
				IF NOT IS_PLAYER_IN_ANY_CAR	player1
					SET_PLAYER_COORDINATES Player1 542.0 207.8 13.8
				ELSE
					WARP_PLAYER_FROM_CAR_TO_COORD Player1 542.0 207.8 13.8	
				ENDIF

				IF NOT IS_CAR_DEAD jury_car2
					IF LOCATE_CAR_2D jury_car2 551.8 194.5 4.0 4.0 FALSE
						SET_CAR_COORDINATES jury_car2 541.7 196.0 13.8	
					ENDIF
				ENDIF

				SET_PLAYER_HEADING Player1 225.0 
				CLEAR_AREA 551.8 194.5 13.8 1.0 TRUE
				CREATE_CHAR PEDTYPE_CIVMALE BMYBU 551.8 194.5 13.6 jury_bloke2 
				SET_CHAR_HEADING jury_bloke2 35.0
				REMOVE_BLIP jury_bloke2_blip 
				
				SET_FIXED_CAMERA_POSITION 553.126 190.922 15.789 0.0 0.0 0.0 //Jury Bloke
				POINT_CAMERA_AT_POINT 552.636 191.782 15.650 JUMP_CUT
				
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer 551.8 194.5

				WHILE NOT HAS_MISSION_AUDIO_LOADED	2
					WAIT 0

				ENDWHILE

				DO_FADE 500 FADE_IN
				//SET_MUSIC_DOES_FADE TRUE

				PLAY_MISSION_AUDIO 2
				PRINT_NOW ( LAW3_21 ) 3000 2 //I can't believe this is happening!
				WAIT 1500
				IF HAS_MISSION_AUDIO_LOADED	1 
					PLAY_MISSION_AUDIO 1
				ENDIF
				LOAD_MISSION_AUDIO 2 LAW3_23
				IF random_samples = 0
					PRINT_NOW ( LAW3_1 ) 3000 1
				ENDIF
						
				IF random_samples = 1
					PRINT_NOW ( LAW3_2 ) 3000 1
				ENDIF

				IF random_samples = 2
					PRINT_NOW ( LAW3_3 ) 3000 1
				ENDIF

				IF random_samples = 3
					PRINT_NOW ( LAW3_4 ) 3000 1
				ENDIF
					
				IF random_samples = 4
					PRINT_NOW ( LAW3_5 ) 3000 1
				ENDIF

				IF random_samples = 5
					PRINT_NOW ( LAW3_6 ) 3000 1
				ENDIF 

				WAIT 1500

				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					WAIT 0

				ENDWHILE
				IF NOT IS_CHAR_DEAD	jury_bloke2
					SET_CHAR_OBJ_RUN_TO_COORD jury_bloke2 535.7 177.3
				ENDIF
				IF HAS_MISSION_AUDIO_LOADED	2 
					PLAY_MISSION_AUDIO 2
					//PRINT_NOW ( LAW3_21 ) 3000 2 //I can't believe this is happening!
				ENDIF

				SET_FIXED_CAMERA_POSITION 548.683 203.050 13.808 0.0 0.0 0.0 //Jury Bloke
				POINT_CAMERA_AT_POINT 548.314 202.122 13.859 JUMP_CUT

				WAIT 3000
				SET_PLAYER_CONTROL player1 ON
				SWITCH_WIDESCREEN OFF
				RESTORE_CAMERA_JUMPCUT
				SET_CAMERA_BEHIND_PLAYER
				SET_CHAR_OBJ_NO_OBJ scplayer
				DELETE_CHAR jury_bloke2
				MARK_CAR_AS_NO_LONGER_NEEDED jury_car2
				GENERATE_RANDOM_INT_IN_RANGE 0 6 random_samples 
				IF NOT IS_CAR_DEAD jury_car2
					SET_CAR_HEAVY jury_car2 FALSE
				ENDIF
 				GOSUB load_random_samples
				all_been_given_a_cunting ++
				beaten_to_a_bloody_mess2 = 1
			ENDIF
					
		ENDIF
	ENDIF

	
ENDWHILE

GOTO mission_lawyer3_passed


 // Mission lawyer3 failed

mission_lawyer3_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission lawyer3 passed

mission_lawyer3_passed:

flag_lawyer_mission3_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 400 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 400 
REGISTER_MISSION_PASSED	LAW_3
PLAYER_MADE_PROGRESS 1
armour_in_stock = 1
START_NEW_SCRIPT lawyer_mission4_loop
RETURN
		


// mission cleanup

mission_cleanup_lawyer3:

GET_GAME_TIMER timer_mobile_start
flag_player_on_mission = 0
REMOVE_BLIP jury_bloke1_blip
REMOVE_BLIP jury_bloke2_blip
REMOVE_BLIP hardware_blip
MARK_MODEL_AS_NO_LONGER_NEEDED HMORI
MARK_MODEL_AS_NO_LONGER_NEEDED Admiral 
MARK_MODEL_AS_NO_LONGER_NEEDED BFYBE
MARK_MODEL_AS_NO_LONGER_NEEDED spand
MARK_MODEL_AS_NO_LONGER_NEEDED glendale
MARK_MODEL_AS_NO_LONGER_NEEDED BMYBU
MARK_MODEL_AS_NO_LONGER_NEEDED hammer
MARK_MODEL_AS_NO_LONGER_NEEDED HMYAP
MARK_MODEL_AS_NO_LONGER_NEEDED sentinel
MARK_MODEL_AS_NO_LONGER_NEEDED WMOGO
MARK_CAR_AS_NO_LONGER_NEEDED hit_n_run_car
MARK_CAR_AS_NO_LONGER_NEEDED jury_car
MARK_CAR_AS_NO_LONGER_NEEDED jury_car2
REMOVE_PICKUP hammer1
REMOVE_PICKUP hammer2
REMOVE_PICKUP hammer_blokes_hammer
UNLOAD_SPECIAL_CHARACTER 4
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
MISSION_HAS_FINISHED	

IF NOT IS_CAR_DEAD jury_car
	SET_CAR_HEAVY jury_car FALSE
	SET_CAN_BURST_CAR_TYRES	jury_car TRUE
ENDIF
IF NOT IS_CAR_DEAD jury_car2
	SET_CAR_HEAVY jury_car2 FALSE
ENDIF
RETURN

load_random_samples:

IF random_samples = 0
	LOAD_MISSION_AUDIO 1 LAW3_1
ENDIF

IF random_samples = 1
	LOAD_MISSION_AUDIO 1 LAW3_2 
ENDIF

IF random_samples = 2
	LOAD_MISSION_AUDIO 1 LAW3_3 
ENDIF

IF random_samples = 3
	LOAD_MISSION_AUDIO 1 LAW3_4 
ENDIF

IF random_samples = 4
	LOAD_MISSION_AUDIO 1 LAW3_5
ENDIF

IF random_samples = 5
	LOAD_MISSION_AUDIO 1 LAW3_6
ENDIF

RETURN


cut_scene_juror1:

			
	IF beaten_to_a_bloody_mess1 = 0
		IF NOT IS_CHAR_DEAD	jury_bloke1
			DO_FADE 500 FADE_OUT
			//SET_MUSIC_DOES_FADE FALSE
			SHUT_PLAYER_UP player1 TRUE 
			SET_PLAYER_CONTROL player1 OFF
			SWITCH_WIDESCREEN ON
			PLAYER_LOOK_AT_CHAR_ALWAYS Player1 jury_bloke1
			REMOVE_BLIP jury_bloke1_blip 
			
			SET_CHAR_OBJ_NO_OBJ jury_bloke1 

			IF HAS_MISSION_AUDIO_LOADED	1 
				PLAY_MISSION_AUDIO 1
			ENDIF

			LOAD_MISSION_AUDIO 2 LAW3_22

			IF random_samples = 0
				PRINT_NOW ( LAW3_1 ) 3000 1
			ENDIF
					
			IF random_samples = 1
				PRINT_NOW ( LAW3_2 ) 3000 1
			ENDIF

			IF random_samples = 2
				PRINT_NOW ( LAW3_3 ) 3000 1
			ENDIF

			IF random_samples = 3
				PRINT_NOW ( LAW3_4 ) 3000 1
			ENDIF
				
			IF random_samples = 4
				PRINT_NOW ( LAW3_5 ) 3000 1
			ENDIF

			IF random_samples = 5
				PRINT_NOW ( LAW3_6 ) 3000 1
			ENDIF

			WHILE GET_FADING_STATUS
				WAIT 0
			ENDWHILE

			LOAD_SCENE 204.5 -1007.6 9.4

			TIMERB = 0

			SET_FIXED_CAMERA_POSITION 203.625 -1010.455 10.988 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT 203.922 -1009.509 10.862 JUMP_CUT
			STOP_PLAYER_LOOKING Player1
				
			CLEAR_AREA 202.7 -1016.4 9.6 1.0 TRUE
			SET_PLAYER_COORDINATES player1 202.7 -1016.4 9.6
			DELETE_CHAR	jury_bloke1
			CLEAR_AREA 204.5 -1007.6 9.4 5.0 TRUE
			CREATE_CHAR PEDTYPE_CIVMALE HMORI 204.5 -1007.6 9.4 jury_bloke1

			//SET_MUSIC_DOES_FADE TRUE
			DO_FADE 500	FADE_IN
			

			IF NOT IS_CHAR_DEAD	jury_bloke1
				SET_CHAR_THREAT_SEARCH jury_bloke1 THREAT_PLAYER1
				SET_CHAR_RUNNING jury_bloke1 TRUE
				SET_CHAR_OBJ_RUN_TO_COORD jury_bloke1 215.6 -958.6
			ENDIF

			TIMERB = 0
				
			WHILE NOT TIMERB > 5000
				WAIT 0

				IF HAS_MISSION_AUDIO_FINISHED 1
					IF HAS_MISSION_AUDIO_LOADED	2 
						PLAY_MISSION_AUDIO 2
					ENDIF
				ENDIF

			ENDWHILE

			GENERATE_RANDOM_INT_IN_RANGE 0 6 random_samples 
				GOSUB load_random_samples
			SET_PLAYER_HEADING Player1 0.0
			SET_PLAYER_CONTROL player1 ON
			SWITCH_WIDESCREEN OFF
			RESTORE_CAMERA_JUMPCUT
			SHUT_PLAYER_UP player1 FALSE
			all_been_given_a_cunting ++
			DELETE_CHAR	jury_bloke1
			MARK_CAR_AS_NO_LONGER_NEEDED jury_car
			MARK_CAR_AS_NO_LONGER_NEEDED jury_car_smash
		    MARK_CHAR_AS_NO_LONGER_NEEDED spand_driver
			IF NOT IS_CAR_DEAD jury_car
				LOCK_CAR_DOORS jury_car CARLOCK_UNLOCKED
			ENDIF
			beaten_to_a_bloody_mess1 = 1
		ENDIF
	ENDIF 
	

RETURN
}