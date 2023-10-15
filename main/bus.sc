MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// **********************************bus routes*********************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

 
// Variables for mission

VAR_INT where_bus bus_created bus1 bus_driver bus_position stop_check_on_mission 
VAR_INT random_busped1 random_busped2 random_busped3 move_bus bus_can_go 
VAR_INT time_to_get_start time_to_get_end total_time_to_get bus_fares

//VAR_INT test_counter 

VAR_FLOAT busx busy busz bus_heading ped_walkx ped_walky   
VAR_FLOAT bus_coordx1 bus_coordx2 bus_coordx3 bus_coordx4 bus_coordx5 bus_coordx6 bus_coordx7 bus_coordx8 bus_coordx9 bus_coordx10
VAR_FLOAT bus_coordy1 bus_coordy2 bus_coordy3 bus_coordy4 bus_coordy5 bus_coordy6 bus_coordy7 bus_coordy8 bus_coordy9 bus_coordy10
VAR_FLOAT bus_coordz1 bus_coordz2 bus_coordz3 bus_coordz4 bus_coordz5 bus_coordz6 bus_coordz7 bus_coordz8 bus_coordz9 bus_coordz10
VAR_FLOAT bus_coordx11 bus_coordx12 bus_coordx13 bus_coordx14 bus_coordx15 bus_coordx16 bus_coordx17 
VAR_FLOAT bus_coordy11 bus_coordy12 bus_coordy13 bus_coordy14 bus_coordy15 bus_coordy16 bus_coordy17 
VAR_FLOAT bus_coordz11 bus_coordz12 bus_coordz13 bus_coordz14 bus_coordz15 bus_coordz16 bus_coordz17
 


/*
// ****************************************Mission Start************************************
//NORTH MAINLAND ROUTE
//downtown
bussign1 -481.5 1345.8 12.1	//across from VAJ finance
bussign1 -747.8 1320.7 12.2	//outside taco bell
bussign1 -877.4 1347.3 11.9	//west of stadium entrance
bussign1 -871.9 1071.0 11.5	//outside concert hall
bussign1 -382.2 1010.3 10.3 //outside Gspotlight building
bussign1 -292.9 1287.3 12.2	//outside last corner gspot jump building

//SOUTH MAINLAND ROUTE
//little havana
bussign1 -905.7 -662.4 11.3	//across from screw this
bussign1 -985.3 -541.7 11.0	//behind ice cream factory    - taken out.
bussign1 -998.7 -517.2 11.0	//across the road from the one behind the ice cream factory
bussign1 -1059.1 -342.3 11.0 //South of the PrintWorks
bussign1 -1124.9 -595.1 11.7 //outside coffee shop
bussign1 -1198.0 -415.5 11.0 //west of basketball courts in havana
//airport
bussign1 -1438.6 -777.9 15.2//outside airport 
bussign1 -1019.2 -913.6 14.8//outside sunshine autos



//NORTH BEACH ROUTE
//north beach
bussign1 308.7 1051.8 13.7 //West of big mall
bussign1 452.3 1270.6 18.0 //north of big mall
bussign1 497.0 1018.5 18.6 //east of big mall
bussign1 524.5 625.11 11.5 //north and across the road of the Sandcastle Hotel
//north beach bottom
bussign1 431.1 314.1 12.1
bussign1 475.0 632.2 11.7 //across from SWANK pad 
bussign1 232.8 718.7 11.5 //just after loooong curve leadign to Big Mall
bussign1 512.0 398.9 11.5 //south and across the road of the Sandcastle Hotel

//SOUTH BEACH ROUTE
//north beach west
bussign1 186.5 -483.8 11.5 //outside Bunch of Tools (close to construction yard)
bussign1 322.1 -78.3 11.4  //next to funky granite shaped houses
//ocean drive north
bussign1 490.1 -5.5 11.5 //outside sex pad 
bussign1 431.4 -454.4 10.6 //north of the police station
//washington north
bussign1 -75.5 -979.0 10.9 //outside Small Mall (WEST)
bussign1 124.7 -806.3 10.9 //across from strange glowing red building
bussign1 214.3 -974.5 10.9 //behind Dakota hotel
//washington south
bussign1 157.4 -1331.3 10.8//outside underpass shortcut
bussign1 -27.4 -1562.7 10.9//across from southmost statue
bussign1 -19.2 -1304.4 10.9//next to the pay n spray
*/

