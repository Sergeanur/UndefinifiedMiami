MISSION_START
// *****************************************************************************************
// *********************************** XXXX mission 1  ************************************* 
// ****************************************  XXXX  *****************************************
// *****************************************************************************************
// ***                                                                                   ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_XXXX

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_XXXX_failed
ENDIF

GOSUB mission_cleanup_XXXX

MISSION_END
 
// Variables for mission

VAR_INT movie_player movie_cop movie_car1 movie_car1_driver	movie_counter movie_timer movie_car2 movie_car2_driver movie_car2_passenger
VAR_INT movie_counter2 movie_shopper1 movie_shopper2 movie_shopper3 movie_shopper4 movie_counter3 movie_club_manager movie_timer2
VAR_INT movie_barman movie_drinker1 movie_drinker2 movie_drinker3 copscar1 copscar2 movie_cop2 progressvalue_int
VAR_INT barrel_1 barrel_2 barrel_3 barrel_4 barrel_5 barrel_6

VAR_FLOAT progressvalue

// ****************************************Mission Start************************************

mission_start_XXXX:

flag_player_on_mission = 1

REGISTER_MISSION_GIVEN
SCRIPT_NAME XXXX

WAIT 0

//LOAD_SCENE 388.7012 -511.8918 8.3556 
//CREATE_PLAYER 0 388.7012 -511.8918 8.3556 player1
//LAUNCH_MISSION moviedemo.sc


REQUEST_MODEL COP
REQUEST_MODEL HFYBE
REQUEST_MODEL SENTINEL
REQUEST_MODEL MALE01
REQUEST_MODEL BANSHEE
REQUEST_MODEL SHOTGUN
REQUEST_MODEL M4
REQUEST_MODEL UZI
REQUEST_MODEL barrel1

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED COP
OR NOT HAS_MODEL_LOADED SENTINEL
OR NOT HAS_MODEL_LOADED HFYBE
OR NOT HAS_MODEL_LOADED SHOTGUN
OR NOT HAS_MODEL_LOADED BANSHEE
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED M4
OR NOT HAS_MODEL_LOADED UZI
OR NOT HAS_MODEL_LOADED barrel1
	WAIT 0
ENDWHILE

//SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 TRUE
SWITCH_WIDESCREEN ON
SET_PLAYER_VISIBLE player1 TRUE
SET_GENERATE_CARS_AROUND_CAMERA TRUE


//LOAD_CAMERA_SPLINE christe//.dat
//
//WAIT 0
//
//MOVE_CAMERA_ALONG_SPLINE jump_cut
//
//loop2:
//
//	WAIT 0
//
//	GET_CAMERA_POSITION_ALONG_SPLINE progressvalue
//	
//	progressvalue_int =# progressvalue
//	
//	PRINT_WITH_NUMBER_NOW number progressvalue_int 5000 1
//
//GOTO loop2


CREATE_CHAR PEDTYPE_CIVMALE	NULL 383.0219 -505.1329 8.3556 movie_player
SET_CHAR_HEADING movie_player 241.0667
SET_CHAR_USE_PEDNODE_SEEK movie_player FALSE

CREATE_CHAR PEDTYPE_CIVMALE	COP 384.4897 -507.7556 8.3556 movie_cop
SET_CHAR_HEADING movie_cop 338.9948

SET_FIXED_CAMERA_POSITION 386.6381 -509.7485 9.0009 0.0 0.0 0.0	//IN JAIL
POINT_CAMERA_AT_POINT 386.0713 -508.9288 9.0839 JUMP_CUT

CREATE_CAR BANSHEE 408.6158 -469.1374 9.1126 movie_car1
SET_CAR_HEADING movie_car1 230.2856
CREATE_CHAR_INSIDE_CAR movie_car1 PEDTYPE_CIVMALE HFYBE movie_car1_driver
CAR_SET_IDLE movie_car1
SET_CAR_CRUISE_SPEED movie_car1 12.0

CREATE_CAR SENTINEL 431.9260 -457.8690 8.9777 movie_car2
SET_CAR_HEADING movie_car2 176.3647
CREATE_CHAR_INSIDE_CAR movie_car2 PEDTYPE_CIVMALE MALE01 movie_car2_driver
CREATE_CHAR_AS_PASSENGER movie_car2 PEDTYPE_CIVMALE MALE01 0 movie_car2_passenger
CLEAR_CHAR_THREAT_SEARCH movie_car2_driver
CLEAR_CHAR_THREAT_SEARCH movie_car2_passenger
SET_CHAR_SUFFERS_CRITICAL_HITS movie_car2_driver FALSE
SET_CHAR_SUFFERS_CRITICAL_HITS movie_car2_passenger FALSE
SET_CHAR_SUFFERS_CRITICAL_HITS movie_player FALSE
SET_CHAR_PROOFS movie_player TRUE FALSE FALSE FALSE FALSE
CAR_SET_IDLE movie_car2
SET_CAR_CRUISE_SPEED movie_car2 12.0
SET_CAR_DRIVING_STYLE movie_car1 2
SET_CAR_DRIVING_STYLE movie_car2 2

DO_FADE 1000 FADE_IN

movie_demo_loop:

WAIT 0

GET_GAME_TIMER game_timer

		
IF movie_counter < 63 
	IF IS_CHAR_DEAD	movie_player
		GOTO mission_XXXX_failed
	ENDIF

	IF movie_counter < 49
		IF IS_CHAR_DEAD	movie_car2_driver
			GOTO mission_XXXX_failed
		ENDIF
	ENDIF

	IF movie_counter < 51
		IF IS_CHAR_DEAD	movie_car2_passenger
			GOTO mission_XXXX_failed
		ENDIF
	ENDIF

	IF IS_CAR_DEAD movie_car1
		GOTO mission_XXXX_failed
	ENDIF

	IF IS_CAR_DEAD movie_car2
		GOTO mission_XXXX_failed
	ENDIF
