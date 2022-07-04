MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ********************************** Unique Stunt Jumps *********************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

 
// Variables for mission

VAR_INT	players_car_usj cash_reward_usj total_completed_usj
VAR_INT usj_number collision_counter_usj do_usj_reward
VAR_INT flag_usj1_passed flag_usj2_passed flag_usj3_passed flag_usj4_passed	flag_usj5_passed 
VAR_INT flag_usj6_passed flag_usj7_passed flag_usj8_passed flag_usj9_passed
VAR_INT flag_usj10_passed flag_usj11_passed flag_usj12_passed flag_usj13_passed flag_usj14_passed
VAR_INT flag_usj15_passed flag_usj16_passed	flag_usj17_passed flag_usj18_passed	flag_usj19_passed
VAR_INT flag_usj20_passed flag_usj21_passed flag_usj22_passed flag_usj23_passed flag_usj24_passed
VAR_INT flag_usj25_passed flag_usj26_passed	flag_usj27_passed flag_usj28_passed	flag_usj29_passed
VAR_INT flag_usj30_passed flag_usj31_passed flag_usj32_passed flag_usj33_passed flag_usj34_passed
VAR_INT flag_usj35_passed flag_usj36_passed
VAR_FLOAT car_speed_usj camera_x camera_y camera_z
VAR_FLOAT usj_start_x usj_start_y usj_start_z usj_end_x usj_end_y usj_end_z usj_jump_dist

// ****************************************Mission Start************************************

flag_usj1_passed = 0
flag_usj2_passed = 0
flag_usj3_passed = 0
flag_usj4_passed = 0
flag_usj5_passed = 0
flag_usj6_passed = 0
flag_usj7_passed = 0
flag_usj8_passed = 0
flag_usj9_passed = 0
flag_usj10_passed = 0
flag_usj11_passed = 0
flag_usj12_passed = 0
flag_usj13_passed = 0
flag_usj14_passed = 0
flag_usj15_passed = 0
flag_usj16_passed = 0
flag_usj17_passed = 0
flag_usj18_passed = 0
flag_usj19_passed = 0
flag_usj20_passed = 0
flag_usj21_passed = 0
flag_usj22_passed = 0
flag_usj23_passed = 0
flag_usj24_passed = 0
flag_usj25_passed = 0
flag_usj26_passed = 0
flag_usj27_passed = 0
flag_usj28_passed = 0
flag_usj29_passed = 0
flag_usj30_passed = 0
flag_usj31_passed = 0
flag_usj32_passed = 0
flag_usj33_passed = 0
flag_usj34_passed = 0
flag_usj35_passed = 0
flag_usj36_passed = 0

cash_reward_usj = 100
usj_number = 0
total_completed_usj = 0
do_usj_reward = 0

SET_DEATHARREST_STATE OFF
SET_UNIQUE_JUMPS_TOTAL 36

SCRIPT_NAME usj


mission_start_usj:

WAIT 0

IF NOT IS_PLAYER_PLAYING player1
	GOTO mission_start_usj
ENDIF

IF flag_usj_off = 1
	GOTO mission_start_usj
ENDIF

IF NOT IS_PLAYER_IN_ANY_CAR player1
	GOTO mission_start_usj
ENDIF
	
IF IS_PLAYER_IN_ANY_BOAT player1
	GOTO mission_start_usj
ENDIF

IF IS_PLAYER_IN_FLYING_VEHICLE player1
	GOTO mission_start_usj
ENDIF

STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_car_usj
GET_CAR_SPEED players_car_usj car_speed_usj

IF car_speed_usj < 25.0
	GOTO mission_start_usj
ENDIF

IF NOT IS_CAR_IN_AIR_PROPER players_car_usj
	GOTO mission_start_usj
ENDIF