SET_DEATHARREST_STATE OFF
SCRIPT_NAME bus
bus_position = 1
{
bus_inner:

	IF bus_created = 0
		WAIT 500          
		move_bus ++
		IF move_bus > 30  //every 15 secs move the position of the bus
			bus_position ++
			move_bus = 0
		ENDIF
		IF bus_position > 17
			bus_position = 1
		ENDIF
	ELSE
		WAIT 500
	ENDIF
	
	//IF test_counter = 0
		//DISPLAY_NTH_ONSCREEN_COUNTER bus_position COUNTER_DISPLAY_NUMBER 1 
		//DISPLAY_NTH_ONSCREEN_COUNTER bus_created COUNTER_DISPLAY_NUMBER 2 
		//test_counter = 1
	//ENDIF
		

	IF flag_player_on_mission = 0
		stop_check_on_mission = 0
		IF bus_created = 0

			IF IS_PLAYER_PLAYING player1
				IF IS_PLAYER_IN_ANY_CAR player1 
					IF IS_PLAYER_IN_MODEL player1 coach
						IF IS_PLAYER_STOPPED player1 
							GET_GAME_TIMER time_to_get_end
							total_time_to_get = time_to_get_end - time_to_get_start  
							IF total_time_to_get > 1000
								GET_BUS_FARES_COLLECTED_BY_PLAYER player1 bus_fares
								IF bus_fares > 0 
									PRINT_WITH_NUMBER_BIG BONUS 5 50 1
									ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
									ADD_SCORE player1 5   								
									GET_GAME_TIMER time_to_get_start
									bus_fares = 0
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
							  
			//BEACH ROUTE 
			IF IS_PLAYER_PLAYING player1
				IF IS_PLAYER_IN_ZONE player1 BEACH1 
				OR IS_PLAYER_IN_ZONE player1 BEACH2
				OR IS_PLAYER_IN_ZONE player1 BEACH3
					IF flag_player_in_stripclub = 0
						IF flag_player_in_hotel = 0
							IF flag_player_in_malibu = 0
								IF  flag_player_in_mall = 0
									IF flag_player_in_cop_shop = 0 	
										IF bus_position = 1		//outside Small Mall (WEST)
											busx = -77.6	
											busy = -982.5
											busz = 9.3					   
											bus_heading = 9.8			  
										ENDIF							 				
										IF bus_position = 2 	//across from strange glowing red building
											busx = 120.0 				 				
											busy = -807.3				    
											busz = 9.3			           
											bus_heading = 333.5			  				
										ENDIF							     
										IF bus_position = 3 	//outside Bunch of Tools (close to construction yard)
											busx = 183.2 				   				  
											busy = -488.9				     
											busz = 9.9			 		  
											bus_heading = 356.5			   				
										ENDIF							     
										IF bus_position = 4 	//next to funky granite shaped houses
											busx = 318.6				  				
											busy = -82.7				    
											busz = 9.6  		    	  
											bus_heading = 351.4			  				
										ENDIF							    
										IF bus_position = 5 	//across from SWANK pad
											busx = 472.7				  				
											busy = 627.8				    
											busz = 10.0 		     	  
											bus_heading = 1.7			  				
										ENDIF							     
										IF bus_position = 6 	//just after loooong curve leadign to Big Mall
											busx = 226.5				   				
											busy = 719.5				     
											busz = 9.7		        	   
											bus_heading = 304.3			   				
										ENDIF							     
										IF bus_position = 7 	//West of big mall
											busx = 306.9 				   				
											busy = 1044.8	 			    
											busz = 12.1		         	    
											bus_heading = 19.4			   				
										ENDIF							    
										IF bus_position = 8 	//North of big mall
											busx = 448.7 				   				
											busy = 1274.3				   
											busz = 16.3		        	   
											bus_heading = 269.5			   				
										ENDIF							   
										IF bus_position = 9 	//East of big mall
											busx = 499.5 				   				
											busy = 1022.8				   
											busz = 16.8		         	   
											bus_heading = 192.4			   				
										ENDIF
										IF bus_position = 10 	//North and across the road of the Sandcastle Hotel
											busx = 528.1
											busy = 632.5
											busz = 9.8
											bus_heading = 180.9
										ENDIF
										IF bus_position = 11 	//South and across the road of the Sandcastle Hotel
											busx = 516.2
											busy = 403.6
											busz = 9.7
											bus_heading = 162.7
										ENDIF
										IF bus_position = 12 	//outside sex pad
											busx = 491.5
											busy = 0.6 
											busz = 9.6
											bus_heading = 194.7
										ENDIF
										IF bus_position = 13 	//north of the police station
											busx = 434.1 
											busy = -454.1
											busz = 9.0
											bus_heading = 178.5
										ENDIF
										IF bus_position = 14 	//behind Dakota hotel
											busx = 217.1 
											busy = -974.4
											busz = 9.0
											bus_heading = 168.2
										ENDIF
										IF bus_position = 15 	//outside underpass shortcut
											busx = 160.6  
											busy = -1329.6
											busz = 9.0
											bus_heading = 172.8
										ENDIF
										IF bus_position = 16 	//across from southmost statue
											busx = -26.6  
											busy = -1566.2
											busz = 9.0
											bus_heading = 84.0
										ENDIF
										IF bus_position = 17 	//next to the pay n spray
											busx = -21.6  
											busy = -1307.4
											busz = 9.0
											bus_heading = 358.1
										ENDIF
										GOSUB creating_bus
										IF bus_created = 1 
											where_bus = 1
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			//MAINLAND ROUTE 
			IF IS_PLAYER_PLAYING player1
				IF IS_PLAYER_IN_ZONE player1 DTOWN 
				OR IS_PLAYER_IN_ZONE player1 HAITI
				OR IS_PLAYER_IN_ZONE player1 HAVANA
				OR IS_PLAYER_IN_ZONE player1 A_PORT
				OR IS_PLAYER_IN_ZONE player1 JUNKY
					IF flag_player_in_bank = 0
						IF flag_player_in_shooting_range = 0	
							IF bus_position > 13
								bus_position = 1
							ENDIF	
							IF bus_position = 1		//outside Gspotlight building
								busx = -385.7	
								busy = 1008.3
								busz = 8.4					   
								bus_heading = 338.4			  
							ENDIF							 				
							IF bus_position = 2		//outside last corner gspot jump building
								busx = -295.4	
								busy = 1283.6
								busz = 10.1					   
								bus_heading = 0.0			  
							ENDIF							 				
							IF bus_position = 3		//across from VAJ finance
								busx = -477.4	
								busy = 1344.0
								busz = 10.1					   
								bus_heading = 97.2			  
							ENDIF							 				
							IF bus_position = 4		//outside taco bell
								busx = -744.3	
								busy = 1319.0
								busz = 10.1					   
								bus_heading = 101.4			  
							ENDIF							 				
							IF bus_position = 5		//west of stadium entrance
								busx = -875.4	
								busy = 1351.1
								busz = 9.8					   
								bus_heading = 187.2			  
							ENDIF							 				
							IF bus_position = 6		//outside concert hall
								busx = -869.5	
								busy = 1074.8
								busz = 9.4					   
								bus_heading = 182.7			  
							ENDIF							 				
							IF bus_position = 7		//behind ice cream factory
								busx = -996.5	
								busy = -513.8
								busz = 9.3					   
								bus_heading = 186.3			  
							ENDIF							 				
							IF bus_position = 8		//across from screw this
								busx = -910.1	
								busy = -660.4
								busz = 9.6					   
								bus_heading = 277.9			  
							ENDIF							 				
							IF bus_position = 9		//outside airport
								busx = -1432.9	
								busy = -780.5
								busz = 13.2					   
								bus_heading = 88.4			  
							ENDIF							 				
							IF bus_position = 10	//outside sunshine autos
								busx = -1017.7	
								busy = -918.7
								busz = 12.9					   
								bus_heading = 46.4			  
							ENDIF							 				
							IF bus_position = 11	//outside coffee shop
								busx = -1130.8	
								busy = -594.3
								busz = 10.0					   
								bus_heading = 275.0			  
							ENDIF							 				
							IF bus_position = 12	//west of basketball courts in havana
								busx = -1200.6	
								busy = -420.0
								busz = 9.3					   
								bus_heading = 5.8			  
							ENDIF							 				
							IF bus_position = 13	//South of the PrintWorks
								busx = -1061.0	
								busy = -340.2
								busz = 9.3					   
								bus_heading = 278.5			  
							ENDIF							 				
							GOSUB creating_bus
							IF bus_created = 1 
								where_bus = 2
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF

		ELSE
			IF flag_player_in_stripclub = 1
			OR flag_player_in_hotel = 1
			OR flag_player_in_malibu = 1
			OR flag_player_in_mall = 1
			OR flag_player_in_bank = 1
				GOSUB deleting_bus_stuff
			ENDIF
			
			IF flag_player_in_shooting_range = 1
			OR flag_player_in_cop_shop = 1	
				GOSUB deleting_bus_stuff
			ENDIF


			//BEACH ROUTE 
			IF where_bus = 1 
				IF IS_PLAYER_PLAYING player1
					IF IS_PLAYER_IN_ZONE player1 BEACH1
					OR IS_PLAYER_IN_ZONE player1 BEACH2
					OR IS_PLAYER_IN_ZONE player1 BEACH3
						bus_coordx1 = -77.6	   //outside Small Mall (WEST)
						bus_coordy1 = -982.5 
						bus_coordz1 = 9.4
						bus_coordx2 = 120.0    //across from strange glowing red building
						bus_coordy2 = -807.3 
						bus_coordz2 = 9.4
						bus_coordx3 = 183.2    //outside Bunch of Tools (close to construction yard)
						bus_coordy3 = -488.9 
						bus_coordz3 = 10.9
						bus_coordx4 = 318.6    //next to funky granite shaped houses
						bus_coordy4 = -82.7 
						bus_coordz4 = 9.6   
						bus_coordx5 = 472.7    //across from SWANK pad
						bus_coordy5 = 627.8
						bus_coordz5 = 10.0  
						bus_coordx6 = 226.5    //just after loooong curve leadign to Big Mall
						bus_coordy6 = 719.5
						bus_coordz6 = 9.7
						bus_coordx7 = 306.9    //West of big mall
						bus_coordy7 = 1044.8
						bus_coordz7 = 11.9
						bus_coordx8 = 448.7    //North of big mall
						bus_coordy8 = 1274.3
						bus_coordz8 = 16.1
						bus_coordx9 = 499.5    //East of big mall
						bus_coordy9 = 1022.8
						bus_coordz9 = 16.8
						bus_coordx10 = 528.1   //North and across the road of the Sandcastle Hotel
						bus_coordy10 = 632.5
						bus_coordz10 = 9.8
						bus_coordx11 = 516.2   //South and across the road of the Sandcastle Hotel
						bus_coordy11 = 403.6
						bus_coordz11 = 9.7
						bus_coordx12 = 491.5   //outside sex pad
						bus_coordy12 = 0.6 
						bus_coordz12 = 9.6
						bus_coordx13 = 434.1   //north of the police station
						bus_coordy13 = -454.1 
						bus_coordz13 = 9.7
						bus_coordx14 = 217.1   //behind Dakota hotel
						bus_coordy14 = -974.4 
						bus_coordz14 = 9.0
						bus_coordx15 = 160.6   //outside underpass shortcut
						bus_coordy15 = -1329.6 
						bus_coordz15 = 9.0
						bus_coordx16 = -26.6   //across from southmost statue
						bus_coordy16 = -1566.2 
						bus_coordz16 = 9.0
						bus_coordx17 = -21.6   //next to the pay n spray
						bus_coordy17 = -1307.4 
						bus_coordz17 = 9.0
						GOSUB setting_speed
					ELSE
						GOSUB deleting_bus_stuff
					ENDIF
				ENDIF
			ENDIF
			
			
			//MAINLAND ROUTE 
			IF where_bus = 2 
				IF IS_PLAYER_PLAYING player1
					IF IS_PLAYER_IN_ZONE player1 DTOWN 
					OR IS_PLAYER_IN_ZONE player1 HAITI
					OR IS_PLAYER_IN_ZONE player1 HAVANA
					OR IS_PLAYER_IN_ZONE player1 A_PORT
					OR IS_PLAYER_IN_ZONE player1 JUNKY
						bus_coordx1 = -385.7   //outside Gspotlight building
						bus_coordy1 = 1008.3 
						bus_coordz1 = 8.4		
						bus_coordx2 = -295.4   //outside last corner gspot jump building
						bus_coordy2 = 1283.6 
						bus_coordz2 = 10.1		
						bus_coordx3 = -477.4   //across from VAJ finance
						bus_coordy3 = 1344.0 
						bus_coordz3 = 10.1	
						bus_coordx4 = -744.3   //outside taco bell
						bus_coordy4 = 1319.0 
						bus_coordz4 = 10.1		 
						bus_coordx5 = -875.4   //west of stadium entrance
						bus_coordy5 = 1351.1
						bus_coordz5 = 9.8		 
						bus_coordx6 = -869.5   //outside concert hall
						bus_coordy6 = 1074.8
						bus_coordz6 = 9.4		
						bus_coordx7 = -996.5   //behind ice cream factory
						bus_coordy7 = -513.8
						bus_coordz7 = 9.3		
						bus_coordx8 = -910.1   //across from screw this
						bus_coordy8 = -660.4
						bus_coordz8 = 9.6		
						bus_coordx9 = -1432.9  //outside airport
						bus_coordy9 = -780.5
						bus_coordz9 = 13.2		
						bus_coordx10 = -1017.7 //outside sunshine autos
						bus_coordy10 = -918.7
						bus_coordz10 = 12.9		
						bus_coordx11 = -1130.8 //outside coffee shop
						bus_coordy11 = -594.3
						bus_coordz11 = 10.0		
						bus_coordx12 = -1200.6 //west of basketball courts in havana
						bus_coordy12 = -420.0
						bus_coordz12 = 9.3		
						bus_coordx13 = -1061.0 //South of the PrintWorks
						bus_coordy13 = -340.2
						bus_coordz13 = 9.3		
						GOSUB setting_speed
					ELSE
						GOSUB deleting_bus_stuff
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		IF stop_check_on_mission = 0
			GOSUB deleting_bus_stuff
			stop_check_on_mission = 1
		ENDIF
	ENDIF
	 
GOTO bus_inner
}
MISSION_END