ENDIF

IF movie_counter = 0
	IF NOT GET_FADING_STATUS
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT movie_player 387.2983 -507.8135
		movie_timer = game_timer + 2500
		movie_counter = 1
	ENDIF
ENDIF

IF movie_counter = 1
	IF game_timer > movie_timer
		DO_FADE 500 FADE_OUT
		movie_counter = 2
	ENDIF
ENDIF

IF movie_counter = 2
	IF NOT GET_FADING_STATUS
		SET_FIXED_CAMERA_POSITION 433.7975 -465.8116 19.6369 0.0 0.0 0.0//HIGH UP SCENE SETTING SHOT AT POLICE STATION
		POINT_CAMERA_AT_POINT 432.8138 -465.9370 19.5081 JUMP_CUT
		SET_PLAYER_COORDINATES player1 415.0560 -493.8982 9.1245
		SET_CHAR_COORDINATES movie_player 395.8395 -473.9948 11.3032  
		SET_CHAR_HEADING movie_player 316.8160
		DO_FADE 500 FADE_IN
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT movie_player 397.2151 -472.0574
		DELETE_CHAR movie_cop
		movie_timer = game_timer + 1800
		movie_counter = 3
	ENDIF
ENDIF

IF movie_counter = 3
	IF game_timer > movie_timer
		SET_FIXED_CAMERA_POSITION 398.0080 -467.5676 11.2081 0.0 0.0 0.0//UP AT PLAYER IN FRONT OF POLICE STATION
		POINT_CAMERA_AT_POINT 397.8017 -468.4708 11.5847 JUMP_CUT
		movie_timer = game_timer + 500
		movie_counter = 4
	ENDIF
ENDIF

IF movie_counter = 4
	IF game_timer > movie_timer
		IF IS_CHAR_STOPPED movie_player
			SET_CHAR_WAIT_STATE movie_player WAITSTATE_CROSS_ROAD_LOOK 2000
			movie_timer = game_timer + 2000
			movie_counter = 5
		ENDIF
	ENDIF
ENDIF

IF movie_counter = 5
	IF game_timer > movie_timer
		SET_FIXED_CAMERA_POSITION 412.9082 -470.9594 11.9520 0.0 0.0 0.0//OVER PLAYERS CAR BONNET
		POINT_CAMERA_AT_POINT 411.9218 -470.8722 11.8129 JUMP_CUT
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT movie_player 400.4298 -469.0890
		movie_counter = 6
	ENDIF
ENDIF

IF movie_counter = 6
	IF LOCATE_CHAR_ON_FOOT_2D movie_player 400.4298 -469.0890 1.0 1.0 0
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT movie_player 405.5740 -472.8026
		SET_FIXED_CAMERA_POSITION 434.9879 -458.1398 10.5767 0.0 0.0 0.0//THROUGH FOLLOWERS CAR
		POINT_CAMERA_AT_POINT 434.0512 -458.4890 10.5516 JUMP_CUT
		//CHAR_LOOK_AT_CHAR_ALWAYS movie_car2_driver movie_player
		//CHAR_LOOK_AT_CHAR_ALWAYS movie_car2_passenger movie_player
		movie_counter = 7
	ENDIF
ENDIF

IF movie_counter = 7
	IF LOCATE_CHAR_ON_FOOT_2D movie_player 405.5740 -472.8026 1.0 1.0 0
		SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER movie_player movie_car1
		CHAR_LOOK_AT_CHAR_ALWAYS movie_car2_passenger movie_player
		movie_timer = game_timer + 2000
		movie_counter = 8
	ENDIF
ENDIF

IF movie_counter = 8
	IF game_timer > movie_timer
		CHAR_LOOK_AT_CHAR_ALWAYS movie_car2_driver movie_player
		movie_timer = game_timer + 2000
		movie_counter = 9
	ENDIF
ENDIF

IF movie_counter = 9
	IF game_timer > movie_timer
		SET_FIXED_CAMERA_POSITION 440.0391 -453.9345 11.4509 0.0 0.0 0.0//BACK BEHIND FOLLOWERS CAR
		POINT_CAMERA_AT_POINT 439.4124 -454.7128 11.4128 JUMP_CUT
		movie_counter = 10
	ENDIF
ENDIF

IF movie_counter = 10
	IF IS_CHAR_IN_ANY_CAR movie_player
		DELETE_CHAR	movie_player
		CREATE_CHAR_AS_PASSENGER movie_car1 PEDTYPE_CIVMALE NULL 0 movie_player
		CAR_GOTO_COORDINATES_ACCURATE movie_car1 423.0787 -485.6171 9.1474
		SET_CAR_CRUISE_SPEED movie_car1 12.0
		movie_counter = 11
	ENDIF
ENDIF
 
IF movie_counter = 11
	IF LOCATE_CAR_2D movie_car1 423.0787 -485.6171 3.0 3.0 0
		CAR_GOTO_COORDINATES_ACCURATE movie_car1 425.0385 -503.6205 8.9777
		CAR_GOTO_COORDINATES movie_car2	167.3340 -1281.8876 9.2418
		movie_counter = 12
	ENDIF
ENDIF

IF movie_counter = 12
	IF LOCATE_CAR_2D movie_car1 425.0385 -503.6205 3.0 3.0 0
		CAR_GOTO_COORDINATES movie_car1 167.3340 -1281.8876 9.2418
		movie_timer = game_timer + 2000
		movie_counter = 13
	ENDIF
