MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ************************************ Rock Mission Three / Publicity Tour ****************
// ******************************************* Speed *************************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME rockb3

// Mission start stuff

GOSUB mission_start_rock3

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_rock3_failed
ENDIF

GOSUB mission_cleanup_rock3

MISSION_END
 
// Variables for mission

// Car stuff

VAR_INT limo_rock3

VAR_FLOAT limo_speed_rock3

VAR_INT limo_blip_rock3

// General stuff

VAR_INT speed_bar_rock3

VAR_FLOAT speed_bar_float_rock3

VAR_INT venue_blip_rock3

// Audio loading stuff

VAR_INT audio_slot_rock3

VAR_INT flag_audio_finished_rock3

VAR_INT flag_car_dead_rock3

VAR_INT flag_blip_added_rock3

// Band stuff

VAR_INT jezz_rock3

VAR_INT flag_jezz_dead_rock3

VAR_INT dick_rock3

VAR_INT flag_dick_dead_rock3

VAR_INT percy_rock3

VAR_INT flag_percy_dead_rock3

VAR_INT timer_drive_rock3

VAR_INT band_in_car_rock3

// Help message stuff

VAR_INT flag_help2_displayed_rock3

// Second set of Audio on the stage

VAR_INT audio_bank2_finished_rock3

// Death in subscript stuff

VAR_INT jezz_died_in_subscript_rock3

VAR_INT dick_died_in_subscript_rock3

VAR_INT percy_died_in_subscript_rock3

VAR_INT car_died_in_subscript_rock3

VAR_INT flag_conversation1_rock3 // Used to trigger each conversation message

// New car stuff for the limo, proper bomb diffused stuff

VAR_INT flag_car_blip_added_rock3
flag_car_blip_added_rock3 = 0

// ****************************************Mission Start************************************

mission_start_rock3:

flag_player_on_mission = 1

REGISTER_MISSION_GIVEN

speed_bar_rock3 = 0

speed_bar_float_rock3 = 100.0

limo_speed_rock3 = 0.0

// Audio stuff

audio_slot_rock3 = 1

flag_audio_finished_rock3 = 0

flag_car_dead_rock3 = 0

flag_blip_added_rock3 = 0

flag_jezz_dead_rock3 = 0

flag_dick_dead_rock3 = 0

flag_percy_dead_rock3 = 0

timer_drive_rock3 = 0

band_in_car_rock3 = 0

// Help message stuff

flag_help2_displayed_rock3 = 0

// Second set of Audio on the stage

audio_bank2_finished_rock3 = 0

// Death in subscript stuff

jezz_died_in_subscript_rock3 = 0

dick_died_in_subscript_rock3 = 0

percy_died_in_subscript_rock3 = 0

car_died_in_subscript_rock3 = 0

flag_conversation1_rock3 = 0 // Used to trigger each conversation message

WAIT 0

LOAD_MISSION_TEXT ROCK3

SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -860.688 1169.914 9.997 185.460

{

// ****************************************START OF CUTSCENE********************************

LOAD_SPECIAL_CHARACTER 1 CSdick
LOAD_SPECIAL_CHARACTER 2 CSjezz
LOAD_SPECIAL_CHARACTER 3 CSkent
LOAD_SPECIAL_CHARACTER 4 CSpercy
LOAD_SPECIAL_CHARACTER 5 CSplay

SET_AREA_VISIBLE VIS_STUDIO

LOAD_SCENE -879.75 1157.77 17.81

SET_EXTRA_COLOURS 17 FALSE

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_SPECIAL_CHARACTER_LOADED 5

	WAIT 0

ENDWHILE

LOAD_CUTSCENE rok_3a

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

CLEAR_AREA -871.90 1159.46 10.07 1.0 TRUE
SET_PLAYER_COORDINATES player1 -871.90 1159.46 10.07
SET_PLAYER_HEADING player1 270.0

DO_FADE 2000 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE


// Displays cutscene text

GET_CUTSCENE_TIME cs_time
WHILE cs_time < 374 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM3_A ) 10000 1 //"Tommy, Tommy, man, that psycho is back!"

WHILE cs_time < 4104 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM3_B ) 10000 1 //"What's going on?"

WHILE cs_time < 4760 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM3_C ) 10000 1 //"That psycho won't leave Love Fist alone!"

WHILE cs_time < 6489
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM3_D ) 10000 1 //"You didnae kill him. And now he's back."

WHILE cs_time < 8719 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM3_E ) 10000 1 //"Yeah, yeah, yeah, and the thing is..."

WHILE cs_time < 9730
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM3_F ) 10000 1 //"The thing is, we need someone to drive the limo so we can relax,"

WHILE cs_time < 12434 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM3_G ) 10000 1 //"cause that nutter keeps making threats!"

WHILE cs_time < 13952 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM3_H ) 10000 1 //"I'm shitin' masel' man. I need ma ma!"

WHILE cs_time < 15620 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM3_I ) 10000 1 //"We're all bricking ourselves man."

WHILE cs_time < 16985 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM3_J ) 10000 1 //"Okay guys, calm down, I'll handle this."

WHILE cs_time < 21240 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM3_K ) 10000 1 //"Normally I wouldn't busy myself with driving around a bunch of drunken Scottish bisexuals,"

WHILE cs_time < 26029 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM3_L ) 10000 1 //"but, in your case I'll make an exception."

WHILE cs_time < 28823 //27623
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

FORCE_WEATHER_NOW WEATHER_RAINY 

SET_RADIO_CHANNEL EMOTION -1

// Waiting for the ped models to load

REQUEST_MODEL LOVEFIST

LOAD_SPECIAL_CHARACTER 6 IGJEZZ

LOAD_SPECIAL_CHARACTER 7 IGDICK

LOAD_SPECIAL_CHARACTER 8 IGPERCY

WHILE NOT HAS_MODEL_LOADED LOVEFIST
OR NOT HAS_SPECIAL_CHARACTER_LOADED 6
OR NOT HAS_SPECIAL_CHARACTER_LOADED 7
OR NOT HAS_SPECIAL_CHARACTER_LOADED 8

	WAIT 0

ENDWHILE