{
creating_bus:
IF LOCATE_PLAYER_ANY_MEANS_3D player1 busx busy busz 180.0 180.0 180.0 FALSE
	IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 busx busy busz 115.0 115.0 115.0 FALSE
		REQUEST_MODEL coach
		WHILE NOT HAS_MODEL_LOADED coach
			WAIT 0
		ENDWHILE
	ENDIF
	IF IS_PLAYER_PLAYING player1 
		IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 busx busy busz 115.0 115.0 115.0 FALSE
			CREATE_CAR coach busx busy busz bus1
			SET_VEHICLE_TO_FADE_IN bus1 0 
			SET_CAR_HEADING bus1 bus_heading  
			SET_CAR_DRIVING_STYLE bus1 0 
			CREATE_RANDOM_CHAR busx busy 30.0 bus_driver
			WARP_CHAR_INTO_CAR bus_driver bus1
			bus_created = 1
		ELSE
			MARK_MODEL_AS_NO_LONGER_NEEDED coach 
		ENDIF
	ENDIF
ENDIF
RETURN
}




{
setting_speed:
IF NOT IS_CAR_DEAD bus1
	IF NOT IS_CHAR_DEAD bus_driver 
		IF IS_CHAR_SITTING_IN_CAR bus_driver bus1
			IF bus_can_go = 0
				IF bus_position = 1
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx1 bus_coordy1 bus_coordz1
				ENDIF
				IF bus_position = 2
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx2 bus_coordy2 bus_coordz2
				ENDIF
				IF bus_position = 3
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx3 bus_coordy3 bus_coordz3
				ENDIF
				IF bus_position = 4
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx4 bus_coordy4 bus_coordz4
				ENDIF
				IF bus_position = 5
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx5 bus_coordy5 bus_coordz5
				ENDIF
				IF bus_position = 6
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx6 bus_coordy6 bus_coordz6
				ENDIF
				IF bus_position = 7
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx7 bus_coordy7 bus_coordz7
				ENDIF
				IF bus_position = 8
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx8 bus_coordy8 bus_coordz8
				ENDIF
				IF bus_position = 9
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx9 bus_coordy9 bus_coordz9
				ENDIF
				IF bus_position = 10
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx10 bus_coordy10 bus_coordz10
				ENDIF
				IF bus_position = 11
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx11 bus_coordy11 bus_coordz11
				ENDIF
				IF bus_position = 12
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx12 bus_coordy12 bus_coordz12
				ENDIF
				IF bus_position = 13
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx13 bus_coordy13 bus_coordz13
				ENDIF
				IF bus_position = 14
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx14 bus_coordy14 bus_coordz14
				ENDIF
				IF bus_position = 15
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx15 bus_coordy15 bus_coordz15
				ENDIF
				IF bus_position = 16
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx16 bus_coordy16 bus_coordz16
				ENDIF
				IF bus_position = 17
					CAR_GOTO_COORDINATES_ACCURATE bus1 bus_coordx17 bus_coordy17 bus_coordz17
				ENDIF
				SET_CAR_CRUISE_SPEED bus1 15.0
				bus_can_go = 1
			ENDIF
		ELSE		
			GOSUB deleting_bus_stuff
		ENDIF 
	ELSE		
		GOSUB deleting_bus_stuff
	ENDIF 
ELSE		
	GOSUB deleting_bus_stuff
ENDIF 

moving_bus:
IF IS_PLAYER_PLAYING player1 
	IF NOT IS_CAR_DEAD bus1
		IF NOT IS_CHAR_DEAD bus_driver 
			IF IS_CHAR_SITTING_IN_CAR bus_driver bus1 	
				GET_CAR_COORDINATES bus1 busx busy busz 	 
				IF LOCATE_PLAYER_ANY_MEANS_3D player1 busx busy busz 180.0 180.0 180.0 FALSE 
					IF bus_position = 1 
						IF LOCATE_CAR_2D bus1 bus_coordx1 bus_coordy1 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
					IF bus_position = 2 
						IF LOCATE_CAR_2D bus1 bus_coordx2 bus_coordy2 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
					IF bus_position = 3 
						IF LOCATE_CAR_2D bus1 bus_coordx3 bus_coordy3 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
					IF bus_position = 4 
						IF LOCATE_CAR_2D bus1 bus_coordx4 bus_coordy4 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
					IF bus_position = 5 
						IF LOCATE_CAR_2D bus1 bus_coordx5 bus_coordy5 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
					IF bus_position = 6 
						IF LOCATE_CAR_2D bus1 bus_coordx6 bus_coordy6 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
					IF bus_position = 7 
						IF LOCATE_CAR_2D bus1 bus_coordx7 bus_coordy7 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
					IF bus_position = 8 
						IF LOCATE_CAR_2D bus1 bus_coordx8 bus_coordy8 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
					IF bus_position = 9 
						IF LOCATE_CAR_2D bus1 bus_coordx9 bus_coordy9 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
					IF bus_position = 10 
						IF LOCATE_CAR_2D bus1 bus_coordx10 bus_coordy10 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
					IF bus_position = 11 
						IF LOCATE_CAR_2D bus1 bus_coordx11 bus_coordy11 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
					IF bus_position = 12 
						IF LOCATE_CAR_2D bus1 bus_coordx12 bus_coordy12 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
					IF bus_position = 13 
						IF LOCATE_CAR_2D bus1 bus_coordx13 bus_coordy13 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
					IF bus_position = 14 
						IF LOCATE_CAR_2D bus1 bus_coordx14 bus_coordy14 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
					IF bus_position = 15 
						IF LOCATE_CAR_2D bus1 bus_coordx15 bus_coordy15 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
					IF bus_position = 16 
						IF LOCATE_CAR_2D bus1 bus_coordx16 bus_coordy16 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
					IF bus_position = 17 
						IF LOCATE_CAR_2D bus1 bus_coordx17 bus_coordy17 3.0 3.0 FALSE 
							GOSUB guys_getting_off_bus
							GOTO setting_speed 
						ENDIF
					ENDIF
				ELSE
					GOSUB deleting_bus_stuff
				ENDIF   
			ELSE
				GOSUB deleting_bus_stuff
			ENDIF 
		ELSE
			GOSUB deleting_bus_stuff
		ENDIF 
	ELSE
		GOSUB deleting_bus_stuff
	ENDIF
ELSE
	GOSUB deleting_bus_stuff
ENDIF 

RETURN
}



