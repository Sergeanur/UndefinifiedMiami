MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***************************************GRIPPED, SORTED*********************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_4x4one
IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_4x4one_failed
ENDIF
GOSUB mission_cleanup_4x4one
MISSION_END

// Variables for mission


// ********************************* EXCLUSIVE ********************************************
//VAR_INT set_record_4x4
//VAR_INT blip_truck_1 blip_truck_2
VAR_INT pcj_seconds
// ****************************************Mission Start************************************

mission_start_4x4one:

IF flag_4x4_mission1_passed = 0
	REGISTER_MISSION_GIVEN
ENDIF

SCRIPT_NAME t4x4_1 
flag_player_on_mission = 1
flag_usj_off = 1
LOAD_MISSION_TEXT MIAMI_1

PRINT_BIG (T4X4_1) 5000 2

WAIT 0

//Set Variables

counter_4x4_pickups = 0
timer_4x4 = 120000
flag_intro = 0
flag_timer = 0
flag_4x4one_trigger = 1
flag_intro_jump = 0
intro_time_lapsed = 0


//timer_bonus = 5000 //ammount added to timer for each pickup
checkpoint_time_limit = 120
pcj_reward = 100
pcj_minutes = 0

flag_truck_1 = 0
flag_truck_2 = 0

flag_blip_1 = 0
flag_blip_2 = 0
flag_blip_3 = 0
flag_blip_4 = 0
flag_blip_5 = 0
flag_blip_6 = 0
flag_blip_7 = 0
flag_blip_8 = 0
flag_blip_9 = 0
flag_blip_10 = 0
flag_blip_11 = 0
flag_blip_12 = 0
flag_blip_13 = 0
flag_blip_14 = 0
flag_blip_15 = 0
flag_blip_16 = 0
flag_blip_17 = 0
flag_blip_18 = 0
flag_blip_19 = 0
flag_blip_20 = 0
flag_blip_21 = 0
flag_blip_22 = 0
flag_blip_23 = 0
flag_blip_24 = 0

//record_temp = 0
//Set Coords

cam_4x4_X = 450.0
cam_4x4_y = -389.0
cam_4x4_z = 26.5

x_1 = 460.0    
y_1 = -400.4
z_1 = 18.0

x_2 = 460.0    
y_2 = -441.5
z_2 = 17.5

x_3 = 453.0   
y_3 = -517.83 
z_3 = 21.0

x_4 = 429.5   
y_4 = -580.6 
z_4 = 11.0

x_5 = 392.0   
y_5 = -661.3 
z_5 = 11.5

x_6 = 366.5 
y_6 = -719.2 
z_6 = 23.3

x_7 = 349.5   
y_7 = -762.2 
z_7 = 24.0

x_8 = 342.26   
y_8 = -802.3 
z_8 = 11.5 

x_9 = 316.0   
y_9 = -858.0 
z_9 = 11.5

x_10 = 285.0   
y_10 = -890.0 
z_10 = 11.5

x_11 = 256.7   
y_11 = -955.0
z_11 = 17.0

x_12 = 242.5 
y_12 = -1111.8 
z_12 = 11.5

x_13 = 228.6    
y_13 = -1147.9
z_13 = 11.5

x_14 = 193.5      
y_14 = -1303.3
z_14 = 11.2

x_15 = 201.44  
y_15 = -1318.7
z_15 = 11.2

x_16 = 188.6    
y_16 = -1357.5
z_16 = 11.2

x_17 = 167.2   
y_17 = -1369.2
z_17 = 11.2

x_18 = 129.6   
y_18 = -1337.8 
z_18 = 9.5

x_19 = 104.45    
y_19 = -1319.7
z_19 = 5.5

x_20 = 78.7 
y_20 = -1300.0
z_20 = 13.5

x_21 = 70.1  
y_21 = -1220.4
z_21 = 11.0

x_22 = 12.5  
y_22 = -1192.0
z_22 = 11.4

