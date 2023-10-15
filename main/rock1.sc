MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************s************************************
// ************************************ Drugs N'Groupies ***********************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME rockb1

// Mission start stuff

GOSUB mission_start_rock1

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_rock1_failed
ENDIF

GOSUB mission_cleanup_rock1

MISSION_END

// Variables for mission

// Mercedes

VAR_INT mercedes_rock1

VAR_INT radar_blip_merc_rock1

VAR_INT flag_merc_in_group_rock1

VAR_INT flag_merc_dead_rock1

VAR_INT radar_blip_coord2_rock1

VAR_INT car_rock1

VAR_INT car2_rock1

VAR_INT no_of_passengers_rock1

// Dealer1

VAR_INT dealer1_rock1

VAR_INT flag_dealer1_dead_rock1

VAR_INT radar_blip_dealer1_rock1

VAR_INT flag_dealer1_created_rock1  // Tells me if the dealer has been created

VAR_INT bike_rock1

VAR_FLOAT deal_local_x_rock1 // location where player has to stop for the deal

VAR_FLOAT deal_local_y_rock1 // location where player has to stop for the deal

VAR_FLOAT deal_local_z_rock1 // location where player has to stop for the deal

VAR_INT radar_blip_deal_rock1

VAR_INT flag_had_horn_mess_rock1 // tells teh player to press teh horn

VAR_INT cutcar_rock1 // car that is stored for second cutscene

VAR_INT flag_done_cutscene_rock1  // Checks to see if cutscene done

VAR_INT dealer1_in_position_rock1

VAR_INT flag_dealer1_in_car_rock1

VAR_INT car3_rock1

// Drug1

VAR_INT drug1_rock1

VAR_INT flag_drug1_collected_rock1

VAR_FLOAT drug1_x_rock1

VAR_FLOAT drug1_y_rock1

VAR_FLOAT drug1_z_rock1

VAR_INT radar_blip_drug1_rock1

VAR_INT flag_drug1_created_rock1

// General

VAR_INT counter_number_drugs_collected

VAR_INT radar_blip_studio_rock1

VAR_INT timer_rock1

VAR_INT flag_had_car_message_rock1  // Used to tell teh player they have to be in a car

// Stuff for dealer2 to walk to players window

VAR_FLOAT dealer1_dest_x_rock1

VAR_FLOAT dealer1_dest_y_rock1

VAR_FLOAT dealer1_dest_z_rock1

dealer1_dest_x_rock1 = 0.0

dealer1_dest_y_rock1 = 0.0

dealer1_dest_z_rock1 = 0.0

VAR_INT flag_had_car2_message_rock1

VAR_INT cutcar2_rock1

//VAR_INT tyre_number_rock1 // Tyre for the dealer to burst

VAR_INT player_in_correct_vehicle_rock1

// Dealer car stuff

VAR_INT flag_dealer_car_rock1
						
VAR_INT flag_dealer_foot_rock1

VAR_INT dealer_doing_stuff_rock1 // Used for the player getting set to do something 1st time

// ****************************************Mission Start************************************

mission_start_rock1:

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1

// Mercedes

flag_merc_in_group_rock1 = 0

flag_merc_dead_rock1 = 0

// dealer1

flag_dealer1_dead_rock1 = 0

deal_local_x_rock1 = -513.988

deal_local_y_rock1 = 1133.143

deal_local_z_rock1 = 10.08

flag_had_horn_mess_rock1 = 0

flag_done_cutscene_rock1 = 0

flag_dealer1_created_rock1 = 0

flag_dealer1_in_car_rock1 = 0

// Drug1

flag_drug1_collected_rock1 = 0

drug1_x_rock1 = 0.0

drug1_y_rock1 = 0.0

drug1_z_rock1 = 0.0

flag_drug1_created_rock1 = 0

// General

counter_number_drugs_collected = 0

//this timer is used for the final drive back to the studio
timer_rock1 =  91000  // 1 1/2 mins 

flag_had_car_message_rock1 = 0

flag_had_car2_message_rock1 = 0 // To check for Misty

player_in_correct_vehicle_rock1 = 0

// Dealer car stuff

flag_dealer_car_rock1 = 0
						
flag_dealer_foot_rock1 = 0

dealer_doing_stuff_rock1 = 0

no_of_passengers_rock1 = 0
		
WAIT 0

LOAD_MISSION_TEXT ROCK1

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

LOAD_CUTSCENE rok_1

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
 
WHILE cs_time < 1056 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_A ) 10000 1 //"AlllllllRrrrighttt!

WHILE cs_time < 5224 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_B ) 10000 1 //"Brilliant, bloody brilliant!

WHILE cs_time < 7304 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_C ) 10000 1 //"Heeey, Tommy! Glad you could make it.

WHILE cs_time < 9427 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_D ) 10000 1 //"Hey, you ever met Love Fist before?

WHILE cs_time < 11052  
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_E ) 10000 1 //"No, I haven't, but I've always loved your music.

WHILE cs_time < 12782
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_F ) 10000 1 //"Let me introduce you to the band.

WHILE cs_time < 14396 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_G ) 10000 1 //"This is P, Percy, dick, and Willy, and that was Jezz in the both earlier,

WHILE cs_time < 18961 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_H ) 10000 1 //"and guys, I want you to meet a good friend of mine.

WHILE cs_time < 21292 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_I ) 10000 1 //"This is Tommy. We go way back.

WHILE cs_time < 22918 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_J ) 10000 1 //"Alright, pal.

WHILE cs_time < 24055 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_K ) 10000 1 //"And eh, what was your name again?

WHILE cs_time < 26610 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_L ) 10000 1 //"Leave it out Jezz You remember,

WHILE cs_time < 28351 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_M ) 10000 1 //"don't be playing those games wiht me mate,

WHILE cs_time < 29855 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_N ) 10000 1 //"I'm too crafty for that, sunshine!

WHILE cs_time < 34583 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_O ) 10000 1 //"You see, the thing is, Tommy, the boys need some help.