IF IS_PLAYER_IN_ZONE player1 A_PORT
	IF LOCATE_PLAYER_IN_CAR_3D player1 -1487.781 -1044.546 18.707 3.5 3.0 3.0 0//OVER WESTERN BOARDING TUNNEL FROM EAST*
		usj_number = 1
		camera_x = -1521.9639  
		camera_y = -1039.8505
		camera_z = 24.1338
		usj_start_x = -1510.2076
		usj_start_y = -1042.8491
		usj_start_z = 32.1510 
		GOTO the_jump
	ENDIF

	IF LOCATE_PLAYER_IN_CAR_3D player1 -1352.695 -755.212 28.673 2.0 4.0 4.0 0//JUMP ONTO TERMINAL ROOF FROM SURFER DUDE BILL BOARD*
		usj_number = 2
		camera_x = -1360.8242  
		camera_y = -781.5606 
		camera_z = 37.2329
		usj_start_x = -1353.0330
		usj_start_y = -806.4550 
		usj_start_z = 39.2439 
		GOTO the_jump
	ENDIF

	IF LOCATE_PLAYER_IN_CAR_3D player1 -1216.49 -911.833 19.0 2.5 2.5 3.0 0//BOARDING STAIRS OVER ROAD ONTO BUILDING*
		usj_number = 3
		camera_x = -1200.2438 
		camera_y = -894.1972 
		camera_z = 26.7296
		usj_start_x = -1170.4802
		usj_start_y = -892.3815 
		usj_start_z = 34.0162 
		GOTO the_jump
	ENDIF

	IF LOCATE_PLAYER_IN_CAR_3D player1 -1252.139 -1054.685 22.016 4.0 4.0 3.0 0//HUGE RAMP AT END OF RUNWAY ONTO ROAD*
		usj_number = 4
		camera_x = -1194.2791
		camera_y = -1027.8624
		camera_z = 22.9790
		usj_start_x = -1201.5020
		usj_start_y = -1013.9373
		usj_start_z = 23.4673 
		GOTO the_jump
	ENDIF

	IF LOCATE_PLAYER_IN_CAR_3D player1 -1551.685 -1075.674 19.121 3.5 2.5 2.5 0//OVER WESTERN BOARDING TUNNEL FROM WEST*
		usj_number = 5
		camera_x = -1520.1648 
		camera_y = -1073.3604 
		camera_z = 24.1604
		usj_start_x = -1511.2036
		usj_start_y = -1065.2136
		usj_start_z = 32.3439 
		GOTO the_jump
	ENDIF
	
	IF LOCATE_PLAYER_IN_CAR_3D player1 -1595.712 -1272.881 19.068 3.0 3.0 2.5 0//OVER RED RADAR BUILDING FROM BORADING STAIRS*
		usj_number = 6
		camera_x =  -1564.4539
		camera_y =  -1271.5879
		camera_z = 21.5915
		usj_start_x = -1548.0720
		usj_start_y = -1255.5304
		usj_start_z = 23.9858 
		GOTO the_jump
	ENDIF
	
	IF LOCATE_PLAYER_IN_CAR_3D player1 -1553.337 -1230.952 17.194 3.0 3.0 2.5 0//OVER RED RADAR BUILDING FROM SIGN*
		usj_number = 7
		camera_x = -1590.5802
		camera_y = -1247.3733
		camera_z = 26.3087   
		usj_start_x = -1598.1204
		usj_start_y = -1252.4260
		usj_start_z = 23.7824 
		GOTO the_jump
	ENDIF
	
	IF LOCATE_PLAYER_IN_CAR_3D player1 -1340.022 -998.257 19.115 3.0 3.0 3.0 0//OVER EASTERN BOARDING TUNNEL*
		usj_number = 8
		camera_x = -1355.2749 
		camera_y = -997.9999 
		camera_z = 24.0731
		usj_start_x = -1363.2073
		usj_start_y = -996.5805 
		usj_start_z = 32.2555 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 PORNI
	IF LOCATE_PLAYER_IN_CAR_3D player1 24.721 897.801 25.103 3.0 3.5 2.5 0//FROM ROOF INTO PORN STUDIO*
		usj_number = 9
		camera_x = 0.1404 
		camera_y = 878.4036 
		camera_z = 20.2009
		usj_start_x = -15.8172
		usj_start_y = 907.1570
		usj_start_z = 28.9023 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 DOCKS
	IF LOCATE_PLAYER_IN_CAR_3D player1 -321.028 -1379.498 10.929 4.0 4.0 3.0 0//COLONELS JETTY SOUTH*
		usj_number = 25
		camera_x = -311.0497 
		camera_y = -1399.5061
		camera_z = 9.6779
		usj_start_x = -320.9215 
		usj_start_y = -1430.5988
		usj_start_z = 16.8534 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -321.028 -1276.589 10.929 4.0 4.0 3.0 0//COLONELS JETTY*
		usj_number = 26
		camera_x = -314.5936 
		camera_y = -1300.2806
		camera_z = 9.4204
		usj_start_x = -320.6415 
		usj_start_y = -1310.9570
		usj_start_z = 17.6351 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 DTOWN
	IF LOCATE_PLAYER_IN_CAR_3D player1 -674.345 1162.422 29.916 2.5 4.0 2.5 0//INFRONT OF AMMU UP STAIRS OVER STREET INTO HOG TIED*
		usj_number = 11
		camera_x = -690.7014 
		camera_y = 1199.2126   
		camera_z = 25.0565
		usj_start_x = -673.2637
		usj_start_y = 1209.8191
		usj_start_z = 32.8857 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -529.84 830.062 98.717 7.0 3.0 3.0 0//OUT OF HIGHRISE INTO HOLE IN OPPOSIT HIGHRISE*
		usj_number = 12
		camera_x = -543.2 
		camera_y = 843.4   
		camera_z = 99.2
		usj_start_x = -529.3288
		usj_start_y = 888.8258 
		usj_start_z = 77.5537 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -839.022 1153.526 31.94 3.7 2.5 2.5 0//G-SPOT OVER STREET FROM HOSPITAL*
		usj_number = 13
		camera_x = -853.7 
		camera_y = 1172.3   
		camera_z = 24.4
		usj_start_x = -837.8480
		usj_start_y = 1200.5847
		usj_start_z = 25.7884 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -312.447 1109.196 47.741 5.0 3.0 2.5 0//ON TO THE ROOF WITH THE G-SPOTLIGHT*
		usj_number = 14
		camera_x = -292.5 
		camera_y = 1102.7   
		camera_z = 40.0
		usj_start_x = -335.0812
		usj_start_y = 1055.3518
		usj_start_z = 47.3995 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 HAITI
	IF LOCATE_PLAYER_IN_CAR_3D player1 -1011.583 -30.098 15.181 2.5 2.5 2.5 0//WOODEN RAMP BEHIND SHITTY LITTLE BUILDINGS NEAR AUNTIE*
		usj_number = 15
		camera_x = -1004.1540 
		camera_y = -62.9943   
		camera_z = 15.9570
		usj_start_x = -1001.7108
		usj_start_y = -83.5744 
		usj_start_z = 22.2569 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -942.702 -114.506 15.181 2.5 2.5 2.5 0// OVER DRIED OUT CANAL/AQUADUCT*
		usj_number = 16
		camera_x = -930.7841 
		camera_y = -125.4432   
		camera_z = 12.2188
		usj_start_x = -881.2348
		usj_start_y = -107.6016
		usj_start_z = 20.2300 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -900.789 260.804 15.915 2.5 2.5 2.5 0//ONTO ROOF WITH HAITI HELI CHECKPOINT*
		usj_number = 17
		camera_x = -906.6896 
		camera_y = 238.6932 
		camera_z = 16.5044
		usj_start_x = -896.8717
		usj_start_y = 235.2098 
		usj_start_z = 23.9347 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 HAVANA
	IF LOCATE_PLAYER_IN_CAR_3D player1 -1041.895 -569.323 21.855 5.0 2.5 2.5 0//JUMP ACROSS THE STREET FROM THE ROOF - EAST FROM THE CUBANS PLACE*
		usj_number = 18
		camera_x = -1055.6156
		camera_y = -588.8613  
		camera_z = 18.1929
		usj_start_x = -1038.9431
		usj_start_y = -599.2438 
		usj_start_z = 26.4899 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 BEACH1//OCEAN BEACH
	IF LOCATE_PLAYER_IN_CAR_3D player1 208.993 -963.672 19.967 2.5 2.5 2.5 0//JUMP FROM THE MALL ACROSS ROAD AND ROOF OFF VENTS*
	//OR LOCATE_PLAYER_IN_CAR_3D player1 205.927 -975.297 19.967 2.5 2.5 2.5 0
		usj_number = 19
		camera_x = 233.5752 //209.0673 
		camera_y = -960.8961 //-980.8854 
		camera_z = 21.5283 //19.5373
		usj_start_x = 242.0566 
		usj_start_y = -963.7044
		usj_start_z = 30.6993 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 46.115 -964.415 25.883 2.5 3.5 2.5 0//MALL*
		usj_number = 20
		camera_x = 63.3356 
		camera_y = -967.6796 
		camera_z = 26.3317
		usj_start_x = 104.9159 
		usj_start_y = -964.5817
		usj_start_z = 18.515 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 110.481 -1230.6 35.67 4.0 4.0 2.5 0//OUT OF THE MULTISTOREY CARPARK*
		usj_number = 22
		camera_x = 84.5247 
		camera_y = -1258.389
		camera_z = 31.4335
		usj_start_x = 106.3865 
		usj_start_y = -1279.5221
		usj_start_z = 40.5100  
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 7.435 -1245.895 17.752 3.0 3.0 3.5 0//GAS STATION*
		usj_number = 23
		camera_x = 4.1501 
		camera_y = -1274.4602
		camera_z = 19.7525
		usj_start_x = 11.7328 
		usj_start_y = -1306.6909
		usj_start_z = 25.3238 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 9.103 -1326.505 20.361 3.0 3.0 2.5 0//PINK ROOF SOUTH FROM GAS STATION*
		usj_number = 24
		camera_x = -6.4837  
		camera_y = -1355.1759
		camera_z = 20.0450
		usj_start_x = 11.7328 
		usj_start_y = -1371.3351
		usj_start_z = 19.3237 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -321.028 -1379.498 10.929 4.0 4.0 3.0 0//COLONELS JETTY SOUTH*
		usj_number = 25
		camera_x = -311.0497 
		camera_y = -1399.5061
		camera_z = 9.6779
		usj_start_x = -320.9215 
		usj_start_y = -1430.5988
		usj_start_z = 16.8534 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 -321.028 -1276.589 10.929 4.0 4.0 3.0 0//COLONELS JETTY*
		usj_number = 26
		camera_x = -314.5936 
		camera_y = -1300.2806
		camera_z = 9.4204
		usj_start_x = -320.6415 
		usj_start_y = -1310.9570
		usj_start_z = 17.6351 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 218.05 -1152.0 12.84 2.5 2.0 2.5 0//PALLETS OVER WIDE ALLEY BEHIND OCEAN DRIVE*
		usj_number = 27
		camera_x = 228.2427
		camera_y = -1140.7739
		camera_z = 14.4116
		usj_start_x = 225.9232 
		usj_start_y = -1101.1895
		usj_start_z = 20.9205 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 259.056 -945.833 12.84 2.5 2.0 2.0 0//PALLETS OVER ROAD BEHIND OCEAN DRIVE*
		usj_number = 28
		camera_x = 259.0203
		camera_y = -963.3474
		camera_z = 10.0962
		usj_start_x = 246.7973 
		usj_start_y = -1007.5247
		usj_start_z = 22.6569 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 BEACH2

	IF LOCATE_PLAYER_IN_CAR_3D player1 284.4732 -494.1143 16.0 3.0 3.0 3.0 0 //DIRT MOUND IN CARPARK OVER RIVER BY COPSHOP*
		usj_number = 30
		camera_x = 268.9545 
		camera_y = -469.6216  
		camera_z = 15.2438 
		usj_start_x = 252.5868 
		usj_start_y = -477.8011
		usj_start_z = 20.6179 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 370.79 -709.863 19.895 3.0 3.0 3.0 0//UP STAIRS IN ALLEY BEHIND OCEAN DRIVE*
		usj_number = 31
		camera_x = 361.3011
		camera_y = -735.6794
		camera_z = 23.4501
		usj_start_x = 344.1249 
		usj_start_y = -748.2875
		usj_start_z = 31.9164 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 461.589 -522.23 18.931 3.0 3.0 3.0 0//STAIRS GOING WEST AT GUARDIAN ANGELS*
		usj_number = 32
		camera_x = 426.6392
		camera_y = -524.0469
		camera_z = 12.3656
		usj_start_x = 403.8112 
		usj_start_y = -510.4724
		usj_start_z = 18.9753 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 454.105 -504.736 18.931 3.0 3.0 3.0 0//STAIRS GOING SOUTH AT GARDIAN ANGEL*
		usj_number = 33
		camera_x = 456.6417
		camera_y = -532.0921
		camera_z = 19.3283
		usj_start_x = 436.7198 
		usj_start_y = -555.8276
		usj_start_z = 28.7096 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 460.91 -383.362 14.222 3.0 3.0 3.0 0//WOODEN RAMP AT END OF BUILDINGS SOUTH FROM MALIBU*
		usj_number = 34
		camera_x = 462.6722
		camera_y = -399.8143
		camera_z = 17.5715
		usj_start_x = 457.8847 
		usj_start_y = -413.2519
		usj_start_z = 26.4187 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 259.041 -480.608 14.688 4.0 5.0 4.0 0 //OVER RIVER NEXT TO COP SHOP*
		usj_number = 35
		camera_x = 282.5344
		camera_y = -479.8412
		camera_z = 10.4141
		usj_start_x = 290.9860 
		usj_start_y = -497.1007
		usj_start_z = 19.0179 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 BEACH3
	IF LOCATE_PLAYER_IN_CAR_3D player1 317.2051 -223.2012 42.3731 2.6 3.6 2.6 0//OFF THE TOP OF THE BUILDING SITE*
		usj_number = 10
		camera_x = 301.9448
		camera_y = -215.9068  
		camera_z = 34.4501
		usj_start_x = 309.8567 
		usj_start_y = -170.8791
		usj_start_z = 20.3312 
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 444.5 -118.4 16.0 3.0 3.0 3.0 0//MALIBU*
		usj_number = 29
		camera_x = 416.4033  
		camera_y = -125.6725 
		camera_z = 13.7649
		usj_start_x = 394.2590 
		usj_start_y = -116.6847
		usj_start_z = 19.7462  
		GOTO the_jump
	ENDIF
	IF LOCATE_PLAYER_IN_CAR_3D player1 435.8542 -334.3212 15.8977 3.0 3.0 3.0 0//SOUTH DOWN ROAD FROM MALIBU OVER BRIDGE*
		usj_number = 21
		camera_x = 420.6179
		camera_y = -367.5033 
		camera_z = 14.1343
		usj_start_x = 427.7329 
		usj_start_y = -381.8485
		usj_start_z = 18.9116 
		GOTO the_jump
	ENDIF