ENDIF

IF movie_counter = 13
	IF game_timer > movie_timer
		DO_FADE 500 FADE_OUT
		movie_counter = 14
	ENDIF
ENDIF

IF movie_counter = 14
	IF NOT GET_FADING_STATUS
		SET_PLAYER_COORDINATES player1 206.9016 -1074.7250 9.3918
		LOAD_SCENE 199.0145 -1069.3364 9.6091
		SET_CAR_COORDINATES	movie_car1 200.4294 -1053.1617 9.2418
		SET_CAR_HEADING	movie_car1 166.4908
		SET_CAR_COORDINATES	movie_car2 202.9422 -1037.7394 9.2418
		SET_CAR_HEADING	movie_car2 166.4316
		SET_FIXED_CAMERA_POSITION 199.0145 -1069.3364 9.6091 0.0 0.0 0.0//MIDDLE OF ROAD LOW
		POINT_CAMERA_AT_CAR movie_car1 FIXED JUMP_CUT
		movie_timer = game_timer// + 200
		//PIZZA SHOP HERE
		movie_counter = 15
	ENDIF
ENDIF
 
IF movie_counter = 15
	IF game_timer > movie_timer
		DO_FADE 500 FADE_IN
		SET_CAR_DRIVING_STYLE movie_car1 2
		movie_timer = game_timer + 5500
		movie_counter = 16
	ENDIF
ENDIF

IF movie_counter = 16
	IF game_timer > movie_timer
		SET_FIXED_CAMERA_POSITION 195.2658 -1096.1324 22.4072 0.0 0.0 0.0//HIGH UP SHOT OF ROAD
		POINT_CAMERA_AT_POINT 195.0012 -1097.0082 22.0033 JUMP_CUT
		LOAD_SCENE 186.3302 -1127.5532 9.2418
		movie_counter = 17
	ENDIF
ENDIF
  
IF movie_counter = 17
	IF LOCATE_CAR_2D movie_car1	189.1301 -1103.4320 3.0 3.0 0
		SET_CAR_CRUISE_SPEED movie_car1 50.0
		movie_counter = 18
	ENDIF
ENDIF
 
IF movie_counter = 18
	IF LOCATE_CAR_2D movie_car1	184.6017 -1124.3391 3.0 3.0 0
		SET_CAR_TEMP_ACTION movie_car1 TEMPACT_HANDBRAKETURNLEFT 400
		//SET_CAR_HANDBRAKE_TURN_RIGHT movie_car1 400
		CAR_GOTO_COORDINATES movie_car1 201.5269 -1132.7877 9.3961
		movie_counter = 19
		movie_counter2 = 1
	ENDIF
ENDIF

IF movie_counter2 = 1
	IF LOCATE_CAR_2D movie_car2	184.6017 -1124.3391 3.0 3.0 0
		SET_CAR_CRUISE_SPEED movie_car2 50.0
		CAR_GOTO_COORDINATES movie_car2 201.5269 -1132.7877 9.3961
		movie_counter2 = 2
	ENDIF
ENDIF

IF movie_counter2 = 2
	IF LOCATE_CAR_2D movie_car2	201.5269 -1132.7877 3.0 3.0 0
		CAR_GOTO_COORDINATES movie_car2 223.0123 -1137.4708 9.4234
		movie_counter2 = 3
	ENDIF
ENDIF

IF movie_counter2 = 3
	IF LOCATE_CAR_2D movie_car2	223.0123 -1137.4708 3.0 3.0 0
		CAR_GOTO_COORDINATES movie_car2 240.5568 -1140.8102 9.8976
		movie_counter2 = 4
	ENDIF
ENDIF

IF movie_counter2 = 4
	IF LOCATE_CAR_2D movie_car2	240.5568 -1140.8102 3.0 3.0 0
		CAR_GOTO_COORDINATES movie_car2 265.5538 -1145.7645 9.8615
		movie_counter2 = 5
	ENDIF
ENDIF

IF movie_counter2 = 5
	IF LOCATE_CAR_2D movie_car2	265.5538 -1145.7645 3.0 3.0 0
		CAR_GOTO_COORDINATES movie_car2 297.6341 -1004.0583 9.8615
		movie_counter2 = 6
	ENDIF
ENDIF

IF movie_counter = 19
	IF LOCATE_CAR_2D movie_car1	201.5269 -1132.7877 3.0 3.0 0
		SET_FIXED_CAMERA_POSITION 228.1009 -1131.6427 10.6909 0.0 0.0 0.0//IN ALLEY
		POINT_CAMERA_AT_CAR movie_car1 FIXED JUMP_CUT
		CAR_GOTO_COORDINATES movie_car1 223.0123 -1137.4708 9.4234
		movie_counter = 20
	ENDIF
ENDIF

IF movie_counter = 20
	IF LOCATE_CAR_2D movie_car1	223.0123 -1137.4708 3.0 3.0 0
		CAR_GOTO_COORDINATES movie_car1 240.5568 -1140.8102 9.8976
		movie_counter = 21
	ENDIF
ENDIF

IF movie_counter = 21
	IF LOCATE_CAR_2D movie_car1	240.5568 -1140.8102 3.0 3.0 0
		CAR_GOTO_COORDINATES movie_car1 265.5538 -1145.7645 9.8615
		movie_counter = 22
	ENDIF
ENDIF