SWITCH_WIDESCREEN ON
SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON
SET_POLICE_IGNORE_PLAYER player1 ON	

CLEAR_AREA -870.157 1145.945 11.050 1.0 FALSE 
SET_FIXED_CAMERA_POSITION -870.157 1145.945 11.050 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -870.468 1146.895 11.078 JUMP_CUT

CLEAR_AREA -872.155 1151.921 11.054 4.0 FALSE 
CREATE_CAR LOVEFIST -872.155 1151.921 11.054 limo_rock3

SET_CAR_HEADING limo_rock3 177.458
SET_CAR_STRONG limo_rock3 TRUE
SET_CAR_HEALTH limo_rock3 1500

CREATE_CHAR_AS_PASSENGER limo_rock3 PEDTYPE_CIVMALE SPECIAL06 0 jezz_rock3

CLEAR_CHAR_THREAT_SEARCH jezz_rock3

SET_CHAR_CANT_BE_DRAGGED_OUT jezz_rock3 TRUE

SET_CHAR_STAY_IN_CAR_WHEN_JACKED jezz_rock3 TRUE 

CREATE_CHAR_AS_PASSENGER limo_rock3 PEDTYPE_CIVMALE SPECIAL07 1 dick_rock3

CLEAR_CHAR_THREAT_SEARCH dick_rock3

SET_CHAR_CANT_BE_DRAGGED_OUT dick_rock3 TRUE

SET_CHAR_STAY_IN_CAR_WHEN_JACKED dick_rock3 TRUE

CREATE_CHAR_AS_PASSENGER limo_rock3 PEDTYPE_CIVMALE SPECIAL08 2 percy_rock3

CLEAR_CHAR_THREAT_SEARCH percy_rock3

SET_CHAR_CANT_BE_DRAGGED_OUT percy_rock3 TRUE

SET_CHAR_STAY_IN_CAR_WHEN_JACKED percy_rock3 TRUE

WARP_CHAR_INTO_CAR scplayer limo_rock3

CAR_SET_IDLE limo_rock3

LOCK_CAR_DOORS limo_rock3 CARLOCK_LOCKED_PLAYER_INSIDE

// fades the screen in

SET_FADING_COLOUR 0 0 0

WAIT 2500


DO_FADE 2000 FADE_IN

WHILE GET_FADING_STATUS

	WAIT 0

	IF flag_jezz_dead_rock3 = 0

		IF IS_CHAR_DEAD jezz_rock3
		OR jezz_died_in_subscript_rock3 = 1
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_jezz_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
		OR dick_died_in_subscript_rock3 = 1
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
		OR percy_died_in_subscript_rock3 = 1
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF

	IF IS_CAR_DEAD limo_rock3
	OR car_died_in_subscript_rock3 = 1
		CLEAR_MISSION_AUDIO 1
		CLEAR_MISSION_AUDIO 2
		CLEAR_PRINTS
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed
	ENDIF
	
ENDWHILE

timerb = 0

WHILE flag_audio_finished_rock3 = 0

	WAIT 0

	IF flag_audio_finished_rock3 = 0
				
		IF flag_played_rock3_before = 1

			IF flag_conversation1_rock3 < 6 

			 	IF IS_BUTTON_PRESSED PAD1 CROSS
			 	OR IS_BUTTON_PRESSED PAD1 START
					flag_conversation1_rock3 = 6
				ENDIF

			ENDIF

		ENDIF
		
		GOSUB conversation1_rock3

	ENDIF
		
	IF timer_drive_rock3 = 1

		IF flag_help2_displayed_rock3 = 0
			timerb = 0
			flag_help2_displayed_rock3 = 1
		ENDIF

		IF flag_help2_displayed_rock3 = 1

			IF timerb >= 5000
				PRINT_HELP ( RBM3_9 ) //"if you are stopped or drive slowly the bar will inscrease."
				flag_help2_displayed_rock3 = 2
			ENDIF

		ENDIF

		IF flag_help2_displayed_rock3 = 2
			timerb = 0
			flag_help2_displayed_rock3 = 3
		ENDIF

		IF flag_help2_displayed_rock3 = 3

			IF timerb >= 5000
				PRINT_HELP ( RBM3_8 ) ////"The faster you go the lower the detonation bar wil go!"
				flag_help2_displayed_rock3 = 4
			ENDIF

		ENDIF

		IF flag_help2_displayed_rock3 = 4
			timerb = 0
			flag_help2_displayed_rock3 = 5
		ENDIF

		IF flag_help2_displayed_rock3 = 5

			IF timerb >= 5000
				PRINT_HELP ( RBM3_3 ) //"If the detonation bar completely fills the car will explode"
				flag_help2_displayed_rock3 = 6
			ENDIF

		ENDIF

	ENDIF

	IF flag_jezz_dead_rock3 = 0

		IF IS_CHAR_DEAD jezz_rock3
		OR jezz_died_in_subscript_rock3 = 1
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_jezz_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
		OR dick_died_in_subscript_rock3 = 1
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
		OR percy_died_in_subscript_rock3 = 1
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF

	IF IS_CAR_DEAD limo_rock3
	OR car_died_in_subscript_rock3 = 1
	OR flag_car_dead_rock3 = 1
	OR flag_jezz_dead_rock3 = 1
	OR flag_dick_dead_rock3 = 1
	OR flag_percy_dead_rock3 = 1
	   	CLEAR_MISSION_AUDIO 1
		CLEAR_MISSION_AUDIO 2
		CLEAR_PRINTS
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed
	ELSE

		IF flag_audio_finished_rock3 = 0
						
			IF NOT IS_PLAYER_IN_CAR player1 limo_rock3
				EXPLODE_CAR limo_rock3
				PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
				GOTO mission_rock3_failed
			ENDIF

		ENDIF

		GET_CAR_SPEED limo_rock3 limo_speed_rock3
				
		IF flag_audio_finished_rock3 = 0

			IF timerb > 5000

				IF flag_conversation1_rock3 = 0
					flag_conversation1_rock3 = 1
				ENDIF
			   			   
			ENDIF
			   	

		ENDIF
		 		 			
	ENDIF

	IF flag_audio_finished_rock3 = 0

		IF timer_drive_rock3 = 1

			IF timera > 5000

				limo_speed_rock3 -= 26.0//20
				limo_speed_rock3 /= 15.0
				speed_bar_float_rock3 += limo_speed_rock3

				IF speed_bar_float_rock3 > 100.0
					speed_bar_float_rock3 = 100.0
				ENDIF
				
				IF speed_bar_float_rock3 < 1.0
			 	
					IF NOT IS_CAR_DEAD limo_rock3 
						EXPLODE_CAR limo_rock3
						//flag_car_dead_rock3 = 1
						PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
						GOTO mission_rock3_failed
					ELSE
						//flag_car_dead_rock3 = 1
						PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
						GOTO mission_rock3_failed
					ENDIF
					
				ENDIF

				temp_float = speed_bar_float_rock3 * -1.0
				temp_float = temp_float + 100.0
				speed_bar_rock3 =# temp_float

			ENDIF

		ENDIF

	ENDIF
	   		