{
guys_getting_off_bus:

//PRINT UG 1000 1 // Si, men?


SET_CAR_CRUISE_SPEED bus1 0.0
bus_position ++
CREATE_RANDOM_CHAR_AS_PASSENGER bus1 1 random_busped1
IF NOT IS_CHAR_DEAD random_busped1 
	SET_CHAR_OBJ_LEAVE_CAR random_busped1 bus1
ENDIF 
WAIT 4700 
IF flag_player_on_mission = 0
	IF IS_PLAYER_PLAYING player1
		IF NOT IS_CAR_DEAD bus1 
			GET_OFFSET_FROM_CAR_IN_WORLD_COORDS bus1 0.0 -20.0 0.0 ped_walkx ped_walky busz
			GET_CAR_COORDINATES bus1 busx busy busz 	 
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 busx busy busz 180.0 180.0 180.0 FALSE 
				GOTO finish_early
			ENDIF 
		ENDIF
	ELSE
		GOTO finish_early
	ENDIF
	IF NOT IS_CHAR_DEAD random_busped1 
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT random_busped1 ped_walkx ped_walky 
	ENDIF  
ELSE
	GOTO finish_early
ENDIF
  
WAIT 1300
IF flag_player_on_mission = 0
	IF IS_PLAYER_PLAYING player1
		IF NOT IS_CAR_DEAD bus1 
			GET_OFFSET_FROM_CAR_IN_WORLD_COORDS bus1 0.0 -10.0 0.0 ped_walkx ped_walky busz
			CREATE_RANDOM_CHAR_AS_PASSENGER bus1 2 random_busped2 
			GET_CAR_COORDINATES bus1 busx busy busz 	 
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 busx busy busz 180.0 180.0 180.0 FALSE 
				GOTO finish_early
			ENDIF 
		ENDIF
	ELSE
		GOTO finish_early
	ENDIF
	IF NOT IS_CHAR_DEAD random_busped2 
		SET_CHAR_OBJ_LEAVE_CAR random_busped2 bus1
	ENDIF 
ELSE
	GOTO finish_early
ENDIF
WAIT 4700 
IF flag_player_on_mission = 0
	IF NOT IS_CHAR_DEAD random_busped2 
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT random_busped2 ped_walkx ped_walky 
	ENDIF    
ELSE
	GOTO finish_early
ENDIF
WAIT 1300
IF flag_player_on_mission = 0
	IF IS_PLAYER_PLAYING player1
		IF NOT IS_CAR_DEAD bus1 
			CREATE_RANDOM_CHAR_AS_PASSENGER bus1 3 random_busped3 
			GET_CAR_COORDINATES bus1 busx busy busz 	 
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 busx busy busz 180.0 180.0 180.0 FALSE 
				GOTO finish_early
			ENDIF 
		ENDIF
	ELSE
		GOTO finish_early
	ENDIF
	IF NOT IS_CHAR_DEAD random_busped3 
		SET_CHAR_OBJ_LEAVE_CAR random_busped3 bus1 
	ENDIF
ELSE
	GOTO finish_early
ENDIF
WAIT 4700 
IF flag_player_on_mission = 0
	IF NOT IS_CHAR_DEAD random_busped3 
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT random_busped3 ped_walkx ped_walky 
	ENDIF 
	IF IS_PLAYER_PLAYING player1
		IF NOT IS_CAR_DEAD bus1 
			GET_CAR_COORDINATES bus1 busx busy busz 	 
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 busx busy busz 180.0 180.0 180.0 FALSE 
				GOTO finish_early
			ENDIF
		ENDIF 
	ELSE
		GOTO finish_early
	ENDIF
ELSE
	GOTO finish_early
ENDIF
WAIT 3300
IF flag_player_on_mission = 0
	IF IS_PLAYER_PLAYING player1
		IF NOT IS_CAR_DEAD bus1 
			GET_CAR_COORDINATES bus1 busx busy busz 	 
			IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 busx busy busz 180.0 180.0 180.0 FALSE 
				GOTO finish_early
			ENDIF
		ENDIF 
	ELSE
		GOTO finish_early
	ENDIF
ELSE
	GOTO finish_early
ENDIF
WAIT 5000
finish_early:
IF where_bus = 1
	IF bus_position > 17
		bus_position = 1
	ENDIF
ENDIF
IF where_bus = 2
	IF bus_position > 13
		bus_position = 1
	ENDIF
ENDIF
MARK_CHAR_AS_NO_LONGER_NEEDED random_busped1 
MARK_CHAR_AS_NO_LONGER_NEEDED random_busped2 
MARK_CHAR_AS_NO_LONGER_NEEDED random_busped3
bus_can_go = 0 

//PRINT OOOG 1000 1 // Si, men?


RETURN
}




{
deleting_bus_stuff:




//PRINT OFF 1000 1 // Si, men?






IF NOT IS_CAR_DEAD bus1
	IF IS_PLAYER_PLAYING player1 
		IF NOT IS_PLAYER_IN_CAR player1 bus1 
			SET_CAR_DRIVING_STYLE bus1 2
			SET_CAR_CRUISE_SPEED bus1 15.0
		ENDIF
	ENDIF
ENDIF 	 
MARK_CAR_AS_NO_LONGER_NEEDED bus1 
MARK_CHAR_AS_NO_LONGER_NEEDED bus_driver 
MARK_MODEL_AS_NO_LONGER_NEEDED coach
MARK_CHAR_AS_NO_LONGER_NEEDED random_busped1
MARK_CHAR_AS_NO_LONGER_NEEDED random_busped2
MARK_CHAR_AS_NO_LONGER_NEEDED random_busped3
bus_created = 0
RETURN
}