ENDIF

IF IS_PLAYER_IN_ZONE player1 STARI
	IF LOCATE_PLAYER_IN_CAR_3D player1 -346.818 -290.741 12.926 3.0 3.0 3.0 0//IN GARDEN UP STAIRS*
		usj_number = 36
		camera_x = -317.0066
		camera_y = -298.7890
		camera_z = 15.3976
		usj_start_x = -306.2269
		usj_start_y = -290.8040
		usj_start_z = 22.1777 
		GOTO the_jump
	ENDIF
ENDIF

GOTO mission_start_usj

the_jump:

collision_counter_usj = 0
do_usj_reward = 0

//GET_PLAYER_COORDINATES player1 usj_start_x usj_start_y usj_start_z
SET_TIME_SCALE 0.3
SET_FIXED_CAMERA_POSITION camera_x camera_y camera_z 0.0 0.0 0.0
POINT_CAMERA_AT_CAR players_car_usj FIXED JUMP_CUT

WHILE IS_CAR_IN_AIR_PROPER players_car_usj
OR collision_counter_usj < 10
	++ collision_counter_usj
	
	WAIT 0

	IF IS_CAR_DEAD players_car_usj
		usj_jump_dist = 0.0
		GOTO camera_restore
	ENDIF
	
	IF IS_CAR_IN_WATER players_car_usj
		usj_jump_dist = 0.0
		GOTO camera_restore
	ENDIF
	
	IF NOT IS_PLAYER_PLAYING player1
		usj_jump_dist = 0.0
		GOTO camera_restore
	ENDIF

	IF NOT IS_PLAYER_IN_ANY_CAR player1
		usj_jump_dist = 0.0
		GOTO camera_restore
	ENDIF

	IF do_usj_reward = 0
		IF LOCATE_PLAYER_IN_CAR_3D player1 usj_start_x usj_start_y usj_start_z 10.0 10.0 10.0 0
			do_usj_reward = 1
		ENDIF
	ENDIF
	