WHILE cs_time < 38289 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_P ) 10000 1 //"They ain't too connected here, don't have the old how's your father.

WHILE cs_time < 41099 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_Q ) 10000 1 //"We need some drugs, pal!

WHILE cs_time < 43119 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_R ) 10000 1 //"Gonna get on the old Love Fist fury, you know?!

WHILE cs_time < 46114 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_S ) 10000 1 //"Well, this is Vice City man. What's the problem?

WHILE cs_time < 48332 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_U ) 10000 1 //"Love Juice, man!

WHILE cs_time < 49782 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_T ) 10000 1 //"We need Love Juice man, ken?

//WHILE cs_time < 50936 
//	WAIT 0
//	GET_CUTSCENE_TIME cs_time
//ENDWHILE

//PRINT_NOW ( RBM1_U ) 10000 1 //"Love Juice, man!

WHILE cs_time < 52122 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_V ) 10000 1 //"Love Juice?

WHILE cs_time < 53173 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_W ) 10000 1 //"Aye, two parts boomshine, 1 part trumpet, 5 fizz bombs and a litre of petrol.

WHILE cs_time < 58523 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_X ) 10000 1 //"Can you help us out pal?

WHILE cs_time < 59953 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_Y ) 10000 1 //"Aw, it would really mean a lot to the boys.

WHILE cs_time < 61300 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( RBM1_Z ) 10000 1 //"You can do that for the boys, right?

WHILE cs_time < 62839
   	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

DO_FADE 2000 FADE_OUT

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

// Waiting for the ped models to load

REQUEST_MODEL BMYBB

REQUEST_MODEL BUDDYSHOT

REQUEST_MODEL STINGER

REQUEST_MODEL PCJ600

LOAD_SPECIAL_CHARACTER 6 igmerc

REQUEST_MODEL cellphone

WHILE NOT HAS_MODEL_LOADED BUDDYSHOT
OR NOT HAS_MODEL_LOADED STINGER
OR NOT HAS_MODEL_LOADED PCJ600
OR NOT HAS_SPECIAL_CHARACTER_LOADED 6
OR NOT HAS_MODEL_LOADED cellphone
OR NOT HAS_MODEL_LOADED BMYBB 

	WAIT 0
      
ENDWHILE

// this stuff has to be here cos of daft compiler

ADD_BLIP_FOR_COORD -867.8 1165.7 10.2 radar_blip_studio_rock1
REMOVE_BLIP radar_blip_studio_rock1

CREATE_PICKUP briefcase PICKUP_ONCE drug1_x_rock1 drug1_y_rock1 drug1_z_rock1 drug1_rock1

ADD_BLIP_FOR_PICKUP drug1_rock1 radar_blip_drug1_rock1

REMOVE_BLIP radar_blip_drug1_rock1

REMOVE_PICKUP drug1_rock1

CREATE_CHAR PEDTYPE_CIVMALE BMYBB 308.24 -621.28 8.9 dealer1_rock1
ADD_BLIP_FOR_CHAR dealer1_rock1 radar_blip_dealer1_rock1

REMOVE_BLIP radar_blip_dealer1_rock1 
DELETE_CHAR dealer1_rock1
   

// end of daft compiler stuff

// fades the screen in

SET_FADING_COLOUR 0 0 0

WAIT 500

DO_FADE 1500 FADE_IN

PRINT_NOW ( RBM1_12 ) 4000 1 //"Go and collect the ingredients for "Love juice from the dealer."

ADD_BLIP_FOR_COORD deal_local_x_rock1 deal_local_y_rock1 deal_local_z_rock1 radar_blip_deal_rock1  

// ********************** Waiting for the player to collect all the drugs ******************

WHILE NOT counter_number_drugs_collected = 1 

	WAIT 0
      			  
// Creates dealer1
   	 				
	IF flag_dealer1_created_rock1 = 0

		IF flag_done_cutscene_rock1 = 0

			IF LOCATE_PLAYER_ANY_MEANS_3D player1 deal_local_x_rock1 deal_local_y_rock1 deal_local_z_rock1 2.0 2.0 2.0 FALSE 
					 				
				IF IS_PLAYER_IN_FLYING_VEHICLE player1
				OR IS_PLAYER_IN_ANY_BOAT player1

					IF flag_had_car_message_rock1 = 0
						PRINT_NOW ( RBM1_14 ) 5000 1 //"You need a car!
						flag_had_car_message_rock1 = 1
					ENDIF

				ELSE

					IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 deal_local_x_rock1 deal_local_y_rock1 deal_local_z_rock1 2.0 2.0 2.0 FALSE
							
						IF flag_had_car_message_rock1 = 0
							PRINT_NOW ( RBM1_14 ) 5000 1 //"You need a car!
							flag_had_car_message_rock1 = 1
						ENDIF

					ENDIF

				ENDIF
						
			ELSE
				flag_had_car_message_rock1 = 0
			ENDIF	


			IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player1 deal_local_x_rock1 deal_local_y_rock1 deal_local_z_rock1 2.0 2.0 2.0 TRUE
			AND NOT IS_PLAYER_IN_FLYING_VEHICLE player1
			AND NOT IS_PLAYER_IN_ANY_BOAT player1 
					
				IF flag_had_horn_mess_rock1 = 0
					PRINT_NOW ( HORN ) 5000 1 //"Press the horn!"
					flag_had_horn_mess_rock1 = 1
				ENDIF

				IF IS_PLAYER_SITTING_IN_ANY_CAR player1
				AND IS_PLAYER_PRESSING_HORN player1
					STORE_CAR_PLAYER_IS_IN player1 cutcar_rock1

					IF NOT IS_CAR_DEAD cutcar_rock1 
						LOCK_CAR_DOORS cutcar_rock1 CARLOCK_LOCKED_PLAYER_INSIDE
					ENDIF

					SET_PLAYER_CONTROL player1 OFF
					SET_POLICE_IGNORE_PLAYER player1 ON
					SET_EVERYONE_IGNORE_PLAYER player1 ON
																				
					WAIT 500
					GOSUB dealer_cutscene
				ENDIF
				
			ELSE
				flag_had_horn_mess_rock1 = 0
			ENDIF

		ENDIF

	ENDIF

