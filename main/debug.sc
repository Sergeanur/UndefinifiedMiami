MISSION_START

VAR_FLOAT x_float_m y_float_m z_float_m text_x text_y text_z text_h	player_heading_debug debug_car_heading
VAR_FLOAT dbcam_x dbcam_y dbcam_z
VAR_INT carcolour_flag1 carcolour_flag2 carcolour_counter1 carcolour_counter2 carcolour_timer1 carcolour_timer2
VAR_INT magic_car button_press_flag car_colour car_colour2 intro_explosion_flag	players_debug_car
VAR_INT flag_create_car initial_create_car initial_car_selected	initial_pickup_selected
VAR_INT counter_create_car colour_counter cheat_mode_on_flag cheat_mode_on open_up_the_property_pickups
VAR_INT button_pressed_warp button_pressed_warp_odd button_pressed_main relative_button_press    
VAR_INT repeat_button_press text_button_pressed	players_car_debug initial_pickup debug_active
VAR_INT debug_crap_on crap_press_flag no_cars repeat_butt_press	test_heli1_blip	print_stuff_button print_stuff_counter
VAR_INT counter_create_pickup flag_create_pickup magic_pickup test_heli1 test_heli1_created
VAR_INT weather_crap add_just_the_once_though invulnerability_on button_press_flag_pickup debug_game_timer
VAR_FLOAT hotelX_d lawyerX_d generalY_d baronY_d sergioY_d bankjobY_d pornY_d protectY_d counterY_d bikersY_d 
VAR_FLOAT cubanY_d haitianY_d darkelY_d rockY_d rockX_d taxiwarY_d philY_d baron2Y_d	kentX_d
VAR_FLOAT goto_thereX goto_thereY goto_thereZ heli1Y_d
VAR_FLOAT corona_x corona_y corona_z stunt_jump_debug_X stunt_jump_debug_Y stunt_jump_debug_Z
VAR_INT onscreen_4 onscreen_1 onscreen_2 onscreen_3	is_stunt_jump_debug	is_rightshock_pressed
VAR_FLOAT RStickX_F RStickY_F

relative_button_press = 0
initial_create_car = 0
counter_create_car = landstal 
counter_create_pickup = brassknuckle 
button_pressed_warp = 0 
button_pressed_main = 0 
cheat_mode_on_flag = 2
cheat_mode_on = 1
weather_crap = 0
add_just_the_once_though = 0
button_pressed_warp_odd = 0
test_heli1_created = 0
initial_pickup = 0
initial_pickup_selected = 0
print_stuff_button = 0
print_stuff_counter = 0
carcolour_flag1 = 0
carcolour_flag2 = 0
carcolour_counter1 = 0
carcolour_counter2 = 0
is_stunt_jump_debug = 0
is_rightshock_pressed = 0

hotelX_d = hotelX + 3.0
lawyerX_d = lawyerX - 5.0 
generalY_d = generalY + 2.4
baronY_d = baronY + 3.0
sergioY_d = sergioY + 3.0
bankjobY_d = bankjobY - 3.0
pornY_d = pornY + 3.0
counterY_d = counterY + 3.0
bikersY_d = bikersY + 3.0
cubanY_d = cubanY + 3.0
haitianY_d = haitianY + 3.0
rockY_d = rockY + 3.0
rockX_d = rockX + 2.0
taxiwarY_d = taxiwarY + 3.0
philY_d = philY + 3.0
baron2Y_d = baron2Y + 3.0
heli1Y_d = heli1Y + 5.0
kentX_d = kentX + 4.0

corona_x = 10.0
corona_y = 10.0
corona_z = 10.0
 
goto_thereX = lawyerX_d
goto_thereY = lawyerY
goto_thereZ	= lawyerZ

SCRIPT_NAME debug

debug_active = 1

SET_DEATHARREST_STATE OFF

GOTO delete_gates

CREATE_OBJECT_NO_OFFSET comgate1closed -181.169 -472.842 12.092 star_gate_1
CREATE_OBJECT_NO_OFFSET comgate2closed -715.225 -490.016 12.092 star_gate_2
CREATE_OBJECT_NO_OFFSET nt_roadblockCI 237.114 961.495 27.221 porn_roadblock
CREATE_OBJECT_NO_OFFSET wsh_roadblock -242.671 -935.667 16.198 south_roadblock
CREATE_OBJECT_NO_OFFSET nt_roadblockGF 213.42 245.061 17.168 golf_roadblock
CREATE_OBJECT_NO_OFFSET mansion_new_doors -391.19 -575.906 24.071 mansion_doors
CREATE_OBJECT_NO_OFFSET ci_jetygatesclosed -116.738 1027.729 11.34 jetty_door_closed
CREATE_OBJECT_NO_OFFSET haitaxidr -1010.466 199.125 11.95 taxi_closed
CREATE_OBJECT_NO_OFFSET b_hse_doors -640.012 -1485.941 15.457 boat_closed

delete_gates:

mission_start_debug:

WAIT 0

GET_GAME_TIMER debug_game_timer

IF IS_PLAYER_PLAYING player1 //ENDIF AT THE BOTTOM OF THE SCRIPT


///	EXPLODE PLAYERS HEAD //////////////////////////////////////////////
//	IF IS_BUTTON_PRESSED PAD2 CROSS
//	AND IS_BUTTON_PRESSED PAD2 SQUARE
//		IF NOT IS_PLAYER_IN_ANY_CAR player1
//			EXPLODE_PLAYER_HEAD player1
//		ELSE
//			STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 car_colour2
//			IF NOT IS_CAR_DEAD car_colour2
//				EXPLODE_CAR car_colour2
//			ENDIF
//		ENDIF
//		GOTO mission_start_debug
//	ENDIF
///////////////////////////////////////////////////////////////////////

/*
//Chris' Super Code to allow you to create a race in a matter of minutes/////

VAR_FLOAT x2 y2 z2 distance 
IF IS_BUTTON_PRESSED PAD1 CIRCLE
	IF button_pressed = 1
		button_pressed = 2
		PRINT_NOW TEXTXYZ 800 1 // Writing coordinates to file...
	ENDIF
ELSE
	IF button_pressed = 0
		button_pressed = 1
	ENDIF
ENDIF

IF button_pressed = 2
	IF IS_PLAYER_IN_ANY_CAR PLAYER1
		GET_PLAYER_COORDINATES player1 X Y Z
		GET_DISTANCE_BETWEEN_COORDS_3D X Y Z x2 y2 z2 distance
		IF distance > 250.0
			PRINT_NOW TEXTXYZ 800 1 // Writing coordinates to file...
			SAVE_NEWLINE_TO_DEBUG_FILE
			SAVE_FLOAT_TO_DEBUG_FILE x
			SAVE_NEWLINE_TO_DEBUG_FILE
			SAVE_FLOAT_TO_DEBUG_FILE y
			SAVE_NEWLINE_TO_DEBUG_FILE
			SAVE_FLOAT_TO_DEBUG_FILE z
			SAVE_NEWLINE_TO_DEBUG_FILE
			x2 = x
			y2 = y
			z2 = z
		ENDIF
	ENDIF
ENDIF
*/

///	FORCE WEATHER /////////////////////////////////////////////////////
	IF cheat_mode_on = 0
		IF IS_BUTTON_PRESSED PAD2 LEFTSHOULDER1
			weather_crap ++
			IF weather_crap > 6
				weather_crap = 1	   
			ENDIF

			IF weather_crap = 1
				FORCE_WEATHER_NOW WEATHER_SUNNY
				PRINT_NOW ( WEATHE1 ) 1000 1 //CHEAT MODE ON
				WAIT 300
			ENDIF

			IF weather_crap = 2
				FORCE_WEATHER_NOW WEATHER_EXTRA_SUNNY
				PRINT_NOW ( WEATHE2 ) 1000 1 //CHEAT MODE ON
				WAIT 300
			ENDIF

			IF weather_crap = 3
				FORCE_WEATHER_NOW WEATHER_CLOUDY
				PRINT_NOW ( WEATHE3 ) 1000 1 //CHEAT MODE ON
				WAIT 300
			ENDIF

			IF weather_crap = 4
				FORCE_WEATHER_NOW WEATHER_RAINY
				PRINT_NOW ( WEATHE4 ) 1000 1 //CHEAT MODE ON
				WAIT 300
			ENDIF

			IF weather_crap = 5
				FORCE_WEATHER_NOW WEATHER_FOGGY
				PRINT_NOW ( WEATHE5 ) 1000 1 //CHEAT MODE ON
				WAIT 300
			ENDIF

			IF weather_crap = 6
				RELEASE_WEATHER 
				PRINT_NOW ( WEATHE6 ) 1000 1 //CHEAT MODE ON
				WAIT 300
			ENDIF
			IF NOT IS_PLAYER_PLAYING player1
				GOTO mission_start_debug
			ENDIF
		ENDIF

/// CHANGE PLAYERS CAR COLOURS //////////////////////////////////////////

		IF IS_BUTTON_PRESSED PAD2 LEFTSHOULDER1
			IF carcolour_flag1 = 1
				IF IS_PLAYER_IN_ANY_CAR player1
					carcolour_counter1 ++
					IF carcolour_counter1 >	94
						carcolour_counter1 = 0
					ENDIF
					carcolour_timer1 = debug_game_timer + 250
					carcolour_flag1 = 2
				ENDIF
			ENDIF
		ENDIF

		IF IS_BUTTON_PRESSED PAD2 LEFTSHOULDER2
			IF carcolour_flag2 = 1
				IF IS_PLAYER_IN_ANY_CAR player1
					carcolour_counter2 ++
					IF carcolour_counter2 >	94
						carcolour_counter2 = 0
					ENDIF
					carcolour_timer2 = debug_game_timer + 250
					carcolour_flag2 = 2
				ENDIF
			ENDIF
		ENDIF

		IF carcolour_flag1 = 2
		OR carcolour_flag2 = 2
			STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_debug_car
			CHANGE_CAR_COLOUR players_debug_car carcolour_counter1 carcolour_counter2
			PRINT_WITH_2_NUMBERS_NOW CO_ONE	carcolour_counter1 carcolour_counter2 500 1
			carcolour_flag1 = 0
			carcolour_flag2 = 0
		ENDIF

		IF NOT IS_BUTTON_PRESSED PAD2 LEFTSHOULDER1
		OR carcolour_timer1 < debug_game_timer
			IF carcolour_flag1 = 0
				carcolour_flag1 = 1
			ENDIF
		ENDIF

		IF NOT IS_BUTTON_PRESSED PAD2 LEFTSHOULDER2
		OR carcolour_timer2 < debug_game_timer
			IF carcolour_flag2 = 0
				carcolour_flag2 = 1
			ENDIF
		ENDIF

	ENDIF
///////////////////////////////////////////////////////////////////////


///	TURN CHEAT MODE ON/OFF ////////////////////////////////////////////
	IF cheat_mode_on_flag = 0
		IF IS_BUTTON_PRESSED PAD2 TRIANGLE
			IF NOT IS_BUTTON_PRESSED PAD2 CROSS
			OR NOT IS_BUTTON_PRESSED PAD2 CIRCLE
			OR NOT IS_BUTTON_PRESSED PAD2 LEFTSHOULDER1
			OR NOT IS_BUTTON_PRESSED PAD2 LEFTSHOULDER2
			OR NOT IS_BUTTON_PRESSED PAD2 START
			OR NOT IS_BUTTON_PRESSED PAD2 SELECT
				PRINT_NOW CHEATON 2000 1//CHEAT MODE ON
				DEBUG_ON
				cheat_mode_on = 1
				cheat_mode_on_flag = 1
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_BUTTON_PRESSED PAD2 TRIANGLE
		IF cheat_mode_on_flag = 1
			cheat_mode_on_flag = 2
		ENDIF
		IF cheat_mode_on_flag = 3
			cheat_mode_on_flag = 0
		ENDIF
	ENDIF

	IF cheat_mode_on_flag = 2
		IF IS_BUTTON_PRESSED PAD2 TRIANGLE
			PRINT_NOW CHEATOF 2000 1//CHEAT MODE OFF
			DEBUG_OFF
			cheat_mode_on = 0
			cheat_mode_on_flag = 3
		ENDIF
	ENDIF