x_23 = 4.96  
y_23 = -1253.5
z_23 = 21.6

x_24 = 19.8  
y_24 = -1308.9
z_24 = 17.3

//Mission Script 

STORE_WANTED_LEVEL player1 wanted_4x4
CLEAR_WANTED_LEVEL player1
SET_EVERYONE_IGNORE_PLAYER player1 ON
STORE_CAR_PLAYER_IS_IN player1 player_4x4
IF NOT IS_CAR_DEAD player_4x4
	LOCK_CAR_DOORS player_4x4 CARLOCK_UNLOCKED
ENDIF

SET_PLAYER_CONTROL player1 off
SWITCH_WIDESCREEN on 
 
		
ADD_BLIP_FOR_COORD x_1 y_1 z_1 blip_1
ADD_BLIP_FOR_COORD x_2 y_2 z_2 blip_2
ADD_BLIP_FOR_COORD x_3 y_3 z_3 blip_3
ADD_BLIP_FOR_COORD x_4 y_4 z_4 blip_4
ADD_BLIP_FOR_COORD x_5 y_5 z_5 blip_5
ADD_BLIP_FOR_COORD x_6 y_6 z_6 blip_6
ADD_BLIP_FOR_COORD x_7 y_7 z_7 blip_7
ADD_BLIP_FOR_COORD x_8 y_8 z_8 blip_8
ADD_BLIP_FOR_COORD x_9 y_9 z_9 blip_9
ADD_BLIP_FOR_COORD x_10 y_10 z_10 blip_10
ADD_BLIP_FOR_COORD x_11 y_11 z_11 blip_11
ADD_BLIP_FOR_COORD x_12 y_12 z_12 blip_12
ADD_BLIP_FOR_COORD x_13 y_13 z_13 blip_13
ADD_BLIP_FOR_COORD x_14 y_14 z_14 blip_14
ADD_BLIP_FOR_COORD x_15 y_15 z_15 blip_15
ADD_BLIP_FOR_COORD x_16 y_16 z_16 blip_16
ADD_BLIP_FOR_COORD x_17 y_17 z_17 blip_17
ADD_BLIP_FOR_COORD x_18 y_18 z_18 blip_18
ADD_BLIP_FOR_COORD x_19 y_19 z_19 blip_19
ADD_BLIP_FOR_COORD x_20 y_20 z_20 blip_20
ADD_BLIP_FOR_COORD x_21 y_21 z_21 blip_21
ADD_BLIP_FOR_COORD x_22 y_22 z_22 blip_22
ADD_BLIP_FOR_COORD x_23 y_23 z_23 blip_23
ADD_BLIP_FOR_COORD x_24 y_24 z_24 blip_24


REQUEST_MODEL YANKEE
WHILE NOT HAS_MODEL_LOADED YANKEE
	WAIT 0
ENDWHILE

