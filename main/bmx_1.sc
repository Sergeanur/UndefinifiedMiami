MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***************************************GRIPPED, SORTED*********************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_bmx_1

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_bmx_1_failed
ENDIF

GOSUB mission_cleanup_bmx_1
MISSION_END

// Variables for mission
/*
//VAR_INT player_4x4 wanted_4x4
VAR_INT counter_laps counter_gates
//VAR_INT flag_timer timer_4x4 timer_bonus
VAR_INT time_lapsed time_now time_start
VAR_INT time_off_bike time_bailed time_left_to_find_bike time_left_to_find_bike_secs
//VAR_INT flag_new_bmx_record_set
VAR_INT record_bmx_1
VAR_INT counter_bmx_1_reward bmx_1_reward
VAR_INT flag_bmx1_print	bmx1_minutes
VAR_INT kwayzee_biker1 kwayzee_biker2 kwayzee_biker3
VAR_INT kwayzee_moto1 kwayzee_moto2 kwayzee_moto3
VAR_INT flag_kwayzee1 flag_kwayzee2 flag_kwayzee3
VAR_INT var_kwayzee var_moto var_flag

//VAR_INT set_record_bmx_2
//VAR_INT bmx_car

VAR_INT blip_1 blip_2 blip_3
VAR_INT blip_4 blip_5 blip_6
VAR_INT blip_7 blip_8 blip_9
VAR_INT blip_10 blip_11 blip_12
VAR_INT blip_13 blip_14 blip_15
VAR_INT blip_16 blip_17 blip_18
VAR_INT blip_19 blip_20 blip_21 blip_22 blip_23

VAR_FLOAT x_1 y_1 z_1 
VAR_FLOAT x_2 y_2 z_2 
VAR_FLOAT x_3 y_3 z_3 
VAR_FLOAT x_4 y_4 z_4 
VAR_FLOAT x_5 y_5 z_5 
VAR_FLOAT x_6 y_6 z_6 
VAR_FLOAT x_7 y_7 z_7 
VAR_FLOAT x_8 y_8 z_8 
VAR_FLOAT x_9 y_9 z_9 
VAR_FLOAT x_10 y_10 z_10 
VAR_FLOAT x_11 y_11 z_11 
VAR_FLOAT x_12 y_12 z_12 
VAR_FLOAT x_13 y_13 z_13 
VAR_FLOAT x_14 y_14 z_14 
VAR_FLOAT x_15 y_15 z_15 
VAR_FLOAT x_16 y_16 z_16 
VAR_FLOAT x_17 y_17 z_17 
VAR_FLOAT x_18 y_18 z_18 
VAR_FLOAT x_19 y_19 z_19 
VAR_FLOAT x_20 y_20 z_20 
VAR_FLOAT x_21 y_21 z_21 
VAR_FLOAT x_22 y_22 z_22 
VAR_FLOAT x_23 y_23 z_23 
*/
// ************** EXCLUSIVE -to be taken out!!! ***********************

//VAR_INT flag_timer timer_4x4 timer_bonus
VAR_INT flag_new_bmx_record_set

VAR_INT barrel_1 barrel_2 barrel_3 barrel_4
/*
VAR_FLOAT x_1 y_1 z_1 
VAR_FLOAT x_2 y_2 z_2 
VAR_FLOAT x_3 y_3 z_3 
VAR_FLOAT x_4 y_4 z_4 
VAR_FLOAT x_5 y_5 z_5 
VAR_FLOAT x_6 y_6 z_6 
VAR_FLOAT x_7 y_7 z_7 
VAR_FLOAT x_8 y_8 z_8 
VAR_FLOAT x_9 y_9 z_9 
VAR_FLOAT x_10 y_10 z_10 
VAR_FLOAT x_11 y_11 z_11 
VAR_FLOAT x_12 y_12 z_12 
VAR_FLOAT x_13 y_13 z_13 
VAR_FLOAT x_14 y_14 z_14 
VAR_FLOAT x_15 y_15 z_15 
VAR_FLOAT x_16 y_16 z_16 
VAR_FLOAT x_17 y_17 z_17 
VAR_FLOAT x_18 y_18 z_18 
VAR_FLOAT x_19 y_19 z_19 
VAR_FLOAT x_20 y_20 z_20 

VAR_INT blip_1 blip_2 blip_3
VAR_INT blip_4 blip_5 blip_6
VAR_INT blip_7 blip_8 blip_9
VAR_INT blip_10 blip_11 blip_12
VAR_INT blip_13 blip_14 blip_15
VAR_INT blip_16 blip_17 blip_18	blip_19 blip_20
*/
// ****************************************Mission Start************************************


