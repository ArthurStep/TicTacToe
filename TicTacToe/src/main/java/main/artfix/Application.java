package main.artfix;

public class Application {
    public static void start() {
        FileIng.read("banner");
        String bannerInfoMenu = FileIng.ReadData;

        if (bannerInfoMenu.equals("false")) {
            bannerInfoMenu = "On";
        } else {
            bannerInfoMenu = "Off";
        }
        System.out.println(" ");
        System.out.println("For Start Game tap '1'.");
        System.out.println("For " + bannerInfoMenu + " Banner Tap '00'.");
        System.out.println("For Exit Tap '0'.");
        System.out.print("Type: ");
        String MenuScan = Config.scan.nextLine();

        switch (MenuScan) {
            case "1":
                Application.Table();

                while (Config.working) {
                    System.out.println(" ");
                    System.out.print("Type Your number: ");
                    String TicTacToeScan = Config.scan.nextLine();

                    switch (TicTacToeScan) {
                        case "1":
                            if (!Config.UsedBox1) {
                                Config.Box1 = "x";
                            } else {
                                System.out.println("Number already used.");
                                System.exit(0);
                            }
                            Config.UsedBox1 = true;
                            break;

                        case "2":
                            if (!Config.UsedBox2) {
                                Config.Box2 = "x";
                            } else {
                                System.out.println("Number already used.");
                                System.exit(0);
                            }
                            Config.UsedBox2 = true;
                            break;

                        case "3":
                            if (!Config.UsedBox3) {
                                Config.Box3 = "x";
                            } else {
                                System.out.println("Number already used.");
                                System.exit(0);
                            }
                            Config.UsedBox3 = true;
                            break;

                        case "4":
                            if (!Config.UsedBox4) {
                                Config.Box4 = "x";
                            } else {
                                System.out.println("Number already used.");
                                System.exit(0);
                            }
                            Config.UsedBox4 = true;
                            break;

                        case "5":
                            if (!Config.UsedBox5) {
                                Config.Box5 = "x";
                            } else {
                                System.out.println("Number already used.");
                                System.exit(0);
                            }
                            Config.UsedBox5 = true;
                            break;

                        case "6":
                            if (!Config.UsedBox6) {
                                Config.Box6 = "x";
                            } else {
                                System.out.println("Number already used.");
                                System.exit(0);
                            }
                            Config.UsedBox6 = true;
                            break;

                        case "7":
                            if (!Config.UsedBox7) {
                                Config.Box7 = "x";
                            } else {
                                System.out.println("Number already used.");
                                System.exit(0);
                            }
                            Config.UsedBox7 = true;
                            break;

                        case "8":
                            if (!Config.UsedBox8) {
                                Config.Box8 = "x";
                            } else {
                                System.out.println("Number already used.");
                                System.exit(0);
                            }
                            Config.UsedBox8 = true;
                            break;

                        case "9":
                            if (!Config.UsedBox9) {
                                Config.Box9 = "x";
                            } else {
                                System.out.println("Number already used.");
                                System.exit(0);
                            }
                            Config.UsedBox9 = true;
                            break;

                    }

                    if (Config.Box1.equals("x") && Config.Box2.equals("x") && Config.Box3.equals("x")) {
                        Application.Table();
                        System.out.println("You win.");
                        System.exit(0);
                    }
                    if (Config.Box4.equals("x") && Config.Box5.equals("x") && Config.Box6.equals("x")) {
                        Application.Table();
                        System.out.println("You win.");
                        System.exit(0);
                    }
                    if (Config.Box7.equals("x") && Config.Box8.equals("x") && Config.Box9.equals("x")) {
                        Application.Table();
                        System.out.println("You win.");
                        System.exit(0);
                    }


                    if (Config.Box1.equals("x") && Config.Box4.equals("x") && Config.Box7.equals("x")) {
                        Application.Table();
                        System.out.println("You win.");
                        System.exit(0);
                    }
                    if (Config.Box2.equals("x") && Config.Box5.equals("x") && Config.Box8.equals("x")) {
                        Application.Table();
                        System.out.println("You win.");
                        System.exit(0);
                    }
                    if (Config.Box3.equals("x") && Config.Box6.equals("x") && Config.Box9.equals("x")) {
                        Application.Table();
                        System.out.println("You win.");
                        System.exit(0);
                    }


                    if (Config.Box1.equals("x") && Config.Box5.equals("x") && Config.Box9.equals("x")) {
                        Application.Table();
                        System.out.println("You win.");
                        System.exit(0);
                    }
                    if (Config.Box7.equals("x") && Config.Box5.equals("x") && Config.Box3.equals("x")) {
                        Application.Table();
                        System.out.println("You win.");
                        System.exit(0);
                    }


                    if (Config.Box1.equals("o") && Config.Box2.equals("o") && Config.Box3.equals("o")) {
                        Application.Table();
                        System.out.println("You lose.");
                        System.exit(0);
                    }
                    if (Config.Box4.equals("o") && Config.Box5.equals("o") && Config.Box6.equals("o")) {
                        Application.Table();
                        System.out.println("You lose.");
                        System.exit(0);
                    }
                    if (Config.Box7.equals("o") && Config.Box8.equals("o") && Config.Box9.equals("o")) {
                        Application.Table();
                        System.out.println("You lose.");
                        System.exit(0);
                    }


                    if (Config.Box1.equals("o") && Config.Box4.equals("o") && Config.Box7.equals("o")) {
                        Application.Table();
                        System.out.println("You lose.");
                        System.exit(0);
                    }
                    if (Config.Box2.equals("o") && Config.Box5.equals("o") && Config.Box8.equals("o")) {
                        Application.Table();
                        System.out.println("You lose.");
                        System.exit(0);
                    }
                    if (Config.Box3.equals("o") && Config.Box6.equals("o") && Config.Box9.equals("o")) {
                        Application.Table();
                        System.out.println("You lose.");
                        System.exit(0);
                    }


                    if (Config.Box1.equals("o") && Config.Box5.equals("o") && Config.Box9.equals("o")) {
                        Application.Table();
                        System.out.println("You lose.");
                        System.exit(0);
                    }
                    if (Config.Box7.equals("o") && Config.Box5.equals("o") && Config.Box3.equals("o")) {
                        Application.Table();
                        System.out.println("You lose.");
                        System.exit(0);
                    }

                    if (!Config.Box1.equals("-") && !Config.Box2.equals("-") && !Config.Box3.equals("-")
                            && !Config.Box4.equals("-") && !Config.Box5.equals("-") && !Config.Box6.equals
                            ("-") && !Config.Box7.equals("-") && !Config.Box8.equals("-") && !Config.Box9.equals("-")) {
                        Application.Table();
                        System.out.println("It's Tie.");
                    }


                    RandomNum.getNum();
                    if (RandomNum.randomNumGet.equals("1")) {
                        if (Config.UsedBox1) {
                            RandomNum.getNum();
                        }
                    }

                    if (RandomNum.randomNumGet.equals("2")) {
                        if (Config.UsedBox2) {
                            RandomNum.getNum();
                            if (RandomNum.randomNumGet.equals("1")) {
                                if (Config.UsedBox1) {
                                    RandomNum.getNum();
                                }
                            }
                        }
                    }

                    if (RandomNum.randomNumGet.equals("3")) {
                        if (Config.UsedBox3) {
                            RandomNum.getNum();
                            if (RandomNum.randomNumGet.equals("2")) {
                                if (Config.UsedBox2) {
                                    RandomNum.getNum();
                                    if (RandomNum.randomNumGet.equals("1")) {
                                        if (Config.UsedBox1) {
                                            RandomNum.getNum();
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (RandomNum.randomNumGet.equals("4")) {
                        if (Config.UsedBox4) {
                            RandomNum.getNum();
                            if (RandomNum.randomNumGet.equals("3")) {
                                if (Config.UsedBox3) {
                                    RandomNum.getNum();
                                    if (RandomNum.randomNumGet.equals("2")) {
                                        if (Config.UsedBox2) {
                                            RandomNum.getNum();
                                            if (RandomNum.randomNumGet.equals("1")) {
                                                if (Config.UsedBox1) {
                                                    RandomNum.getNum();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (RandomNum.randomNumGet.equals("5")) {
                        if (Config.UsedBox5) {
                            RandomNum.getNum();
                            if (RandomNum.randomNumGet.equals("4")) {
                                if (Config.UsedBox4) {
                                    RandomNum.getNum();
                                    if (RandomNum.randomNumGet.equals("3")) {
                                        if (Config.UsedBox3) {
                                            RandomNum.getNum();
                                            if (RandomNum.randomNumGet.equals("2")) {
                                                if (Config.UsedBox2) {
                                                    RandomNum.getNum();
                                                    if (RandomNum.randomNumGet.equals("1")) {
                                                        if (Config.UsedBox1) {
                                                            RandomNum.getNum();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (RandomNum.randomNumGet.equals("6")) {
                        if (Config.UsedBox6) {
                            RandomNum.getNum();
                            if (RandomNum.randomNumGet.equals("5")) {
                                if (Config.UsedBox5) {
                                    RandomNum.getNum();
                                    if (RandomNum.randomNumGet.equals("4")) {
                                        if (Config.UsedBox4) {
                                            RandomNum.getNum();
                                            if (RandomNum.randomNumGet.equals("3")) {
                                                if (Config.UsedBox3) {
                                                    RandomNum.getNum();
                                                    if (RandomNum.randomNumGet.equals("2")) {
                                                        if (Config.UsedBox2) {
                                                            RandomNum.getNum();
                                                            if (RandomNum.randomNumGet.equals("1")) {
                                                                if (Config.UsedBox1) {
                                                                    RandomNum.getNum();
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (RandomNum.randomNumGet.equals("7")) {
                        if (Config.UsedBox7) {
                            RandomNum.getNum();
                            if (RandomNum.randomNumGet.equals("6")) {
                                if (Config.UsedBox6) {
                                    RandomNum.getNum();
                                    if (RandomNum.randomNumGet.equals("5")) {
                                        if (Config.UsedBox5) {
                                            RandomNum.getNum();
                                            if (RandomNum.randomNumGet.equals("4")) {
                                                if (Config.UsedBox4) {
                                                    RandomNum.getNum();
                                                    if (RandomNum.randomNumGet.equals("3")) {
                                                        if (Config.UsedBox3) {
                                                            RandomNum.getNum();
                                                            if (RandomNum.randomNumGet.equals("2")) {
                                                                if (Config.UsedBox2) {
                                                                    RandomNum.getNum();
                                                                    if (RandomNum.randomNumGet.equals("1")) {
                                                                        if (Config.UsedBox1) {
                                                                            RandomNum.getNum();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (RandomNum.randomNumGet.equals("8")) {
                        if (Config.UsedBox8) {
                            RandomNum.getNum();
                            if (RandomNum.randomNumGet.equals("7")) {
                                if (Config.UsedBox7) {
                                    RandomNum.getNum();
                                    if (RandomNum.randomNumGet.equals("6")) {
                                        if (Config.UsedBox6) {
                                            RandomNum.getNum();
                                            if (RandomNum.randomNumGet.equals("5")) {
                                                if (Config.UsedBox5) {
                                                    RandomNum.getNum();
                                                    if (RandomNum.randomNumGet.equals("4")) {
                                                        if (Config.UsedBox4) {
                                                            RandomNum.getNum();
                                                            if (RandomNum.randomNumGet.equals("3")) {
                                                                if (Config.UsedBox3) {
                                                                    RandomNum.getNum();
                                                                    if (RandomNum.randomNumGet.equals("2")) {
                                                                        if (Config.UsedBox2) {
                                                                            RandomNum.getNum();
                                                                            if (RandomNum.randomNumGet.equals("1")) {
                                                                                if (Config.UsedBox1) {
                                                                                    RandomNum.getNum();
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (RandomNum.randomNumGet.equals("9")) {
                        if (Config.UsedBox9) {
                            RandomNum.getNum();
                            if (RandomNum.randomNumGet.equals("8")) {
                                if (Config.UsedBox8) {
                                    RandomNum.getNum();
                                    if (RandomNum.randomNumGet.equals("7")) {
                                        if (Config.UsedBox7) {
                                            RandomNum.getNum();
                                            if (RandomNum.randomNumGet.equals("6")) {
                                                if (Config.UsedBox6) {
                                                    RandomNum.getNum();
                                                    if (RandomNum.randomNumGet.equals("5")) {
                                                        if (Config.UsedBox5) {
                                                            RandomNum.getNum();
                                                            if (RandomNum.randomNumGet.equals("4")) {
                                                                if (Config.UsedBox4) {
                                                                    RandomNum.getNum();
                                                                    if (RandomNum.randomNumGet.equals("3")) {
                                                                        if (Config.UsedBox3) {
                                                                            RandomNum.getNum();
                                                                            if (RandomNum.randomNumGet.equals("2")) {
                                                                                if (Config.UsedBox2) {
                                                                                    RandomNum.getNum();
                                                                                    if (RandomNum.randomNumGet.equals("1")) {
                                                                                        if (Config.UsedBox1) {
                                                                                            RandomNum.getNum();
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    System.out.println("I select: " + RandomNum.randomNumGet + ".");

                    switch (RandomNum.randomNumGet) {
                        case "1":
                            if (Config.Box1.equals("-")) {
                                Config.Box1 = "o";
                                Application.Table();
                                Config.UsedBox1 = true;
                            } else {
                                System.out.println("Err.");
                                System.exit(0);
                            }
                            break;

                        case "2":
                            if (Config.Box2.equals("-")) {
                                Config.Box2 = "o";
                                Application.Table();
                                Config.UsedBox2 = true;
                            } else {
                                System.out.println("Err.");
                                System.exit(0);
                            }
                            break;

                        case "3":
                            if (Config.Box3.equals("-")) {
                                Config.Box3 = "o";
                                Application.Table();
                                Config.UsedBox3 = true;
                            } else {
                                System.out.println("Err.");
                                System.exit(0);
                            }
                            break;

                        case "4":
                            if (Config.Box4.equals("-")) {
                                Config.Box4 = "o";
                                Application.Table();
                                Config.UsedBox4 = true;
                            } else {
                                System.out.println("Err.");
                                System.exit(0);
                            }
                            break;

                        case "5":
                            if (Config.Box5.equals("-")) {
                                Config.Box5 = "o";
                                Application.Table();
                                Config.UsedBox5 = true;
                            } else {
                                System.out.println("Err.");
                                System.exit(0);
                            }
                            break;

                        case "6":
                            if (Config.Box6.equals("-")) {
                                Config.Box6 = "o";
                                Application.Table();
                                Config.UsedBox6 = true;
                            } else {
                                System.out.println("Err.");
                                System.exit(0);
                            }
                            break;

                        case "7":
                            if (Config.Box7.equals("-")) {
                                Config.Box7 = "o";
                                Application.Table();
                                Config.UsedBox7 = true;
                            } else {
                                System.out.println("Err.");
                                System.exit(0);
                            }
                            break;

                        case "8":
                            if (Config.Box8.equals("-")) {
                                Config.Box8 = "o";
                                Application.Table();
                                Config.UsedBox8 = true;
                            } else {
                                System.out.println("Err.");
                                System.exit(0);
                            }
                            break;

                        case "9":
                            if (Config.Box9.equals("-")) {
                                Config.Box9 = "o";
                                Application.Table();
                                Config.UsedBox9 = true;
                            } else {
                                System.out.println("Err.");
                                System.exit(0);
                            }
                            break;


                        default:
                            System.out.println("System Err.");
                            Application.start();
                            break;
                    }

                }
                break;


            case "0":
                System.exit(0);
                break;

            case "00":
                FileIng.read("banner");
                bannerInfoMenu = FileIng.ReadData;

                if (bannerInfoMenu.equals("false")) {
                    FileIng.write("banner", "true");
                } else {
                    FileIng.write("banner", "false");
                }
                Application.start();
                break;

            default:
                System.out.println("Wrong Command.");
                Application.start();
                break;
        }

    }

    public static void Table() {
        System.out.println(" ");
        System.out.println("          -------------");
        System.out.println("          | " + Config.Box1 + " | " + Config.Box2 + " | " + Config.Box3 + " |");
        System.out.println("          -------------");
        System.out.println("          | " + Config.Box4 + " | " + Config.Box5 + " | " + Config.Box6 + " |");
        System.out.println("          -------------");
        System.out.println("          | " + Config.Box7 + " | " + Config.Box8 + " | " + Config.Box9 + " |");
        System.out.println("          -------------");
        System.out.println(" ");
    }
}