/// CREATE A PICKUP //////////////////////////////////////////
	
	IF IS_BUTTON_PRESSED PAD2 DPADDOWN
	AND flag_create_pickup = 0
	AND button_press_flag_pickup = 0
		GET_PLAYER_COORDINATES player1 x_float_m y_float_m z_float_m
		GET_PLAYER_HEADING player1 player_heading_debug
		IF player_heading_debug < 45.0
		AND player_heading_debug > 0.0
			y_float_m += 5.0
			debug_car_heading = 90.0
		ENDIF
		IF player_heading_debug < 360.0
		AND player_heading_debug > 315.0
			y_float_m += 5.0
			debug_car_heading = 90.0
		ENDIF
		IF player_heading_debug < 135.0
		AND player_heading_debug > 45.0
			x_float_m -= 5.0
			debug_car_heading = 180.0
		ENDIF
		IF player_heading_debug < 225.0
		AND player_heading_debug > 135.0
			y_float_m -= 5.0
			debug_car_heading = 270.0
		ENDIF
		IF player_heading_debug < 315.0
		AND player_heading_debug > 225.0
			x_float_m += 5.0
			debug_car_heading = 0.0
		ENDIF
		z_float_m = z_float_m + 1.0
		GET_GROUND_Z_FOR_3D_COORD x_float_m y_float_m z_float_m	z_float_m

		IF NOT IS_PLAYER_PLAYING player1
			GOTO mission_start_debug
		ENDIF
		
		next_pickup:

		WAIT 0
 										  
			++ counter_create_pickup

			IF counter_create_pickup > camera
				counter_create_pickup = brassknuckle
			ENDIF

			IF counter_create_pickup = missile
				counter_create_pickup = colt45
			ENDIF

			flag_create_pickup = 1
			button_press_flag_pickup = 1
		
		IF NOT IS_MODEL_AVAILABLE counter_create_pickup
			GOTO next_pickup
		ENDIF

		REQUEST_MODEL counter_create_pickup
		PRINT_NOW LOADCAR 250 1 //"Loading vehicle, press pad2 leftshoulder1 to cancel"
		LOAD_ALL_MODELS_NOW
		
		WHILE NOT HAS_MODEL_LOADED counter_create_pickup
			WAIT 0
			
			PRINT_NOW LOADCAR 80 1 //"Loading vehicle, press pad2 leftshoulder1 to cancel"
			
			IF IS_BUTTON_PRESSED PAD2 LEFTSHOULDER1
				GOTO next_pickup
			ENDIF
	
		ENDWHILE
	
		z_float_m = z_float_m + 0.8
		CREATE_PICKUP_WITH_AMMO counter_create_pickup PICKUP_ONCE 2000 x_float_m y_float_m z_float_m magic_pickup
		CLEAR_THIS_BIG_PRINT NUMBER
		PRINT_WITH_NUMBER_BIG NUMBER counter_create_pickup 500 4
		//SET_CAR_HEADING	magic_pickup debug_car_heading
		
		//LOCK_CAR_DOORS magic_pickup CARLOCK_UNLOCKED

		MARK_MODEL_AS_NO_LONGER_NEEDED counter_create_pickup
		//MARK_CAR_AS_NO_LONGER_NEEDED magic_pickup
	
	ENDIF

	IF NOT IS_BUTTON_PRESSED PAD2 DPADDOWN
	AND button_press_flag_pickup = 1
		button_press_flag_pickup = 0
	ENDIF


	IF IS_BUTTON_PRESSED PAD2 DPADDOWN
	AND flag_create_pickup = 1
	AND button_press_flag_pickup = 0
		REMOVE_PICKUP magic_pickup 
		flag_create_pickup = 0
		initial_pickup_selected = 0
		button_press_flag_pickup = 1
	ENDIF



///////////////////////////////////////////////////////////////////////

	IF cheat_mode_on = 1	   /// ONLY DO STUFF IF CHEATMODE IS ON ///
	AND cheat_mode_on_flag = 2 ////////////////////////////////////////

///	PLAYER INVULNERABILITY (SOMETIMES) ////////////////////////////////
//		IF invulnerability_on = 0
//			IF IS_BUTTON_PRESSED PAD2 START
//				DO_FADE 100 FADE_IN
//				invulnerability_on = 1
//			ENDIF
//		ENDIF
//
//		IF invulnerability_on = 2
//			IF IS_BUTTON_PRESSED PAD2 START
//				DO_FADE 100 FADE_IN
//				invulnerability_on = 3
//			ENDIF
//		ENDIF
//
//		IF NOT IS_BUTTON_PRESSED PAD2 START
//			IF invulnerability_on = 1
//				invulnerability_on = 2
//			ENDIF
//			IF invulnerability_on = 3
//				invulnerability_on = 0
//			ENDIF
//		ENDIF
///////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////
///////// WRITE 3D LOCATE COORDINATES TO TEMP_DEBUG.TXT ///////////////
///////////////////////////////////////////////////////////////////////
// TURN CHEAT MODE ON AND PRESS PAD1 L1 & L2 AND PAD2 CROSS TO START //
// USE THE PAD1 RIGHT ANALOGUE STICK AND PAD1 L1 & L2 TO POSITION THE//
// LOCATE BOX. R1, R2, TRIANGLE, CROSS, SQUARE & CIRCLE TO RESIZE IT //
///////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////
		IF IS_PLAYER_PLAYING player1
			IF is_stunt_jump_debug = 0
				IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER1
				AND IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
				AND IS_BUTTON_PRESSED PAD2 CROSS
					is_stunt_jump_debug = 1
					GET_PLAYER_COORDINATES player1 stunt_jump_debug_X stunt_jump_debug_Y stunt_jump_debug_Z
					SET_PLAYER_CONTROL player1 OFF
					corona_x = 10.0
					corona_y = 10.0
					corona_z = 10.0
				ENDIF
			ELSE
				GET_POSITION_OF_ANALOGUE_STICKS PAD1 LStickX LStickY RStickX RStickY
				RStickX_F =# RStickX
				RStickY_F =# RStickY
				RStickX_F /= 100.0
				RStickY_F /= 100.0
				RStickY_F *= -1.0
				stunt_jump_debug_X += RStickX_F
				stunt_jump_debug_Y += RStickY_F
				IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER1
					stunt_jump_debug_Z += 0.2
				ELSE
					IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
						stunt_jump_debug_Z -= 0.2
					ENDIF
				ENDIF
				IF IS_BUTTON_PRESSED PAD1 CIRCLE
					corona_x += 0.2
				ELSE
					IF IS_BUTTON_PRESSED PAD1 SQUARE
						corona_x -= 0.2
					ENDIF
				ENDIF
				IF IS_BUTTON_PRESSED PAD1 TRIANGLE
					corona_y += 0.2
				ELSE
					IF IS_BUTTON_PRESSED PAD1 CROSS
						corona_y -= 0.2
					ENDIF
				ENDIF
				IF IS_BUTTON_PRESSED PAD1 TRIANGLE
					corona_y += 0.2
				ELSE
					IF IS_BUTTON_PRESSED PAD1 CROSS
						corona_y -= 0.2
					ENDIF
				ENDIF
				IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER1
					corona_z += 0.2
				ELSE
					IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER2
						corona_z -= 0.2
					ENDIF
				ENDIF
				IF LOCATE_PLAYER_ANY_MEANS_3D player1 stunt_jump_debug_X stunt_jump_debug_Y stunt_jump_debug_Z corona_x corona_y corona_z 0
				ENDIF

				IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
					IF is_rightshock_pressed = 0
						SAVE_NEWLINE_TO_DEBUG_FILE
						SAVE_FLOAT_TO_DEBUG_FILE stunt_jump_debug_X
						SAVE_NEWLINE_TO_DEBUG_FILE
						SAVE_FLOAT_TO_DEBUG_FILE stunt_jump_debug_Y
						SAVE_NEWLINE_TO_DEBUG_FILE
						SAVE_FLOAT_TO_DEBUG_FILE stunt_jump_debug_Z
						SAVE_NEWLINE_TO_DEBUG_FILE
						SAVE_FLOAT_TO_DEBUG_FILE corona_x 
						SAVE_FLOAT_TO_DEBUG_FILE corona_y 
						SAVE_FLOAT_TO_DEBUG_FILE corona_z
						SAVE_NEWLINE_TO_DEBUG_FILE
						PRINT_NOW TEXTXYZ 800 1 // Writing coordinates to file...
						is_rightshock_pressed = 1
					ENDIF
				ELSE
					IF is_rightshock_pressed = 1
						is_rightshock_pressed = 0
					ENDIF
				ENDIF
				IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER1
				AND IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
				AND IS_BUTTON_PRESSED PAD2 CROSS
					SET_PLAYER_CONTROL player1 ON
					is_stunt_jump_debug = 0
				ENDIF
			ENDIF
		ENDIF
///////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////


/// TURN PEDS AND CARS ON AND OFF /////////////////////////////////////
		IF IS_BUTTON_PRESSED PAD2 SELECT
		AND repeat_butt_press = 0
		AND no_cars = 0
			SET_CAR_DENSITY_MULTIPLIER 0.0
			SET_PED_DENSITY_MULTIPLIER 0.0
			PRINT_NOW CARSOFF 2000 1
			no_cars = 1
			repeat_butt_press = 1
		ENDIF

		IF IS_BUTTON_PRESSED PAD2 SELECT
		AND repeat_butt_press = 0
		AND no_cars = 1
			SET_CAR_DENSITY_MULTIPLIER 1.0
			SET_PED_DENSITY_MULTIPLIER 1.0
			PRINT_NOW CARS_ON 2000 1
			no_cars = 0
			repeat_butt_press = 1
		ENDIF

		IF NOT IS_BUTTON_PRESSED PAD2 SELECT
			IF repeat_butt_press = 1
				repeat_butt_press = 0
			ENDIF
		ENDIF
///////////////////////////////////////////////////////////////////////

/// TEST FOR TEXT PRINTS SO THE ARTISTS CAN CHECK COLOURS ETC /////////
		IF IS_BUTTON_PRESSED PAD2 SELECT
		AND IS_BUTTON_PRESSED PAD2 CROSS
			IF print_stuff_button = 1
				print_stuff_counter ++
				IF print_stuff_counter > 6
					print_stuff_counter = 1
				ENDIF
				IF print_stuff_counter = 1
					CLEAR_ONSCREEN_TIMER onscreen_4
					CLEAR_ONSCREEN_COUNTER onscreen_1
					CLEAR_ONSCREEN_COUNTER onscreen_2
					CLEAR_ONSCREEN_COUNTER onscreen_3
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_1 COUNTER_DISPLAY_BAR 1 BUSTED
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_2 COUNTER_DISPLAY_NUMBER 2 BUSTED
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_3 COUNTER_DISPLAY_NUMBER 3 BUSTED
					DISPLAY_ONSCREEN_TIMER_WITH_STRING onscreen_4 TIMER_UP BUSTED
					PRINT_WITH_NUMBER_BIG M_PASS print_stuff_counter 2000 1
				ENDIF
				IF print_stuff_counter = 2
					CLEAR_ONSCREEN_TIMER onscreen_4
					CLEAR_ONSCREEN_COUNTER onscreen_1
					CLEAR_ONSCREEN_COUNTER onscreen_2
					CLEAR_ONSCREEN_COUNTER onscreen_3
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_1 COUNTER_DISPLAY_BAR 1 BUSTED
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_2 COUNTER_DISPLAY_NUMBER 2 BUSTED
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_3 COUNTER_DISPLAY_NUMBER 3 BUSTED
					DISPLAY_ONSCREEN_TIMER_WITH_STRING onscreen_4 TIMER_UP BUSTED
					PRINT_WITH_NUMBER_BIG M_PASS print_stuff_counter 2000 2
				ENDIF
				IF print_stuff_counter = 3
					CLEAR_ONSCREEN_TIMER onscreen_4
					CLEAR_ONSCREEN_COUNTER onscreen_1
					CLEAR_ONSCREEN_COUNTER onscreen_2
					CLEAR_ONSCREEN_COUNTER onscreen_3
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_1 COUNTER_DISPLAY_BAR 1 BUSTED
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_2 COUNTER_DISPLAY_NUMBER 2 BUSTED
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_3 COUNTER_DISPLAY_NUMBER 3 BUSTED
					DISPLAY_ONSCREEN_TIMER_WITH_STRING onscreen_4 TIMER_UP BUSTED
					PRINT_WITH_NUMBER_BIG M_PASS print_stuff_counter 2000 3
				ENDIF
				IF print_stuff_counter = 4
					CLEAR_ONSCREEN_TIMER onscreen_4
					CLEAR_ONSCREEN_COUNTER onscreen_1
					CLEAR_ONSCREEN_COUNTER onscreen_2
					CLEAR_ONSCREEN_COUNTER onscreen_3
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_1 COUNTER_DISPLAY_BAR 1 BUSTED
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_2 COUNTER_DISPLAY_NUMBER 2 BUSTED
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_3 COUNTER_DISPLAY_NUMBER 3 BUSTED
					DISPLAY_ONSCREEN_TIMER_WITH_STRING onscreen_4 TIMER_UP BUSTED
					PRINT_WITH_NUMBER_BIG M_PASS print_stuff_counter 2000 4
				ENDIF
				IF print_stuff_counter = 5
					CLEAR_ONSCREEN_TIMER onscreen_4
					CLEAR_ONSCREEN_COUNTER onscreen_1
					CLEAR_ONSCREEN_COUNTER onscreen_2
					CLEAR_ONSCREEN_COUNTER onscreen_3
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_1 COUNTER_DISPLAY_BAR 1 BUSTED
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_2 COUNTER_DISPLAY_NUMBER 2 BUSTED
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_3 COUNTER_DISPLAY_NUMBER 3 BUSTED
					DISPLAY_ONSCREEN_TIMER_WITH_STRING onscreen_4 TIMER_UP BUSTED
					PRINT_WITH_NUMBER_BIG M_PASS print_stuff_counter 2000 5
				ENDIF
				IF print_stuff_counter = 6
					CLEAR_ONSCREEN_TIMER onscreen_4
					CLEAR_ONSCREEN_COUNTER onscreen_1
					CLEAR_ONSCREEN_COUNTER onscreen_2
					CLEAR_ONSCREEN_COUNTER onscreen_3
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_1 COUNTER_DISPLAY_BAR 1 BUSTED
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_2 COUNTER_DISPLAY_NUMBER 2 BUSTED
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING onscreen_3 COUNTER_DISPLAY_NUMBER 3 BUSTED
					DISPLAY_ONSCREEN_TIMER_WITH_STRING onscreen_4 TIMER_UP BUSTED
					PRINT_WITH_NUMBER_BIG M_PASS print_stuff_counter 2000 6
				ENDIF
			ENDIF
			print_stuff_button = 0
		ELSE
			IF print_stuff_button = 0
				print_stuff_button = 1
			ENDIF
		ENDIF
///////////////////////////////////////////////////////////////////////



/// WRITE PLAYER COORDS TO TEMP_DEBUG.TXT /////////////////////////////
		IF IS_BUTTON_PRESSED PAD2 LEFTSHOULDER1
		AND text_button_pressed = 0
			GET_PLAYER_COORDINATES player1 text_x text_y text_z
//			IF NOT IS_PLAYER_IN_ANY_CAR player1
			GET_GROUND_Z_FOR_3D_COORD text_x text_y text_z text_z