mission_start_bmx_1:

IF flag_bmx_1_passed = 0
	REGISTER_MISSION_GIVEN
ENDIF
SCRIPT_NAME bmx_1 
flag_player_on_mission = 1
LOAD_MISSION_TEXT bmx_1

//flag_player_on_4x4_mission = 1

//PRINT_BIG (BMX_1) 5000 2

WAIT 0

//Set Variables

counter_laps = 0
counter_gates = 1

timer_4x4 = 0
time_lapsed = 0

record_temp = 0
flag_new_bmx_record_set = 0
flag_timer = 0
flag_bmx1_print = 0

flag_kwayzee1 = 0
flag_kwayzee2 = 0
flag_kwayzee3 = 0

//counter_bmx_1_reward = 3  // TEST !!!!!

//Set Coords

x_1 = -456.0    
y_1 = 1417.9
z_1 = 14.24

x_2 = -467.8    
y_2 = 1398.7
z_2 = 8.15

x_3 = -488.4   
y_3 = 1425.9 
z_3 = 14.5

x_4 = -516.8   
y_4 = 1409.1 
z_4 = 12.6

x_5 = -529.6   
y_5 = 1430.0 
z_5 = 9.6

x_6 = -556.4 
y_6 = 1422.7 
z_6 = 10.0

x_7 = -533.55   
y_7 = 1455.6 
z_7 = 10.3

x_8 = -560.0   
y_8 = 1460.0 
z_8 = 10.3 

x_9 = -528.5   
y_9 = 1476.9 
z_9 = 10.5

x_10 = -535.0   
y_10 = 1500.0 
z_10 = 9.8

x_11 = -502.4   
y_11 = 1474.6
z_11 = 11.3

x_12 = -500.6 
y_12 = 1507.1 
z_12 = 9.8

x_13 = -472.2    
y_13 = 1490.5
z_13 = 11.0

x_14 = -499.3      
y_14 = 1447.5
z_14 = 15.5

x_15 = -450.2  
y_15 = 1481.4
z_15 = 9.8


x_16 = -440.6    
y_16 = 1455.42
z_16 = 9.8


x_17 = -429.0    
y_17 = 1491.8
z_17 = 10.1

x_18 = -418.0   
y_18 = 1432.1 
z_18 = 10.0

x_19 = -445.0    
y_19 = 1439.5
z_19 = 10.4

x_20 = -453.5  
y_20 = 1434.6
z_20 = 10.0

//Mission Script 
 
GET_GAME_TIMER time_start		
//STORE_CAR_PLAYER_IS_IN player1 bmx_car 		
ADD_BLIP_FOR_COORD x_1 y_1 z_1 blip_1

IF counter_bmx_1_reward	> 0
	REQUEST_MODEL barrel4
	WHILE NOT HAS_MODEL_LOADED barrel4
		WAIT 0
	ENDWHILE

	//GET_GROUND_Z_FOR_3D_COORD -413.0 1434.4 50.0 ground_z
	CREATE_OBJECT barrel4 -413.0 1434.4 -100.0 barrel_1
	SET_OBJECT_COLLISION barrel_1 TRUE
	//SET_OBJECT_DYNAMIC barrel_1 TRUE

	CREATE_OBJECT barrel4 -405.36 1447.12 -100.0 barrel_2
	SET_OBJECT_COLLISION barrel_2 TRUE
	//SET_OBJECT_DYNAMIC barrel_2 TRUE

	CREATE_OBJECT barrel4 -400.0 1455.5 -100.0  barrel_3
	SET_OBJECT_COLLISION barrel_3 TRUE
	//SET_OBJECT_DYNAMIC barrel_3 TRUE

	CREATE_OBJECT barrel4 -402.73 1465.0 -100.0  barrel_4
	SET_OBJECT_COLLISION barrel_4 TRUE
	//SET_OBJECT_DYNAMIC barrel_4 TRUE
ENDIF

