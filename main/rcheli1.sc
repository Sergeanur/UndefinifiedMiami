MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ****************************		rcbuggy1 - Job 'Road Kill'	  **************************
// *********Carl Pearson, delivery man.  He must not complete his deliveries.***************
// *********blip on radar for bloke driving a van. Player must kill him before he completes* 
// *********deliveries. Set car to wander randomly, then after a set time, set car to goto** 
// *********coordinates. If he reaches location successfully, mission fails***************** 
// ******************************(discuss mechanics of this?).******************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************



{
SCRIPT_NAME RCHELI

// Mission start stuff
GOSUB mission_start_rcbuggy1

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_rcbuggy1_failed
ENDIF

GOSUB mission_cleanup_rcbuggy1

MISSION_END

//teststuff
VAR_INT cartest
VAR_INT mantest

 
// Variables for mission
VAR_INT vanforrc
VAR_INT remote_copter
VAR_INT timer_for_rcraider_coronas
VAR_INT previous_wanted_level 

//flags
VAR_INT player_in_topfun_van
VAR_INT pack_counter
VAR_INT pack1  
VAR_INT pack2  
VAR_INT pack3  
VAR_INT pack4  
VAR_INT pack5  
VAR_INT pack6  
VAR_INT pack7  
VAR_INT pack8  
VAR_INT pack9  
VAR_INT pack10  
VAR_INT pack11  
VAR_INT pack12
VAR_INT pack13
VAR_INT pack14  
VAR_INT pack15
VAR_INT pack16
VAR_INT pack17
VAR_INT pack18
VAR_INT pack19
VAR_INT pack20



//coords
VAR_FLOAT pack1x pack1y pack1z
VAR_FLOAT pack2x pack2y pack2z 
VAR_FLOAT pack3x pack3y pack3z 
VAR_FLOAT pack4x pack4y pack4z 
VAR_FLOAT pack5x pack5y pack5z 
VAR_FLOAT pack6x pack6y pack6z 
VAR_FLOAT pack7x pack7y pack7z 
VAR_FLOAT pack8x pack8y pack8z 
VAR_FLOAT pack9x pack9y pack9z 
VAR_FLOAT pack10x pack10y pack10z 
VAR_FLOAT pack11x pack11y pack11z 
VAR_FLOAT pack12x pack12y pack12z 
VAR_FLOAT pack13x pack13y pack13z 
VAR_FLOAT pack14x pack14y pack14z 
VAR_FLOAT pack15x pack15y pack15z 
VAR_FLOAT pack16x pack16y pack16z 
VAR_FLOAT pack17x pack17y pack17z
VAR_FLOAT pack18x pack18y pack18z
VAR_FLOAT pack19x pack19y pack19z
VAR_FLOAT pack20x pack20y pack20z   
//blips

VAR_INT pack1blip
VAR_INT pack2blip
VAR_INT pack3blip
VAR_INT pack4blip
VAR_INT pack5blip
VAR_INT pack6blip
VAR_INT pack7blip
VAR_INT pack8blip
VAR_INT pack9blip
VAR_INT pack10blip
VAR_INT pack11blip
VAR_INT pack12blip
VAR_INT pack13blip
VAR_INT pack14blip
VAR_INT pack15blip
VAR_INT pack16blip
VAR_INT pack17blip
VAR_INT pack18blip
VAR_INT pack19blip
VAR_INT pack20blip

//time stuff
VAR_INT race_timer_seconds_heli1
VAR_INT race_timer_mins_heli1
VAR_INT race_timer_seconds2_heli1 playerpassedrcheli



// **************************************** Mission Start **********************************

mission_start_rcbuggy1:				  

IF playerpassedrcheli = 0
	REGISTER_MISSION_GIVEN
ENDIF

flag_player_on_mission = 1


WAIT 0

LOAD_MISSION_TEXT RCHELI1


REQUEST_MODEL rcraider

WHILE NOT HAS_MODEL_LOADED rcraider
WAIT 0
ENDWHILE

//counters
timer_for_rcraider_coronas = 0
pack_counter = 20

//set flags
player_in_topfun_van = 0

pack1 = 0  
pack2 = 0  
pack3 = 0
pack4 = 0 
pack5 = 0  
pack6 = 0  
pack7 = 0  
pack8 = 0  
pack9 = 0  
pack10 = 0  
pack11 = 0  
pack12 = 0
pack13 = 0  
pack14 = 0  
pack15 = 0
pack16 = 0
pack17 = 0
pack18 = 0
pack19 = 0
pack20 = 0

//set coords
pack1x = -1290.792//-1262.96
pack1y = -1253.498//-1238.56		 //1
pack1z = 21.376//24.70

pack2x = -1369.82 		  //2
pack2y = -1256.41
pack2z = 18.17883

pack3x = -1482.534		//3
pack3y = -1254.653
pack3z = 14.86

pack4x = -1573.508//-1638.171		//3
pack4y = -1239.667//-1256.501
pack4z = 21.762//14.868

pack5x = -1785.86	   //4
pack5y = -1343.75
pack5z = 15.97

pack6x = -1793.35	   //5
pack6y = -1248.55
pack6z = 22.08

pack7x = -1689.2056//-1793.91	   //6
pack7y = -1103.073//-1130.54
pack7z = 14.035994//14.87

pack8x = -1774.52295//-1807.87	//7
pack8y = -1060.862//-1074.18
pack8z = 14.965479//14.87

pack9x = -1793.91	//9
pack9y = -908.69	
pack9z = 14.86		

pack10x = -1788.038574//-1765.252
pack10y = -884.222351//-1007.855225
pack10z = 42.331383//14.868	

pack11x	= -1646.72 //10
pack11y	= -929.44
pack11z = 13.94

pack12x	= -1563.4743	//11
pack12y	= -814.635498
pack12z = 16.210712

pack13x = -1514.844//-1356.59  //14
pack13y = -951.425//-960.93
pack13z = 15.168//24.63

pack14x = -1488.259766//-1435.85	//12
pack14y	= -892.678589//-912.58
pack14z	= 26.174585//58.3467

pack15x = -1355.305//-1515.407 //13
pack15y = -951.825//-958.288//-969.344
pack15z = 15.168//24.67

pack16x = -1352.431396	 //15
pack16y = -751.111023
pack16z = 25.788078

pack17x = -1240.26	  //16
pack17y = -841.24
pack17z = 22.30

pack18x = -1253.92	//18
pack18y = -1056.68
pack18z = 13.94

pack19x = -1270.146	  //19
pack19y = -1151.49
pack19z = 22.30

pack20x = -1270.4703//-1269.244
pack20y = -1272.444//-1252.97
pack20z = 14.866//14.866

SET_POLICE_IGNORE_PLAYER player1 ON
CLEAR_WANTED_LEVEL player1
STORE_CAR_PLAYER_IS_IN player1 vanforrc
CLEAR_AREA -1237.285 -1232.1212 14.77 10.0 TRUE
STORE_WANTED_LEVEL player1 previous_wanted_level




WAIT 0

//getting the player in the car
IF NOT IS_CAR_DEAD vanforrc
	IF IS_PLAYER_SITTING_IN_CAR player1 vanforrc
	
		 LOCK_CAR_DOORS vanforrc CARLOCK_LOCKED
		 SWITCH_WIDESCREEN ON
		 		 
		 GIVE_REMOTE_CONTROLLED_MODEL_TO_PLAYER player1 -1237.285 -1232.1212 14.77 337.839 rcraider  
		 GET_REMOTE_CONTROLLED_CAR player1 remote_copter
		
		 SET_FIXED_CAMERA_POSITION -1237.809692 -1227.21 19.330381 0.0 0.0 0.0 
		 POINT_CAMERA_AT_POINT -1237.587158 -1227.993530 18.749018 JUMP_CUT  

	ENDIF
ENDIF

DO_FADE 1500 FADE_IN


WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


IF player_in_topfun_van = 0

		 TIMERA = 0

		 WHILE TIMERA < 5000
		   			   
		 WAIT 0
		 
		 PRINT_NOW ( RCH1_6 ) 5000 2
		
		 DRAW_CORONA pack2x pack2y pack2z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		 DRAW_CORONA pack8x pack8y pack8z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		 					
			 IF IS_BUTTON_PRESSED PAD1 cross
			 	GOTO endrchelilable
			 ENDIF

		 ENDWHILE

			 		 
	 LOAD_SCENE -1357.8689 -1258.004 21.487 
	 SET_FIXED_CAMERA_POSITION -1357.8689 -1258.004 21.487 -0.948 0.121 -0.2947
	 POINT_CAMERA_AT_POINT -1358.82 -1257.88 21.192 JUMP_CUT
	 	 
		 TIMERA = 0

		 WHILE TIMERA < 5000
		   			   
		 WAIT 0
		 
		 PRINT_NOW ( RCH1_7 ) 5000 2
		
		 DRAW_CORONA pack2x pack2y pack2z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		 DRAW_CORONA pack8x pack8y pack8z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		 					
			 IF IS_BUTTON_PRESSED PAD1 cross
			 	GOTO endrchelilable
			 ENDIF

		 ENDWHILE

			 			 
	 LOAD_SCENE	-1786.243 -1073.31 15.304
	 POINT_CAMERA_AT_POINT -1785.705 -1072.465 15.27 JUMP_CUT
	 SET_FIXED_CAMERA_POSITION -1786.243 -1073.31 15.304 0.0 0.0 0.0 
	 	 
		 TIMERA = 0

		 WHILE TIMERA < 5000
		   			   
		 WAIT 0
		 
		 PRINT_NOW ( RCH1_8 ) 0500 2
		
		 DRAW_CORONA pack2x pack2y pack2z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		 DRAW_CORONA pack8x pack8y pack8z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100

		 					
			 IF IS_BUTTON_PRESSED PAD1 cross
			 	GOTO endrchelilable
			 ENDIF

		 ENDWHILE

			 
endrchelilable:
			 
		 IF NOT IS_CAR_DEAD remote_copter
		 	POINT_CAMERA_AT_CAR remote_copter CAM_ON_A_STRING JUMP_CUT
		 ENDIF
		 
		 CLEAR_SMALL_PRINTS 
		 
		 DISPLAY_ONSCREEN_TIMER_WITH_STRING timer_for_rcraider_coronas TIMER_UP ( RCH1_5 ) 
		 DISPLAY_ONSCREEN_COUNTER_WITH_STRING pack_counter COUNTER_DISPLAY_NUMBER ( RCH1_4 )

		 SET_PLAYER_CONTROL player1 ON
		 SWITCH_WIDESCREEN OFF

		 player_in_topfun_van = 1

ENDIF





WHILE pack_counter > 0

WAIT 0



IF pack1 < 2
	IF pack1 = 0
		ADD_BLIP_FOR_COORD pack1x pack1y pack1z pack1blip
		pack1 = 1
	ENDIF
	IF NOT IS_CAR_DEAD remote_copter
		DRAW_CORONA pack1x pack1y pack1z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
	   		IF LOCATE_CAR_3D remote_copter pack1x pack1y pack1z 2.0 2.0 2.0	FALSE
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				REMOVE_BLIP pack1blip 
				pack_counter--
				pack1 = 2
			ENDIF
	ENDIF
ENDIF

IF pack1 = 2
	IF pack2 < 2
		IF pack2 = 0
			ADD_BLIP_FOR_COORD pack2x pack2y pack2z pack2blip
			pack2 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack2x pack2y pack2z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack2x pack2y pack2z 2.0 2.0 2.0	FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack2blip
					pack_counter--
					pack2 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack2 = 2
	IF pack3 < 2
		IF pack3 = 0
			ADD_BLIP_FOR_COORD pack3x pack3y pack3z pack3blip
			pack3 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack3x pack3y pack3z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack3x pack3y pack3z 2.0 2.0 2.0	FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack3blip
					pack_counter--
					pack3 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack3 = 2
	IF pack4 < 2
		IF pack4 = 0
			ADD_BLIP_FOR_COORD pack4x pack4y pack4z pack4blip
			pack4 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack4x pack4y pack4z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack4x pack4y pack4z 2.0 2.0 2.0	FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack4blip
					pack_counter--
					pack4 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack4 = 2
	IF pack5 < 2
		IF pack5 = 0
			ADD_BLIP_FOR_COORD pack5x pack5y pack5z pack5blip
			pack5 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack5x pack5y pack5z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack5x pack5y pack5z 2.0 2.0 2.0	FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack5blip
					pack_counter--
					pack5 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack5 = 2
	IF pack6 < 2
		IF pack6 = 0
			ADD_BLIP_FOR_COORD pack6x pack6y pack6z pack6blip
			pack6 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack6x pack6y pack6z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack6x pack6y pack6z 2.0 2.0 2.0	FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack6blip
					pack_counter--
					pack6 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack6 = 2
	IF pack7 < 2
		IF pack7 = 0
			ADD_BLIP_FOR_COORD pack7x pack7y pack7z pack7blip
			pack7 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack7x pack7y pack7z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack7x pack7y pack7z 2.0 2.0 2.0	FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack7blip
					pack_counter--
					pack7 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack7 = 2
	IF pack8 < 2
		IF pack8 = 0
			ADD_BLIP_FOR_COORD pack8x pack8y pack8z pack8blip
			pack8 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack8x pack8y pack8z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack8x pack8y pack8z 2.0 2.0 2.0	FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack8blip
					pack_counter--
					pack8 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack8 = 2
	IF pack9 < 2
		IF pack9 = 0
			ADD_BLIP_FOR_COORD pack9x pack9y pack9z pack9blip
			pack9 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack9x pack9y pack9z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack9x pack9y pack9z 2.0 2.0 2.0	FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack9blip
					pack_counter--
					pack9 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack9 = 2
	IF pack10 < 2
		IF pack10 = 0
			ADD_BLIP_FOR_COORD pack10x pack10y pack10z pack10blip
			pack10 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack10x pack10y pack10z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack10x pack10y pack10z 2.0 2.0 2.0	FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack10blip
					pack_counter--
					pack10 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF


IF pack10 = 2
	IF pack11 < 2
		IF pack11 = 0
			ADD_BLIP_FOR_COORD pack11x pack11y pack11z pack11blip
			pack11 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack11x pack11y pack11z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack11x pack11y pack11z 2.0 2.0 2.0	FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack11blip
					pack_counter--
					pack11 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack11 = 2
	IF pack12 < 2
		IF pack12 = 0
			ADD_BLIP_FOR_COORD pack12x pack12y pack12z pack12blip
			pack12 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack12x pack12y pack12z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack12x pack12y pack12z 2.0 2.0 2.0 FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack12blip
					pack_counter--
					pack12 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack12 = 2
	IF pack13 < 2
		IF pack13 = 0
			ADD_BLIP_FOR_COORD pack13x pack13y pack13z pack13blip
			pack13 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack13x pack13y pack13z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack13x pack13y pack13z 2.0 2.0 2.0 FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack13blip
					pack_counter--
					pack13 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack13 = 2
	IF pack14 < 2
		IF pack14 = 0
			ADD_BLIP_FOR_COORD pack14x pack14y pack14z pack14blip
			pack14 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack14x pack14y pack14z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack14x pack14y pack14z 2.0 2.0 2.0 FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack14blip
					pack_counter--
					pack14 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack14 = 2
	IF pack15 < 2
		IF pack15 = 0
			ADD_BLIP_FOR_COORD pack15x pack15y pack15z pack15blip
			pack15 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack15x pack15y pack15z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack15x pack15y pack15z 2.0 2.0 2.0 FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack15blip
					pack_counter--
					pack15 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack15 = 2
	IF pack16 < 2
		IF pack16 = 0
			ADD_BLIP_FOR_COORD pack16x pack16y pack16z pack16blip
			pack16 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack16x pack16y pack16z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack16x pack16y pack16z 2.0 2.0 2.0 FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack16blip
					pack_counter--
					pack16 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack16 = 2
	IF pack17 < 2
		IF pack17 = 0
			ADD_BLIP_FOR_COORD pack17x pack17y pack17z pack17blip
			pack17 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack17x pack17y pack17z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack17x pack17y pack17z 2.0 2.0 2.0 FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack17blip
					pack_counter--
					pack17 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack17 = 2
	IF pack18 < 2
		IF pack18 = 0
			ADD_BLIP_FOR_COORD pack18x pack18y pack18z pack18blip
			pack18 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack18x pack18y pack18z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack18x pack18y pack18z 2.0 2.0 2.0 FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack18blip
					pack_counter--
					pack18 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack18 = 2
	IF pack19 < 2
		IF pack19 = 0
			ADD_BLIP_FOR_COORD pack19x pack19y pack19z pack19blip
			pack19 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack19x pack19y pack19z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack19x pack19y pack19z 2.0 2.0 2.0 FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack19blip
					pack_counter--
					pack19 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF

IF pack19 = 2
	IF pack20 < 2
		IF pack20 = 0
			ADD_BLIP_FOR_COORD pack20x pack20y pack20z pack20blip
			pack20 = 1
		ENDIF
		IF NOT IS_CAR_DEAD remote_copter
			DRAW_CORONA pack20x pack20y pack20z 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 100 100
		   		IF LOCATE_CAR_3D remote_copter pack20x pack20y pack20z 2.0 2.0 2.0 FALSE
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP pack20blip
					pack_counter--
					pack20 = 2
				ENDIF
		ENDIF
	ENDIF
ENDIF


//player passes if they collect coronas within time
IF pack_counter = 0
	IF NOT IS_CAR_DEAD vanforrc
		IF timer_for_rcraider_coronas > 0
			LOCK_CAR_DOORS vanforrc CARLOCK_UNLOCKED
			GOTO mission_rcbuggy1_passed
		ENDIF
	ENDIF
ENDIF 

//warning out of range
IF NOT IS_CAR_DEAD remote_copter
	IF NOT IS_CAR_IN_AREA_2D remote_copter -1881.576 -1612.496 -979.9678 -582.2634 FALSE
		IF IS_CAR_IN_AREA_2D remote_copter -2104.88 -1655.804 -866.489 -430.5 FALSE
			PRINT_NOW ( RCH1_12 ) 3000 1
		ENDIF
	ENDIF
ENDIF	

		

//out of range
IF NOT IS_CAR_DEAD remote_copter
	IF NOT IS_CAR_IN_AREA_2D remote_copter -2104.88 -1655.804 -866.489 -430.5 FALSE
		BLOW_UP_RC_BUGGY
		PRINT_NOW ( RCH1_13 ) 5000 1 
		GOTO mission_rcbuggy1_failed
	ENDIF
ENDIF

//player fails if van is blown up is damaged
IF IS_CAR_DEAD vanforrc
	PRINT_NOW ( WRECKED ) 3000 1 //"The vehicle's wrecked!"
	REMOVE_RC_BUGGY
	GOTO mission_rcbuggy1_failed
ENDIF

//or copter is dead
IF player_in_topfun_van = 1
	IF IS_CAR_DEAD remote_copter
		IF NOT pack_counter = 0
			PRINT_NOW ( WRECKED ) 3000 1 //"The vehicle's wrecked!"
			GOTO mission_rcbuggy1_failed
		ENDIF
	ENDIF
ENDIF

ENDWHILE



// ****************************************START OF CUTSCENE********************************


 // **************************************** Mission haitian3 failed ************************

mission_rcbuggy1_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
ALTER_WANTED_LEVEL player1 previous_wanted_level
RETURN

   

// **************************************** mission haitian3 passed ************************

mission_rcbuggy1_passed:

flag_complete_rcheli_once = 1


/// Works out time in mins and seconds
race_timer_seconds_heli1 = timer_for_rcraider_coronas / 1000 //seconds

REGISTER_FASTEST_TIME 5 race_timer_seconds_heli1

race_timer_mins_heli1 = race_timer_seconds_heli1 / 60 // mins
race_timer_seconds2_heli1 = race_timer_mins_heli1 * 60 
race_timer_seconds_heli1 = race_timer_seconds_heli1 - race_timer_seconds2_heli1 

IF race_timer_seconds_heli1 >= 10
	PRINT_WITH_2_NUMBERS_NOW ( RCH1_9 ) race_timer_mins_heli1 race_timer_seconds_heli1 7000 1 
ELSE
	PRINT_WITH_2_NUMBERS_NOW ( RCH1_10 ) race_timer_mins_heli1 race_timer_seconds_heli1 7000 1
ENDIF
IF playerpassedrcheli = 0
	PLAYER_MADE_PROGRESS 1
	REGISTER_ODDJOB_MISSION_PASSED 
	playerpassedrcheli = 1
ENDIF

//REGISTER_MISSION_PASSED ( )
PRINT_WITH_NUMBER_BIG ( M_PASS ) 100 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
PLAY_MISSION_PASSED_TUNE 1
ADD_SCORE player1 100


RETURN
		


// ********************************** mission cleanup **************************************

mission_cleanup_rcbuggy1:

flag_player_on_mission = 0
//MARK_MODEL_AS_NO_LONGER_NEEDED MALE01
//MARK_CAR_AS_NO_LONGER_NEEDED delvan
//MARK_CAR_AS_NO_LONGER_NEEDED newcar
//BLOW_UP_RC_BUGGY
//LOCK_CAR_DOORS vanforrc CARLOCK_UNLOCKED
CLEAR_ONSCREEN_TIMER timer_for_rcraider_coronas
CLEAR_ONSCREEN_COUNTER pack_counter
REMOVE_RC_BUGGY
IF NOT IS_CAR_DEAD vanforrc
	LOCK_CAR_DOORS vanforrc CARLOCK_UNLOCKED
ENDIF
MARK_MODEL_AS_NO_LONGER_NEEDED rcraider
MARK_MODEL_AS_NO_LONGER_NEEDED infernus
REMOVE_BLIP pack1blip
REMOVE_BLIP pack2blip
REMOVE_BLIP pack3blip
REMOVE_BLIP pack4blip
REMOVE_BLIP pack5blip
REMOVE_BLIP pack6blip
REMOVE_BLIP pack7blip
REMOVE_BLIP pack8blip
REMOVE_BLIP pack9blip
REMOVE_BLIP pack10blip
REMOVE_BLIP pack11blip
REMOVE_BLIP pack12blip
REMOVE_BLIP pack13blip
REMOVE_BLIP pack14blip
REMOVE_BLIP pack15blip
REMOVE_BLIP pack16blip
REMOVE_BLIP pack17blip
REMOVE_BLIP pack18blip
REMOVE_BLIP pack19blip
REMOVE_BLIP pack20blip
SET_POLICE_IGNORE_PLAYER player1 OFF
has_player_just_done_rcheli_mission = 1
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN
}