IF movie_counter = 22
	IF LOCATE_CAR_2D movie_car1	265.5538 -1145.7645 3.0 3.0 0
		SET_CAR_TEMP_ACTION movie_car1 TEMPACT_HANDBRAKETURNLEFT 250
		//SET_CAR_HANDBRAKE_TURN_RIGHT movie_car1 250
		CAR_GOTO_COORDINATES movie_car1	297.6341 -1004.0583 9.8615
		movie_timer = game_timer + 500
		movie_counter = 23
	ENDIF
ENDIF

IF movie_counter = 23
	IF game_timer > movie_timer
		POINT_CAMERA_AT_CAR movie_car2 FIXED JUMP_CUT
		movie_counter = 24
	ENDIF
ENDIF

IF movie_counter = 24
	IF movie_counter2 = 6
		DO_FADE 500 FADE_OUT
		movie_counter = 25
	ENDIF
ENDIF

IF movie_counter = 25
	IF NOT GET_FADING_STATUS
		SET_FIXED_CAMERA_POSITION 417.6970 85.3492 11.9908 0.0 0.0 0.0//IN PIZZA SHOP 
		POINT_CAMERA_AT_POINT 418.4539 85.9975 11.9088 JUMP_CUT
		
		SET_PLAYER_COORDINATES player1 425.0735 96.8492 10.3588
		LOAD_SCENE 452.8855 91.3795 9.8736
		
		SET_CAR_COORDINATES movie_car1 398.6962 159.8536 9.8616
		SET_CAR_HEADING movie_car1 198.3470
		SET_CAR_COORDINATES movie_car2 397.0435 171.9857 9.8616
		SET_CAR_HEADING movie_car2 182.8275
		
		CAR_GOTO_COORDINATES_ACCURATE movie_car1 510.9139 -82.3355 9.4241//496.9194 -101.1175 9.5295
		CAR_GOTO_COORDINATES_ACCURATE movie_car2 510.4948 -74.0066 9.4967//496.9194 -101.1175 9.5295
		SET_CAR_DRIVING_STYLE movie_car1 2
		SET_CAR_DRIVING_STYLE movie_car2 2
		SET_CAR_CRUISE_SPEED movie_car1 50.0
		SET_CAR_CRUISE_SPEED movie_car2 50.0
		
		CREATE_CHAR PEDTYPE_CIVMALE MALE01 420.1246 90.2250 10.2499 movie_shopper1
		SET_CHAR_HEADING movie_shopper1 207.3158
		CREATE_CHAR PEDTYPE_CIVMALE MALE01 421.3222 88.2824 10.3766 movie_shopper2
		SET_CHAR_HEADING movie_shopper2 63.0121 
		CREATE_CHAR PEDTYPE_CIVMALE MALE01 422.9127 87.0644 10.3521 movie_shopper3
		SET_CHAR_HEADING movie_shopper3 77.3265 
		CREATE_CHAR PEDTYPE_CIVMALE MALE01 430.2144 81.2067 10.1969 movie_shopper4
		SET_CHAR_HEADING movie_shopper4 355.5790
		
		SET_CHARS_CHATTING movie_shopper1 movie_shopper2 3200
		
		DO_FADE 500 FADE_IN
		movie_timer = game_timer + 3300
		movie_counter = 26
		movie_counter2 = 7
	ENDIF
ENDIF

IF movie_counter = 26
	IF game_timer > movie_timer
		POINT_CAMERA_AT_CAR movie_car1 FIXED INTERPOLATION
		IF NOT IS_CHAR_DEAD	movie_shopper1
			CHAR_LOOK_AT_CHAR_ALWAYS movie_shopper1	movie_player
		ENDIF
		IF NOT IS_CHAR_DEAD	movie_shopper2
			CHAR_LOOK_AT_CHAR_ALWAYS movie_shopper2	movie_player
		ENDIF
		IF NOT IS_CHAR_DEAD	movie_shopper3
			CHAR_LOOK_AT_CHAR_ALWAYS movie_shopper3	movie_player
		ENDIF
		IF NOT IS_CHAR_DEAD	movie_shopper4
			CHAR_LOOK_AT_CHAR_ALWAYS movie_shopper4	movie_player
		ENDIF
		movie_counter = 27
	ENDIF
ENDIF

IF movie_counter = 27
	IF LOCATE_CAR_2D movie_car1 446.4955 83.0253 3.0 3.0 0
		SET_CAR_TEMP_ACTION movie_car1 TEMPACT_HANDBRAKETURNLEFT 300
		//SET_CAR_HANDBRAKE_TURN_RIGHT movie_car1 300
		movie_timer = game_timer + 2000
		movie_counter = 28
	ENDIF
ENDIF

IF movie_counter2 = 7
	IF LOCATE_CAR_2D movie_car2 446.4955 83.0253 3.0 3.0 0
		SET_CAR_TEMP_ACTION movie_car2 TEMPACT_HANDBRAKETURNLEFT 300
		//SET_CAR_HANDBRAKE_TURN_RIGHT movie_car2 300
		movie_counter2 = 8
	ENDIF
ENDIF

IF movie_counter = 28
	IF game_timer > movie_timer
		SET_FIXED_CAMERA_POSITION 502.4712 108.9173 12.7109 0.0 0.0 0.0//AT CORNER
		POINT_CAMERA_AT_POINT 501.7713 108.2058 12.6488	JUMP_CUT
		DELETE_CHAR	movie_shopper1
		DELETE_CHAR	movie_shopper2
		DELETE_CHAR	movie_shopper3
		DELETE_CHAR	movie_shopper4
		movie_counter = 29
	ENDIF
ENDIF