IF counter_bmx_1_reward	> 2
	REQUEST_MODEL HNa
	REQUEST_MODEL HNb
	REQUEST_MODEL machete
	WHILE NOT HAS_MODEL_LOADED HNa
	OR NOT HAS_MODEL_LOADED HNb
	OR NOT HAS_MODEL_LOADED machete
		WAIT 0
	ENDWHILE

	CREATE_CAR sanchez -478.7 1524.0 10.4 kwayzee_moto1
	CHANGE_CAR_COLOUR kwayzee_moto1 0 0
	SET_CAR_HEADING kwayzee_moto1 190.0
	CREATE_CHAR_INSIDE_CAR kwayzee_moto1 PEDTYPE_CIVMALE HNa kwayzee_biker1
	GIVE_WEAPON_TO_CHAR kwayzee_biker1 WEAPONTYPE_MACHETE 0
	//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kwayzee_biker1 player1
	SET_CAR_MISSION kwayzee_moto1 MISSION_RAMPLAYER_FARAWAY
	SET_CAR_STRAIGHT_LINE_DISTANCE kwayzee_moto1 255

	CREATE_CAR sanchez -476.7 1522.0 10.4 kwayzee_moto2
	CHANGE_CAR_COLOUR kwayzee_moto2 0 0
	SET_CAR_HEADING kwayzee_moto2 190.0
	CREATE_CHAR_INSIDE_CAR kwayzee_moto2 PEDTYPE_CIVMALE HNa kwayzee_biker2
	GIVE_WEAPON_TO_CHAR kwayzee_biker2 WEAPONTYPE_MACHETE 0
	//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kwayzee_biker2 player1
	SET_CAR_MISSION kwayzee_moto2 MISSION_RAMPLAYER_FARAWAY
	SET_CAR_STRAIGHT_LINE_DISTANCE kwayzee_moto2 255
	
	CREATE_CAR sanchez -480.7 1525.0 10.4 kwayzee_moto3
	CHANGE_CAR_COLOUR kwayzee_moto3 0 0
	SET_CAR_HEADING kwayzee_moto3 190.0
	CREATE_CHAR_INSIDE_CAR kwayzee_moto3 PEDTYPE_CIVMALE HNa kwayzee_biker3
	GIVE_WEAPON_TO_CHAR kwayzee_biker3 WEAPONTYPE_MACHETE 0
	//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS kwayzee_biker3 player1
	SET_CAR_MISSION kwayzee_moto3 MISSION_RAMPLAYER_FARAWAY
	SET_CAR_STRAIGHT_LINE_DISTANCE kwayzee_moto3 255

ENDIF