ENDWHILE

//GET_PLAYER_COORDINATES player1 usj_end_x usj_end_y usj_end_z
//GET_DISTANCE_BETWEEN_COORDS_3D usj_start_x usj_start_y usj_start_z usj_end_x usj_end_y usj_end_z usj_jump_dist

camera_restore:
WAIT 300
SET_TIME_SCALE 1.0
RESTORE_CAMERA_JUMPCUT

IF do_usj_reward = 1//usj_jump_dist > 20.0
	IF usj_number = 1 
	AND flag_usj1_passed = 0
		flag_usj1_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 2
	AND flag_usj2_passed = 0
		flag_usj2_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 3
	AND flag_usj3_passed = 0
		flag_usj3_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 4
	AND flag_usj4_passed = 0
		flag_usj4_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 5
	AND flag_usj5_passed = 0
		flag_usj5_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 6
	AND flag_usj6_passed = 0
		flag_usj6_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 7
	AND flag_usj7_passed = 0
		flag_usj7_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 8
	AND flag_usj8_passed = 0
		flag_usj8_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 9
	AND flag_usj9_passed = 0
		flag_usj9_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 10
	AND flag_usj10_passed = 0
		flag_usj10_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 11
	AND flag_usj11_passed = 0
		flag_usj11_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 12
	AND flag_usj12_passed = 0
		flag_usj12_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 13
	AND flag_usj13_passed = 0
		flag_usj13_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 14
	AND	flag_usj14_passed = 0
		flag_usj14_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 15
	AND flag_usj15_passed = 0
		flag_usj15_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 16
	AND	flag_usj16_passed = 0
		flag_usj16_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 17
	AND	flag_usj17_passed = 0
		flag_usj17_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 18
	AND flag_usj18_passed = 0
		flag_usj18_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 19
	AND flag_usj19_passed = 0
		flag_usj19_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 20
	AND flag_usj20_passed = 0
		flag_usj20_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 21
	AND flag_usj21_passed = 0
		flag_usj21_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 22
	AND flag_usj22_passed = 0
		flag_usj22_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 23
	AND flag_usj23_passed = 0
		flag_usj23_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 24
	AND	flag_usj24_passed = 0
		flag_usj24_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 25
	AND flag_usj25_passed = 0
		flag_usj25_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 26
	AND flag_usj26_passed = 0
		flag_usj26_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 27
	AND flag_usj27_passed = 0
		flag_usj27_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 28
	AND flag_usj28_passed = 0
		flag_usj28_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 29
	AND flag_usj29_passed = 0
		flag_usj29_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 30
	AND flag_usj30_passed = 0
		flag_usj30_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 31
	AND flag_usj31_passed = 0
		flag_usj31_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 32
	AND flag_usj32_passed = 0
		flag_usj32_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 33
	AND flag_usj33_passed = 0
		flag_usj33_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 34
	AND	flag_usj34_passed = 0
		flag_usj34_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 35
	AND flag_usj35_passed = 0
		flag_usj35_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF

	IF usj_number = 36
	AND flag_usj36_passed = 0
		flag_usj36_passed = 1
		++ total_completed_usj
		PLAYER_MADE_PROGRESS 1
		GOTO reward_usj
	ENDIF