//			ENDIF
			GET_PLAYER_HEADING player1 text_h
			SAVE_FLOAT_TO_DEBUG_FILE text_x
			SAVE_FLOAT_TO_DEBUG_FILE text_y
			SAVE_FLOAT_TO_DEBUG_FILE text_z
			SAVE_FLOAT_TO_DEBUG_FILE text_h
			SAVE_NEWLINE_TO_DEBUG_FILE
			PRINT_NOW TEXTXYZ 800 1 // Writing coordinates to file...
			text_button_pressed = 1
		ENDIF

		IF NOT IS_BUTTON_PRESSED PAD2 LEFTSHOULDER1
		AND text_button_pressed = 1
			text_button_pressed = 0
		ENDIF
///////////////////////////////////////////////////////////////////////


///	WRITE DEBUG CAMERA COORDS TO TEMP_DEBUG.TXT ///////////////////////
		IF IS_BUTTON_PRESSED PAD2 LEFTSHOULDER2
		AND repeat_button_press = 0
			PRINT_NOW TEXTXYZ 800 1 // Writing coordinates to file...
			GET_DEBUG_CAMERA_COORDINATES text_x text_y text_z
			SAVE_FLOAT_TO_DEBUG_FILE text_x
			SAVE_FLOAT_TO_DEBUG_FILE text_y
			SAVE_FLOAT_TO_DEBUG_FILE text_z
			GET_DEBUG_CAMERA_POINT_AT text_x text_y text_z
			SAVE_FLOAT_TO_DEBUG_FILE text_x
			SAVE_FLOAT_TO_DEBUG_FILE text_y
			SAVE_FLOAT_TO_DEBUG_FILE text_z
			SAVE_NEWLINE_TO_DEBUG_FILE
			repeat_button_press = 1
		ENDIF

		IF NOT IS_BUTTON_PRESSED PAD2 LEFTSHOULDER2
			IF repeat_button_press = 1
				repeat_button_press = 0
			ENDIF
		ENDIF
///////////////////////////////////////////////////////////////////////


///	WRITE PLAYER COORDS RELATIVE TO THE CLOSET CAR TO TEMP_DEBUG.TXT //
//		IF IS_BUTTON_PRESSED PAD2 LEFTSHOULDER1
//		AND IS_BUTTON_PRESSED PAD2 LEFTSHOULDER2
//			IF relative_button_press = 0
//				PRINT_NOW TEXTXYZ 800 1 // Writing coordinates to file...
//				GET_PLAYER_COORDINATES player1 player_x player_y player_z
//				text_x = player_x - 5.0
//				text_y = player_y - 5.0
//				x = player_x + 5.0
//				y = player_y + 5.0
//				GET_RANDOM_CAR_OF_TYPE_IN_AREA text_x text_y x y -1 car
//				IF NOT car = -1
//					GET_CAR_COORDINATES	car	text_x text_y text_z
//					x = player_x - text_x
//					y = player_y - text_y
//					z = player_z - text_z
//					SAVE_FLOAT_TO_DEBUG_FILE x
//					SAVE_FLOAT_TO_DEBUG_FILE y
//					SAVE_FLOAT_TO_DEBUG_FILE z
//					SAVE_FLOAT_TO_DEBUG_FILE 9.9999
//					SAVE_FLOAT_TO_DEBUG_FILE 9.9999
//					SAVE_NEWLINE_TO_DEBUG_FILE
//					GET_OFFSET_FROM_CAR_IN_WORLD_COORDS car x y z corona_x corona_y corona_z
//					MARK_CAR_AS_NO_LONGER_NEEDED car
//					car = -1
//				ELSE
//					SAVE_FLOAT_TO_DEBUG_FILE 9.9999
//					SAVE_NEWLINE_TO_DEBUG_FILE
//				ENDIF
//				relative_button_press = 1
//			ENDIF
//			DRAW_CORONA corona_x corona_y corona_z 0.2 CORONATYPE_CIRCLE FLARETYPE_NONE 250 0 0
//		ENDIF
//
//		IF NOT IS_BUTTON_PRESSED PAD2 LEFTSHOULDER1
//			IF NOT IS_BUTTON_PRESSED PAD2 LEFTSHOULDER2
//				IF relative_button_press = 1
//					relative_button_press = 0
//				ENDIF
//			ENDIF
//		ENDIF
///////////////////////////////////////////////////////////////////////

		  
/// CREATE A CAR - right shoulder1//////////////////////////////////////////
	
		IF IS_BUTTON_PRESSED PAD2 RIGHTSHOULDER1
		AND flag_create_car = 0
		AND button_press_flag = 0
			GET_PLAYER_COORDINATES player1 x_float_m y_float_m z_float_m
			GET_PLAYER_HEADING player1 player_heading_debug
			IF player_heading_debug < 45.0
			AND player_heading_debug > 0.0
				y_float_m += 5.0
				debug_car_heading = 90.0
			ENDIF
			IF player_heading_debug < 360.0
			AND player_heading_debug > 315.0
				y_float_m += 5.0
				debug_car_heading = 90.0
			ENDIF
			IF player_heading_debug < 135.0
			AND player_heading_debug > 45.0
				x_float_m -= 5.0
				debug_car_heading = 180.0
			ENDIF
			IF player_heading_debug < 225.0
			AND player_heading_debug > 135.0
				y_float_m -= 5.0
				debug_car_heading = 270.0
			ENDIF
			IF player_heading_debug < 315.0
			AND player_heading_debug > 225.0
				x_float_m += 5.0
				debug_car_heading = 0.0
			ENDIF
			z_float_m = z_float_m + 0.6
			GET_GROUND_Z_FOR_3D_COORD x_float_m y_float_m z_float_m	z_float_m

			IF NOT IS_PLAYER_PLAYING player1
				GOTO mission_start_debug
			ENDIF
			

			next_carzzz:

			WAIT 0

			IF NOT IS_BUTTON_PRESSED PAD2 CROSS

						   
				IF initial_create_car = 1
					++ counter_create_car
				ENDIF

				IF initial_create_car = 0
					counter_create_car = landstal
					initial_create_car = 1
				ENDIF

				IF counter_create_car > 236
					counter_create_car = landstal
				ENDIF
				
				IF counter_create_car = chopper	//POLICE CHOPPER
			   		counter_create_car = angel
				ENDIF

				IF counter_create_car =	airtrain	
				OR counter_create_car = deaddodo	
					counter_create_car = speeder
				ENDIF


				flag_create_car = 1
				button_press_flag = 1
			ELSE

				IF initial_create_car = 1
					-- counter_create_car
				ENDIF

				IF initial_create_car = 0
					counter_create_car = 236
					initial_create_car = 1
				ENDIF

				initial_create_car = 1

				IF counter_create_car < landstal
					counter_create_car = 236
				ENDIF
				
				IF counter_create_car = chopper	//POLICE CHOPPER
					counter_create_car = cuban
				ENDIF

				IF counter_create_car =	airtrain	
				OR counter_create_car = deaddodo	
					counter_create_car = gangbur
				ENDIF

				flag_create_car = 1
				button_press_flag = 1
			ENDIF

			IF NOT IS_BUTTON_PRESSED PAD2 SQUARE

				IF NOT IS_MODEL_AVAILABLE counter_create_car
					GOTO next_carzzz
				ENDIF
				REQUEST_MODEL counter_create_car
				PRINT_NOW LOADCAR 250 1 //"Loading vehicle, press pad2 leftshoulder1 to cancel"
				LOAD_ALL_MODELS_NOW
				
				WHILE NOT HAS_MODEL_LOADED counter_create_car
					WAIT 0
					
					PRINT_NOW LOADCAR 80 1 //"Loading vehicle, press pad2 leftshoulder1 to cancel"
					
					IF IS_BUTTON_PRESSED PAD2 LEFTSHOULDER1
						GOTO next_carzzz
					ENDIF
					
			
				ENDWHILE
			
				CREATE_CAR counter_create_car x_float_m y_float_m z_float_m magic_car
				CLEAR_THIS_BIG_PRINT NUMBER
				PRINT_WITH_NUMBER_BIG NUMBER counter_create_car 500 4
				SET_CAR_HEADING	magic_car debug_car_heading
				
				LOCK_CAR_DOORS magic_car CARLOCK_UNLOCKED

				MARK_MODEL_AS_NO_LONGER_NEEDED counter_create_car
				MARK_CAR_AS_NO_LONGER_NEEDED magic_car
			ELSE
				counter_create_car = counter_create_car + 10
				PRINT_WITH_NUMBER_BIG NUMBER counter_create_car 500 4	
			ENDIF

		ENDIF

		IF NOT IS_BUTTON_PRESSED PAD2 RIGHTSHOULDER1
		AND button_press_flag = 1
			button_press_flag = 0
		ENDIF


		IF IS_BUTTON_PRESSED PAD2 RIGHTSHOULDER1
		AND flag_create_car = 1
		AND button_press_flag = 0
			IF IS_CAR_DEAD magic_car
				DELETE_CAR magic_car
			ELSE
				IF NOT IS_PLAYER_IN_CAR player1 magic_car
					DELETE_CAR magic_car
				ELSE
					MARK_CAR_AS_NO_LONGER_NEEDED magic_car
				ENDIF
			ENDIF 
			flag_create_car = 0
			initial_car_selected = 0
			button_press_flag = 1
		ENDIF

	
	ENDIF //IS DEBUG ON




/// MISSION SKIP //////////////////////////////////////////////////////
// ********************************************************************************************************************
//INDUSTRIAL MISSION SKIP RIGHT ***************************************************************************************
//IF flag_player_on_mission = 0
	//IF NOT IS_BUTTON_PRESSED PAD2 CROSS
	IF IS_BUTTON_PRESSED PAD2 DPADRIGHT