IF movie_counter = 29
	IF LOCATE_CAR_2D movie_car1 487.0447 94.3898 4.0 4.0 0
		SET_CAR_TEMP_ACTION movie_car1 TEMPACT_HANDBRAKETURNRIGHT 300
		//SET_CAR_HANDBRAKE_TURN_LEFT movie_car1 300
		movie_timer = game_timer + 2000
		movie_counter = 30
	ENDIF
ENDIF

IF movie_counter2 = 8
	IF LOCATE_CAR_2D movie_car2 470.5926 93.6275 3.0 3.0 0
		SET_CAR_TEMP_ACTION movie_car2 TEMPACT_HANDBRAKETURNRIGHT 300
		//SET_CAR_HANDBRAKE_TURN_LEFT movie_car2 300
		movie_counter2 = 9
	ENDIF
ENDIF

IF movie_counter = 30
	IF game_timer > movie_timer
		SET_FIXED_CAMERA_POSITION 476.1554 22.6055 36.9843 0.0 0.0 0.0//FROM PENTHOUSE
		POINT_CAMERA_AT_CAR	movie_car1 FIXED JUMP_CUT
		movie_timer = game_timer + 2300
		movie_counter = 31
	ENDIF
ENDIF

IF movie_counter = 31
	IF game_timer > movie_timer
		SET_FIXED_CAMERA_POSITION 532.8522 -87.4967 12.6269 0.0 0.0 0.0//FRONT OF CLUB
		POINT_CAMERA_AT_POINT 531.8540 -87.5545 12.6077 JUMP_CUT
		SET_PLAYER_COORDINATES player1 471.0432 -84.1013 10.4438
		DO_FADE 0 FADE_OUT
		LOAD_SCENE 498.8900 -82.0271 8.9903
		DO_FADE 0 FADE_IN
		movie_counter2 = 10
		movie_counter = 32
	ENDIF
ENDIF

IF movie_counter = 32
	IF LOCATE_CAR_2D movie_car1	510.9139 -80.3355 3.0 3.0 0
		CAR_GOTO_COORDINATES_ACCURATE movie_car1 520.9139 -80.3355 9.5
		movie_timer = game_timer + 250
		movie_counter = 33
	ENDIF
ENDIF

IF movie_counter = 33
	IF game_timer > movie_timer
		SET_CAR_TEMP_ACTION movie_car1 TEMPACT_HANDBRAKETURNLEFT 5000
		//SET_CAR_HANDBRAKE_TURN_RIGHT movie_car1 5000
		movie_counter = 34
	ENDIF
ENDIF

IF movie_counter2 = 10
	IF LOCATE_CAR_2D movie_car2	510.4948 -72.0066 3.0 3.0 0
		CAR_GOTO_COORDINATES_ACCURATE movie_car2 520.9139 -72.0066 9.5
		movie_timer2 = game_timer + 150
		movie_counter2 = 11
	ENDIF
ENDIF

IF movie_counter2 = 11
	IF game_timer > movie_timer2
		SET_CAR_TEMP_ACTION movie_car2 TEMPACT_HANDBRAKETURNLEFT 5000
		//SET_CAR_HANDBRAKE_TURN_RIGHT movie_car2 5000
		movie_counter2 = 12
	ENDIF
ENDIF

IF movie_counter = 34
	IF IS_CAR_STOPPED movie_car1
		SET_CHAR_OBJ_RUN_TO_COORD movie_player 501.5616 -82.9503
		CREATE_CHAR PEDTYPE_CIVMALE MALE01 466.3348 -58.5777 14.6633 movie_club_manager
		SET_CHAR_HEADING movie_club_manager 245.9955
		CREATE_CHAR PEDTYPE_CIVMALE MALE01 467.8509 -53.6819 10.4431 movie_barman
		SET_CHAR_HEADING movie_barman 221.5119
		CHAR_LOOK_AT_CHAR_ALWAYS movie_barman movie_player
		CREATE_CHAR PEDTYPE_CIVMALE MALE01 468.9094 -54.9209 10.4431 movie_drinker1
		SET_CHAR_HEADING movie_drinker1 42.7760
		CREATE_CHAR PEDTYPE_CIVMALE MALE01 470.0663 -53.5861 10.4431 movie_drinker2
		SET_CHAR_HEADING movie_drinker2 101.4189
		CREATE_CHAR PEDTYPE_CIVMALE MALE01 466.6759 -57.1055 10.4431 movie_drinker3
		SET_CHAR_HEADING movie_drinker2 222.7760
		GIVE_WEAPON_TO_CHAR	movie_player WEAPONTYPE_SHOTGUN 9999
		CAR_SET_IDLE movie_car1
		movie_counter = 35
	ENDIF
ENDIF

IF movie_counter > 34
	IF movie_counter < 46
		IF IS_CHAR_DEAD	movie_club_manager   
			GOTO mission_XXXX_failed
		ENDIF
	ENDIF
//	IF IS_CHAR_DEAD	movie_barman   
//		GOTO mission_XXXX_failed
//	ENDIF
//	IF IS_CHAR_DEAD	movie_drinker1
//		GOTO mission_XXXX_failed
//	ENDIF
//	IF IS_CHAR_DEAD	movie_drinker2
//		GOTO mission_XXXX_failed
//	ENDIF
//	IF IS_CHAR_DEAD	movie_drinker3
//		GOTO mission_XXXX_failed
//	ENDIF
ENDIF

IF movie_counter = 35
	IF LOCATE_CHAR_ON_FOOT_2D movie_player	501.5616 -82.9503 1.0 1.0 0
		SET_CHAR_OBJ_RUN_TO_COORD movie_player 486.6614 -73.9622
		SET_FIXED_CAMERA_POSITION 463.5040 -54.8264 16.8099 0.0 0.0 0.0//OVER SHOLDER
		POINT_CAMERA_AT_POINT 464.3841 -55.2169 16.5396 JUMP_CUT
		movie_counter = 36
	ENDIF