WHILE counter_laps < 2

	WAIT 0

	GET_GAME_TIMER time_now
	time_lapsed = time_now - time_start
	//time_lapsed = time_lapsed / 1000

	IF flag_timer = 0
		DISPLAY_ONSCREEN_TIMER_WITH_STRING time_lapsed TIMER_UP R_TIME
		flag_timer = 1
	ENDIF

	IF flag_bmx1_print = 0
		PRINT_NOW (BMX_HOW) 5000 1
		flag_bmx1_print = 1
	ENDIF

	IF flag_bmx1_print = 1
	AND time_lapsed > 5000
		PRINT_NOW (BMXREW1) 5000 1
		flag_bmx1_print = 2
	ENDIF

	IF flag_bmx1_print = 2
	AND time_lapsed > 10000
		PRINT_NOW (BMXREW2) 5000 1
		flag_bmx1_print = 3
	ENDIF
	

	IF counter_gates = 1
		DRAW_CORONA x_1 y_1 z_1 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_1 y_1 z_1 3.0 3.0 3.0 false
			REMOVE_BLIP blip_1
			ADD_ONE_OFF_SOUND x_1 y_1 z_1 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_2 y_2 z_2 blip_2
			++ counter_gates
		ENDIF
	ENDIF 
	
	IF counter_gates = 2
		DRAW_CORONA x_2 y_2 z_2 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_2 y_2 z_2 3.0 3.0 3.0 false
			REMOVE_BLIP blip_2
			ADD_ONE_OFF_SOUND x_2 y_2 z_2 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_3 y_3 z_3 blip_3
			++ counter_gates
		ENDIF
	ENDIF 
	
	IF counter_gates = 3
		DRAW_CORONA x_3 y_3 z_3 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_3 y_3 z_3 3.0 3.0 3.0 false
			REMOVE_BLIP blip_3
			ADD_ONE_OFF_SOUND x_3 y_3 z_3 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_4 y_4 z_4 blip_4
			++ counter_gates
		ENDIF
	ENDIF 
	
	IF counter_gates = 4
		DRAW_CORONA x_4 y_4 z_4 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_4 y_4 z_4 3.0 3.0 3.0 false
			REMOVE_BLIP blip_4
			ADD_ONE_OFF_SOUND x_4 y_4 z_4 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_5 y_5 z_5 blip_5
			++ counter_gates
		ENDIF
	ENDIF 
	
	IF counter_gates = 5
		DRAW_CORONA x_5 y_5 z_5 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_5 y_5 z_5 3.0 3.0 3.0 false
			REMOVE_BLIP blip_5
			ADD_ONE_OFF_SOUND x_12 y_12 z_12 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_6 y_6 z_6 blip_6
			++ counter_gates
		ENDIF
	ENDIF 
	
	IF counter_gates = 6
		DRAW_CORONA x_6 y_6 z_6 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_6 y_6 z_6 3.0 3.0 3.0 false
			REMOVE_BLIP blip_6
			ADD_ONE_OFF_SOUND x_6 y_6 z_6 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_7 y_7 z_7 blip_7
			++ counter_gates
		ENDIF
	ENDIF 
	
	IF counter_gates = 7
		DRAW_CORONA x_7 y_7 z_7 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_7 y_7 z_7 3.0 3.0 3.0 false
			REMOVE_BLIP blip_7
			ADD_ONE_OFF_SOUND x_7 y_7 z_7 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_8 y_8 z_8 blip_8
			++ counter_gates
		ENDIF
	ENDIF 
	
	IF counter_gates = 8
		DRAW_CORONA x_8 y_8 z_8 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_8 y_8 z_8 3.0 3.0 3.0 false
			REMOVE_BLIP blip_8
			ADD_ONE_OFF_SOUND x_8 y_8 z_8 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_9 y_9 z_9 blip_9
			++ counter_gates
		ENDIF
	ENDIF 
	
	IF counter_gates = 9
		DRAW_CORONA x_9 y_9 z_9 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_9 y_9 z_9 3.0 3.0 3.0 false
			REMOVE_BLIP blip_9
			ADD_ONE_OFF_SOUND x_9 y_9 z_9 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_10 y_10 z_10 blip_10
			++ counter_gates
			IF flag_bmx1_print = 3
			AND time_lapsed > 12000
			AND	counter_bmx_1_reward > 1
				FORCE_WEATHER WEATHER_RAINY
				PRINT_NOW (BMXRAIN) 4000 1
				flag_bmx1_print = 4
			ENDIF
		ENDIF
	ENDIF 
	
	IF counter_gates = 10
		DRAW_CORONA x_10 y_10 z_10 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_10 y_10 z_10 3.0 3.0 3.0 false
			REMOVE_BLIP blip_10
			ADD_ONE_OFF_SOUND x_10 y_10 z_10 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_11 y_11 z_11 blip_11
			++ counter_gates
		ENDIF
	ENDIF 
	
	IF counter_gates = 11
		DRAW_CORONA x_11 y_11 z_11 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_11 y_11 z_11 3.0 3.0 3.0 false
			REMOVE_BLIP blip_11
			ADD_ONE_OFF_SOUND x_11 y_11 z_11 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_12 y_12 z_12 blip_12
			++ counter_gates
		ENDIF
	ENDIF 
	
	IF counter_gates = 12
		DRAW_CORONA x_12 y_12 z_12 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_12 y_12 z_12 3.0 3.0 3.0 false
			REMOVE_BLIP blip_12
			ADD_ONE_OFF_SOUND x_12 y_12 z_12 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_13 y_13 z_13 blip_13
			++ counter_gates
		ENDIF
	ENDIF 
	
	IF counter_gates = 13
		DRAW_CORONA x_13 y_13 z_13 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_13 y_13 z_13 3.0 3.0 3.0 false
			REMOVE_BLIP blip_13
			ADD_ONE_OFF_SOUND x_13 y_13 z_13 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_14 y_14 z_14 blip_14
			++ counter_gates
		ENDIF
	ENDIF 
	
	IF counter_gates = 14
		DRAW_CORONA x_14 y_14 z_14 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_14 y_14 z_14 3.0 3.0 3.0 false
			REMOVE_BLIP blip_14
			ADD_ONE_OFF_SOUND x_14 y_14 z_14 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_15 y_15 z_15 blip_15
			++ counter_gates
		ENDIF
	ENDIF 

	IF counter_gates = 15
		DRAW_CORONA x_15 y_15 z_15 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_15 y_15 z_15 3.0 3.0 3.0 false
			REMOVE_BLIP blip_15
			ADD_ONE_OFF_SOUND x_15 y_15 z_15 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_16 y_16 z_16 blip_16
			++ counter_gates
		ENDIF
	ENDIF 

	IF counter_gates = 16
		DRAW_CORONA x_16 y_16 z_16 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_16 y_16 z_16 3.0 3.0 3.0 false
			REMOVE_BLIP blip_16
			ADD_ONE_OFF_SOUND x_16 y_16 z_16 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_17 y_17 z_17 blip_17
			++ counter_gates
		ENDIF
	ENDIF 
	
	IF counter_gates = 17
		DRAW_CORONA x_17 y_17 z_17 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_17 y_17 z_17 3.0 3.0 3.0 false
			REMOVE_BLIP blip_17
			ADD_ONE_OFF_SOUND x_17 y_17 z_17 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_18 y_18 z_18 blip_18
			++ counter_gates
		ENDIF
	ENDIF 
	
	IF counter_gates = 18
		DRAW_CORONA x_18 y_18 z_18 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_18 y_18 z_18 3.0 3.0 3.0 false
			REMOVE_BLIP blip_18
			ADD_ONE_OFF_SOUND x_18 y_18 z_18 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD x_19 y_19 z_19 blip_19
			++ counter_gates
		ENDIF
	ENDIF 
	
	IF counter_gates = 19
		DRAW_CORONA x_19 y_19 z_19 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_19 y_19 z_19 3.0 3.0 3.0 false
			REMOVE_BLIP blip_19
			ADD_ONE_OFF_SOUND x_19 y_19 z_19 SOUND_PART_MISSION_COMPLETE
			counter_gates = 1
			++ counter_laps
			IF counter_laps < 3
				ADD_BLIP_FOR_COORD x_1 y_1 z_1 blip_1
			ENDIF
		ENDIF
	ENDIF 
	/*
	IF counter_gates = 20
		DRAW_CORONA x_20 y_20 z_20 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_20 y_20 z_20 3.0 3.0 3.0 false
			REMOVE_BLIP blip_20
			ADD_ONE_OFF_SOUND x_20 y_20 z_20 SOUND_PART_MISSION_COMPLETE
			counter_gates = 1
			++ counter_laps
			IF counter_laps < 3
				ADD_BLIP_FOR_COORD x_1 y_1 z_1 blip_1
			ENDIF
		ENDIF
	ENDIF 
	*/
	var_kwayzee = kwayzee_biker1
	var_moto = kwayzee_moto1
	var_flag = flag_kwayzee1
	GOSUB kwayzee_stuff
	IF var_flag = 1
		flag_kwayzee1 = 1
	ENDIF
	
	var_kwayzee = kwayzee_biker2
	var_moto = kwayzee_moto2
	var_flag = flag_kwayzee2
	GOSUB kwayzee_stuff
	IF var_flag = 1
		flag_kwayzee2 = 1
	ENDIF
	
	var_kwayzee = kwayzee_biker3
	var_moto = kwayzee_moto3
	var_flag = flag_kwayzee3
	GOSUB kwayzee_stuff
	IF var_flag = 1
		flag_kwayzee3 = 1
	ENDIF
		

	IF NOT IS_PLAYER_IN_MODEL player1 sanchez
		GET_GAME_TIMER time_bailed
		WHILE NOT time_left_to_find_bike < 0
			WAIT 0
			GET_GAME_TIMER time_now
			time_off_bike = time_now - time_bailed
			time_left_to_find_bike = 15000 - time_off_bike
			time_left_to_find_bike_secs = time_left_to_find_bike / 1000
			PRINT_WITH_NUMBER_NOW (GETBIK2) time_left_to_find_bike_secs 2000 1
			IF IS_PLAYER_IN_MODEL player1 sanchez
				time_left_to_find_bike = 1
				GOTO bmx_boogie
			ENDIF
		ENDWHILE 		
		GOTO mission_bmx_1_failed
	ENDIF
	
	bmx_boogie:

ENDWHILE

IF counter_laps = 2
	time_lapsed = time_lapsed / 1000
	IF flag_bmx_1_passed = 0
		record_bmx_1 = time_lapsed
		flag_new_bmx_record_set	= 1
		counter_bmx_1_reward = 1
		GOSUB timing_malarkey
	ELSE
		IF time_lapsed < record_bmx_1
			record_bmx_1 = time_lapsed
			flag_new_bmx_record_set	= 1
			++ counter_bmx_1_reward
			GOSUB timing_malarkey
		ENDIF
	ENDIF

	IF flag_new_bmx_record_set = 1
		//set_record_bmx_1 = record_bmx_1 * 1000
		REGISTER_FASTEST_TIME 17 record_bmx_1
		GOTO mission_bmx_1_passed
	ENDIF
ENDIF 

// --------------------------Mission failed-----------------------------------------------

mission_bmx_1_failed:


PRINT_BIG ( M_FAIL ) 5000 1
PRINT_NOW ( BMXFAIL ) 5000 1

RETURN
   




// -------------------------Mission passed-------------------------------------------------

mission_bmx_1_passed:

bmx_1_reward = counter_bmx_1_reward * 100
//PRINT_WITH_NUMBER_NOW (BMX_REC) record_bmx_1 5000 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) bmx_1_reward 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 bmx_1_reward
//REGISTER_BMX_1_TIME record_bmx_1