//	IF NOT button_pressed_main = 0
		IF IS_PLAYER_PLAYING player1
			button_pressed_main ++
			IF button_pressed_main > 62
				button_pressed_main = 1	   
			ENDIF

			FAIL_CURRENT_MISSION
			GOSUB terminate_all_scripts

			IF button_pressed_main = 1
				PRINT_BIG ( INT_B ) 1000 4 //"Hotel cut scene"
				PRINT_NOW ( CUT ) 2000 1
				WAIT 80
				flag_hotel_mission1_passed = 0
	  			START_NEW_SCRIPT hotel_mission1_loop // TEST STUFF
				goto_thereX = hotelX_d  
				goto_thereY = hotelY  
				goto_thereZ = hotelZ
			ENDIF

			IF button_pressed_main = 2
				PRINT_BIG ( LAW_1 ) 1000 4 //"lawyer mission 1"
				PRINT_NOW ( LAW ) 2000 1
				WAIT 80
				flag_lawyer_mission1_passed = 0
	  			START_NEW_SCRIPT lawyer_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT lawyerX lawyerY lawyerZ the_lawyer_blip lawyer_contact_blip
				goto_thereX = lawyerX_d 
				goto_thereY = lawyerY 
				goto_thereZ = lawyerZ
			ENDIF

			IF button_pressed_main = 3
				PRINT_BIG ( LAW_2 ) 1000 4 //"lawyer mission 2"
				PRINT_NOW ( LAW ) 2000 1
				WAIT 80
				flag_lawyer_mission2_passed = 0
	  			START_NEW_SCRIPT lawyer_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT lawyerX lawyerY lawyerZ the_lawyer_blip lawyer_contact_blip
				goto_thereX = lawyerX_d 
				goto_thereY = lawyerY 
				goto_thereZ = lawyerZ
			ENDIF

			IF button_pressed_main = 4
				PRINT_BIG ( LAW_3 ) 1000 4 //"lawyer mission 3"
				PRINT_NOW ( LAW ) 2000 1
				WAIT 80
				flag_lawyer_mission3_passed = 0
	  			START_NEW_SCRIPT lawyer_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT lawyerX lawyerY lawyerZ the_lawyer_blip lawyer_contact_blip
				goto_thereX = lawyerX_d 
				goto_thereY = lawyerY 
				goto_thereZ = lawyerZ
			ENDIF

			IF button_pressed_main = 5
				PRINT_BIG ( LAW_4 ) 1000 4 //"lawyer mission 4"
				PRINT_NOW ( LAW ) 2000 1
				WAIT 80
				flag_lawyer_mission4_passed = 0
	  			START_NEW_SCRIPT lawyer_mission4_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT lawyerX lawyerY lawyerZ the_lawyer_blip lawyer_contact_blip
				goto_thereX = lawyerX_d 
				goto_thereY = lawyerY 
				goto_thereZ = lawyerZ
			ENDIF


			IF button_pressed_main = 6
				PRINT_BIG ( COL_1 ) 1000 4 //"General mission 1"
				PRINT_NOW ( GENERAL ) 2000 1
				WAIT 80
				flag_general_mission1_passed = 0
	  			START_NEW_SCRIPT general_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT generalX generalY generalZ the_general_blip general_contact_blip
				goto_thereX = generalX 
				goto_thereY = generalY_d 
				goto_thereZ = generalZ
			ENDIF

			IF button_pressed_main = 7				
				PRINT_BIG ( COL_2 ) 1000 4 //"General mission 2"
				PRINT_NOW ( GENERAL ) 2000 1
				WAIT 80
				flag_general_mission2_passed = 0
	  			START_NEW_SCRIPT general_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT generalX generalY generalZ the_general_blip general_contact_blip
				goto_thereX = generalX 
				goto_thereY = generalY_d 
				goto_thereZ = generalZ
			ENDIF

			IF button_pressed_main = 8				
				PRINT_BIG ( COL_3 ) 1000 4 //"General mission 3" 
				PRINT_NOW ( GENERAL ) 2000 1
				WAIT 80
				flag_general_mission3_passed = 0
	  			START_NEW_SCRIPT general_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT generalX generalY generalZ the_general_blip general_contact_blip
				goto_thereX = generalX 
				goto_thereY = generalY_d 
				goto_thereZ = generalZ
			ENDIF

			IF button_pressed_main = 9
				PRINT_BIG ( COL_4 ) 1000 4 //"General mission 4"
				PRINT_NOW ( GENERAL ) 2000 1
				WAIT 80
				flag_general_mission4_passed = 0
	  			START_NEW_SCRIPT general_mission4_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT generalX generalY generalZ the_general_blip general_contact_blip
				goto_thereX = generalX 
				goto_thereY = generalY_d 
				goto_thereZ = generalZ
			ENDIF

			IF button_pressed_main = 10
				PRINT_BIG ( COL_5 ) 1000 4 //"General mission 5"
				PRINT_NOW ( GENERAL ) 2000 1
				WAIT 80
				START_NEW_SCRIPT general_mission5_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT generalX generalY generalZ the_general_blip general_contact_blip
				goto_thereX = generalX 
				goto_thereY = generalY_d 
				goto_thereZ = generalZ
			ENDIF

			IF button_pressed_main = 11
				PRINT_BIG ( COK_1 ) 1000 4 //"baron mission 1"
				PRINT_NOW ( COKE ) 2000 1
				WAIT 80
				flag_baron_mission1_passed = 0
	  			START_NEW_SCRIPT baron_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT baronX baronY baronZ the_baron_blip baron_contact_blip
				goto_thereX = baronX 
				goto_thereY = baronY_d 
				goto_thereZ = baronZ
			ENDIF

			IF button_pressed_main = 12
				PRINT_BIG ( COK_2 ) 1000 4 //"baron mission 2"
				PRINT_NOW ( COKE ) 2000 1
				WAIT 80
				flag_baron_mission2_passed = 0
	  			START_NEW_SCRIPT baron_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT baronX baronY baronZ the_baron_blip baron_contact_blip
				goto_thereX = baronX 
				goto_thereY = baronY_d 
				goto_thereZ = baronZ
			ENDIF

			IF button_pressed_main = 13
				PRINT_BIG ( COK_3 ) 1000 4 //"baron mission 3"
				PRINT_NOW ( COKE ) 2000 1
				WAIT 80
				flag_baron_mission3_passed = 0
	  			START_NEW_SCRIPT baron_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT baronX baronY baronZ the_baron_blip baron_contact_blip
				goto_thereX = baronX 
				goto_thereY = baronY_d 
				goto_thereZ = baronZ
			ENDIF

			IF button_pressed_main = 14				
				PRINT_BIG ( COK_4 ) 1000 4 //"baron mission 4"
				PRINT_NOW ( COKE ) 2000 1
				WAIT 80
				flag_baron_mission4_passed = 0
	  			START_NEW_SCRIPT baron_mission4_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT baronX baronY baronZ the_baron_blip baron_contact_blip
				goto_thereX = baronX 
				goto_thereY = baronY_d 
				goto_thereZ = baronZ
			ENDIF

			IF button_pressed_main = 15
				PRINT_BIG ( KENT_1 ) 1000 4 //"Kent paul 1"
				PRINT_NOW ( KENT ) 2000 1
				WAIT 80
				flag_kent_mission1_passed = 0
				flag_kent_mission_active = 1
	  			START_NEW_SCRIPT kent_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT 491.0 -77.7 10.4 the_kent_blip kent_contact_blip
				goto_thereX = 495.604 //kentX_d 
				goto_thereY = -82.80  //kentY 
				goto_thereZ = 9.03  //kentZ
			ENDIF

			IF button_pressed_main = 16
				PRINT_BIG ( ASS_1 ) 1000 4 //"baron mission 5"
				PRINT_NOW ( COKE ) 2000 1
				WAIT 80
				flag_baron_mission5_passed = 0
	  			START_NEW_SCRIPT baron_mission5_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT baron2X baron2Y baron2Z 7 baron_contact_blip
				goto_thereX = baron2X 
				goto_thereY = baron2Y_d 
				goto_thereZ = baron2Z
			ENDIF

			IF button_pressed_main = 17
				PRINT_BIG ( TEX_1 ) 1000 4 //"TEX mission 1"
				PRINT_NOW ( AVERY ) 2000 1
				WAIT 80
				flag_sergio_mission1_passed = 0
	  			START_NEW_SCRIPT serg_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT SERGIOX SERGIOY SERGIOZ the_sergio_blip SERGIO_contact_blip
				goto_thereX = sergioX 
				goto_thereY = sergioY_d 
				goto_thereZ = sergioZ
			ENDIF
				
			IF button_pressed_main = 18
				PRINT_BIG ( TEX_3 ) 1000 4 //"TEX mission 3"
				PRINT_NOW ( AVERY ) 2000 1
				WAIT 80
				flag_sergio_mission2_passed = 0
	  			START_NEW_SCRIPT serg_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT SERGIOX SERGIOY SERGIOZ the_sergio_blip SERGIO_contact_blip
				goto_thereX = sergioX 
				goto_thereY = sergioY_d 
				goto_thereZ = sergioZ
			ENDIF

			IF button_pressed_main = 19
				PRINT_BIG ( TEX_2 ) 1000 4 //"TEX mission 2"
				PRINT_NOW ( AVERY ) 2000 1
				WAIT 80
				flag_sergio_mission3_passed = 0
	  			START_NEW_SCRIPT serg_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT SERGIOX SERGIOY SERGIOZ the_sergio_blip SERGIO_contact_blip
				goto_thereX = sergioX 
				goto_thereY = sergioY_d 
				goto_thereZ = sergioZ
			ENDIF

			IF button_pressed_main = 20
				PRINT_BIG ( BANK_1 ) 1000 4 //"bankjob mission 1"
				PRINT_NOW ( BANK ) 2000 1
				WAIT 80
				flag_bankjob_mission1_passed = 0
	  			START_NEW_SCRIPT bankjob_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT bankjobX bankjobY bankjobZ the_bankjob_blip bankjob_contact_blip
				goto_thereX = 491.0 
				goto_thereY = -77.7 
				goto_thereZ = 10.4
			ENDIF
				
			IF button_pressed_main = 21
				PRINT_BIG ( BANK_2 ) 1000 4 //"bankjob mission 2"
				PRINT_NOW ( BANK ) 2000 1
				WAIT 80
				flag_bankjob_mission2_passed = 0
	  			START_NEW_SCRIPT bankjob_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT bankjobX bankjobY bankjobZ the_bankjob_blip bankjob_contact_blip
				goto_thereX = 491.0 
				goto_thereY = -77.7 
				goto_thereZ = 10.4
			ENDIF

			IF button_pressed_main = 22
				PRINT_BIG ( BANK_3 ) 1000 4 //"bankjob mission 3"
				PRINT_NOW ( BANK ) 2000 1
				WAIT 80
				flag_bankjob_mission3_passed = 0
	  			START_NEW_SCRIPT bankjob_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT bankjobX bankjobY bankjobZ the_bankjob_blip bankjob_contact_blip
				goto_thereX = 491.0 
				goto_thereY = -77.7 
				goto_thereZ = 10.4
			ENDIF

			IF button_pressed_main = 23
				PRINT_BIG ( BANK_4 ) 1000 4 //"bankjob mission 4"
				PRINT_NOW ( BANK ) 2000 1
				WAIT 80
				flag_bankjob_mission4_passed = 0
	  			START_NEW_SCRIPT bankjob_mission4_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT bankjobX bankjobY bankjobZ the_bankjob_blip bankjob_contact_blip
				goto_thereX = 491.0 
				goto_thereY = -77.7 
				goto_thereZ = 10.4
			ENDIF

			IF button_pressed_main = 24
				PRINT_BIG ( PHIL_1 ) 1000 4 //"phil mission 1"
				PRINT_NOW ( PHIL ) 2000 1
				WAIT 80
				flag_phil_mission1_passed = 0
	  			START_NEW_SCRIPT phil_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT philX philY philZ the_phil_blip phil_contact_blip
				goto_thereX = philX 
				goto_thereY = philY_d 
				goto_thereZ = philZ
			ENDIF
				
			IF button_pressed_main = 25
				PRINT_BIG ( PHIL_2 ) 1000 4 //"phil mission 2"
				PRINT_NOW ( PHIL ) 2000 1
				WAIT 80
				flag_phil_mission2_passed = 0
	  			START_NEW_SCRIPT phil_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT philX philY philZ the_phil_blip phil_contact_blip
				goto_thereX = philX 
				goto_thereY = philY_d 
				goto_thereZ = philZ
			ENDIF

			IF button_pressed_main = 26
				PRINT_BIG ( PORN_1 ) 1000 4 //"porn mission 1"
				PRINT_NOW ( PORN ) 2000 1
				WAIT 80
				flag_porn_mission1_passed = 0
	  			START_NEW_SCRIPT porn_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT pornX pornY pornZ the_porn_blip porn_contact_blip
				goto_thereX = pornX 
				goto_thereY = pornY_d 
				goto_thereZ = pornZ
			ENDIF
				
			IF button_pressed_main = 27
				PRINT_BIG ( PORN_2 ) 1000 4 //"porn mission 2"
				PRINT_NOW ( PORN ) 2000 1
				WAIT 80
				flag_porn_mission2_passed = 0
	  			START_NEW_SCRIPT porn_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT pornX pornY pornZ the_porn_blip porn_contact_blip
				goto_thereX = pornX 
				goto_thereY = pornY_d 
				goto_thereZ = pornZ
			ENDIF

			IF button_pressed_main = 28
				PRINT_BIG ( PORN_3 ) 1000 4 //"porn mission 3"
				PRINT_NOW ( PORN ) 2000 1
				WAIT 80
				flag_porn_mission3_passed = 0
	  			START_NEW_SCRIPT porn_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT pornX pornY pornZ the_porn_blip porn_contact_blip
				goto_thereX = pornX 
				goto_thereY = pornY_d 
				goto_thereZ = pornZ
			ENDIF

			IF button_pressed_main = 29
				PRINT_BIG ( PORN_4 ) 1000 4 //"porn mission 4"
				PRINT_NOW ( PORN ) 2000 1
				WAIT 80
				flag_porn_mission4_passed = 0
	  			START_NEW_SCRIPT porn_mission4_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT pornX pornY pornZ the_porn_blip porn_contact_blip
				goto_thereX = pornX 
				goto_thereY = pornY_d 
				goto_thereZ = pornZ
			ENDIF

			IF button_pressed_main = 30
				PRINT_BIG ( BUD_1 ) 1000 4 //"protect mission 1"
				PRINT_NOW ( PROT ) 2000 1
				WAIT 80
				flag_protect_mission1_passed = 0
	  			START_NEW_SCRIPT protect_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT -378.3 -579.8 24.5 RADAR_SPRITE_TOMMY protect_contact_blip
				goto_thereX = baronX 
				goto_thereY = baronY_d 
				goto_thereZ = baronZ
			ENDIF

			IF button_pressed_main = 31
				PRINT_BIG ( BUD_2 ) 1000 4 //"protect mission 2"
				PRINT_NOW ( PROT ) 2000 1
				WAIT 80
				flag_protect_mission2_passed = 0
	  			START_NEW_SCRIPT protect_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT -397.4 -561.3 18.7 RADAR_SPRITE_TOMMY protect_contact_blip
				goto_thereX = baronX 
				goto_thereY = baronY_d 
				goto_thereZ = baronZ
			ENDIF

			IF button_pressed_main = 32
				PRINT_BIG ( BUD_3 ) 1000 4 //"protect mission 3"
				PRINT_NOW ( PROT ) 2000 1
				WAIT 80
				flag_protect_mission3_passed = 0
	  			START_NEW_SCRIPT protect_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT -348.5 -541.8 16.4 RADAR_SPRITE_TOMMY protect_contact_blip
				goto_thereX = baronX 
				goto_thereY = baronY_d 
				goto_thereZ = baronZ
			ENDIF
  
			IF button_pressed_main = 33
				PRINT_BIG ( CNT_1 ) 1000 4 //"counter mission 1"
				PRINT_NOW ( COUNT ) 2000 1
				WAIT 80
				flag_counter_mission1_passed = 0
				START_NEW_SCRIPT counter_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT counterX counterY counterZ the_counter_blip counter_contact_blip
				goto_thereX = counterX 
				goto_thereY = counterY_d 
				goto_thereZ = counterZ
			ENDIF

			IF button_pressed_main = 34
				PRINT_BIG ( CNT_2 ) 1000 4 //"counter mission 2"
				PRINT_NOW ( COUNT ) 2000 1
				WAIT 80
				flag_counter_mission2_passed = 0
	  			START_NEW_SCRIPT counter_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT counterX counterY counterZ the_counter_blip counter_contact_blip
				goto_thereX = counterX 
				goto_thereY = counterY_d 
				goto_thereZ = counterZ
			ENDIF

			IF button_pressed_main = 35
				PRINT_BIG ( CAP_1 ) 1000 4 //"finale mission 1"
				PRINT_NOW ( FIN ) 2000 1
				WAIT 80
				flag_finale_mission1_passed = 0
				malibu_asset_acquired = 1 
				porn_asset_acquired = 1 
				icecream_asset_acquired = 1
				taxifirm_asset_acquired = 1
				boatyard_asset_acquired = 1
				showroom_asset_acquired = 1
	  			START_NEW_SCRIPT finale_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT counterX counterY counterZ the_counter_blip baron_contact_blip
				goto_thereX = counterX 
				goto_thereY = counterY_d 
				goto_thereZ = counterZ
			ENDIF

			IF button_pressed_main = 36
				PRINT_BIG ( FIN_1 ) 1000 4 //"finale mission 2"
				PRINT_NOW ( FIN ) 2000 1
				WAIT 80
				flag_finale_mission2_passed = 0
	  			START_NEW_SCRIPT finale_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT -378.3 -579.8 24.5 RADAR_SPRITE_TOMMY baron_contact_blip
				goto_thereX = baronX 
				goto_thereY = baronY_d 
				goto_thereZ = baronZ
			ENDIF

			IF button_pressed_main = 37
				PRINT_BIG ( BIKE_1 ) 1000 4 //"bikers mission 1"
				PRINT_NOW ( BIKE ) 2000 1
				WAIT 80
				flag_bikers_mission1_passed = 0
	  			START_NEW_SCRIPT bikers_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT bikersX bikersY bikersZ the_biker_blip bikers_contact_blip
				goto_thereX = bikersX 
				goto_thereY = bikersY_d 
				goto_thereZ = bikersZ
			ENDIF

			IF button_pressed_main = 38
				PRINT_BIG ( BIKE_2 ) 1000 4 //"bikers mission 2"
				PRINT_NOW ( BIKE ) 2000 1
				WAIT 80
				flag_bikers_mission2_passed = 0
	  			START_NEW_SCRIPT bikers_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT bikersX bikersY bikersZ the_biker_blip bikers_contact_blip
				goto_thereX = bikersX 
				goto_thereY = bikersY_d 
				goto_thereZ = bikersZ
			ENDIF

			IF button_pressed_main = 39
				PRINT_BIG ( BIKE_3 ) 1000 4 //"bikers mission 3"
				PRINT_NOW ( BIKE ) 2000 1
				WAIT 80
				flag_bikers_mission3_passed = 0
	  			START_NEW_SCRIPT bikers_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT bikersX bikersY bikersZ the_biker_blip bikers_contact_blip
				goto_thereX = bikersX 
				goto_thereY = bikersY_d 
				goto_thereZ = bikersZ
			ENDIF

			IF button_pressed_main = 40
				PRINT_BIG ( ROCK_1 ) 1000 4 //"Rockband mission 1"
				PRINT_NOW ( ROCK ) 2000 1
				WAIT 80
				flag_rock_mission1_passed = 0
	  			START_NEW_SCRIPT rock_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT rockX rockY rockZ the_rock_blip rock_contact_blip
				goto_thereX = rockX_d 
				goto_thereY = rockY_d 
				goto_thereZ = rockZ
				ENDIF

			IF button_pressed_main = 41
				PRINT_BIG ( ROCK_2 ) 1000 4 //"Rockband mission 2"
				PRINT_NOW ( ROCK ) 2000 1
				WAIT 80
				flag_rock_mission2_passed = 0
	  			START_NEW_SCRIPT rock_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT rockX rockY rockZ the_rock_blip rock_contact_blip
				goto_thereX = rockX_d 
				goto_thereY = rockY_d 
				goto_thereZ = rockZ
			ENDIF

			IF button_pressed_main = 42
				PRINT_BIG ( ROCK_3 ) 1000 4 //"Rockband mission 3"
				PRINT_NOW ( ROCK ) 2000 1
				WAIT 80
				flag_rock_mission3_passed = 0
				START_NEW_SCRIPT rock_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT rockX rockY rockZ the_rock_blip rock_contact_blip
				goto_thereX = rockX_d 
				goto_thereY = rockY_d 
				goto_thereZ = rockZ
			ENDIF

			IF button_pressed_main = 43
				PRINT_BIG ( CUB_1 ) 1000 4 //"Cuban mission 1"
				PRINT_NOW ( CUBANM ) 2000 1
				WAIT 80
				flag_cuban_mission1_passed = 0
	  			START_NEW_SCRIPT cuban_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
				goto_thereX = cubanX 
				goto_thereY = cubanY_d 
				goto_thereZ = cubanZ
			ENDIF

			IF button_pressed_main = 44
				PRINT_BIG ( CUB_2 ) 1000 4 //"Cuban mission 2"
				PRINT_NOW ( CUBANM ) 2000 1
				WAIT 80
				flag_cuban_mission2_passed = 0
	  			START_NEW_SCRIPT cuban_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
				goto_thereX = cubanX 
				goto_thereY = cubanY_d 
				goto_thereZ = cubanZ
			ENDIF

			IF button_pressed_main = 45
				PRINT_BIG ( CUB_3 ) 1000 4 //"Cuban mission 3"
				PRINT_NOW ( CUBANM ) 2000 1
				WAIT 80
				flag_cuban_mission3_passed = 0
	  			START_NEW_SCRIPT cuban_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
				goto_thereX = cubanX 
				goto_thereY = cubanY_d 
				goto_thereZ = cubanZ
			ENDIF

			IF button_pressed_main = 46
				PRINT_BIG ( CUB_4 ) 1000 4 //"Cuban mission 4"
				PRINT_NOW ( CUBANM ) 2000 1
				WAIT 80
				flag_cuban_mission4_passed = 0
				flag_haitian_mission3_passed = 1
	  			START_NEW_SCRIPT cuban_mission4_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
				goto_thereX = cubanX 
				goto_thereY = cubanY_d 
				goto_thereZ = cubanZ
			ENDIF

			IF button_pressed_main = 47
				PRINT_BIG ( HAT_1 ) 1000 4 //"haitian mission 1"
				PRINT_NOW ( HAIT ) 2000 1
				WAIT 80
				flag_haitian_mission1_passed = 0
	  			START_NEW_SCRIPT haitian_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT haitianX haitianY haitianZ the_haitian_blip haitian_contact_blip
				goto_thereX = haitianX 
				goto_thereY = haitianY_d 
				goto_thereZ = haitianZ
			ENDIF

			IF button_pressed_main = 48
				PRINT_BIG ( HAT_2 ) 1000 4 //"haitian mission 2"
				PRINT_NOW ( HAIT ) 2000 1
				WAIT 80
				flag_haitian_mission2_passed = 0
	  			START_NEW_SCRIPT haitian_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT haitianX haitianY haitianZ the_haitian_blip haitian_contact_blip
				goto_thereX = haitianX 
				goto_thereY = haitianY_d 
				goto_thereZ = haitianZ
			ENDIF

			IF button_pressed_main = 49
				PRINT_BIG ( HAT_3 ) 1000 4 //"haitian mission 3"
				PRINT_NOW ( HAIT ) 2000 1
				WAIT 80
				flag_haitian_mission3_passed = 0
	  			START_NEW_SCRIPT haitian_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT haitianX haitianY haitianZ the_haitian_blip haitian_contact_blip
				goto_thereX = haitianX 
				goto_thereY = haitianY_d 
				goto_thereZ = haitianZ
			ENDIF
			
  			IF button_pressed_main = 50
				PRINT_BIG ( JOB_1 ) 1000 4 //"assasin mission 1"
				PRINT_NOW ( ASM ) 2000 1
				WAIT 80
				flag_assin_mission1_passed = 0
	  			START_NEW_SCRIPT assin_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT ass_1_x ass_1_y ass_1_z the_assasin_blip assasin_contact_blip
				goto_thereX = ass_1_x   
				goto_thereY = ass_1_y 
				goto_thereZ = ass_1_z
			ENDIF

			IF button_pressed_main = 51
				PRINT_BIG ( JOB_2 ) 1000 4 //"assasin mission 2"
				PRINT_NOW ( ASM ) 2000 1
				WAIT 80
				flag_assin_mission2_passed = 0
	  			START_NEW_SCRIPT assin_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT ass_2_x ass_2_y ass_2_z the_assasin_blip assasin_contact_blip
				goto_thereX = ass_2_x   
				goto_thereY = ass_2_y 
				goto_thereZ = ass_2_z
			ENDIF

			IF button_pressed_main = 52 
				PRINT_BIG ( JOB_3 ) 1000 4 //"assasin mission 3"
				PRINT_NOW ( ASM ) 2000 1
				WAIT 80
				flag_assin_mission3_passed = 0
	  			START_NEW_SCRIPT assin_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT ass_3_x ass_3_y ass_3_z the_assasin_blip assasin_contact_blip
				goto_thereX = ass_3_x   
				goto_thereY = ass_3_y 
				goto_thereZ = ass_3_z
			ENDIF
			
			IF button_pressed_main = 53 
				PRINT_BIG ( JOB_4 ) 1000 4 //"assasin mission 4"
				PRINT_NOW ( ASM ) 2000 1
				WAIT 80
				flag_assin_mission4_passed = 0
	  			START_NEW_SCRIPT assin_mission4_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT ass_4_x ass_4_y ass_4_z the_assasin_blip assasin_contact_blip
				goto_thereX = ass_4_x   
				goto_thereY = ass_4_y 
				goto_thereZ = ass_4_z
			ENDIF

			IF button_pressed_main = 54 
				PRINT_BIG ( JOB_5 ) 1000 4 //"assasin mission 5"
				PRINT_NOW ( ASM ) 2000 1
				WAIT 80
				flag_assin_mission5_passed = 0
	  			START_NEW_SCRIPT assin_mission5_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT ass_5_x ass_5_y ass_5_z the_assasin_blip assasin_contact_blip
				goto_thereX = ass_5_x   
				goto_thereY = ass_5_y 
				goto_thereZ = ass_5_z
			ENDIF

			IF button_pressed_main = 55
				PRINT_BIG ( TAXI_1 ) 1000 4 //"taxiwar mission 1"
				PRINT_NOW ( TAX_1 ) 2000 1
				WAIT 80
				flag_taxiwar_mission1_passed = 0
	  			START_NEW_SCRIPT taxiwar_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT taxiwarX taxiwarY taxiwarZ the_taxiwar_blip taxiwar_contact_blip
			ENDIF

			IF button_pressed_main = 56 
				PRINT_BIG ( TAXI_2 ) 1000 4 //"taxiwar mission 2"
				PRINT_NOW ( TAX_1 ) 2000 1
				WAIT 80
				flag_taxiwar_mission2_passed = 0
	  			START_NEW_SCRIPT taxiwar_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT taxiwarX taxiwarY taxiwarZ the_taxiwar_blip taxiwar_contact_blip
				goto_thereX = taxiwarX 
				goto_thereY = taxiwarY_d 
				goto_thereZ = taxiwarz
			ENDIF

			IF button_pressed_main = 57 
				PRINT_BIG ( TAXI_3 ) 1000 4 //"taxiwar mission 3"
				PRINT_NOW ( TAX_1 ) 2000 1
				WAIT 80
				flag_taxiwar_mission3_passed = 0
	  			START_NEW_SCRIPT taxiwar_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT taxiwarX taxiwarY taxiwarZ the_taxiwar_blip taxiwar_contact_blip
				goto_thereX = taxiwarX 
				goto_thereY = taxiwarY_d 
				goto_thereZ = taxiwarz
			ENDIF

			IF button_pressed_main = 58 
				PRINT_BIG ( HELI_1 ) 1000 4 //"Heli mission 1"
				PRINT_NOW ( HELIODD ) 2000 1
				WAIT 80
				test_heli1_created = 0
	  			START_NEW_SCRIPT heli_mission1_loop // TEST STUFF
				goto_thereX = heli1X 
				goto_thereY = heli1Y_d 
				goto_thereZ = heli1Z
			ENDIF

			IF button_pressed_main = 59 
				PRINT_BIG ( TAXCUT ) 1000 4 //"Taxi cut scene"
				WAIT 80
				REMOVE_PICKUP taxibuy_pickup 
				CREATE_FORSALE_PROPERTY_PICKUP taxibuyX taxibuyY taxibuyZ taxibuy_price TAXI_L taxibuy_pickup//Press R3 to purchase the Taxi Company for $~1~ 
				START_NEW_SCRIPT taxibuy_loop
				goto_thereX = taxiwarX 
				goto_thereY = taxiwarY 
				goto_thereZ = taxiwarz
			ENDIF

			IF button_pressed_main = 60 
				PRINT_BIG ( ICECUT ) 1000 4 //"Ice cream cut scene"
				WAIT 80
				REMOVE_PICKUP icebuy_pickup 
				CREATE_FORSALE_PROPERTY_PICKUP icecreamX icecreamY icecreamZ icebuy_price ICE_L icebuy_pickup//Press R3 to purchase the Taxi Company for $~1~ 
				START_NEW_SCRIPT icebuy_loop
				goto_thereX = icecreamX 
				goto_thereY = icecreamY 
				goto_thereZ = icecreamZ
			ENDIF

			IF button_pressed_main = 61 
				PRINT_BIG ( BOATCUT ) 1000 4 //"boat yard cut scene"
				WAIT 80
				REMOVE_PICKUP boatbuy_pickup 
				CREATE_FORSALE_PROPERTY_PICKUP boatbuyX boatbuyY boatbuyZ boatbuy_price BOAT_L boatbuy_pickup//Press R3 to purchase the Taxi Company for $~1~ 
				START_NEW_SCRIPT boatbuy_loop
				goto_thereX = boatbuyX 
				goto_thereY = boatbuyY 
				goto_thereZ = boatbuyZ
			ENDIF

			IF button_pressed_main = 62 
				PRINT_BIG ( CARCUT ) 1000 4 //"CAR yard cut scene"
				WAIT 80
				REMOVE_PICKUP carbuy_pickup 
				CREATE_FORSALE_PROPERTY_PICKUP carbuyX carbuyY carbuyZ carbuy_price CAR_L carbuy_pickup//Press R3 to purchase the Taxi Company for $~1~ 
				START_NEW_SCRIPT property_car_loop
				goto_thereX = carbuyX 
				goto_thereY = carbuyY 
				goto_thereZ = carbuyZ
			ENDIF
			//GOSUB load_and_warp_player
		ENDIF
	ENDIF

	IF IS_BUTTON_PRESSED PAD2 RIGHTSHOCK
		GOSUB load_and_warp_player
	ENDIF

	//INDUSTRIAL MISSION SKIP LEFT ************************************************************************************
	IF IS_BUTTON_PRESSED PAD2 DPADLEFT
		IF IS_PLAYER_PLAYING player1
			button_pressed_main --
			IF button_pressed_main < 1
				button_pressed_main = 62	   
			ENDIF

			FAIL_CURRENT_MISSION
			GOSUB terminate_all_scripts

			IF button_pressed_main = 62 
				PRINT_BIG ( CARCUT ) 1000 4 //"CAR yard cut scene"
				WAIT 80
				REMOVE_PICKUP carbuy_pickup 
				CREATE_FORSALE_PROPERTY_PICKUP carbuyX carbuyY carbuyZ carbuy_price CAR_L carbuy_pickup//Press R3 to purchase the Taxi Company for $~1~ 
				START_NEW_SCRIPT property_car_loop
				goto_thereX = carbuyX 
				goto_thereY = carbuyY 
				goto_thereZ = carbuyZ
			ENDIF

			IF button_pressed_main = 61 
				PRINT_BIG ( BOATCUT ) 1000 4 //"boat yard cut scene"
				WAIT 80
				REMOVE_PICKUP boatbuy_pickup 
				CREATE_FORSALE_PROPERTY_PICKUP boatbuyX boatbuyY boatbuyZ boatbuy_price BOAT_L boatbuy_pickup//Press R3 to purchase the Taxi Company for $~1~ 
				START_NEW_SCRIPT boatbuy_loop
				goto_thereX = boatbuyX 
				goto_thereZ = boatbuyZ 
				goto_thereY = boatbuyY
			ENDIF

			IF button_pressed_main = 60 
				PRINT_BIG ( ICECUT ) 1000 4 //"Ice cream cut scene"
				WAIT 80
				REMOVE_PICKUP icebuy_pickup 
				CREATE_FORSALE_PROPERTY_PICKUP icecreamX icecreamY icecreamZ icebuy_price ICE_L icebuy_pickup//Press R3 to purchase the Taxi Company for $~1~ 
				START_NEW_SCRIPT icebuy_loop
				goto_thereX = icecreamX 
				goto_thereY = icecreamY 
				goto_thereZ = icecreamZ
			ENDIF

			IF button_pressed_main = 59 
				PRINT_BIG ( TAXCUT ) 1000 4 //"Taxi cut scene"
				WAIT 80
				REMOVE_PICKUP taxibuy_pickup 
				CREATE_FORSALE_PROPERTY_PICKUP taxibuyX taxibuyY taxibuyZ taxibuy_price TAXI_L taxibuy_pickup//Press R3 to purchase the Taxi Company for $~1~ 
				START_NEW_SCRIPT taxibuy_loop
				goto_thereX = taxiwarX 
				goto_thereY = taxiwarY_d 
				goto_thereZ = taxiwarz
			ENDIF

			IF button_pressed_main = 58 
				PRINT_BIG ( HELI_1 ) 1000 4 //"Heli mission 1"
				PRINT_NOW ( HELIODD ) 2000 1
				WAIT 80
				test_heli1_created = 0
	  			START_NEW_SCRIPT heli_mission1_loop // TEST STUFF
				goto_thereX = heli1X 
				goto_thereY = heli1Y_d 
				goto_thereZ = heli1Z
			ENDIF
									  
			IF button_pressed_main = 57
				PRINT_BIG ( TAXI_3 ) 1000 4 //"taxiwar mission 3"
				PRINT_NOW ( TAX_1 ) 2000 1
				WAIT 80
				flag_taxiwar_mission3_passed = 0
	  			START_NEW_SCRIPT taxiwar_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT taxiwarX taxiwarY taxiwarZ the_taxiwar_blip taxiwar_contact_blip
				goto_thereX = taxiwarX 
				goto_thereY = taxiwarY_d 
				goto_thereZ = taxiwarz
			ENDIF

			IF button_pressed_main = 56 
				PRINT_BIG ( TAXI_2 ) 1000 4 //"taxiwar mission 2"
				PRINT_NOW ( TAX_1 ) 2000 1
				WAIT 80
				flag_taxiwar_mission2_passed = 0
	  			START_NEW_SCRIPT taxiwar_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT taxiwarX taxiwarY taxiwarZ the_taxiwar_blip taxiwar_contact_blip
				goto_thereX = taxiwarX 
				goto_thereY = taxiwarY_d 
				goto_thereZ = taxiwarz
			ENDIF

			IF button_pressed_main = 55
				PRINT_BIG ( TAXI_1 ) 1000 4 //"taxiwar mission 1"
				PRINT_NOW ( TAX_1 ) 2000 1
				WAIT 80
				flag_taxiwar_mission1_passed = 0
	  			START_NEW_SCRIPT taxiwar_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT taxiwarX taxiwarY taxiwarZ the_taxiwar_blip taxiwar_contact_blip
				goto_thereX = taxiwarX 
				goto_thereY = taxiwarY_d 
				goto_thereZ = taxiwarz
			ENDIF

			IF button_pressed_main = 54
				PRINT_BIG ( JOB_5 ) 1000 4 //"assasin mission 5"
				PRINT_NOW ( ASM ) 2000 1
				WAIT 80
				flag_assin_mission5_passed = 0
	  			START_NEW_SCRIPT assin_mission5_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT ass_5_x ass_5_y ass_5_z the_assasin_blip assasin_contact_blip
				goto_thereX = ass_5_x   
				goto_thereY = ass_5_y 
				goto_thereZ = ass_5_z
			ENDIF

			IF button_pressed_main = 53 
				PRINT_BIG ( JOB_4 ) 1000 4 //"assasin mission 4"
				PRINT_NOW ( ASM ) 2000 1
				WAIT 80
				flag_assin_mission4_passed = 0
	  			START_NEW_SCRIPT assin_mission4_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT ass_4_x ass_4_y ass_4_z the_assasin_blip assasin_contact_blip
				goto_thereX = ass_4_x   
				goto_thereY = ass_4_y 
				goto_thereZ = ass_4_z
			ENDIF

			IF button_pressed_main = 52
				PRINT_BIG ( JOB_3 ) 1000 4 //"assasin mission 3"
				PRINT_NOW ( ASM ) 2000 1
				WAIT 80
				flag_assin_mission3_passed = 0
	  			START_NEW_SCRIPT assin_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT ass_3_x ass_3_y ass_3_z the_assasin_blip assasin_contact_blip
				goto_thereX = ass_3_x   
				goto_thereY = ass_3_y 
				goto_thereZ = ass_3_z
			ENDIF

			IF button_pressed_main = 51
				PRINT_BIG ( JOB_2 ) 1000 4 //"assasin mission 2"
				PRINT_NOW ( ASM ) 2000 1
				WAIT 80
				flag_assin_mission2_passed = 0
	  			START_NEW_SCRIPT assin_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT ass_2_x ass_2_y ass_2_z the_assasin_blip assasin_contact_blip
				goto_thereX = ass_2_x   
				goto_thereY = ass_2_y 
				goto_thereZ = ass_2_z
			ENDIF

 			IF button_pressed_main = 50
				PRINT_BIG ( JOB_1 ) 1000 4 //"assasin mission 1"
				PRINT_NOW ( ASM ) 2000 1
				WAIT 80
				flag_assin_mission1_passed = 0
	  			START_NEW_SCRIPT assin_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT ass_1_x ass_1_y ass_1_z the_assasin_blip assasin_contact_blip
				goto_thereX = ass_1_x   
				goto_thereY = ass_1_y 
				goto_thereZ = ass_1_z
			ENDIF
			
			IF button_pressed_main = 49
				PRINT_BIG ( HAT_3 ) 1000 4 //"haitian mission 3"
				PRINT_NOW ( HAIT ) 2000 1
				WAIT 80
				flag_haitian_mission3_passed = 0
	  			START_NEW_SCRIPT haitian_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT haitianX haitianY haitianZ the_haitian_blip haitian_contact_blip
				goto_thereX = haitianX 
				goto_thereY = haitianY_d 
				goto_thereZ = haitianZ
			ENDIF

			IF button_pressed_main = 48
				PRINT_BIG ( HAT_2 ) 1000 4 //"haitian mission 2"
				PRINT_NOW ( HAIT ) 2000 1
				WAIT 80
				flag_haitian_mission2_passed = 0
	  			START_NEW_SCRIPT haitian_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT haitianX haitianY haitianZ the_haitian_blip haitian_contact_blip
				goto_thereX = haitianX 
				goto_thereY = haitianY_d 
				goto_thereZ = haitianZ
			ENDIF

			IF button_pressed_main = 47
				PRINT_BIG ( HAT_1 ) 1000 4 //"haitian mission 1"
				PRINT_NOW ( HAIT ) 2000 1
				WAIT 80
				flag_haitian_mission1_passed = 0
	  			START_NEW_SCRIPT haitian_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT haitianX haitianY haitianZ the_haitian_blip haitian_contact_blip
				goto_thereX = haitianX 
				goto_thereY = haitianY_d 
				goto_thereZ = haitianZ
			ENDIF

			IF button_pressed_main = 46
				PRINT_BIG ( CUB_4 ) 1000 4 //"Cuban mission 4"
				PRINT_NOW ( CUBANM ) 2000 1
				WAIT 80
				flag_cuban_mission4_passed = 0
				flag_haitian_mission3_passed = 1
	  			START_NEW_SCRIPT cuban_mission4_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
				goto_thereX = cubanX 
				goto_thereY = cubanY_d 
				goto_thereZ = cubanZ
			ENDIF
									 
			IF button_pressed_main = 45
				PRINT_BIG ( CUB_3 ) 1000 4 //"Cuban mission 3"
				PRINT_NOW ( CUBANM ) 2000 1
				WAIT 80
				flag_cuban_mission3_passed = 0
	  			START_NEW_SCRIPT cuban_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
				goto_thereX = cubanX 
				goto_thereY = cubanY_d 
				goto_thereZ = cubanZ
			ENDIF

			IF button_pressed_main = 44
				PRINT_BIG ( CUB_2 ) 1000 4 //"Cuban mission 2"
				PRINT_NOW ( CUBANM ) 2000 1
				WAIT 80
				flag_cuban_mission2_passed = 0
	  			START_NEW_SCRIPT cuban_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
				goto_thereX = cubanX 
				goto_thereY = cubanY_d 
				goto_thereZ = cubanZ
			ENDIF

			IF button_pressed_main = 43
				PRINT_BIG ( CUB_1 ) 1000 4 //"Cuban mission 1"
				PRINT_NOW ( CUBANM ) 2000 1
				WAIT 80
				flag_cuban_mission1_passed = 0
	  			START_NEW_SCRIPT cuban_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT cubanX cubanY cubanZ the_cuban_blip cuban_contact_blip
				goto_thereX = cubanX 
				goto_thereY = cubanY_d 
				goto_thereZ = cubanZ
			ENDIF

			IF button_pressed_main = 42
				PRINT_BIG ( ROCK_3 ) 1000 4 //"Rockband mission 3"
				PRINT_NOW ( ROCK ) 2000 1
				WAIT 80
				flag_rock_mission3_passed = 0
				START_NEW_SCRIPT rock_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT rockX rockY rockZ the_rock_blip rock_contact_blip
				goto_thereX = rockX_d 
				goto_thereY = rockY_d 
				goto_thereZ = rockZ
			ENDIF

			IF button_pressed_main = 41
				PRINT_BIG ( ROCK_2 ) 1000 4 //"Rockband mission 2"
				PRINT_NOW ( ROCK ) 2000 1
				WAIT 80
				flag_rock_mission2_passed = 0
	  			START_NEW_SCRIPT rock_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT rockX rockY rockZ the_rock_blip rock_contact_blip
				goto_thereX = rockX_d 
				goto_thereY = rockY_d 
				goto_thereZ = rockZ
			ENDIF

			IF button_pressed_main = 40
				PRINT_BIG ( ROCK_1 ) 1000 4 //"Rockband mission 1"
				PRINT_NOW ( ROCK ) 2000 1
				WAIT 80
				flag_rock_mission1_passed = 0
	  			START_NEW_SCRIPT rock_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT rockX rockY rockZ the_rock_blip rock_contact_blip
				goto_thereX = rockX_d 
				goto_thereY = rockY_d 
				goto_thereZ = rockZ
			ENDIF

			IF button_pressed_main = 39
				PRINT_BIG ( BIKE_3 ) 1000 4 //"bikers mission 3"
				PRINT_NOW ( BIKE ) 2000 1
				WAIT 80
				flag_bikers_mission3_passed = 0
	  			START_NEW_SCRIPT bikers_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT bikersX bikersY bikersZ the_biker_blip bikers_contact_blip
				goto_thereX = bikersX 
				goto_thereY = bikersY_d 
				goto_thereZ = bikersZ
			ENDIF

			IF button_pressed_main = 38
				PRINT_BIG ( BIKE_2 ) 1000 4 //"bikers mission 2"
				PRINT_NOW ( BIKE ) 2000 1
				WAIT 80
				flag_bikers_mission2_passed = 0
	  			START_NEW_SCRIPT bikers_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT bikersX bikersY bikersZ the_biker_blip bikers_contact_blip
				goto_thereX = bikersX 
				goto_thereY = bikersY_d 
				goto_thereZ = bikersZ
			ENDIF

			IF button_pressed_main = 37
				PRINT_BIG ( BIKE_1 ) 1000 4 //"bikers mission 1"
				PRINT_NOW ( BIKE ) 2000 1
				WAIT 80
				flag_bikers_mission1_passed = 0
	  			START_NEW_SCRIPT bikers_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT bikersX bikersY bikersZ the_biker_blip bikers_contact_blip
				goto_thereX = bikersX 
				goto_thereY = bikersY_d 
				goto_thereZ = bikersZ
			ENDIF

			IF button_pressed_main = 36
				PRINT_BIG ( FIN_1 ) 1000 4 //"finale mission 2"
				PRINT_NOW ( FIN ) 2000 1
				WAIT 80
				flag_finale_mission2_passed = 0
	  			START_NEW_SCRIPT finale_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT -378.3 -579.8 24.5 RADAR_SPRITE_TOMMY baron_contact_blip
				goto_thereX = baronX 
				goto_thereY = baronY_d 
				goto_thereZ = baronZ
			ENDIF

			IF button_pressed_main = 35
				PRINT_BIG ( CAP_1 ) 1000 4 //"finale mission 1"
				PRINT_NOW ( FIN ) 2000 1
				WAIT 80
				flag_finale_mission1_passed = 0
				malibu_asset_acquired = 1 
				porn_asset_acquired = 1 
				icecream_asset_acquired = 1
				taxifirm_asset_acquired = 1
				boatyard_asset_acquired = 1
				showroom_asset_acquired = 1
	  			START_NEW_SCRIPT finale_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT counterX counterY counterZ the_counter_blip baron_contact_blip
				goto_thereX = counterX 
				goto_thereY = counterY_d 
				goto_thereZ = counterZ
			ENDIF

			IF button_pressed_main = 34
				PRINT_BIG ( CNT_2 ) 1000 4 //"counter mission 2"
				PRINT_NOW ( COUNT ) 2000 1
				WAIT 80
				flag_counter_mission2_passed = 0				
	  			START_NEW_SCRIPT counter_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT counterX counterY counterZ the_counter_blip counter_contact_blip
				goto_thereX = counterX 
				goto_thereY = counterY_d 
				goto_thereZ = counterZ
			ENDIF

			IF button_pressed_main = 33
				PRINT_BIG ( CNT_1 ) 1000 4 //"counter mission 1"
				PRINT_NOW ( COUNT ) 2000 1
				WAIT 80
				flag_counter_mission1_passed = 0
	  			START_NEW_SCRIPT counter_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT counterX counterY counterZ the_counter_blip counter_contact_blip
				goto_thereX = counterX 
				goto_thereY = counterY_d 
				goto_thereZ = counterZ
			ENDIF

			IF button_pressed_main = 32
				PRINT_BIG ( BUD_3 ) 1000 4 //"protect mission 3"
				PRINT_NOW ( PROT ) 2000 1
				WAIT 80
				flag_protect_mission3_passed = 0
	  			START_NEW_SCRIPT protect_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT -348.5 -541.8 16.4 RADAR_SPRITE_TOMMY protect_contact_blip
				goto_thereX = baronX 
				goto_thereY = baronY_d 
				goto_thereZ = baronZ
			ENDIF

			IF button_pressed_main = 31
				PRINT_BIG ( BUD_2 ) 1000 4 //"protect mission 2"
				PRINT_NOW ( PROT ) 2000 1
				WAIT 80
				flag_protect_mission2_passed = 0
	  			START_NEW_SCRIPT protect_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT -397.4 -561.3 18.7 RADAR_SPRITE_TOMMY protect_contact_blip
				goto_thereX = baronX 
				goto_thereY = baronY_d 
				goto_thereZ = baronZ
			ENDIF

			IF button_pressed_main = 30
				PRINT_BIG ( BUD_1 ) 1000 4 //"protect mission 1"
				PRINT_NOW ( PROT ) 2000 1
				WAIT 80
				flag_protect_mission1_passed = 0
	  			START_NEW_SCRIPT protect_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT -378.3 -579.8 24.5 RADAR_SPRITE_TOMMY protect_contact_blip
				goto_thereX = baronX 
				goto_thereY = baronY_d 
				goto_thereZ = baronZ
			ENDIF

			IF button_pressed_main = 29
				PRINT_BIG ( PORN_4 ) 1000 4 //"porn mission 4"
				PRINT_NOW ( PORN ) 2000 1
				WAIT 80
				flag_porn_mission4_passed = 0
	  			START_NEW_SCRIPT porn_mission4_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT pornX pornY pornZ the_porn_blip porn_contact_blip
				goto_thereX = pornX 
				goto_thereY = pornY_d 
				goto_thereZ = pornZ
			ENDIF

			IF button_pressed_main = 28
				PRINT_BIG ( PORN_3 ) 1000 4 //"porn mission 3"
				PRINT_NOW ( PORN ) 2000 1
				WAIT 80
				flag_porn_mission3_passed = 0
	  			START_NEW_SCRIPT porn_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT pornX pornY pornZ the_porn_blip porn_contact_blip
				goto_thereX = pornX 
				goto_thereY = pornY_d 
				goto_thereZ = pornZ
			ENDIF

			IF button_pressed_main = 27
				PRINT_BIG ( PORN_2 ) 1000 4 //"porn mission 2"
				PRINT_NOW ( PORN ) 2000 1
				WAIT 80
				flag_porn_mission2_passed = 0
	  			START_NEW_SCRIPT porn_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT pornX pornY pornZ the_porn_blip porn_contact_blip
				goto_thereX = pornX 
				goto_thereY = pornY_d 
				goto_thereZ = pornZ
			ENDIF

			IF button_pressed_main = 26
				PRINT_BIG ( PORN_1 ) 1000 4 //"porn mission 1"
				PRINT_NOW ( PORN ) 2000 1
				WAIT 80
				flag_porn_mission1_passed = 0
	  			START_NEW_SCRIPT porn_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT pornX pornY pornZ the_porn_blip porn_contact_blip
				goto_thereX = pornX 
				goto_thereY = pornY_d 
				goto_thereZ = pornZ
			ENDIF
									  
			IF button_pressed_main = 25
				PRINT_BIG ( PHIL_2 ) 1000 4 //"phil mission 2"
				PRINT_NOW ( PHIL ) 2000 1
				WAIT 80
				flag_phil_mission2_passed = 0
	  			START_NEW_SCRIPT phil_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT philX philY philZ the_phil_blip phil_contact_blip
				goto_thereX = philX 
				goto_thereY = philY_d 
				goto_thereZ = philZ
			ENDIF

			IF button_pressed_main = 24
				PRINT_BIG ( PHIL_1 ) 1000 4 //"phil mission 1"
				PRINT_NOW ( PHIL ) 2000 1
				WAIT 80
				flag_phil_mission1_passed = 0
	  			START_NEW_SCRIPT phil_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT philX philY philZ the_phil_blip phil_contact_blip
	  			goto_thereX = philX 
				goto_thereY = philY_d 
				goto_thereZ = philZ	
			ENDIF

			IF button_pressed_main = 23
				PRINT_BIG ( BANK_4 ) 1000 4 //"bankjob mission 4"
				PRINT_NOW ( BANK ) 2000 1
				WAIT 80
				flag_bankjob_mission4_passed = 0
	  			START_NEW_SCRIPT bankjob_mission4_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT bankjobX bankjobY bankjobZ the_bankjob_blip bankjob_contact_blip
				goto_thereX = 491.0 
				goto_thereY = -77.7 
				goto_thereZ = 10.4
			ENDIF

			IF button_pressed_main = 22
				PRINT_BIG ( BANK_3 ) 1000 4 //"bankjob mission 3"
				PRINT_NOW ( BANK ) 2000 1
				WAIT 80
				flag_bankjob_mission3_passed = 0
	  			START_NEW_SCRIPT bankjob_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT bankjobX bankjobY bankjobZ the_bankjob_blip bankjob_contact_blip
				goto_thereX = 491.0 
				goto_thereY = -77.7 
				goto_thereZ = 10.4
			ENDIF
				
			IF button_pressed_main = 21
				PRINT_BIG ( BANK_2 ) 1000 4 //"bankjob mission 2"
				PRINT_NOW ( BANK ) 2000 1
				WAIT 80
				flag_bankjob_mission2_passed = 0
	  			START_NEW_SCRIPT bankjob_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT bankjobX bankjobY bankjobZ the_bankjob_blip bankjob_contact_blip
				goto_thereX = 491.0 
				goto_thereY = -77.7 
				goto_thereZ = 10.4
			ENDIF

			IF button_pressed_main = 20
				PRINT_BIG ( BANK_1 ) 1000 4 //"bankjob mission 1"
				PRINT_NOW ( BANK ) 2000 1
				WAIT 80
				flag_bankjob_mission1_passed = 0
	  			START_NEW_SCRIPT bankjob_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT bankjobX bankjobY bankjobZ the_bankjob_blip bankjob_contact_blip
				goto_thereX = 491.0 
				goto_thereY = -77.7 
				goto_thereZ = 10.4
			ENDIF

			IF button_pressed_main = 19
				PRINT_BIG ( TEX_2 ) 1000 4 //"TEX mission 3"
				PRINT_NOW ( AVERY ) 2000 1
				WAIT 80
				flag_sergio_mission3_passed = 0
	  			START_NEW_SCRIPT serg_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT SERGIOX SERGIOY SERGIOZ the_sergio_blip SERGIO_contact_blip
				goto_thereX = sergioX 
				goto_thereY = sergioY_d 
				goto_thereZ = sergioZ
			ENDIF

			IF button_pressed_main = 18
				PRINT_BIG ( TEX_3 ) 1000 4 //"TEX mission 2"
				PRINT_NOW ( AVERY ) 2000 1
				WAIT 80
				flag_sergio_mission2_passed = 0
	  			START_NEW_SCRIPT serg_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT SERGIOX SERGIOY SERGIOZ the_sergio_blip SERGIO_contact_blip
				goto_thereX = sergioX 
				goto_thereY = sergioY_d 
				goto_thereZ = sergioZ
			ENDIF

			IF button_pressed_main = 17
				PRINT_BIG ( TEX_1 ) 1000 4 //"TEX mission 1"
				PRINT_NOW ( AVERY ) 2000 1
				WAIT 80
				flag_sergio_mission1_passed = 0
	  			START_NEW_SCRIPT serg_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT SERGIOX SERGIOY SERGIOZ the_sergio_blip SERGIO_contact_blip
				goto_thereX = sergioX 
				goto_thereY = sergioY_d 
				goto_thereZ = sergioZ
			ENDIF

			IF button_pressed_main = 16
				PRINT_BIG ( ASS_1 ) 1000 4 //"baron mission 5"
				PRINT_NOW ( COKE ) 2000 1
				WAIT 80
				flag_baron_mission5_passed = 0
	  			START_NEW_SCRIPT baron_mission5_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT baron2X baron2Y baron2Z 7 baron_contact_blip
				goto_thereX = baron2X 
				goto_thereY = baron2Y_d 
				goto_thereZ = baron2Z
			ENDIF

			IF button_pressed_main = 15
				PRINT_BIG ( KENT_1 ) 1000 4 //"Kent paul 1"
				PRINT_NOW ( KENT ) 2000 1
				WAIT 80
				flag_kent_mission1_passed = 0
				flag_kent_mission_active = 1
	  			START_NEW_SCRIPT kent_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT 491.0 -77.7 10.4 the_kent_blip kent_contact_blip
				goto_thereX = 495.60 // kentX_d 
				goto_thereY = -82.80 // kentY 
				goto_thereZ = 9.03 // kentZ
			ENDIF

			IF button_pressed_main = 14
				PRINT_BIG ( COK_4 ) 1000 4 //"baron mission 4"
				PRINT_NOW ( COKE ) 2000 1
				WAIT 80
				flag_baron_mission4_passed = 0
	  			START_NEW_SCRIPT baron_mission4_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT baronX baronY baronZ the_baron_blip baron_contact_blip
				goto_thereX = baronX 
				goto_thereY = baronY_d 
				goto_thereZ = baronZ
			ENDIF

			IF button_pressed_main = 13
				PRINT_BIG ( COK_3 ) 1000 4 //"baron mission 3"
				PRINT_NOW ( COKE ) 2000 1
				WAIT 80
				flag_baron_mission3_passed = 0
	  			START_NEW_SCRIPT baron_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT baronX baronY baronZ the_baron_blip baron_contact_blip
				goto_thereX = baronX 
				goto_thereY = baronY_d 
				goto_thereZ = baronZ
			ENDIF

			IF button_pressed_main = 12
				PRINT_BIG ( COK_2 ) 1000 4 //"baron mission 2"
				PRINT_NOW ( COKE ) 2000 1
				WAIT 80
				flag_baron_mission2_passed = 0
	  			START_NEW_SCRIPT baron_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT baronX baronY baronZ the_baron_blip baron_contact_blip
				goto_thereX = baronX 
				goto_thereY = baronY_d 
				goto_thereZ = baronZ
			ENDIF

			IF button_pressed_main = 11
				PRINT_BIG ( COK_1 ) 1000 4 //"baron mission 1"
				PRINT_NOW ( COKE ) 2000 1
				WAIT 80
				flag_baron_mission1_passed = 0
	  			START_NEW_SCRIPT baron_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT baronX baronY baronZ the_baron_blip baron_contact_blip
				goto_thereX = baronX 
				goto_thereY = baronY_d 
				goto_thereZ = baronZ
			ENDIF

			IF button_pressed_main = 10
				PRINT_BIG ( COL_5 ) 1000 4 //"General mission 5"
				PRINT_NOW ( GENERAL ) 2000 1
				WAIT 80
				START_NEW_SCRIPT general_mission5_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT generalX generalY generalZ the_general_blip general_contact_blip
				goto_thereX = generalX 
				goto_thereY = generalY_d 
				goto_thereZ = generalZ
			ENDIF

			IF button_pressed_main = 9
				PRINT_BIG ( COL_4 ) 1000 4 //"General mission 4"
				PRINT_NOW ( GENERAL ) 2000 1
				WAIT 80
				flag_general_mission4_passed = 0
	  			START_NEW_SCRIPT general_mission4_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT generalX generalY generalZ the_general_blip general_contact_blip
				goto_thereX = generalX 
				goto_thereY = generalY_d 
				goto_thereZ = generalZ
			ENDIF

			IF button_pressed_main = 8
				PRINT_BIG ( COL_3 ) 1000 4 //"General mission 3" 
				PRINT_NOW ( GENERAL ) 2000 1
				WAIT 80
				flag_general_mission3_passed = 0
	  			START_NEW_SCRIPT general_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT generalX generalY generalZ the_general_blip general_contact_blip
				goto_thereX = generalX 
				goto_thereY = generalY_d 
				goto_thereZ = generalZ
			ENDIF

			IF button_pressed_main = 7
				PRINT_BIG ( COL_2 ) 1000 4 //"General mission 2"
				PRINT_NOW ( GENERAL ) 2000 1
				WAIT 80
				flag_general_mission2_passed = 0
	  			START_NEW_SCRIPT general_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT generalX generalY generalZ the_general_blip general_contact_blip
				goto_thereX = generalX 
				goto_thereY = generalY_d 
				goto_thereZ = generalZ
			ENDIF

			IF button_pressed_main = 6
				PRINT_BIG ( COL_1 ) 1000 4 //"General mission 1"
				PRINT_NOW ( GENERAL ) 2000 1
				WAIT 80
				flag_general_mission1_passed = 0
	  			START_NEW_SCRIPT general_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT generalX generalY generalZ the_general_blip general_contact_blip
				goto_thereX = generalX 
				goto_thereY = generalY_d 
				goto_thereZ = generalZ
			ENDIF

			IF button_pressed_main = 5
				PRINT_BIG ( LAW_4 ) 1000 4 //"lawyer mission 4"
				PRINT_NOW ( LAW ) 2000 1
				WAIT 80
				flag_lawyer_mission4_passed = 0
	  			START_NEW_SCRIPT lawyer_mission4_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT lawyerX lawyerY lawyerZ the_lawyer_blip lawyer_contact_blip
				goto_thereX = lawyerX_d 
				goto_thereY = lawyerY 
				goto_thereZ = lawyerZ
			ENDIF

			IF button_pressed_main = 4
				PRINT_BIG ( LAW_3 ) 1000 4 //"lawyer mission 3"
				PRINT_NOW ( LAW ) 2000 1
				WAIT 80
				flag_lawyer_mission3_passed = 0
	  			START_NEW_SCRIPT lawyer_mission3_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT lawyerX lawyerY lawyerZ the_lawyer_blip lawyer_contact_blip
				goto_thereX = lawyerX_d 
				goto_thereY = lawyerY 
				goto_thereZ = lawyerZ
			ENDIF

			IF button_pressed_main = 3
				PRINT_BIG ( LAW_2 ) 1000 4 //"lawyer mission 2"
				PRINT_NOW ( LAW ) 2000 1
				WAIT 80
				flag_lawyer_mission2_passed = 0
	  			START_NEW_SCRIPT lawyer_mission2_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT lawyerX lawyerY lawyerZ the_lawyer_blip lawyer_contact_blip
				goto_thereX = lawyerX_d 
				goto_thereY = lawyerY 
				goto_thereZ = lawyerZ
			ENDIF

			IF button_pressed_main = 2
				PRINT_BIG ( LAW_1 ) 1000 4 //"lawyer mission 1"
				PRINT_NOW ( LAW ) 2000 1
				WAIT 80
				flag_lawyer_mission1_passed = 0
	  			START_NEW_SCRIPT lawyer_mission1_loop // TEST STUFF
				ADD_SPRITE_BLIP_FOR_CONTACT_POINT lawyerX lawyerY lawyerZ the_lawyer_blip lawyer_contact_blip
				goto_thereX = lawyerX_d 
				goto_thereY = lawyerY 
				goto_thereZ = lawyerZ
			ENDIF

			IF button_pressed_main = 1
				PRINT_BIG ( INT_B ) 1000 4 //"Hotel cut scene"
				PRINT_NOW ( CUT ) 2000 1
				WAIT 80
				flag_hotel_mission1_passed = 0
	  			START_NEW_SCRIPT hotel_mission1_loop // TEST STUFF
				goto_thereX = hotelX_d  
				goto_thereY = hotelY  
				goto_thereZ = hotelZ
			ENDIF


		ENDIF
	ENDIF
	
	IF IS_BUTTON_PRESSED PAD2 RIGHTSHOCK
		GOSUB load_and_warp_player
	ENDIF