ENDIF

IF movie_counter = 36
	IF LOCATE_CHAR_ON_FOOT_2D movie_player	486.6614 -73.9622 1.0 1.0 0
		SET_CHAR_OBJ_RUN_TO_COORD movie_player 467.2191 -58.0957
		movie_timer = game_timer + 2000
		movie_counter = 37
	ENDIF
ENDIF

IF movie_counter = 37
	IF game_timer > movie_timer
		SET_CHAR_COORDINATES movie_player 481.4690 -68.8889 8.9430
		SET_FIXED_CAMERA_POSITION 485.0654 -64.3929 10.1884 0.0 0.0 0.0//UP AT MANAGER
		POINT_CAMERA_AT_POINT 484.1102 -64.1311 10.3265 JUMP_CUT
		movie_counter = 38
	ENDIF
ENDIF


IF movie_counter = 38
	IF LOCATE_CHAR_ON_FOOT_2D movie_player 467.2191 -58.0957 1.0 1.0 0
		SET_CHAR_OBJ_RUN_TO_COORD movie_player 464.8464 -59.8506
		movie_counter = 39
	ENDIF
ENDIF

IF movie_counter = 39
	IF LOCATE_CHAR_ON_FOOT_2D movie_player 464.8464 -59.8506 1.0 1.0 0
		SET_CHAR_OBJ_RUN_TO_COORD movie_player 457.8582 -52.0823
		movie_counter = 40
	ENDIF
ENDIF

IF movie_counter = 40
	IF LOCATE_CHAR_ON_FOOT_2D movie_player 457.8582 -52.0823 1.0 1.0 0
		SET_CHAR_OBJ_RUN_TO_COORD movie_player 454.1453 -55.6716
		movie_counter = 41
	ENDIF
ENDIF

IF movie_counter = 41
	IF LOCATE_CHAR_ON_FOOT_2D movie_player 454.1453 -55.6716 1.0 1.0 0
		SET_CHAR_OBJ_RUN_TO_COORD movie_player 457.6962 -59.2783
		movie_counter = 42
	ENDIF
ENDIF

IF movie_counter = 42
	IF LOCATE_CHAR_ON_FOOT_2D movie_player 457.6962 -59.2783 1.0 1.0 0
		SET_CHAR_OBJ_RUN_TO_COORD movie_player 462.2478 -54.9318
		SET_FIXED_CAMERA_POSITION 471.5735 -56.0797 16.2224 0.0 0.0 0.0//IN MANAGERS ROOM
		POINT_CAMERA_AT_POINT 470.5805 -56.1331 16.1171 JUMP_CUT
		movie_counter = 43
	ENDIF
ENDIF

IF movie_counter = 43
	TURN_CHAR_TO_FACE_CHAR movie_club_manager movie_player
	IF LOCATE_STOPPED_CHAR_ON_FOOT_2D movie_player 462.2478 -54.9318 1.0 1.0 0
		SET_CHAR_STAY_IN_SAME_PLACE	movie_player TRUE
		TURN_CHAR_TO_FACE_CHAR movie_player movie_club_manager
		movie_timer = game_timer + 800
		movie_counter = 44
	ENDIF
ENDIF

IF movie_counter = 44
	IF game_timer > movie_timer
		SET_CHAR_WAIT_STATE movie_club_manager WAITSTATE_PLAYANIM_HANDSUP 2000
		movie_timer = game_timer + 1500
		movie_counter = 45
	ENDIF
ENDIF

IF movie_counter = 45
	IF game_timer > movie_timer
		SET_CHAR_OBJ_KILL_CHAR_ON_FOOT movie_player movie_club_manager
		movie_timer = game_timer + 600
		movie_counter = 46
	ENDIF
ENDIF

IF movie_counter = 46
	IF game_timer > movie_timer
		SET_CHAR_OBJ_RUN_TO_COORD movie_player 457.6962 -59.2783
		movie_counter = 47
	ENDIF
ENDIF

IF movie_counter = 47
	IF LOCATE_CHAR_ON_FOOT_2D movie_player 457.6962 -59.2783 1.0 1.0 0
		SET_CHAR_COORDINATES movie_player 458.6772 -51.7050 10.45
		SET_CHAR_OBJ_RUN_TO_COORD movie_player 464.8543 -59.6144
		SET_FIXED_CAMERA_POSITION 467.5534 -64.1758 10.3380 0.0 0.0 0.0//AT PLAYER SHOOTING FROM LOW DOWN
		POINT_CAMERA_AT_POINT 467.3854 -63.2178 10.5704	JUMP_CUT
		GIVE_WEAPON_TO_CHAR	movie_player WEAPONTYPE_M4 9999
		movie_counter = 48
	ENDIF
ENDIF

IF movie_counter = 48
	IF LOCATE_CHAR_ON_FOOT_2D movie_player 464.8543 -59.6144 1.0 1.0 0
		SET_CHAR_COORDINATES movie_player 464.8543 -59.6144 10.45
		CHAR_SET_IDLE movie_player
		SET_CHAR_OBJ_NO_OBJ	movie_player
		SET_CHAR_STAY_IN_SAME_PLACE	movie_player TRUE
		SET_CHAR_OBJ_KILL_CHAR_ON_FOOT movie_player	movie_car2_driver
		SET_CHAR_COORDINATES movie_car2_driver 487.5853 -72.1326 10.4431
		SET_CHAR_HEALTH	movie_player 999
		SET_CHAR_HEALTH	movie_car2_driver 9999
		SET_CHAR_STAY_IN_SAME_PLACE	movie_car2_driver TRUE
		SET_CHAR_OBJ_KILL_CHAR_ON_FOOT movie_car2_driver movie_player
		SET_CHAR_STAY_IN_SAME_PLACE	movie_car2_passenger TRUE
		SET_CHAR_OBJ_KILL_CHAR_ON_FOOT movie_car2_passenger movie_player
		movie_timer = game_timer + 1500
		movie_counter = 49
	ENDIF