ENDIF

GOTO mission_start_usj

reward_usj:
IF total_completed_usj < 36 
	PRINT_BIG_Q USJ 5000 5 //UNIQUE STUNT BONUS!
	PRINT_WITH_NUMBER_BIG REWARD cash_reward_usj 6000 6
	ADD_SCORE player1 cash_reward_usj
ELSE
	PRINT_BIG_Q USJ 5000 5 //UNIQUE STUNT BONUS!
	PRINT_HELP USJ_ALL //ALL UNIQUE STUNTS COMPLETED!
	PRINT_WITH_NUMBER_BIG REWARD 10000 6000 6
	ADD_SCORE player1 10000
ENDIF

do_usj_reward = 0

ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE

REGISTER_UNIQUE_JUMP_FOUND
cash_reward_usj += 100
GOTO mission_start_usj

MISSION_END










//ESCOBAR INTERNATIONAL
//-1487.781 -1044.546 18.707//OVER WESTERN BOARDING TUNNEL FROM EAST*
//-1352.695 -755.212 28.673//JUMP ONTO TERMINAL ROOF FROM SURFER DUDE BILL BOARD*
//-1216.49 -911.833 19.0//BOARDING STAIRS OVER ROAD ONTO BUILDING*
//-1252.139 -1054.685 22.016//HUGE RAMP AT END OF RUNWAY ONTO ROAD*
//-1551.685 -1075.674 19.121//OVER WESTERN BOARDING TUNNEL FROM WEST*
//-1595.712 -1272.881 19.068//OVER RED RADAR BUILDING FROM BORADING STAIRS*
//-1553.337 -1230.952 17.194//OVER RED RADAR BUILDING FROM SIGN*
//-1340.022 -998.257 19.115//OVER EASTERN BOARDING TUNNEL*
//
//PRAWN ISLAND
//24.721 897.801 25.103//FROM ROOF INTO PORN STUDIO*
//
//DOWNTOWN
//-674.345 1162.422 29.916//INFRONT OF AMMU UP STAIRS OVER STREET INTO HOG TIED*
//-529.84 830.062 98.717//OUT OF HIGHRISE INTO HOLE IN OPPOSIT HIGHRISE*
//-839.022 1153.526 31.94//G-SPOT OVER STREET FROM HOSPITAL*
//-312.447 1109.196 47.741//ON TO THE ROOF WITH THE G-SPOTLIGHT*
//
//LITTLE HAITI
//-1011.583 -30.098 15.181//WOODEN RAMP BEHIND SHITTY LITTLE BUILDINGS NEAR AUNTIE*
//-942.702 -114.506 15.181// OVER DRIED OUT CANAL/AQUADUCT*
//-900.789 260.804 15.915//ONTO ROOF WITH HAITI HELI CHECKPOINT*
//
//LITTEL HAVANA
//-1041.895 -569.323 21.855//JUMP ACROSS THE STREET FROM THE ROOF - EAST FROM THE CUBANS PLACE*
//
//OCEAN BEACH
//208.993 -963.672 19.967//JUMP FROM THE MALL ACROSS ROAD AND ROOF OFF VENTS*
//46.115 -964.415 25.883//MALL*
//110.481 -1230.6 35.67//OUT OF THE MULTISTOREY CARPARK*
//7.435 -1245.895 17.752//GAS STATION*
//9.103 -1326.505 20.361//PINK ROOF SOUTH FROM GAS STATION*
//-321.028 -1379.498 10.93//COLONELS JETTY SOUTH*
//-321.028 -1276.589 10.93//COLONELS JETTY*
//218.05 -1152.0 12.84//PALLETS OVER WIDE ALLEY BEHIND OCEAN DRIVE*
//259.056 -945.833 12.8//PALLETS OVER ROAD BEHIND OCEAN DRIVE*
//
//WASHNGTON BEACH
//284.4732 -494.1143 16.0//DIRT MOUND IN CARPARK OVER RIVER BY COPSHOP*
//370.79 -709.863 19.895//UP STAIRS IN ALLEY BEHIND OCEAN DRIVE*
//461.589 -522.23 18.931//STAIRS GOING WEST AT GUARDIAN ANGELS*
//454.105 -504.736 18.931//STAIRS GOING SOUTH AT GARDIAN ANGEL*
//460.91 -383.362 14.222//WOODEN RAMP AT END OF BUILDINGS SOUTH FROM MALIBU*
//259.041 -480.608 14.688//OVER RIVER NEXT TO COP SHOP*
//
//VICE POINT
//317.2051 -223.2012 42.3731//OFF THE TOP OF THE BUILDING SITE*
//444.5 -118.4 16.0//MALIBU*
//435.8542 -334.3212 15.8977//SOUTH DOWN ROAD FROM MALIBU OVER BRIDGE*
//
//STARFISH ISLAND
//-346.818 -290.741 12.926//IN GARDEN UP STAIRS*