WHILE counter_4x4_pickups < 24

	WAIT 0

	IF flag_timer = 1
		IF timer_4x4 < 1
			PRINT_NOW (taxi2) 3000 1
			GOTO mission_4x4one_failed
		ENDIF
	ENDIF
	
	IF counter_4x4_pickups = 1
	AND flag_timer = 0
		DISPLAY_ONSCREEN_TIMER timer_4x4 TIMER_DOWN
		flag_timer = 1
	ENDIF

	IF IS_PLAYER_IN_MODEL player1 PCJ600
	OR	flag_intro < 4
		IF flag_blip_1 = 0
			DRAW_CORONA x_1 y_1 z_1 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_1 y_1 z_1 2.5 2.5 3.5 false
				REMOVE_BLIP blip_1
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_1 y_1 z_1 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_1 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_2 = 0
			DRAW_CORONA x_2 y_2 z_2 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_2 y_2 z_2 2.5 2.5 3.5 false
				REMOVE_BLIP blip_2
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_2 y_2 z_2 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_2 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_3 = 0
			DRAW_CORONA x_3 y_3 z_3 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_3 y_3 z_3 2.5 2.5 3.5 false
				REMOVE_BLIP blip_3
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_3 y_3 z_3 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_3 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_4 = 0
			DRAW_CORONA x_4 y_4 z_4 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_4 y_4 z_4 2.5 2.5 3.5 false
				REMOVE_BLIP blip_4
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_4 y_4 z_4 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_4 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_5 = 0
			DRAW_CORONA x_5 y_5 z_5 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_5 y_5 z_5 2.5 2.5 3.5 false
				REMOVE_BLIP blip_5
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_5 y_5 z_5 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_5 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_6 = 0
			DRAW_CORONA x_6 y_6 z_6 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_6 y_6 z_6 2.5 2.5 3.5 false
				REMOVE_BLIP blip_6
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_6 y_6 z_6 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_6 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_7 = 0
			DRAW_CORONA x_7 y_7 z_7 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_7 y_7 z_7 2.5 2.5 3.5 false
				REMOVE_BLIP blip_7
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_7 y_7 z_7 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_7 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_8 = 0
			DRAW_CORONA x_8 y_8 z_8 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_8 y_8 z_8 2.5 2.5 3.5 false
				REMOVE_BLIP blip_8
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_8 y_8 z_8 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_8 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_9 = 0
			DRAW_CORONA x_9 y_9 z_9 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_9 y_9 z_9 2.5 2.5 3.5 false
				REMOVE_BLIP blip_9
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_9 y_9 z_9 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_9 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_10 = 0
			DRAW_CORONA x_10 y_10 z_10 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_10 y_10 z_10 2.5 2.5 3.5 false
				REMOVE_BLIP blip_10
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_10 y_10 z_10 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_10 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_11 = 0
			DRAW_CORONA x_11 y_11 z_11 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_11 y_11 z_11 2.5 2.5 3.5 false
				REMOVE_BLIP blip_11
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_11 y_11 z_11 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_11 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_12 = 0
			DRAW_CORONA x_12 y_12 z_12 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_12 y_12 z_12 2.5 2.5 3.5 false
				REMOVE_BLIP blip_12
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_12 y_12 z_12 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_12 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_13 = 0
			DRAW_CORONA x_13 y_13 z_13 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_13 y_13 z_13 2.5 2.5 3.5 false
				REMOVE_BLIP blip_13
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_13 y_13 z_13 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_13 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_14 = 0
			DRAW_CORONA x_14 y_14 z_14 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_14 y_14 z_14 2.5 2.5 3.5 false
				REMOVE_BLIP blip_14
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_14 y_14 z_14 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_14 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 

		IF flag_blip_15 = 0
			DRAW_CORONA x_15 y_15 z_15 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_15 y_15 z_15 2.5 2.5 3.5 false
				REMOVE_BLIP blip_15
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_15 y_15 z_15 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_15 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 

		IF flag_blip_16 = 0
			DRAW_CORONA x_16 y_16 z_16 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_16 y_16 z_16 2.5 2.5 3.5 false
				REMOVE_BLIP blip_16
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_16 y_16 z_16 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_16 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_17 = 0
			DRAW_CORONA x_17 y_17 z_17 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_17 y_17 z_17 2.5 2.5 3.5 false
				REMOVE_BLIP blip_17
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_17 y_17 z_17 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_17 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_18 = 0
			DRAW_CORONA x_18 y_18 z_18 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_18 y_18 z_18 2.5 2.5 3.5 false
				REMOVE_BLIP blip_18
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_18 y_18 z_18 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_18 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_19 = 0
			DRAW_CORONA x_19 y_19 z_19 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_19 y_19 z_19 2.5 2.5 3.5 false
				REMOVE_BLIP blip_19
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_19 y_19 z_19 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_19 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_20 = 0
			DRAW_CORONA x_20 y_20 z_20 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_20 y_20 z_20 2.5 2.5 3.5 false
				REMOVE_BLIP blip_20
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_20 y_20 z_20 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_20 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_21 = 0
			DRAW_CORONA x_21 y_21 z_21 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_21 y_21 z_21 2.5 2.5 3.5 false
				REMOVE_BLIP blip_21
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_21 y_21 z_21 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_21 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_22 = 0
			DRAW_CORONA x_22 y_22 z_22 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_22 y_22 z_22 2.5 2.5 3.5 false
				REMOVE_BLIP blip_22
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_22 y_22 z_22 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_22 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_23 = 0
			DRAW_CORONA x_23 y_23 z_23 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_23 y_23 z_23 2.5 2.5 3.5 false
				REMOVE_BLIP blip_23
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_23 y_23 z_23 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_23 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF 
		
		IF flag_blip_24 = 0
			DRAW_CORONA x_24 y_24 z_24 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
			IF LOCATE_PLAYER_IN_CAR_3D player1 x_24 y_24 z_24 2.5 2.5 3.5 false
				REMOVE_BLIP blip_24
				++ counter_4x4_pickups
				ADD_ONE_OFF_SOUND x_24 y_24 z_24 SOUND_PART_MISSION_COMPLETE
				//timer_4x4 = timer_4x4 + timer_bonus
				flag_blip_24 = 1
				PRINT_WITH_NUMBER_NOW (T4X4_1C) counter_4x4_pickups 3000 1
			ENDIF
		ENDIF
	ENDIF 
	
	IF flag_intro1_before = 1
		IF flag_intro_jump = 0
		AND flag_intro < 4
			IF IS_BUTTON_PRESSED PAD1 CROSS
				intro_time_lapsed = 9501
				flag_intro = 3
				flag_intro_jump = 1
			ENDIF
		ENDIF
	ENDIF

	IF flag_intro = 0
		GET_GAME_TIMER timer_intro_start
		SET_FIXED_CAMERA_POSITION cam_4x4_X cam_4x4_y cam_4x4_z 0.0 0.0 0.0
		SET_MUSIC_DOES_FADE FALSE
		SET_FADING_COLOUR 0 0 0
		DO_FADE 1000 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		//WARP_PLAYER_FROM_CAR_TO_COORD player1 cam_4x4_X cam_4x4_y -100.0
		LOAD_SCENE cam_4x4_X cam_4x4_y cam_4x4_z
		POINT_CAMERA_AT_POINT 459.5 -382.2 14.0 JUMP_CUT
		DO_FADE 1000 FADE_IN
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		PRINT_WITH_NUMBER_NOW (T4X4_1A) checkpoint_time_limit 5000 1 
		flag_intro = 1
	ENDIF

	IF flag_intro_jump = 0
		GET_GAME_TIMER timer_intro_now
		intro_time_lapsed = timer_intro_now - timer_intro_start
	ENDIF
	
	IF intro_time_lapsed > 4000
	AND flag_intro = 1
		POINT_CAMERA_AT_POINT x_1 y_1 z_1 INTERPOLATION
		flag_intro = 2
	ENDIF
	
	IF intro_time_lapsed > 7000
	AND flag_intro = 2
		POINT_CAMERA_AT_POINT x_3 y_3 z_3 INTERPOLATION
		PRINT_NOW (T4X4_1B) 5000 1
		flag_intro = 3
	ENDIF
	

	IF intro_time_lapsed > 9500
	AND flag_intro = 3
		DO_FADE 1000 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		CLEAR_PRINTS
		//WARP_PLAYER_INTO_CAR player1 player_4x4
		GET_PLAYER_COORDINATES player1 player_x player_y player_z
		LOAD_SCENE player_x player_y player_z
		RESTORE_CAMERA_JUMPCUT
		SWITCH_WIDESCREEN OFF
		SET_PLAYER_CONTROL player1 ON
		IF NOT IS_CAR_DEAD player_4x4
			LOCK_CAR_DOORS player_4x4 CARLOCK_UNLOCKED
		ENDIF
		ALTER_WANTED_LEVEL player1 wanted_4x4
		SET_EVERYONE_IGNORE_PLAYER player1 OFF
		SET_FADING_COLOUR 0 0 0
		DO_FADE 1000 FADE_IN
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		SET_MUSIC_DOES_FADE TRUE
		flag_intro = 4
		flag_intro1_before = 1
	ENDIF
	
	IF flag_truck_1 = 0
		IF LOCATE_PLAYER_ANY_MEANS_2D player1 274.0 -905.0 10.0 10.0 FALSE //from ocean beach side
			//IF NOT IS_POINT_ON_SCREEN 266.0 -961.0 10.0	3.0
			CLEAR_AREA 278.0 -961.0 10.0 3.0 TRUE
			CREATE_CAR YANKEE 278.0 -961.0 10.0 truck_1
			CREATE_CHAR_INSIDE_CAR truck_1 PEDTYPE_CIVMALE MALE01 truck_driver1
			//SET_CAR_CRUISE_SPEED truck_1 0.0
			//CAR_SET_IDLE truck_1
			SET_CAR_HEADING truck_1 70.0 
			SET_CAR_FORWARD_SPEED truck_1 15.0
			CAR_GOTO_COORDINATES truck_1 121.5 -912.88 10.0
			//SET_CAR_TEMP_ACTION truck_1 TEMPACT_GOFORWARD 10000
			//SET_CAR_DRIVE_STRAIGHT_AHEAD truck_1 true
			flag_truck_1 = 1
		ENDIF
	ENDIF
	IF flag_truck_1 = 1
		IF NOT IS_CAR_DEAD truck_1
			IF LOCATE_CAR_2D truck_1 121.5 -912.88 4.0 4.0 FALSE
				CAR_WANDER_RANDOMLY truck_1
				flag_truck_1 = 2
			ENDIF
		ENDIF
	ENDIF			
	IF flag_truck_2 = 0
		IF LOCATE_PLAYER_ANY_MEANS_2D player1 239.0 -1081.0 10.0 10.0 FALSE //from ocean beach side
			//IF NOT IS_POINT_ON_SCREEN 210.1 -1136.5 10.3 3.0
			CREATE_CAR YANKEE 210.1 -1136.5 10.3 truck_2
			CREATE_CHAR_INSIDE_CAR truck_2 PEDTYPE_CIVMALE MALE01 truck_driver2 
			//SET_CAR_CRUISE_SPEED truck_2 0.0
			SET_CAR_HEADING truck_2 260.0 
			SET_CAR_FORWARD_SPEED truck_2 10.0
			SET_CAR_TEMP_ACTION truck_2 TEMPACT_GOFORWARD 20000
			//ADD_BLIP_FOR_CAR truck_2 blip_truck_2
			flag_truck_2 = 1
		ENDIF
	ENDIF
	IF flag_truck_2 = 1
		IF NOT IS_CAR_DEAD truck_2
			IF LOCATE_CAR_2D truck_2 252.4 -1142.4 4.0 4.0 FALSE
				CAR_WANDER_RANDOMLY truck_2
				flag_truck_2 = 2
			ENDIF
		ENDIF
	ENDIF			
	
	IF flag_intro > 3
		IF NOT IS_PLAYER_IN_MODEL player1 PCJ600
			WHILE NOT IS_PLAYER_IN_MODEL player1 PCJ600
				WAIT 0
				IF flag_timer = 1
					timer_4x4_secs = timer_4x4 / 1000
					IF timer_4x4_secs > 0
						PRINT_WITH_NUMBER_NOW (GETBIK1) timer_4x4_secs 2000 1
					ELSE
						PRINT_NOW (T4x4_F) 3000 1 		
						GOTO mission_4x4one_failed
					ENDIF
				ELSE
					PRINT_NOW ( GETBIK3 ) 1000 1
				ENDIF

				IF IS_PLAYER_IN_ANY_CAR player1
				AND NOT IS_PLAYER_IN_MODEL player1 PCJ600
					PRINT_NOW (T4x4_F) 3000 1 		
					GOTO mission_4x4one_failed
				ENDIF
					 
			ENDWHILE
		ENDIF
	ENDIF