ENDIF	// IF IS_PLAYER_PLAYING player1

GOTO mission_start_debug

MISSION_END 



{
load_and_warp_player:

IF IS_PLAYER_PLAYING player1
	SET_AREA_VISIBLE VIS_MAIN_MAP
	LOAD_SCENE goto_thereX goto_thereY goto_thereZ
	SET_PLAYER_COORDINATES player1 goto_thereX goto_thereY goto_thereZ
ENDIF

//WHILE IS_BUTTON_PRESSED PAD2 CROSS
//	WAIT 0

//ENDWHILE				   

IF button_pressed_main = 59
AND test_heli1_created = 0
	REQUEST_MODEL sparrow
	LOAD_ALL_MODELS_NOW 
	CREATE_CAR sparrow heli1X heli1Y heli1Z test_heli1
	MARK_MODEL_AS_NO_LONGER_NEEDED sparrow
	MARK_CAR_AS_NO_LONGER_NEEDED test_heli1
	test_heli1_created = 1
ENDIF

RETURN
}


terminate_all_scripts:

	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME HOT
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME LAW1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME LAW2
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME LAW3
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME LAW4
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME KEN1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME GEN1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME GEN2
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME GEN3
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME GEN4
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME GEN5
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME BAR1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME BAR2
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME BAR3
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME BAR4
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME BAR5
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME SER1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME SER2
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME SER3
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME BANK1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME BANK2
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME BANK3
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME BANK4
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME PHI1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME PHI2
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME PORN1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME PORN2
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME PORN3
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME PORN4
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME PRO1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME PRO2
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME PRO3
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME COU1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME COU2
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME FIN1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME FIN2
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME BIK1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME BIK2
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME BIK3
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME ROC1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME ROC2
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME ROC3
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME ROC4
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME CUB1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME CUB2
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME CUB3
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME CUB4
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME HAT1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME HAT2
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME HAT3
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME ASSIN_1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME ASSIN_2
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME ASSIN_3
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME ASSIN_4
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME ASSIN_5
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME TWAR1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME TWAR2
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME TWAR3
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME HELI1
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME BOATBUY
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME TAXIBUY
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME ICEBUY
	TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME CARBUY

	flag_kent_mission_active = 0
	flag_open_mansion = 2

	//REMOVE_BLIP	hotel_contact_blip
	REMOVE_BLIP	lawyer_contact_blip
	REMOVE_BLIP	kent_contact_blip
	REMOVE_BLIP	general_contact_blip
	REMOVE_BLIP	baron_contact_blip
	REMOVE_BLIP	sergio_contact_blip
	REMOVE_BLIP	bankjob_contact_blip
	REMOVE_BLIP	phil_contact_blip
	REMOVE_BLIP	porn_contact_blip
	REMOVE_BLIP	protect_contact_blip
	REMOVE_BLIP	counter_contact_blip
	REMOVE_BLIP	bikers_contact_blip
	REMOVE_BLIP	rock_contact_blip
	REMOVE_BLIP	cuban_contact_blip
	REMOVE_BLIP	haitian_contact_blip
	REMOVE_BLIP	assasin_contact_blip
	REMOVE_BLIP	taxiwar_contact_blip
	REMOVE_PICKUP taxibuy_pickup
	REMOVE_BLIP goto_hotel_contact_blip

	IF switch_off_starfish_gates = 0
		SET_MAX_WANTED_LEVEL 6				    
		SWITCH_PED_ROADS_ON -787.8 -519.4 10.0 -657.5 -475.2 20.0 // Star Island gates mainland
		SWITCH_PED_ROADS_ON -230.0 -464.5 10.0 56.85 -459.8 20.0 // Star Island gates ocean beach
		SWITCH_PED_ROADS_ON -99.8 1041.9 0.0 -129.0 1097.4 30.0 //  porn island road block
		SWITCH_PED_ROADS_ON -214.6 -948.8 0.0 -258.7 -920.6 30.0 //  South road block
		SWITCH_PED_ROADS_ON 162.0 245.0 18.0 166.0 250.0 25.0 //  Golf course road block
		SWITCH_PED_ROADS_ON 59.0 198.5 18.0 51.0 200.0 25.0 //  Golf course road block
						  
		SWITCH_ROADS_ON -787.8 -519.4 10.0 -657.5 -475.2 20.0 // Star Island gates	mainland
		SWITCH_ROADS_ON -230.0 -464.5 10.0 165.85 -459.8 20.0 // Star Island gates ocean beach
		SWITCH_ROADS_ON -99.8 1041.9 0.0 -129.0 1097.4 30.0 // porn island road block
		SWITCH_ROADS_ON -214.6 -948.8 0.0 -258.7 -920.6 30.0 //  South road block
		SWITCH_ROADS_ON 162.0 245.0 18.0 166.0 250.0 25.0 // Golf Club
		SWITCH_ROADS_ON 59.0 198.5 18.0 51.0 200.0 25.0 // Golf Club
		DELETE_OBJECT star_gate_1
		DELETE_OBJECT star_gate_2
		DELETE_OBJECT porn_roadblock
		DELETE_OBJECT south_roadblock
		DELETE_OBJECT golf_roadblock
		CREATE_OBJECT_NO_OFFSET comgate1open -715.042 -489.0 12.615 star_gate_1
        //SET_OBJECT_HEADING star_gate_1 3.0
        DONT_REMOVE_OBJECT star_gate_1
        CREATE_OBJECT_NO_OFFSET comgate2open -181.402 -472.859 12.65 star_gate_2
        //SET_OBJECT_HEADING star_gate_2 12.5
        DONT_REMOVE_OBJECT star_gate_2
		DELETE_OBJECT mansion_doors
		DELETE_OBJECT porn_north_gate_closed   
		DELETE_OBJECT jetty_door_closed
		DELETE_OBJECT taxi_closed
		DELETE_OBJECT boat_closed
		//DELETE_OBJECT boat_closed
		switch_off_starfish_gates = 1
	ENDIF

	IF IS_BUTTON_PRESSED PAD2 CROSS
		IF open_up_the_property_pickups = 0 
			REMOVE_PICKUP print_works_pickup 
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT printbuyX printbuyY printbuyZ RADAR_SPRITE_PROPERTY print_works_blip 
			CHANGE_BLIP_DISPLAY print_works_blip BLIP_ONLY 
			CREATE_FORSALE_PROPERTY_PICKUP printbuyX printbuyY printbuyZ printworks_price PRNT_L print_works_pickup//Press R3 to purchase the Print Works for $~1~ 
			START_NEW_SCRIPT print_buy_loop
			//CAR SHOWROOM PURCHASING PICKUP
			REMOVE_PICKUP carbuy_pickup 
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT carbuyX carbuyY carbuyZ RADAR_SPRITE_PROPERTY carbuy_blip 
			CHANGE_BLIP_DISPLAY carbuy_blip BLIP_ONLY 
			CREATE_FORSALE_PROPERTY_PICKUP carbuyX carbuyY carbuyZ carbuy_price CAR_L carbuy_pickup//Press R3 to purchase the Car Showroom for $~1~ 
			//FILM STUDIO PURCHASING PICKUP
			REMOVE_PICKUP pornbuy_pickup 
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT pornbuyX pornbuyY pornbuyZ RADAR_SPRITE_PROPERTY pornbuy_blip 
			CHANGE_BLIP_DISPLAY pornbuy_blip BLIP_ONLY 
			CREATE_FORSALE_PROPERTY_PICKUP pornbuyX pornbuyY pornbuyZ pornbuy_price PORN_L pornbuy_pickup//Press R3 to purchase the Film Studios for $~1~ 
			START_NEW_SCRIPT pornbuy_loop
			//ICECREAM FACTORY PURCHASING PICKUP
			REMOVE_PICKUP icebuy_pickup 
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT icebuyX icebuyY icebuyZ RADAR_SPRITE_PROPERTY icebuy_blip 
			CHANGE_BLIP_DISPLAY icebuy_blip BLIP_ONLY 
			CREATE_FORSALE_PROPERTY_PICKUP icebuyX icebuyY icebuyZ icebuy_price ICE_L icebuy_pickup//Press R3 to purchase the Icecream Factory for $~1~ 
			//TAXI FIRM PURCHASING PICKUP
			REMOVE_PICKUP taxibuy_pickup 
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT taxibuyX taxibuyY taxibuyZ RADAR_SPRITE_PROPERTY taxibuy_blip 
			CHANGE_BLIP_DISPLAY taxibuy_blip BLIP_ONLY 
			CREATE_FORSALE_PROPERTY_PICKUP taxibuyX taxibuyY taxibuyZ taxibuy_price TAXI_L taxibuy_pickup//Press R3 to purchase the Taxi Company for $~1~ 
			//THE MALIBU PURCHASING PICKUP
			REMOVE_PICKUP bankbuy_pickup 
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT bankbuyX bankbuyY bankbuyZ RADAR_SPRITE_PROPERTY bankbuy_blip 
			CHANGE_BLIP_DISPLAY bankbuy_blip BLIP_ONLY 
			CREATE_FORSALE_PROPERTY_PICKUP bankbuyX bankbuyY bankbuyZ bankbuy_price BANK_L bankbuy_pickup//Press R3 to purchase The Malibu for $~1~ 
			START_NEW_SCRIPT bankbuy_loop
			//BOAT YARD PURCHASING PICKUP
			REMOVE_PICKUP boatbuy_pickup 
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT boatbuyX boatbuyY boatbuyZ RADAR_SPRITE_PROPERTY boatbuy_blip 
			CHANGE_BLIP_DISPLAY boatbuy_blip BLIP_ONLY 
			CREATE_FORSALE_PROPERTY_PICKUP boatbuyX boatbuyY boatbuyZ boatbuy_price BOAT_L boatbuy_pickup//Press R3 to purchase the Boat Yard for $~1~ 
			//STRIP CLUB PURCHASING PICKUP
			REMOVE_PICKUP strpbuy_pickup
			CREATE_FORSALE_PROPERTY_PICKUP strpbuyX strpbuyY strpbuyZ strpbuy_price STRP_L strpbuy_pickup//Press R3 to purchase the Car Showroom for $~1~ 
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT strpbuyX strpbuyY strpbuyZ RADAR_SPRITE_PROPERTY strpbuy_blip
			CHANGE_BLIP_DISPLAY strpbuy_blip BLIP_ONLY 
			START_NEW_SCRIPT strpbuy_loop
			open_up_the_property_pickups = 1
		ENDIF
			START_NEW_SCRIPT icebuy_loop
			START_NEW_SCRIPT taxibuy_loop
			START_NEW_SCRIPT boatbuy_loop
			START_NEW_SCRIPT property_car_loop
	ENDIF

RETURN