// Drug1 collection

	IF flag_drug1_created_rock1 = 1

		IF flag_drug1_collected_rock1 = 0 
			GOSUB drug1_collection_rock1
		ENDIF

	ENDIF

// DEALER 1 STUFF

	IF flag_dealer1_created_rock1 = 1
			
		IF flag_dealer1_dead_rock1 = 0
	
			IF IS_CHAR_DEAD dealer1_rock1
				REMOVE_BLIP radar_blip_dealer1_rock1
				
				IF flag_done_cutscene_rock1 = 0
					PRINT_NOW ( RBM1_10 ) 5000 1 //"You idiot we have lost the mercandise!"
					GOTO mission_rock1_failed
				ELSE
				  						  		
					IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON dealer1_rock1 WEAPONTYPE_MOLOTOV
					OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON dealer1_rock1 WEAPONTYPE_FLAMETHROWER
					OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON dealer1_rock1 WEAPONTYPE_EXPLOSION
						PRINT_NOW ( RBM1_10 ) 5000 1 //"You idiot we have lost the mercandise!"
						GOTO mission_rock1_failed	
					ELSE

						IF DOES_CHAR_EXIST dealer1_rock1                               
							GET_DEAD_CHAR_PICKUP_COORDS dealer1_rock1 drug1_x_rock1 drug1_y_rock1 drug1_z_rock1
							CREATE_PICKUP briefcase PICKUP_ONCE  drug1_x_rock1 drug1_y_rock1 drug1_z_rock1 drug1_rock1
							ADD_BLIP_FOR_PICKUP drug1_rock1 radar_blip_drug1_rock1
							flag_drug1_created_rock1 = 1
						ELSE
							PRINT_NOW ( RBM1_10 ) 5000 1 //"You idiot we have lost the mercandise!"
							GOTO mission_rock1_failed
						ENDIF
							
					ENDIF
									   				
				ENDIF

				flag_dealer1_dead_rock1 = 1

			ELSE

				IF flag_drug1_created_rock1 = 0 

					IF IS_CHAR_IN_WATER dealer1_rock1
						PRINT_NOW ( RBM1_10 ) 5000 1 //"You idiot we have lost the mercandise!"
						GOTO mission_rock1_failed
					ENDIF
					
				ENDIF	

				IF NOT IS_CHAR_DEAD dealer1_rock1
				
					IF flag_done_cutscene_rock1 = 1

						IF NOT IS_CHAR_ON_SCREEN dealer1_rock1
								
							IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 dealer1_rock1 180.0 180.0 180.0 FALSE
								REMOVE_BLIP radar_blip_dealer1_rock1 	 
								PRINT_NOW ( RBM1_15 ) 5000 1 //"You idiot you have lost the dealer, the cash and drugs!"
								GOTO mission_rock1_failed
							ENDIF
							
						ENDIF
						
						IF dealer_doing_stuff_rock1 = 0 
							  				
							IF NOT IS_CHAR_IN_ANY_CAR dealer1_rock1

								IF IS_CHAR_ON_SCREEN dealer1_rock1
									SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS dealer1_rock1 player1
									dealer_doing_stuff_rock1 = 1
								ENDIF
									
							ENDIF

						ENDIF
					
						IF flag_dealer1_in_car_rock1 = 0
			
							IF IS_CHAR_IN_ANY_CAR dealer1_rock1	
				   				SET_CHAR_OBJ_NO_OBJ dealer1_rock1
								STORE_CAR_CHAR_IS_IN dealer1_rock1 car3_rock1
								ADD_UPSIDEDOWN_CAR_CHECK car3_rock1
								ADD_STUCK_CAR_CHECK car3_rock1 0.1 2000
								SET_CAR_CRUISE_SPEED car3_rock1 40.0
								SET_CAR_DRIVING_STYLE car3_rock1 2
								CAR_WANDER_RANDOMLY car3_rock1
								dealer_doing_stuff_rock1 = 0
								flag_dealer1_in_car_rock1 = 1
							ENDIF

						ENDIF
						
						IF flag_dealer1_in_car_rock1 = 1

							IF NOT IS_CAR_DEAD car3_rock1

								IF IS_CAR_STUCK_ON_ROOF car3_rock1
								OR IS_CAR_STUCK car3_rock1
								OR IS_CAR_ON_FIRE car3_rock1
									SET_CHAR_OBJ_LEAVE_CAR dealer1_rock1 car3_rock1
									dealer_doing_stuff_rock1 = 0
								ENDIF
			
							ENDIF

						ENDIF

						IF flag_dealer1_in_car_rock1 = 1
				
							IF NOT IS_CHAR_IN_ANY_CAR dealer1_rock1
								REMOVE_UPSIDEDOWN_CAR_CHECK car3_rock1
								REMOVE_STUCK_CAR_CHECK car3_rock1
								MARK_CAR_AS_NO_LONGER_NEEDED car3_rock1
								dealer_doing_stuff_rock1 = 0
								flag_dealer1_in_car_rock1 = 0
							ENDIF
					
						ENDIF	 
						
					ENDIF

				ENDIF

			ENDIF
						
		ENDIF

	ENDIF
			
ENDWHILE

// ********************************** KENT PAUL PHONE CALL *********************************

MARK_CAR_AS_NO_LONGER_NEEDED car3_rock1
MARK_CHAR_AS_NO_LONGER_NEEDED dealer1_rock1 

timera = 0

LOAD_MISSION_AUDIO 1 ( MOBRING )
LOAD_MISSION_AUDIO 2 ( MOB_07A ) // Hey mate, the guys could do with some company, if you know what I mean..

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	
	WAIT 0