ENDWHILE

IF counter_4x4_pickups = 24
	GOTO mission_4x4one_passed
ENDIF 

// --------------------------Mission failed-----------------------------------------------

mission_4x4one_failed:


PRINT_BIG ( M_FAIL ) 2000 1


RETURN
   




// -------------------------Mission passed-------------------------------------------------

mission_4x4one_passed:

timer_4x4 = timer_4x4 * -1
timer_4x4 = timer_4x4 + 120000
timer_4x4 = timer_4x4 / 1000


IF flag_4x4_mission1_passed = 0
	record_4x4_one = timer_4x4
	GOSUB time_calc
ENDIF

IF flag_4x4_mission1_passed = 1
	IF timer_4x4 < record_4x4_one
		record_4x4_one = timer_4x4
		GOSUB time_calc
	ELSE
		pcj_reward = 100
	ENDIF
ENDIF

PRINT_WITH_NUMBER_BIG ( M_PASS ) pcj_reward 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 pcj_reward
//REGISTER_4X4_THREE_TIME record_4x4_one

IF flag_4x4_mission1_passed = 0
	REGISTER_ODDJOB_MISSION_PASSED                                                                      
	flag_4x4_mission1_passed = 1
	PLAYER_MADE_PROGRESS 1 
ENDIF