ENDWHILE

RELEASE_WEATHER

CLEAR_ONSCREEN_COUNTER speed_bar_rock3

PRINT_BIG ( RBM3_7 ) 4000 4  //"Bomb Diffused!"

WHILE flag_conversation1_rock3 < 29

	WAIT 0

	IF flag_conversation1_rock3 < 29
		GOSUB conversation1_part2_rock3
	ENDIF

	IF flag_jezz_dead_rock3 = 0

		IF IS_CHAR_DEAD jezz_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_jezz_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF	

	IF IS_CAR_DEAD limo_rock3
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed
	ELSE

		IF flag_jezz_dead_rock3 = 0
		AND flag_dick_dead_rock3 = 0 
		AND flag_percy_dead_rock3 = 0
				
			IF IS_CHAR_IN_CAR jezz_rock3 limo_rock3 
			AND IS_CHAR_IN_CAR dick_rock3 limo_rock3 
			AND IS_CHAR_IN_CAR percy_rock3 limo_rock3
				band_in_car_rock3 = 1
			ELSE
				band_in_car_rock3 = 0
			ENDIF

		ENDIF

		IF NOT IS_PLAYER_IN_CAR player1 limo_rock3

			IF flag_car_blip_added_rock3 = 0
				ADD_BLIP_FOR_CAR limo_rock3 limo_blip_rock3
				PRINT_NOW ( IN_VEH ) 5000 1 //"Get bck into the car!"
				flag_car_blip_added_rock3 = 1
			ENDIF
			
		ELSE
		
			IF flag_car_blip_added_rock3 = 1
				REMOVE_BLIP limo_blip_rock3
				flag_car_blip_added_rock3 = 0
			ENDIF  
			
		ENDIF

	ENDIF
	
ENDWHILE

IF NOT IS_CAR_DEAD limo_rock3
	LOCK_CAR_DOORS limo_rock3 CARLOCK_UNLOCKED
ELSE
	PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
	GOTO mission_rock3_failed
ENDIF

SET_RADIO_CHANNEL V_ROCK -1 
PRINT_NOW ( RBM3_1 ) 5000 1 //"Get the band to the venue!"
ADD_BLIP_FOR_COORD -870.933 1053.342 9.90 venue_blip_rock3
flag_blip_added_rock3 = 1

WHILE NOT LOCATE_CAR_3D limo_rock3 -870.933 1053.342 9.90 3.0 3.0 3.0 TRUE
OR band_in_car_rock3 = 0
	
	WAIT 0

	IF flag_jezz_dead_rock3 = 0

		IF IS_CHAR_DEAD jezz_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_jezz_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF	

	IF IS_CAR_DEAD limo_rock3
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed
	ELSE

		IF flag_jezz_dead_rock3 = 0
		AND flag_dick_dead_rock3 = 0 
		AND flag_percy_dead_rock3 = 0
				
			IF IS_CHAR_IN_CAR jezz_rock3 limo_rock3 
			AND IS_CHAR_IN_CAR dick_rock3 limo_rock3 
			AND IS_CHAR_IN_CAR percy_rock3 limo_rock3
				band_in_car_rock3 = 1
			ELSE
				band_in_car_rock3 = 0
			ENDIF

		ENDIF

		IF NOT IS_PLAYER_IN_CAR player1 limo_rock3

			IF flag_blip_added_rock3 = 1
				REMOVE_BLIP venue_blip_rock3
				ADD_BLIP_FOR_CAR limo_rock3 limo_blip_rock3
				PRINT_NOW ( IN_VEH ) 5000 1 //"Get bck into the car!"
				flag_blip_added_rock3 = 0
			ENDIF
			
		ELSE
		
			IF flag_blip_added_rock3 = 0
				REMOVE_BLIP limo_blip_rock3
				PRINT_NOW ( RBM3_1 ) 5000 1 //"Get the band to the venue!"
				ADD_BLIP_FOR_COORD -870.933 1053.342 9.90 venue_blip_rock3  
				flag_blip_added_rock3 = 1
			ENDIF

		ENDIF

	ENDIF
	
ENDWHILE

IF NOT IS_CAR_DEAD limo_rock3
	LOCK_CAR_DOORS limo_rock3 CARLOCK_UNLOCKED
ELSE
	PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
	GOTO mission_rock3_failed
ENDIF

SWITCH_WIDESCREEN ON
SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON
SET_POLICE_IGNORE_PLAYER player1 ON

CLEAR_AREA -880.363 1043.654 12.096 1.0 FALSE
SET_FIXED_CAMERA_POSITION -880.363 1043.654 12.096 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -879.557 1044.242 12.035 JUMP_CUT

IF NOT IS_CAR_DEAD limo_rock3

	SET_CHAR_OBJ_LEAVE_CAR scplayer limo_rock3

	IF NOT IS_CHAR_DEAD jezz_rock3
		SET_CHAR_OBJ_LEAVE_CAR jezz_rock3 limo_rock3
	ELSE
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed
	ENDIF

	IF NOT IS_CHAR_DEAD dick_rock3
		SET_CHAR_OBJ_LEAVE_CAR dick_rock3 limo_rock3
	ELSE
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed
	ENDIF

	IF NOT IS_CHAR_DEAD percy_rock3
		SET_CHAR_OBJ_LEAVE_CAR percy_rock3 limo_rock3
	ELSE
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed
	ENDIF