ENDWHILE

WHILE timera < 3000

	WAIT 0

ENDWHILE

PLAY_MISSION_AUDIO 1

WHILE NOT HAS_MISSION_AUDIO_FINISHED 1

	WAIT 0

ENDWHILE

SET_POLICE_IGNORE_PLAYER player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 ON

IF IS_CHAR_ON_FOOT scplayer
	SET_CHAR_ANSWERING_MOBILE scplayer TRUE
	WAIT 1250
ENDIF

LOAD_MISSION_AUDIO 1 ( MOB_07B ) // I know just the girl

PLAY_MISSION_AUDIO 2
PRINT_NOW ( MOB_07A ) 10000 1 //"Hey mate, the guys could do with some company, if you know what I mean.."

WHILE NOT HAS_MISSION_AUDIO_FINISHED 2

	WAIT 0

ENDWHILE

CLEAR_THIS_PRINT ( MOB_07A )

WHILE NOT HAS_MISSION_AUDIO_LOADED 1

	WAIT 0
	   
ENDWHILE

PLAY_MISSION_AUDIO 1
PRINT_NOW ( MOB_07B ) 5000 1 //"I know just the girl

WHILE NOT HAS_MISSION_AUDIO_FINISHED 1

	WAIT 0
	   
ENDWHILE

CLEAR_THIS_PRINT ( MOB_07B )

IF IS_CHAR_ON_FOOT scplayer
	SET_CHAR_ANSWERING_MOBILE scplayer FALSE
ENDIF

SET_POLICE_IGNORE_PLAYER player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 OFF

// ********************************* Player is sent to get Mercecdes ***********************

PRINT_NOW ( RBM1_1 ) 5000 1 //"Go and collect Mercedes from the strip club!"

CREATE_CHAR PEDTYPE_CIVFEMALE SPECIAL06 297.849 289.728 16.64 mercedes_rock1
CLEAR_CHAR_THREAT_SEARCH mercedes_rock1
SET_CHAR_HEADING mercedes_rock1 270.0
SET_ANIM_GROUP_FOR_CHAR mercedes_rock1 ANIM_SEXY_WOMANPED
SET_CHAR_SUFFERS_CRITICAL_HITS mercedes_rock1 FALSE
SET_CHAR_AS_PLAYER_FRIEND mercedes_rock1 player1 TRUE
SET_CHAR_NEVER_TARGETTED mercedes_rock1 TRUE  

ADD_BLIP_FOR_COORD 304.747 291.581 15.238 radar_blip_coord2_rock1

blob_flag = 1

WHILE NOT LOCATE_STOPPED_PLAYER_IN_CAR_3D player1 304.747 291.581 15.238 3.0 3.0 4.0 blob_flag
OR NOT IS_PLAYER_SITTING_IN_ANY_CAR player1
OR player_in_correct_vehicle_rock1 = 0
			 				   
	WAIT 0

	IF IS_CHAR_DEAD mercedes_rock1
		PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
		 flag_merc_dead_rock1 = 1
		 blob_flag = 0
		GOTO mission_rock1_failed
	ENDIF

	no_of_passengers_rock1 = 0

	IF IS_PLAYER_IN_ANY_CAR player1
		STORE_CAR_PLAYER_IS_IN player1 car2_rock1
	ENDIF
		

	IF IS_PLAYER_IN_ANY_BOAT player1
	OR IS_PLAYER_IN_FLYING_VEHICLE player1
	OR IS_PLAYER_IN_MODEL player1 PIZZABOY
	OR IS_PLAYER_IN_MODEL player1 BAGGAGE
		player_in_correct_vehicle_rock1 = 0
	ELSE
		player_in_correct_vehicle_rock1 = 1
	ENDIF	

	IF NOT IS_CAR_DEAD car2_rock1
		IF NOT IS_CAR_PASSENGER_SEAT_FREE car2_rock1 0
			player_in_correct_vehicle_rock1 = 0
		ELSE
			player_in_correct_vehicle_rock1 = 1
		ENDIF
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 304.747 291.581 15.238 3.0 3.0 4.0 FALSE

		IF NOT IS_CAR_DEAD car2_rock1
			IF NOT IS_CAR_PASSENGER_SEAT_FREE car2_rock1 0
				IF flag_had_car2_message_rock1 = 0
					PRINT_NOW ( RBM1_14 ) 5000 1  //"You need a car!
					flag_had_car2_message_rock1 = 1
				ENDIF
			ENDIF
		ENDIF

		IF IS_PLAYER_IN_ANY_BOAT player1
 		OR IS_PLAYER_IN_MODEL player1 PIZZABOY
 		OR IS_PLAYER_IN_MODEL player1 BAGGAGE
 		OR IS_PLAYER_IN_FLYING_VEHICLE player1

			IF flag_had_car2_message_rock1 = 0
				PRINT_NOW ( RBM1_14 ) 5000 1 //"You need a car!
				flag_had_car2_message_rock1 = 1
			ENDIF

		ELSE

			IF LOCATE_PLAYER_ON_FOOT_3D player1 304.747 291.581 15.238 3.0 3.0 4.0 FALSE 

				IF flag_had_car2_message_rock1 = 0
					PRINT_NOW ( RBM1_14 ) 5000 1 //"You need a car!
					flag_had_car2_message_rock1 = 1
				ENDIF

			ENDIF

		ENDIF

	ELSE
		flag_had_car2_message_rock1 = 0
	ENDIF
	
ENDWHILE

REMOVE_BLIP radar_blip_coord2_rock1

// mini cut scene with Mercedes

SWITCH_WIDESCREEN ON

SET_PLAYER_CONTROL player1 OFF 

SET_POLICE_IGNORE_PLAYER player1 ON

SET_EVERYONE_IGNORE_PLAYER player1 ON

STORE_CAR_PLAYER_IS_IN player1 car_rock1

SET_CHAR_CANT_BE_DRAGGED_OUT scplayer TRUE