//START_NEW_SCRIPT t4x4_mission2_loop
//START_NEW_SCRIPT multistorey_mission_loop

RETURN
		


// mission cleanup

mission_cleanup_4x4one:

RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN off
SET_PLAYER_CONTROL player1 on
SET_EVERYONE_IGNORE_PLAYER player1 OFF

REMOVE_BLIP blip_1
REMOVE_BLIP blip_2
REMOVE_BLIP blip_3
REMOVE_BLIP blip_4
REMOVE_BLIP blip_5
REMOVE_BLIP blip_6
REMOVE_BLIP blip_7
REMOVE_BLIP blip_8
REMOVE_BLIP blip_9
REMOVE_BLIP blip_10
REMOVE_BLIP blip_11
REMOVE_BLIP blip_12
REMOVE_BLIP blip_13
REMOVE_BLIP blip_14
REMOVE_BLIP blip_15
REMOVE_BLIP blip_16
REMOVE_BLIP blip_17
REMOVE_BLIP blip_18
REMOVE_BLIP blip_19
REMOVE_BLIP blip_20
REMOVE_BLIP blip_21
REMOVE_BLIP blip_22
REMOVE_BLIP blip_23
REMOVE_BLIP blip_24

MARK_CHAR_AS_NO_LONGER_NEEDED truck_driver1
MARK_CHAR_AS_NO_LONGER_NEEDED truck_driver2
MARK_MODEL_AS_NO_LONGER_NEEDED YANKEE

CLEAR_ONSCREEN_TIMER timer_4x4
flag_player_on_mission = 0
flag_launch_4x4_1_ok = 0
flag_usj_off = 0
//flag_player_on_4x4_mission = 0

MISSION_HAS_FINISHED
RETURN




time_calc:
	//set_record_4x4 = record_4x4_one * 1000
	REGISTER_FASTEST_TIME 16 record_4x4_one
	pcj_seconds = record_4x4_one 
	pcj_minutes = 0
	time_cactus:
	IF pcj_seconds > 59
		pcj_seconds = pcj_seconds - 60
		++ pcj_minutes
		GOTO time_cactus
	ENDIF
	PRINT_WITH_2_NUMBERS_NOW NEW_REC pcj_minutes pcj_seconds 5000 1
	pcj_reward = 1000
RETURN