ELSE
	PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
	GOTO mission_rock3_failed
ENDIF

WHILE IS_CHAR_IN_ANY_CAR scplayer
AND IS_CHAR_IN_ANY_CAR jezz_rock3
AND IS_CHAR_IN_ANY_CAR dick_rock3
AND IS_CHAR_IN_ANY_CAR percy_rock3

	WAIT 0

	IF flag_jezz_dead_rock3 = 0

		IF IS_CHAR_DEAD jezz_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_jezz_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF	

	IF IS_CAR_DEAD limo_rock3
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed
	ENDIF
		
ENDWHILE

DO_FADE 1500 FADE_OUT

WHILE GET_FADING_STATUS

	WAIT 0

	IF flag_jezz_dead_rock3 = 0

		IF IS_CHAR_DEAD jezz_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_jezz_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF	

	IF IS_CAR_DEAD limo_rock3
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed
	ENDIF
	
ENDWHILE

RESTORE_CAMERA_JUMPCUT
SET_AREA_VISIBLE VIS_CONCERT_HALL
LOAD_SCENE -928.915 1056.264 12.28
SET_EXTRA_COLOURS 12 FALSE // TRY THIS AARON WILL HAVE A LOOK AND DECIDE IF ITS OK 
SET_PLAYER_COORDINATES player1 -924.115 1054.524 12.28
SET_PLAYER_HEADING player1 188.883

DELETE_CHAR jezz_rock3

IF NOT IS_CHAR_DEAD dick_rock3
	SET_CHAR_COORDINATES dick_rock3 -925.288 1053.268 12.20
	SET_CHAR_HEADING dick_rock3 249.491
ELSE
	PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
	GOTO mission_rock3_failed 
	flag_jezz_dead_rock3 = 1
ENDIF

IF NOT IS_CHAR_DEAD percy_rock3
	SET_CHAR_COORDINATES percy_rock3 -923.094 1053.125 12.20
	SET_CHAR_HEADING percy_rock3 44.398
ELSE
	PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
	GOTO mission_rock3_failed 
	flag_jezz_dead_rock3 = 1
ENDIF

LOAD_CUTSCENE FIST

//CLEAR_AREA -920.961 1052.965 13.823 1.0 FALSE
//SET_FIXED_CAMERA_POSITION -920.961 1052.965 13.823 0.0 0.0 0.0
//POINT_CAMERA_AT_POINT -921.248 1053.785 14.319 JUMP_CUT

CLEAR_AREA -924.114 1038.890 12.675 1.0 FALSE
SET_FIXED_CAMERA_POSITION -924.114 1038.890 12.675 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -924.114 1039.858 12.925 JUMP_CUT  

DELETE_CAR limo_rock3

DO_FADE 1000 FADE_IN

WHILE GET_FADING_STATUS

	WAIT 0
      	
	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF

ENDWHILE

// Band are on stage and game has faded in

START_CUTSCENE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 16980 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF
		
ENDWHILE

SET_FIXED_CAMERA_POSITION -926.720 1048.895 13.040 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -926.320 1049.811 13.075 JUMP_CUT

IF flag_percy_dead_rock3 = 0

	IF IS_CHAR_DEAD percy_rock3
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed 
		flag_percy_dead_rock3 = 1
	ELSE
		SET_CHAR_WAIT_STATE percy_rock3 WAITSTATE_PLAYANIM_CHAT 1000000
	ENDIF
		
ENDIF 

PRINT_NOW ( ROK3_73 ) 10000 1//rhubarb rhubarb

WHILE cs_time < 18851 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF

ENDWHILE

PRINT_NOW ( ROK3_62 ) 10000 1//rhubarb rhubarb

WHILE cs_time < 22311 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
ENDWHILE

PRINT_NOW ( ROK3_63 ) 10000 1//rhubarb rhubarb

WHILE cs_time < 24834 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF

ENDWHILE

IF flag_percy_dead_rock3 = 0

	IF IS_CHAR_DEAD percy_rock3
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed 
		flag_percy_dead_rock3 = 1
	ELSE
		SET_CHAR_WAIT_STATE percy_rock3 WAITSTATE_FALSE 1
	ENDIF
		
ENDIF 

PRINT_NOW ( ROK3_64 ) 10000 1//rhubarb rhubarb
SET_FIXED_CAMERA_POSITION -919.641 1050.383 14.670 0.0 0.0 0.0 // Looks at skull
POINT_CAMERA_AT_POINT -919.783 1051.364 14.799 JUMP_CUT

WHILE cs_time < 28433 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF

ENDWHILE

IF flag_dick_dead_rock3 = 0

	IF IS_CHAR_DEAD dick_rock3
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed 
		flag_dick_dead_rock3 = 1
	ELSE
		SET_CHAR_WAIT_STATE dick_rock3 WAITSTATE_PLAYANIM_CHAT 1000000 
	ENDIF
		
ENDIF

PRINT_NOW ( ROK3_65 ) 10000 1//rhubarb rhubarb

WHILE cs_time < 32395
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF

ENDWHILE

IF flag_dick_dead_rock3 = 0

	IF IS_CHAR_DEAD dick_rock3
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed 
		flag_dick_dead_rock3 = 1
	ELSE
		SET_CHAR_WAIT_STATE dick_rock3 WAITSTATE_FALSE 1 
	ENDIF
		
ENDIF

PRINT_NOW ( ROK3_66 ) 10000 1//rhubarb rhubarb

WHILE cs_time < 36052 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF

ENDWHILE

PRINT_NOW ( ROK3_67 ) 10000 1//rhubarb rhubarb

WHILE cs_time < 37237 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
ENDWHILE

IF flag_percy_dead_rock3 = 0

	IF IS_CHAR_DEAD percy_rock3
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed 
		flag_percy_dead_rock3 = 1
	ELSE
		SET_CHAR_WAIT_STATE percy_rock3 WAITSTATE_PLAYANIM_CHAT 1000000
	ENDIF
		