CLEAR_AREA 297.020 299.427 17.47 1.0 FALSE 

SET_FIXED_CAMERA_POSITION 297.020 299.427 17.47 0.0 0.0 0.0

POINT_CAMERA_AT_POINT 297.473 298.532 17.43 JUMP_CUT

IF IS_CAR_DEAD car_rock1
	GOTO mission_rock1_failed
ELSE
	
	IF NOT IS_CHAR_DEAD mercedes_rock1
		SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER mercedes_rock1 car_rock1
	ELSE
		PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
		flag_merc_dead_rock1 = 1
		GOTO mission_rock1_failed
	ENDIF

ENDIF

// Waiting for Mercedes to get into the car

LOAD_MISSION_AUDIO 1 ( ROK1_5 ) // Hey Mercedes!

LOAD_MISSION_AUDIO 2 ( ROK1_6 ) //Hiya, Tommy. And how are you?"

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2

	WAIT 0
	  
	IF IS_CHAR_DEAD mercedes_rock1
		PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
		 flag_merc_dead_rock1 = 1
		GOTO mission_rock1_failed
	ENDIF

	IF IS_CAR_DEAD car_rock1

		IF IS_CHAR_DEAD mercedes_rock1
			PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
		 	flag_merc_dead_rock1 = 1
			GOTO mission_rock1_failed
		ELSE
			GOTO mission_rock1_failed
		ENDIF

	ENDIF
		
ENDWHILE

PLAY_MISSION_AUDIO 1
PRINT_NOW ( ROK1_5 ) 5000 1 //"Hey Mercedes!"

WHILE NOT HAS_MISSION_AUDIO_FINISHED 1

	WAIT 0
	  
	IF IS_CHAR_DEAD mercedes_rock1
		PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
		 flag_merc_dead_rock1 = 1
		GOTO mission_rock1_failed
	ENDIF

	IF IS_CAR_DEAD car_rock1

		IF IS_CHAR_DEAD mercedes_rock1
			PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
		 	flag_merc_dead_rock1 = 1
			GOTO mission_rock1_failed
		ELSE
			GOTO mission_rock1_failed
		ENDIF

	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( ROK1_5 )
LOAD_MISSION_AUDIO 1 ( ROK1_7 ) //Just fine. Listen, you fancy having Love Fist?"

PLAY_MISSION_AUDIO 2 // Hiya, Tommy. And how are you?
PRINT_NOW ( ROK1_6 ) 5000 1 //"Hiya, Tommy. And how are you?

WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
OR NOT HAS_MISSION_AUDIO_LOADED 1

	WAIT 0
  
	IF IS_CHAR_DEAD mercedes_rock1
		PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
		 flag_merc_dead_rock1 = 1
		GOTO mission_rock1_failed
	ENDIF

	IF IS_CAR_DEAD car_rock1

		IF IS_CHAR_DEAD mercedes_rock1
			PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
		 	flag_merc_dead_rock1 = 1
			GOTO mission_rock1_failed
		ELSE
			GOTO mission_rock1_failed
		ENDIF

	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( ROK1_6 )
LOAD_MISSION_AUDIO 2 ( ROK1_8 ) //Ok, but just as a favour I expect returned

PLAY_MISSION_AUDIO 1
PRINT_NOW ( ROK1_7 ) 5000 1 //"Just fine. Listen, you fancy having Love Fist? )

WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2

	WAIT 0
	   
	IF IS_CHAR_DEAD mercedes_rock1
		PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
		 flag_merc_dead_rock1 = 1
		GOTO mission_rock1_failed
	ENDIF

	IF IS_CAR_DEAD car_rock1

		IF IS_CHAR_DEAD mercedes_rock1
			PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
		 	flag_merc_dead_rock1 = 1
			GOTO mission_rock1_failed
		ELSE
			GOTO mission_rock1_failed
		ENDIF

	ENDIF
	
ENDWHILE

CLEAR_THIS_PRINT ( ROK1_7 ) 
PLAY_MISSION_AUDIO 2
PRINT_NOW ( ROK1_8 ) 5000 1 //"Ok, but just as a favour I expect returned

WHILE NOT HAS_MISSION_AUDIO_FINISHED 2

	WAIT 0
	  
	IF IS_CHAR_DEAD mercedes_rock1
		PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
		 flag_merc_dead_rock1 = 1
		GOTO mission_rock1_failed
	ENDIF

	IF IS_CAR_DEAD car_rock1

		IF IS_CHAR_DEAD mercedes_rock1
			PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
		 	flag_merc_dead_rock1 = 1
			GOTO mission_rock1_failed
		ELSE
			GOTO mission_rock1_failed
		ENDIF

	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( ROK1_8 )

WHILE NOT IS_CHAR_IN_CAR mercedes_rock1 car_rock1

	WAIT 0

	IF IS_CHAR_DEAD mercedes_rock1
		PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
		 flag_merc_dead_rock1 = 1
		GOTO mission_rock1_failed
	ENDIF

	IF IS_CAR_DEAD car_rock1

		IF IS_CHAR_DEAD mercedes_rock1
			PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
		 	flag_merc_dead_rock1 = 1
			GOTO mission_rock1_failed
		ELSE
			GOTO mission_rock1_failed
		ENDIF

	ENDIF

ENDWHILE

IF NOT IS_CHAR_DEAD mercedes_rock1 
	SET_PLAYER_AS_LEADER mercedes_rock1 player1
	SET_CHAR_RUNNING mercedes_rock1 TRUE
ELSE
	PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
	flag_merc_dead_rock1 = 1
	GOTO mission_rock1_failed	
ENDIF

flag_merc_in_group_rock1 = 1

SWITCH_WIDESCREEN OFF

SET_CHAR_CANT_BE_DRAGGED_OUT scplayer FALSE

RESTORE_CAMERA_JUMPCUT

SET_PLAYER_CONTROL player1 ON

SET_POLICE_IGNORE_PLAYER player1 OFF