ENDIF

IF movie_counter = 49
	IF game_timer > movie_timer
		SET_FIXED_CAMERA_POSITION 488.9160 -73.8545 11.3968 0.0 0.0 0.0//BEHIND BAD DUDES
		POINT_CAMERA_AT_POINT 488.0700 -73.3232 11.3518 JUMP_CUT
		SET_CAR_COORDINATES	movie_car1 493.6040 -94.0816 9.3432
		SET_CAR_HEADING	movie_car1 87.8408
		IF NOT IS_CHAR_DEAD	movie_car2_driver
			SET_CHAR_HEALTH	movie_car2_driver 20
		ENDIF
		movie_counter = 50
	ENDIF
ENDIF

IF movie_counter = 50
	IF IS_CHAR_DEAD	movie_car2_driver
		SET_CHAR_OBJ_KILL_CHAR_ON_FOOT movie_player	movie_car2_passenger
		movie_counter = 51
	ENDIF
ENDIF

IF movie_counter2 = 12
	IF IS_CAR_STOPPED movie_car2
		SET_CHAR_OBJ_RUN_TO_COORD movie_car2_driver 501.3533 -79.8217
		SET_CHAR_OBJ_RUN_TO_COORD movie_car2_passenger 501.3533 -79.8217
		GIVE_WEAPON_TO_CHAR	movie_car2_driver WEAPONTYPE_UZI 9999
		GIVE_WEAPON_TO_CHAR	movie_car2_passenger WEAPONTYPE_UZI 9999
		CAR_SET_IDLE movie_car2
		movie_counter2 = 13
		movie_counter3 = 1
	ENDIF
ENDIF

IF movie_counter2 = 13
	IF LOCATE_CHAR_ON_FOOT_2D movie_car2_driver	501.3533 -79.8217 1.0 1.0 0
		SET_CHAR_OBJ_RUN_TO_COORD movie_car2_driver 493.8939 -78.4198
		movie_counter2 = 14
	ENDIF
ENDIF

IF movie_counter2 = 14
	IF LOCATE_CHAR_ON_FOOT_2D movie_car2_driver	493.8939 -78.4198 1.0 1.0 0
		SET_CHAR_OBJ_RUN_TO_COORD movie_car2_driver 488.3700 -71.6619
		movie_counter2 = 15
	ENDIF
ENDIF

IF movie_counter3 = 1
	IF LOCATE_CHAR_ON_FOOT_2D movie_car2_passenger 501.3533 -79.8217 1.0 1.0 0
		SET_CHAR_OBJ_RUN_TO_COORD movie_car2_passenger 493.8939 -78.4198
		movie_counter3 = 2
	ENDIF
ENDIF

IF movie_counter3 = 2
	IF LOCATE_CHAR_ON_FOOT_2D movie_car2_passenger 493.8939 -78.4198 1.0 1.0 0
		SET_CHAR_OBJ_RUN_TO_COORD movie_car2_passenger 481.7643 -73.7486
		movie_counter3 = 3
	ENDIF
ENDIF

IF movie_counter = 51
	IF IS_CHAR_DEAD	movie_car2_passenger
		IF NOT IS_CHAR_DEAD	movie_barman
			SET_CHAR_OBJ_KILL_CHAR_ON_FOOT movie_player	movie_barman
		ENDIF
		movie_timer = game_timer + 1500
		movie_counter = 52
	ENDIF
ENDIF

IF movie_counter = 52
	IF game_timer > movie_timer
		SET_CHAR_COORDINATES movie_player 484.6963 -69.5012 9.4430
		SET_FIXED_CAMERA_POSITION 497.3029 -101.1990 12.0689 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 497.0254 -100.2479 11.9335 JUMP_CUT
		SET_CHAR_OBJ_RUN_TO_COORD movie_player 492.5949 -88.6765
		movie_counter = 53
	ENDIF
ENDIF

IF movie_counter = 53
	IF LOCATE_CHAR_ON_FOOT_2D movie_player 492.5949 -88.6765 1.0 1.0 0
		SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER	movie_player movie_car1
		movie_counter = 54
	ENDIF
ENDIF

IF movie_counter = 54
	IF IS_CHAR_IN_ANY_CAR movie_player
		CAR_GOTO_COORDINATES movie_car1	440.6581 -403.6276 9.3850
		SET_CAR_CRUISE_SPEED movie_car1 100.0
		SET_CAR_DRIVING_STYLE movie_car1 3
		movie_timer = game_timer + 1000
		movie_counter = 55
	ENDIF
ENDIF