ENDIF

PRINT_NOW ( ROK3_68 ) 10000 1//rhubarb rhubarb

SET_FIXED_CAMERA_POSITION -926.720 1048.895 13.040 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -926.320 1049.811 13.075 JUMP_CUT

WHILE cs_time < 40045 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF

ENDWHILE

PRINT_NOW ( ROK3_69 ) 10000 1//rhubarb rhubarb

WHILE cs_time < 42415 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF

ENDWHILE

IF flag_percy_dead_rock3 = 0

	IF IS_CHAR_DEAD percy_rock3
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed 
		flag_percy_dead_rock3 = 1
	ELSE
		SET_CHAR_WAIT_STATE percy_rock3 WAITSTATE_FALSE 1
	ENDIF
		
ENDIF

IF flag_dick_dead_rock3 = 0

	IF IS_CHAR_DEAD dick_rock3
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed 
		flag_dick_dead_rock3 = 1
	ELSE
		SET_CHAR_WAIT_STATE percy_rock3 WAITSTATE_PLAYANIM_CHAT 1000000
	ENDIF
		
ENDIF

PRINT_NOW ( ROK3_70 ) 10000 1//rhubarb rhubarb

WHILE cs_time < 44776 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF

ENDWHILE

IF flag_dick_dead_rock3 = 0

	IF IS_CHAR_DEAD dick_rock3
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed 
		flag_dick_dead_rock3 = 1
	ELSE
		SET_CHAR_WAIT_STATE percy_rock3 WAITSTATE_FALSE 1
	ENDIF
		
ENDIF

IF flag_percy_dead_rock3 = 0

	IF IS_CHAR_DEAD percy_rock3
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed 
		flag_percy_dead_rock3 = 1
	ELSE
		SET_CHAR_WAIT_STATE percy_rock3 WAITSTATE_PLAYANIM_CHAT 1000000
	ENDIF
		
ENDIF

PRINT_NOW ( ROK3_71 ) 10000 1//rhubarb rhubarb

WHILE cs_time < 49873 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF

ENDWHILE

IF flag_percy_dead_rock3 = 0

	IF IS_CHAR_DEAD percy_rock3
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		GOTO mission_rock3_failed 
		flag_percy_dead_rock3 = 1
	ELSE
		SET_CHAR_WAIT_STATE percy_rock3 WAITSTATE_FALSE 1
	ENDIF
		
ENDIF

CLEAR_PRINTS

DO_FADE 1500 FADE_OUT

WHILE cs_time < 51280 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF

ENDWHILE

CLEAR_CUTSCENE

timera = 0

WHILE GET_FADING_STATUS

	WAIT 0
  		
	IF flag_dick_dead_rock3 = 0

		IF IS_CHAR_DEAD dick_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_dick_dead_rock3 = 1
		ENDIF
		
	ENDIF
	
	IF flag_percy_dead_rock3 = 0

		IF IS_CHAR_DEAD percy_rock3
			PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			GOTO mission_rock3_failed 
			flag_percy_dead_rock3 = 1
		ENDIF
		
	ENDIF

ENDWHILE

DELETE_CHAR dick_rock3
DELETE_CHAR percy_rock3

CLEAR_EXTRA_COLOURS FALSE
SET_AREA_VISIBLE VIS_MAIN_MAP
LOAD_SCENE -885.396 1054.467 12.583 

SET_FIXED_CAMERA_POSITION -887.965 1054.653 14.846 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -887.016 1054.583 14.538 JUMP_CUT
SET_PLAYER_COORDINATES player1 -885.396 1054.467 12.583 
SET_PLAYER_HEADING player1 280.871 
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_IN_FRONT_OF_PLAYER

DO_FADE 1500 FADE_IN 

WHILE GET_FADING_STATUS

	WAIT 0
	
ENDWHILE

SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 OFF
SET_POLICE_IGNORE_PLAYER player1 OFF
 

GOTO mission_rock3_passed


// ****************************************** Mission Failed *******************************

mission_rock3_failed:

CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
//CLEAR_PRINTS

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN


// *************************************** Mission Passed **********************************

mission_rock3_passed:

flag_rock_mission3_passed = 1
REGISTER_MISSION_PASSED ( ROCK_3 )
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
CLEAR_WANTED_LEVEL player1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 8000 5000 1 //"Mission Passed!"
ADD_SCORE player1 8000
SWITCH_CAR_GENERATOR gen_car161 101
REMOVE_BLIP rock_contact_blip
RETURN

// **************************************** MISSION CLEANUP ********************************

mission_cleanup_rock3:

flag_player_on_mission = 0

SET_RADIO_CHANNEL V_ROCK -1

IF NOT IS_CAR_DEAD limo_rock3
	LOCK_CAR_DOORS limo_rock3 CARLOCK_UNLOCKED
	MARK_CAR_AS_NO_LONGER_NEEDED limo_rock3
ENDIF

REMOVE_CHAR_ELEGANTLY jezz_rock3
REMOVE_CHAR_ELEGANTLY dick_rock3
REMOVE_CHAR_ELEGANTLY percy_rock3
RELEASE_WEATHER
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
CLEAR_EXTRA_COLOURS FALSE
SET_AREA_VISIBLE VIS_MAIN_MAP
REMOVE_BLIP limo_blip_rock3
REMOVE_BLIP venue_blip_rock3
CLEAR_ONSCREEN_COUNTER speed_bar_rock3
MARK_MODEL_AS_NO_LONGER_NEEDED LOVEFIST
UNLOAD_SPECIAL_CHARACTER 6
UNLOAD_SPECIAL_CHARACTER 7
UNLOAD_SPECIAL_CHARACTER 8
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN

// Conversation 1 in the car
 
conversation1_rock3:

IF timer_drive_rock3 = 1
				
	IF flag_help2_displayed_rock3 = 0
		timerb = 0
		flag_help2_displayed_rock3 = 1
	ENDIF

	IF flag_help2_displayed_rock3 = 1

		IF timerb >= 5000
			PRINT_HELP ( RBM3_9 ) //"if you are stopped or drive slowly the bar will inscrease."
			flag_help2_displayed_rock3 = 2
		ENDIF

	ENDIF

	IF flag_help2_displayed_rock3 = 2
		timerb = 0
		flag_help2_displayed_rock3 = 3
	ENDIF

	IF flag_help2_displayed_rock3 = 3

		IF timerb >= 5000
			PRINT_HELP ( RBM3_8 ) ////"The faster you go the lower the detonation bar wil go!"
			flag_help2_displayed_rock3 = 4
		ENDIF

	ENDIF

	IF flag_help2_displayed_rock3 = 4
		timerb = 0
		flag_help2_displayed_rock3 = 5
	ENDIF

	IF flag_help2_displayed_rock3 = 5

		IF timerb >= 5000
			PRINT_HELP ( RBM3_3 ) //"If the detonation bar completely fills the car will explode"
			flag_help2_displayed_rock3 = 6
		ENDIF

	ENDIF

ENDIF
	   
IF flag_jezz_dead_rock3 = 0

	IF IS_CHAR_DEAD jezz_rock3
		jezz_died_in_subscript_rock3 = 1
	ENDIF
			
ENDIF
		
IF flag_dick_dead_rock3 = 0

	IF IS_CHAR_DEAD dick_rock3
		dick_died_in_subscript_rock3 = 1
	ENDIF
			
ENDIF
		
IF flag_percy_dead_rock3 = 0

	IF IS_CHAR_DEAD percy_rock3
		percy_died_in_subscript_rock3 = 1
	ENDIF
			
ENDIF
				
IF IS_CAR_DEAD limo_rock3
	car_died_in_subscript_rock3 = 1
ELSE

	GET_CAR_SPEED limo_rock3 limo_speed_rock3

	IF NOT IS_PLAYER_SITTING_IN_CAR player1 limo_rock3
		EXPLODE_CAR limo_rock3
		PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		//flag_car_dead_rock3 = 1		
	ENDIF

	IF flag_audio_finished_rock3 = 0

		IF timer_drive_rock3 = 1

			IF timera > 5000

			   	limo_speed_rock3 -= 26.0//24.0
			   	limo_speed_rock3 /= 15.0
			   	speed_bar_float_rock3 += limo_speed_rock3

				IF speed_bar_float_rock3 < 1.0
						
			   		IF NOT IS_CAR_DEAD limo_rock3 
			   			EXPLODE_CAR limo_rock3
						PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			   			//flag_car_dead_rock3 = 1
			   		ELSE
			   		   //	flag_car_dead_rock3 = 1
			   		ENDIF
				
				ENDIF
						
				IF speed_bar_float_rock3 > 100.0
			   		speed_bar_float_rock3 = 100.0
			   	ENDIF
			   
				temp_float = speed_bar_float_rock3 * -1.0
			   	temp_float = temp_float + 100.0
				speed_bar_rock3 =# temp_float
						
			ENDIF

		ENDIF

	ENDIF
			
ENDIF

IF flag_conversation1_rock3 = 1
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_1 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_1 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_1 )
	flag_conversation1_rock3 = 2

	IF flag_audio_finished_rock3 = 0
				
		IF flag_played_rock3_before = 1

			IF flag_conversation1_rock3 < 6 

			 	IF IS_BUTTON_PRESSED PAD1 CROSS
			 	OR IS_BUTTON_PRESSED PAD1 START
					flag_conversation1_rock3 = 6
				ENDIF

			ENDIF

		ENDIF
		
	ENDIF
		
ENDIF

IF flag_conversation1_rock3 = 2
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_2 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_2 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_2 )
	flag_conversation1_rock3 = 3

	IF flag_audio_finished_rock3 = 0
				
		IF flag_played_rock3_before = 1

			IF flag_conversation1_rock3 < 6 

			 	IF IS_BUTTON_PRESSED PAD1 CROSS
			 	OR IS_BUTTON_PRESSED PAD1 START
					flag_conversation1_rock3 = 6
				ENDIF

			ENDIF

		ENDIF
		
	ENDIF
		
ENDIF

IF flag_conversation1_rock3 = 3
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_3 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_3 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_3 )
	flag_conversation1_rock3 = 4

	IF flag_audio_finished_rock3 = 0
				
		IF flag_played_rock3_before = 1

			IF flag_conversation1_rock3 < 6 

			 	IF IS_BUTTON_PRESSED PAD1 CROSS
			 	OR IS_BUTTON_PRESSED PAD1 START
					flag_conversation1_rock3 = 6
				ENDIF

			ENDIF

		ENDIF
		
	ENDIF

ENDIF

IF flag_conversation1_rock3 = 4
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_4 )
	GOSUB loading_and_playing_audio_rock3
	SET_RADIO_CHANNEL 9 -1
	PRINT_NOW ( ROK3_4 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_4 )
	flag_conversation1_rock3 = 5

	IF flag_audio_finished_rock3 = 0
				
		IF flag_played_rock3_before = 1

			IF flag_conversation1_rock3 < 6 

			 	IF IS_BUTTON_PRESSED PAD1 CROSS
			 	OR IS_BUTTON_PRESSED PAD1 START
					flag_conversation1_rock3 = 6
				ENDIF

			ENDIF

		ENDIF
		
	ENDIF
		
ENDIF

IF flag_conversation1_rock3 = 5
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_5 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_5 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_5 )
	flag_conversation1_rock3 = 6
ENDIF

IF flag_conversation1_rock3 = 6
	
	IF timer_drive_rock3 = 0
		SWITCH_WIDESCREEN OFF
		SET_CAMERA_BEHIND_PLAYER
		RESTORE_CAMERA_JUMPCUT
		SET_PLAYER_CONTROL player1 ON
		SET_EVERYONE_IGNORE_PLAYER player1 OFF
		SET_POLICE_IGNORE_PLAYER player1 OFF
		PRINT_HELP ( RBM3_2 ) //"Keep up your speed				
		DISPLAY_ONSCREEN_COUNTER_WITH_STRING speed_bar_rock3 COUNTER_DISPLAY_BAR ( RBM3_6 )
		timera = 0
		timer_drive_rock3 = 1
	ENDIF
	flag_played_rock3_before = 1
	flag_conversation1_rock3 = 7