SET_EVERYONE_IGNORE_PLAYER player1 OFF

PRINT_NOW ( RBM1_13 ) 7000 1 //"Get the love juice before the band are needed on stage"

ADD_BLIP_FOR_COORD -867.8 1165.7 10.2 radar_blip_studio_rock1

DISPLAY_ONSCREEN_TIMER timer_rock1 TIMER_DOWN

blob_flag = 1

// Waiting for the player1 to deliver all the drugs

WHILE NOT LOCATE_STOPPED_CHAR_ANY_MEANS_3D mercedes_rock1 -867.8 1165.7 10.2 4.0 4.0 4.0 blob_flag 

	WAIT 0

	IF flag_merc_dead_rock1 = 0

		IF IS_CHAR_DEAD mercedes_rock1
			PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
			flag_merc_dead_rock1 = 1
			GOTO mission_rock1_failed
		ELSE
			
			IF flag_merc_in_group_rock1 = 1 

				IF NOT IS_CHAR_IN_PLAYERS_GROUP mercedes_rock1 player1
					REMOVE_BLIP radar_blip_studio_rock1
					ADD_BLIP_FOR_CHAR mercedes_rock1 radar_blip_merc_rock1
					PRINT_NOW ( HEY ) 5000 1 //"Don't leave her behind!"
					blob_flag = 0
					flag_merc_in_group_rock1 = 0
				ENDIF
									
			ENDIF

			IF flag_merc_in_group_rock1 = 0

				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 mercedes_rock1 8.0 8.0 FALSE
					REMOVE_BLIP radar_blip_merc_rock1
					PRINT_NOW ( RBM1_13 ) 7000 1 //"Get the love juice before the band are needed on stage"
					SET_PLAYER_AS_LEADER mercedes_rock1 player1
					ADD_BLIP_FOR_COORD -867.8 1165.7 10.2 radar_blip_studio_rock1
					blob_flag = 1
					flag_merc_in_group_rock1 = 1
				ENDIF

			ENDIF

		ENDIF

	ENDIF
	
	IF timer_rock1 = 0
		PRINT_NOW ( RBM1_7 ) 5000 1 //"You did not get the drugs in time!"
		GOTO mission_rock1_failed
	ENDIF
         	
ENDWHILE

// Everybody is at the club

end_cut_rock1:

CLEAR_ONSCREEN_TIMER timer_rock1
REMOVE_BLIP radar_blip_studio_rock1

SWITCH_WIDESCREEN ON
SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON
SET_POLICE_IGNORE_PLAYER player1 ON

IF IS_CHAR_DEAD mercedes_rock1
	PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
	GOTO mission_rock1_failed
ELSE
	LEAVE_GROUP mercedes_rock1
	SET_ANIM_GROUP_FOR_CHAR mercedes_rock1 ANIM_SEXY_WOMANPED
ENDIF

SET_FIXED_CAMERA_POSITION -874.13 1153.04 14.37 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -873.68 1153.89 14.10 JUMP_CUT

LOAD_MISSION_AUDIO 1 ( MERC_39 )

WHILE NOT HAS_MISSION_AUDIO_LOADED 1

 	WAIT 0

 	IF IS_CHAR_DEAD mercedes_rock1
 		PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
 		GOTO mission_rock1_failed
 	ENDIF

ENDWHILE

IF NOT IS_CHAR_DEAD mercedes_rock1
	
	IF NOT IS_CHAR_IN_ANY_CAR mercedes_rock1
		TURN_CHAR_TO_FACE_PLAYER mercedes_rock1 player1
	ENDIF
	
ELSE
	PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
	GOTO mission_rock1_failed
ENDIF

PLAY_MISSION_AUDIO 1
PRINT_NOW ( MERC_39 ) 5000 1 //"I'll see you later, big boy."

WHILE NOT HAS_MISSION_AUDIO_FINISHED 1

	WAIT 0

	IF IS_CHAR_DEAD mercedes_rock1
	   	PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
	   	GOTO mission_rock1_failed
	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( MERC_39 )

IF IS_CHAR_IN_ANY_CAR mercedes_rock1
	STORE_CAR_CHAR_IS_IN mercedes_rock1 cutcar2_rock1
	
	SET_CHAR_OBJ_LEAVE_CAR mercedes_rock1 cutcar2_rock1
	
	WHILE IS_CHAR_IN_ANY_CAR mercedes_rock1
	
		WAIT 0

		IF IS_CHAR_DEAD mercedes_rock1
			PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
			GOTO mission_rock1_failed
		ENDIF
		
		IF IS_CAR_DEAD cutcar2_rock1
		
			IF IS_CHAR_DEAD mercedes_rock1
				PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
				GOTO mission_rock1_failed
			ENDIF

		ENDIF   
		
	ENDWHILE
	
ENDIF

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mercedes_rock1 -873.33 1161.28

timera = 0

WHILE timera < 3000

	WAIT 0
		
	IF IS_CHAR_DEAD mercedes_rock1
		PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
		GOTO mission_rock1_failed
	ENDIF
	
ENDWHILE

CLEAR_AREA -872.90 1153.53 11.72 1.0 FALSE 
SET_FIXED_CAMERA_POSITION -872.90 1153.53 11.72 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -873.31 1154.47 11.48 JUMP_CUT

IF NOT IS_CHAR_DEAD mercedes_rock1
	CHAR_SET_IDLE mercedes_rock1
	SET_CHAR_COORDINATES mercedes_rock1 -872.40 1159.86 10.09
	SET_CHAR_OBJ_NO_OBJ mercedes_rock1
ELSE
	PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
	GOTO mission_rock1_failed
ENDIF     

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT mercedes_rock1 -883.26 1159.30

timerb = 0

WHILE timerb < 2500

	WAIT 0

	IF IS_CHAR_DEAD mercedes_rock1
		PRINT_NOW ( RBM1_8 ) 5000 1 //"You idiot Mercedes is dead!"
		GOTO mission_rock1_failed
	ENDIF
	