IF flag_bmx_1_passed = 0
	//REGISTER_MISSION_PASSED bmx_1
	flag_bmx_1_passed = 1
	PLAYER_MADE_PROGRESS 1
	REGISTER_ODDJOB_MISSION_PASSED                                                                       
ENDIF

//START_NEW_SCRIPT t4x4_mission2_loop
//START_NEW_SCRIPT multistorey_mission_loop

RETURN
		


// mission cleanup

mission_cleanup_bmx_1:

time_left_to_find_bike = 1

RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN off
SET_PLAYER_CONTROL player1 on

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
//REMOVE_BLIP blip_20
MARK_MODEL_AS_NO_LONGER_NEEDED barrel4
MARK_MODEL_AS_NO_LONGER_NEEDED machete
MARK_MODEL_AS_NO_LONGER_NEEDED HNa
MARK_MODEL_AS_NO_LONGER_NEEDED HNb

MARK_CHAR_AS_NO_LONGER_NEEDED kwayzee_biker1
MARK_CAR_AS_NO_LONGER_NEEDED kwayzee_moto1
MARK_CHAR_AS_NO_LONGER_NEEDED kwayzee_biker2
MARK_CAR_AS_NO_LONGER_NEEDED kwayzee_moto2
MARK_CHAR_AS_NO_LONGER_NEEDED kwayzee_biker3
MARK_CAR_AS_NO_LONGER_NEEDED kwayzee_moto3


DELETE_OBJECT barrel_1
DELETE_OBJECT barrel_2
DELETE_OBJECT barrel_3
DELETE_OBJECT barrel_4

RELEASE_WEATHER


CLEAR_ONSCREEN_TIMER time_lapsed
flag_player_on_mission = 0
//flag_player_on_4x4_mission = 0

MISSION_HAS_FINISHED
RETURN




timing_malarkey:
	bmx1_minutes = 0
	time_coctos:
	IF time_lapsed > 59
		time_lapsed = time_lapsed - 60
		++ bmx1_minutes
		GOTO time_coctos
	ENDIF
	PRINT_WITH_2_NUMBERS_NOW NEW_REC bmx1_minutes time_lapsed 5000 1
RETURN

kwayzee_stuff:
	IF NOT IS_CHAR_DEAD var_kwayzee
	AND var_flag = 0
		IF NOT IS_CAR_DEAD var_moto
			IF NOT IS_CHAR_IN_CAR var_kwayzee var_moto
			OR NOT IS_PLAYER_IN_ANY_CAR player1
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS var_kwayzee player1
				var_flag = 1
			ENDIF
		ELSE
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS var_kwayzee player1
			var_flag = 1
		ENDIF
	ENDIF
RETURN