ENDIF

IF flag_conversation1_rock3 = 7
   	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_6 )
	GOSUB loading_and_playing_audio_rock3
   	PRINT_NOW ( ROK3_6 ) 10000 1//rhubarb rhubarb
   	GOSUB has_audio_finished_rock3
   	CLEAR_THIS_PRINT ( ROK3_6 )
	flag_conversation1_rock3 = 8
ENDIF

IF flag_conversation1_rock3 = 8
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_7 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_7 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_7 )
	flag_conversation1_rock3 = 9
ENDIF

IF flag_conversation1_rock3 = 9
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_8 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_8 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_8 )
	flag_conversation1_rock3 = 10
ENDIF

IF flag_conversation1_rock3 = 10
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_9 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_9 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_9 )
	flag_conversation1_rock3 = 11
ENDIF

IF flag_conversation1_rock3 = 11
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_10 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_10 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_10 )
	flag_conversation1_rock3 = 12
ENDIF

IF flag_conversation1_rock3 = 12
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_11 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_11 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_11 )
	flag_conversation1_rock3 = 13
ENDIF

IF flag_conversation1_rock3 = 13
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_12 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_12 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_12 )
	flag_conversation1_rock3 = 14
ENDIF

IF flag_conversation1_rock3 = 14
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_13 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_13 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_13 )
	flag_conversation1_rock3 = 15
ENDIF

IF flag_conversation1_rock3 = 15
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_14 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_14 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_14 )
	flag_conversation1_rock3 = 16
ENDIF

IF flag_conversation1_rock3 = 16
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_15 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_15 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_15 )
	flag_conversation1_rock3 = 17
ENDIF

IF flag_conversation1_rock3 = 17
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_16 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_16 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_16 )
	flag_conversation1_rock3 = 18
ENDIF

IF flag_conversation1_rock3 = 18
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_17 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_17 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_17 )
	flag_conversation1_rock3 = 19
ENDIF

IF flag_conversation1_rock3 = 19
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_18 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_18 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_18 )
	flag_conversation1_rock3 = 20
ENDIF

IF flag_conversation1_rock3 = 20
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_19 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_19 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_19 )
	flag_conversation1_rock3 = 21
ENDIF

IF flag_conversation1_rock3 = 21
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_20 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_20 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_20 )
	flag_conversation1_rock3 = 22
ENDIF

IF flag_conversation1_rock3 = 22
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_21 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_21 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_21 )
	flag_conversation1_rock3 = 23
ENDIF

IF flag_conversation1_rock3 = 23
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_22 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_22 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_22 )
	flag_conversation1_rock3 = 24
ENDIF

IF flag_conversation1_rock3 = 24
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_23 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_23 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_23 )
	flag_conversation1_rock3 = 25
ENDIF

IF flag_conversation1_rock3 = 25
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_24 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_24 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_24 )
	flag_conversation1_rock3 = 26
	flag_audio_finished_rock3 = 1
ENDIF

RETURN

// part2 of the conversation

conversation1_part2_rock3:

IF flag_conversation1_rock3 = 26
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_25 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_25 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_25 )
	flag_conversation1_rock3 = 27
ENDIF

IF flag_conversation1_rock3 = 27
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_26 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_26 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_26 )
	flag_conversation1_rock3 = 28
ENDIF