ENDWHILE  	 

SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 OFF
SET_POLICE_IGNORE_PLAYER player1 OFF
RESTORE_CAMERA_JUMPCUT
DELETE_CHAR mercedes_rock1 

GOTO mission_rock1_passed


// ****************************************** Mission Failed *******************************

mission_rock1_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN


   

// *************************************** Mission Passed **********************************

mission_rock1_passed:

flag_rock_mission1_passed = 1
REGISTER_MISSION_PASSED ( ROCK_1 )
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
CLEAR_WANTED_LEVEL player1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 2000 5000 1 //"Mission Passed!"
ADD_SCORE player1 2000
START_NEW_SCRIPT rock_mission2_loop
RETURN
	


// *************************************** Mission Cleanup *********************************

mission_cleanup_rock1:

flag_player_on_mission = 0

SET_CAR_DENSITY_MULTIPLIER 1.0

IF NOT IS_CAR_DEAD car3_rock1
	REMOVE_UPSIDEDOWN_CAR_CHECK car3_rock1
	REMOVE_STUCK_CAR_CHECK car3_rock1
ENDIF

IF NOT IS_CHAR_DEAD mercedes_rock1
	REMOVE_CHAR_ELEGANTLY mercedes_rock1
ENDIF

IF IS_PLAYER_PLAYING player1

	IF NOT IS_PLAYER_IN_ANY_CAR player1
		SET_CHAR_ANSWERING_MOBILE scplayer FALSE
	ENDIF

ENDIF

REMOVE_BLIP radar_blip_merc_rock1
REMOVE_BLIP radar_blip_deal_rock1
REMOVE_BLIP radar_blip_coord2_rock1
REMOVE_BLIP radar_blip_studio_rock1
REMOVE_BLIP radar_blip_drug1_rock1
REMOVE_BLIP radar_blip_dealer1_rock1
CLEAR_ONSCREEN_TIMER timer_rock1
REMOVE_PICKUP drug1_rock1
MARK_MODEL_AS_NO_LONGER_NEEDED BMYBB
MARK_MODEL_AS_NO_LONGER_NEEDED BUDDYSHOT
MARK_MODEL_AS_NO_LONGER_NEEDED STINGER
MARK_MODEL_AS_NO_LONGER_NEEDED PCJ600
MARK_MODEL_AS_NO_LONGER_NEEDED cellphone
UNLOAD_SPECIAL_CHARACTER 6
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN
		
// mini scutscene for the player and dealer1

dealer_cutscene:

SWITCH_WIDESCREEN ON
STORE_CAR_PLAYER_IS_IN player1 cutcar_rock1
CLEAR_THIS_PRINT ( HORN ) // Removes the horn message to stop it being displayed in cutscene
GET_PLAYER_CHAR player1 scplayer
FREEZE_ONSCREEN_TIMER TRUE
REMOVE_BLIP radar_blip_deal_rock1

LOAD_MISSION_AUDIO 1 ( ROK1_9 ) // Thanks for the money sucker

LOAD_MISSION_AUDIO 2 ( ROK1_1A ) //Looking for something special? I got what you need!

WHILE NOT HAS_MISSION_AUDIO_LOADED 2
OR NOT HAS_MISSION_AUDIO_LOADED 1

	WAIT 0

ENDWHILE

SET_PLAYER_CONTROL player1 OFF
SET_FIXED_CAMERA_POSITION -504.261 1131.601 14.157 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -505.183 1131.776 13.81 JUMP_CUT


CLEAR_AREA -517.476 1121.888 10.05 1.0 FALSE
CREATE_CHAR PEDTYPE_CIVMALE BMYBB -517.476 1121.888 10.05 dealer1_rock1


CLEAR_CHAR_THREAT_SEARCH dealer1_rock1
SET_CHAR_ONLY_DAMAGED_BY_PLAYER dealer1_rock1 TRUE 
SET_CHAR_MONEY dealer1_rock1 1000

flag_dealer1_created_rock1 = 1
timera = 0
dealer1_in_position_rock1 = 1