IF movie_counter = 55
	IF game_timer > movie_timer
		SET_FIXED_CAMERA_POSITION 470.9526 -138.9579 10.0 0.0 0.0 0.0
		POINT_CAMERA_AT_CAR	movie_car1 FIXED JUMP_CUT
		DELETE_CAR movie_car2
		CREATE_CAR POLICE 501.2257 -100.2508 9.5295 copscar1 
		SET_CAR_HEADING copscar1 90.1727 
		CREATE_CAR POLICE 510.5414 -99.9129 9.5221 copscar2
		SET_CAR_HEADING copscar2 114.2435
		SET_CAR_CRUISE_SPEED copscar1 100.0
		SET_CAR_CRUISE_SPEED copscar2 100.0
		SET_CAR_DRIVING_STYLE copscar1 2
		SET_CAR_DRIVING_STYLE copscar2 2
		CAR_GOTO_COORDINATES copscar1 440.6581 -403.6276 9.3850
		CAR_GOTO_COORDINATES copscar2 440.6581 -403.6276 9.3850
		SWITCH_CAR_SIREN copscar1 ON
		SWITCH_CAR_SIREN copscar2 ON
		CREATE_CHAR_INSIDE_CAR copscar1 PEDTYPE_CIVMALE COP movie_cop
		CREATE_CHAR_INSIDE_CAR copscar2 PEDTYPE_CIVMALE COP movie_cop2
		CREATE_CAR SENTINEL 453.5575 -338.9098 9.5 movie_car2
		SET_GENERATE_CARS_AROUND_CAMERA FALSE
		SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 460.562 -379.384 10.63 1.0 newramp FALSE
		CREATE_OBJECT barrel1 459.7787 -379.0 9.5 barrel_1
		CREATE_OBJECT barrel1 459.7787 -377.0 9.5 barrel_2
		CREATE_OBJECT barrel1 459.7787 -376.0 9.5 barrel_3
		CREATE_OBJECT barrel1 461.7787 -379.0 9.5 barrel_4
		CREATE_OBJECT barrel1 461.7787 -377.0 9.5 barrel_5
		CREATE_OBJECT barrel1 461.7787 -376.0 9.5 barrel_6
		SET_OBJECT_COLLISION barrel_1 FALSE
		SET_OBJECT_COLLISION barrel_2 FALSE
		SET_OBJECT_COLLISION barrel_3 FALSE
		SET_OBJECT_COLLISION barrel_4 FALSE
		SET_OBJECT_COLLISION barrel_5 FALSE
		SET_OBJECT_COLLISION barrel_6 FALSE
		movie_timer = game_timer + 3000
		movie_counter = 56
	ENDIF
ENDIF

IF movie_counter = 56
	IF game_timer > movie_timer
		SET_FIXED_CAMERA_POSITION 487.0211 -251.7067 16.3674 0.0 0.0 0.0
		POINT_CAMERA_AT_CAR	movie_car1 FIXED JUMP_CUT
		movie_timer = game_timer + 3000
		movie_counter = 57
	ENDIF
ENDIF
		
IF movie_counter = 57
	IF game_timer > movie_timer
		SET_FIXED_CAMERA_POSITION 444.8286 -352.6365 11.7309 0.0 0.0 0.0
		POINT_CAMERA_AT_CAR	movie_car1 FIXED JUMP_CUT
		movie_timer = game_timer + 3000
		movie_counter = 58
	ENDIF
ENDIF

IF movie_counter = 58
	IF LOCATE_CAR_2D movie_car1 457.3652 -320.4637 3.0 3.0 0
		CAR_GOTO_COORDINATES_ACCURATE movie_car1 458.5753 -339.3495 9.2
		movie_counter = 59
	ENDIF
ENDIF

IF movie_counter = 59
	IF LOCATE_CAR_2D movie_car1 458.5753 -339.3495 3.0 3.0 0
		CAR_GOTO_COORDINATES_ACCURATE movie_car1 459.7853 -358.2354 9.2
		movie_counter = 60
	ENDIF
ENDIF

IF movie_counter = 60
	IF LOCATE_CAR_2D movie_car1 459.7853 -358.2354 3.0 3.0 0
		CAR_GOTO_COORDINATES_ACCURATE movie_car1 460.9953 -377.1213 9.2
		SET_FIXED_CAMERA_POSITION 439.8378 -386.9468 10.1505 0.0 0.0 0.0
		POINT_CAMERA_AT_CAR	movie_car1 FIXED JUMP_CUT
		movie_counter2 = 90
		movie_counter = 61
	ENDIF
ENDIF

IF movie_counter = 61
	IF LOCATE_CAR_2D movie_car1 460.9953 -377.1213 3.0 3.0 0
		CAR_GOTO_COORDINATES_ACCURATE movie_car1 462.2053 -396.0072 9.2
		movie_counter = 62
	ENDIF
ENDIF

IF movie_counter2 = 90
	IF LOCATE_CAR_2D movie_car1 460.9953 -377.1213 2.0 2.0 0
		SET_OBJECT_COLLISION barrel_1 TRUE
		SET_OBJECT_COLLISION barrel_2 TRUE
		SET_OBJECT_COLLISION barrel_3 TRUE
		SET_OBJECT_COLLISION barrel_4 TRUE
		SET_OBJECT_COLLISION barrel_5 TRUE
		SET_OBJECT_COLLISION barrel_6 TRUE
		ADD_EXPLOSION 462.2737 -376.2148 9.3957 EXPLOSION_GRENADE
		ADD_EXPLOSION 462.0712 -377.1941 9.4086 EXPLOSION_GRENADE
		ADD_EXPLOSION 461.9546 -377.7579 9.5774 EXPLOSION_GRENADE
		movie_counter = 63
		movie_counter2 = 91
	ENDIF
ENDIF

//IF IS_CAR_DEAD movie_car1
//	GOTO the_end
//ENDIF

GOTO movie_demo_loop

//the_end:

	
// Mission XXXX 1 failed

mission_XXXX_failed:
RETURN

   

// mission XXXX 1 passed

mission_XXXX_passed:

RETURN
		


// mission cleanup

mission_cleanup_XXXX:

flag_player_on_mission = 0

MISSION_HAS_FINISHED
RETURN
		