IF flag_conversation1_rock3 = 28
	LOAD_MISSION_AUDIO audio_slot_rock3 ( ROK3_27 )
	GOSUB loading_and_playing_audio_rock3
	PRINT_NOW ( ROK3_27 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_rock3
	CLEAR_THIS_PRINT ( ROK3_27 )
	flag_conversation1_rock3 = 29
ENDIF
 
RETURN
	
// loads and plays the audio

loading_and_playing_audio_rock3:

WHILE NOT HAS_MISSION_AUDIO_LOADED audio_slot_rock3

	WAIT 0
			
	IF flag_audio_finished_rock3 = 0  

		IF timer_drive_rock3 = 1

			IF flag_help2_displayed_rock3 = 0
				timerb = 0
				flag_help2_displayed_rock3 = 1
			ENDIF

			IF flag_help2_displayed_rock3 = 1

				IF timerb >= 5000
					PRINT_HELP ( RBM3_9 ) //"if you are stopped or drive slowly the bar will inscrease."
					flag_help2_displayed_rock3 = 2
				ENDIF

			ENDIF

			IF flag_help2_displayed_rock3 = 2
				timerb = 0
				flag_help2_displayed_rock3 = 3
			ENDIF

			IF flag_help2_displayed_rock3 = 3

				IF timerb >= 5000
					PRINT_HELP ( RBM3_8 ) ////"The faster you go the lower the detonation bar wil go!"
					flag_help2_displayed_rock3 = 4
				ENDIF

			ENDIF

			IF flag_help2_displayed_rock3 = 4
				timerb = 0
				flag_help2_displayed_rock3 = 5
			ENDIF

			IF flag_help2_displayed_rock3 = 5

				IF timerb >= 5000
					PRINT_HELP ( RBM3_3 ) //"If the detonation bar completely fills the car will explode"
					flag_help2_displayed_rock3 = 6
				ENDIF

			ENDIF

		ENDIF

	ENDIF

		IF flag_jezz_dead_rock3 = 0

			IF IS_CHAR_DEAD jezz_rock3
				jezz_died_in_subscript_rock3 = 1
			ENDIF
			
		ENDIF
		
		IF flag_dick_dead_rock3 = 0

			IF IS_CHAR_DEAD dick_rock3
				dick_died_in_subscript_rock3 = 1
			ENDIF
			
		ENDIF
		
		IF flag_percy_dead_rock3 = 0

			IF IS_CHAR_DEAD percy_rock3
				percy_died_in_subscript_rock3 = 1
			ENDIF
			
		ENDIF
				
		IF IS_CAR_DEAD limo_rock3
			car_died_in_subscript_rock3 = 1
		ELSE

			GET_CAR_SPEED limo_rock3 limo_speed_rock3

			IF NOT IS_PLAYER_SITTING_IN_CAR player1 limo_rock3
		  		EXPLODE_CAR limo_rock3
				PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		   		//flag_car_dead_rock3 = 1		
		   	ENDIF

		   	IF flag_audio_finished_rock3 = 0

			  	IF timer_drive_rock3 = 1

			   		IF timera > 5000
						

			   			limo_speed_rock3 -= 26.0//24.0
			   			limo_speed_rock3 /= 15.0
			   			speed_bar_float_rock3 += limo_speed_rock3

						IF speed_bar_float_rock3 < 1.0
						
			   				IF NOT IS_CAR_DEAD limo_rock3 
			   					EXPLODE_CAR limo_rock3
								PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
			   				   //	flag_car_dead_rock3 = 1
			   				ELSE
			   				   //	flag_car_dead_rock3 = 1
			   				ENDIF
				
						ENDIF
						
						IF speed_bar_float_rock3 > 100.0
			   				speed_bar_float_rock3 = 100.0
			   			ENDIF
			   
						temp_float = speed_bar_float_rock3 * -1.0
			   			temp_float = temp_float + 100.0
						speed_bar_rock3 =# temp_float
						
				   	ENDIF

			   	ENDIF

		  	ENDIF
			
		ENDIF

	
	IF flag_audio_finished_rock3 = 1

		IF audio_bank2_finished_rock3 = 0
		   		   			
			IF flag_dick_dead_rock3 = 0

				IF IS_CHAR_DEAD dick_rock3
					dick_died_in_subscript_rock3 = 1
				ENDIF
				
			ENDIF
			
			IF flag_percy_dead_rock3 = 0

				IF IS_CHAR_DEAD percy_rock3
					percy_died_in_subscript_rock3 = 1
				ENDIF
				
			ENDIF

		ENDIF

	ENDIF
								
ENDWHILE

PLAY_MISSION_AUDIO audio_slot_rock3

RETURN

// checking to see if the audio is finished

has_audio_finished_rock3:

WHILE NOT HAS_MISSION_AUDIO_FINISHED audio_slot_rock3

	WAIT 0

	IF flag_audio_finished_rock3 = 0

		IF timer_drive_rock3 = 1

			IF flag_help2_displayed_rock3 = 0
				timerb = 0
				flag_help2_displayed_rock3 = 1
			ENDIF

			IF flag_help2_displayed_rock3 = 1

				IF timerb >= 5000
					PRINT_HELP ( RBM3_9 ) //"if you are stopped or drive slowly the bar will inscrease."
					flag_help2_displayed_rock3 = 2
				ENDIF

			ENDIF

			IF flag_help2_displayed_rock3 = 2
				timerb = 0
				flag_help2_displayed_rock3 = 3
			ENDIF

			IF flag_help2_displayed_rock3 = 3

				IF timerb >= 5000
					PRINT_HELP ( RBM3_8 ) ////"The faster you go the lower the detonation bar wil go!"
					flag_help2_displayed_rock3 = 4
				ENDIF

			ENDIF

			IF flag_help2_displayed_rock3 = 4
				timerb = 0
				flag_help2_displayed_rock3 = 5
			ENDIF

			IF flag_help2_displayed_rock3 = 5

				IF timerb >= 5000
					PRINT_HELP ( RBM3_3 ) //"If the detonation bar completely fills the car will explode"
					flag_help2_displayed_rock3 = 6
				ENDIF

			ENDIF

		ENDIF

	ENDIF

		IF flag_jezz_dead_rock3 = 0

			IF IS_CHAR_DEAD jezz_rock3
				jezz_died_in_subscript_rock3 = 1
			ENDIF
			
		ENDIF
		
		IF flag_dick_dead_rock3 = 0

			IF IS_CHAR_DEAD dick_rock3
				dick_died_in_subscript_rock3 = 1
			ENDIF
			
		ENDIF
		
		IF flag_percy_dead_rock3 = 0

			IF IS_CHAR_DEAD percy_rock3
				percy_died_in_subscript_rock3 = 1
			ENDIF
			
		ENDIF

		IF IS_CAR_DEAD limo_rock3
			car_died_in_subscript_rock3 = 1
		ELSE

			GET_CAR_SPEED limo_rock3 limo_speed_rock3

		   	IF NOT IS_PLAYER_SITTING_IN_CAR player1 limo_rock3
		   		EXPLODE_CAR limo_rock3
				PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
		  		flag_car_dead_rock3 = 1		
		  	ENDIF

		   	IF flag_audio_finished_rock3 = 0

			   	IF timer_drive_rock3 = 1

				   	IF timera > 5000

					 	limo_speed_rock3 -= 26.0//20.0
					  	limo_speed_rock3 /= 15.0
					  	speed_bar_float_rock3 += limo_speed_rock3

					   	IF speed_bar_float_rock3 < 1.0
					  
						 	IF NOT IS_CAR_DEAD limo_rock3 
						  		EXPLODE_CAR limo_rock3
								PRINT_NOW ( RBM3_4 ) 5000 1 //"You killed the Band!"
						 		//flag_car_dead_rock3 = 1
					   		ELSE
							   //	flag_car_dead_rock3 = 1
					  		ENDIF

					 	ENDIF
						
					 	IF speed_bar_float_rock3 > 100.0
					 		speed_bar_float_rock3 = 100.0
					 	ENDIF

						temp_float = speed_bar_float_rock3 * -1.0
					 	temp_float = temp_float + 100.0
						speed_bar_rock3 =# temp_float

				   	ENDIF

			   	ENDIF

			ENDIF
			
		ENDIF
			
	IF flag_audio_finished_rock3 = 1

		IF audio_bank2_finished_rock3 = 0
		  		  			
			IF flag_dick_dead_rock3 = 0

				IF IS_CHAR_DEAD dick_rock3
					dick_died_in_subscript_rock3 = 1
				ENDIF
				
			ENDIF
			
			IF flag_percy_dead_rock3 = 0

				IF IS_CHAR_DEAD percy_rock3
					percy_died_in_subscript_rock3 = 1
				ENDIF
				
			ENDIF

		ENDIF

	ENDIF
						
ENDWHILE

RETURN


}