WHILE NOT dealer1_in_position_rock1 = 8

	WAIT 0
	
	IF flag_dealer1_dead_rock1 = 0
		
		IF IS_CHAR_DEAD dealer1_rock1
			flag_dealer1_dead_rock1 = 1
		ELSE
		
			IF dealer1_in_position_rock1 = 1
				 					
				IF NOT IS_CAR_DEAD cutcar_rock1 
				   	GET_OFFSET_FROM_CAR_IN_WORLD_COORDS cutcar_rock1 -1.7267 0.1686 -0.0662 dealer1_dest_x_rock1 dealer1_dest_y_rock1 dealer1_dest_z_rock1
				ENDIF

				CLEAR_AREA dealer1_dest_x_rock1 dealer1_dest_y_rock1 dealer1_dest_z_rock1 1.0 FALSE
				SET_CHAR_OBJ_RUN_TO_COORD dealer1_rock1 dealer1_dest_x_rock1 dealer1_dest_y_rock1
				timera = 0
				dealer1_in_position_rock1 = 2
				
			ENDIF

			IF dealer1_in_position_rock1 = 2

				IF timera >= 5000
					SET_CHAR_COORDINATES dealer1_rock1 dealer1_dest_x_rock1 dealer1_dest_y_rock1 dealer1_dest_z_rock1
				ENDIF 
	
				IF LOCATE_CHAR_ON_FOOT_2D dealer1_rock1 dealer1_dest_x_rock1 dealer1_dest_y_rock1 0.5 0.5 FALSE
					TURN_CHAR_TO_FACE_PLAYER dealer1_rock1 player1
					SET_CHAR_OBJ_NO_OBJ dealer1_rock1
					SET_CHAR_WAIT_STATE dealer1_rock1 WAITSTATE_PLAYANIM_CHAT 3000
					PLAY_MISSION_AUDIO 2 // Looking for something special? I got what you need!
					PRINT_NOW ( ROK1_1A ) 3000 1 //"Looking for something special? I got what you need!
					ADD_SCORE player1 -500
					timera = 0
					dealer1_in_position_rock1 = 3
				ENDIF
	
			ENDIF

			IF dealer1_in_position_rock1 = 3

				IF HAS_MISSION_AUDIO_FINISHED 2
					CLEAR_THIS_PRINT ( ROK1_1A )
					dealer1_in_position_rock1 = 4
				ENDIF
				
			ENDIF 
	
			IF dealer1_in_position_rock1 = 4
		
				IF timera >= 3000
					PLAY_MISSION_AUDIO 1 // Thanks for the money sucker! 
					PRINT_NOW ( ROK1_9 ) 5000 1 //"Thanks for the money sucker!"
					GIVE_WEAPON_TO_CHAR dealer1_rock1 WEAPONTYPE_STUBBY_SHOTGUN 30000 // Set to infinate ammo

					//IF NOT IS_CAR_DEAD cutcar_rock1
						//SET_CHAR_WAIT_STATE dealer1_rock1 WAITSTATE_PLAYANIM_DUCK 100000
					   //	GET_NEAREST_TYRE_TO_POINT cutcar_rock1 dealer1_dest_x_rock1 dealer1_dest_y_rock1 tyre_number_rock1 
					   //	BURST_CAR_TYRE cutcar_rock1 tyre_number_rock1
					   //	timerb = 0
					//ENDIF

					dealer1_in_position_rock1 = 5
				ENDIF
				
			ENDIF
			
			IF dealer1_in_position_rock1 = 5
				   
				IF NOT IS_CHAR_DEAD dealer1_rock1
					CLEAR_AREA -523.372 1117.609 9.91 1.0 FALSE 
					CREATE_CAR PCJ600 -523.372 1117.609 9.91 bike_rock1
					SET_CAR_HEADING bike_rock1 55.96 
					SET_CHAR_ONLY_DAMAGED_BY_PLAYER dealer1_rock1 FALSE

					IF NOT IS_CAR_DEAD bike_rock1
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER dealer1_rock1 bike_rock1
						flag_dealer_car_rock1 = 1
					ELSE
						SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS dealer1_rock1 player1
						flag_dealer_foot_rock1 = 1
					ENDIF
						
					timera = 0 
					dealer1_in_position_rock1 = 6
				ENDIF
												
			ENDIF   	

			IF dealer1_in_position_rock1 = 6
				
				IF flag_dealer_foot_rock1 = 1
					dealer1_in_position_rock1 = 8
				ENDIF	 
			   
				IF flag_dealer_car_rock1 = 1

					IF timera > 3000
				
						CLEAR_AREA -518.031 1126.795 11.975 1.0 FALSE 
						SET_FIXED_CAMERA_POSITION -518.031 1126.795 11.975 0.0 0.0 0.0
						POINT_CAMERA_AT_POINT -518.735 1126.094 11.86 JUMP_CUT 

						IF IS_CHAR_IN_ANY_CAR dealer1_rock1

							IF NOT IS_CAR_DEAD bike_rock1
								timerb = 0
								ADD_BLIP_FOR_CHAR dealer1_rock1 radar_blip_dealer1_rock1
								PRINT_NOW ( RBM1_17 ) 5000 1 //"Kill the dealer and get the drugs!"
								SET_CAR_DRIVING_STYLE bike_rock1 2
								SET_CAR_CRUISE_SPEED bike_rock1 40.0
								CAR_WANDER_RANDOMLY bike_rock1
								flag_dealer1_in_car_rock1 = 1
								dealer1_in_position_rock1 = 7
							ENDIF
							
						ENDIF

					ENDIF

				ENDIF
				
			ENDIF

			IF dealer1_in_position_rock1 = 7
			
				IF timerb > 1500
					dealer1_in_position_rock1 = 8
				ENDIF
				
			ENDIF	 
		   						
		ENDIF

	ENDIF

	IF HAS_MISSION_AUDIO_FINISHED 1
		CLEAR_THIS_PRINT ( ROK1_9 ) // Thanks for the money sucker! 
	ENDIF

	IF HAS_MISSION_AUDIO_FINISHED 2
		CLEAR_THIS_PRINT ( ROK1_1A ) // Thanks for the money sucker! 
	ENDIF
	   	
ENDWHILE

IF NOT IS_CAR_DEAD bike_rock1
	SET_CAR_DRIVING_STYLE bike_rock1 2
	SET_CAR_CRUISE_SPEED bike_rock1 40.0
	CAR_WANDER_RANDOMLY bike_rock1
ENDIF

IF HAS_MISSION_AUDIO_FINISHED 1
	CLEAR_THIS_PRINT ( ROK1_9 ) // Thanks for the money sucker! 
ENDIF

IF HAS_MISSION_AUDIO_FINISHED 2
	CLEAR_THIS_PRINT ( ROK1_1A ) // Thanks for the money sucker! 
ENDIF
   				
SET_POLICE_IGNORE_PLAYER player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 OFF

IF NOT IS_CAR_DEAD cutcar_rock1 
	LOCK_CAR_DOORS cutcar_rock1 CARLOCK_UNLOCKED
ENDIF

SET_CAR_DENSITY_MULTIPLIER 0.5

SET_CAMERA_BEHIND_PLAYER
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
FREEZE_ONSCREEN_TIMER FALSE
RESTORE_CAMERA_JUMPCUT
flag_done_cutscene_rock1 = 1
	  
RETURN
					  							
// Checks to see if the drugs have been picked up

// Drug1 collection

drug1_collection_rock1:

IF flag_drug1_collected_rock1 = 0

	IF HAS_PICKUP_BEEN_COLLECTED drug1_rock1
		REMOVE_BLIP radar_blip_drug1_rock1
		++ counter_number_drugs_collected
		flag_drug1_collected_rock1 = 1
	ENDIF
	
ENDIF 

RETURN

}

