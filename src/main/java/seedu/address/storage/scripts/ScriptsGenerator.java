package seedu.address.storage.scripts;

/**
 * This class will help the program to generate scripts automatically by BruteForce.
 */
public class ScriptsGenerator {
    private static final String NEXT_LINE = System.lineSeparator();

    private static final String ADD_COMMAND = "n/Alex Yeoh g/Male nat/SG p/87438807 "
            + "e/alexyeoh@example.com a/Blk 30 Geylang Street 29, #06-40 t/friends" + NEXT_LINE
            + "n/Bernice Yu g/Female nat/SG p/99272758 e/berniceyu@example.com "
            + "a/Blk 30 Lorong 3 Serangoon Gardens, #07-18 t/colleagues" + NEXT_LINE
            + "n/Charlotte Oliveiro g/F nat/AU p/93210283 e/charlotte@example.com "
            + "a/Blk 11 Ang Mo Kio Street 74, #11-04 t/neighbours" + NEXT_LINE
            + "n/David Li g/M nat/CN p/91031282 e/lidavid@example.com "
            + "a/Blk 436 Serangoon Gardens Street 26, #16-43 t/family" + NEXT_LINE
            + "n/Irfan Ibrahim g/M nat/MY p/92492021 e/irfan@example.com "
            + "a/Blk 47 Tampines Street 20, #17-35 t/classmates" + NEXT_LINE
            + "n/Roy Balakrishna g/M nat/IN p/92624417 e/royb@example.com "
            + "a/Blk 45 Aljunied Street 85, #11-31 t/colleagues" + NEXT_LINE
            + "n/Khadijah Saine g/F nat/IN p/92142978 e/KhadijahSaine@example.com "
            + "a/Blk 112, Simei Street 1 t/classmates" + NEXT_LINE
            + "n/Jeni Eisenhower g/F nat/US p/91077545 e/JeniEisenhower@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Tien Agan g/F nat/US p/96175570 e/TienAgan@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Brendan g/M nat/SG p/95704308 e/Brendan@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Fay g/M nat/SG p/97894720 e/Fay@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Tracey g/F nat/SG p/99944817 e/Tracey@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Christy g/F nat/SG p/98496742 e/Christy@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Heidi g/F nat/SG p/95067553 e/Heidi@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Christene g/F nat/SG p/96573233 e/Christene@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Les g/F nat/SG p/94615325 e/Les@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Luigi g/M nat/SG p/96259361 e/Luigi@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Reatha g/F nat/IN p/96775760 e/Reatha@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Dorethea g/F nat/CN p/94680649 e/Dorethea@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Deon g/M nat/SG p/96200344 e/Deon@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Joleen g/F nat/SG p/98481923 e/Joleen@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Glynis g/F nat/SG p/91174790 e/Glynis@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Corinna g/F nat/SG p/91082076 e/Corinna@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Lianne g/F nat/SG p/97181574 e/Lianne@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Deanne g/F nat/SG p/96849130 e/Deanne@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Donna g/F nat/SG p/95435362 e/Donna@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Chandra g/M nat/IN p/91410083 e/Chandra@example.com "
            + "a/NUS Utown t/classmates" + NEXT_LINE
            + "n/Tsu Wei Quan g/M nat/SG p/96259561 e/tsuweiquan@gmail.com "
            + "a/Blk 111, Simei Street 1 t/colleagues" + NEXT_LINE
            + "n/Novin Tong Yong Kang g/M nat/SG p/99999999 "
            + "e/E0176909@u.nus.edu a/Pasir Ris street 99,#02-25 t/colleagues" + NEXT_LINE
            + "n/TsuraJovin g/M nat/SG p/99999999 e/tsurajovin@gmail.com "
            + "a/Bedok street 99,#02-25 t/colleagues" + NEXT_LINE
            + "n/Joel g/M nat/MY p/9784230 e/joeltan98@hotmail.com "
            + "a/Jurong West Street 52 t/colleagues" + NEXT_LINE
            + "n/JoelTan g/M nat/MY p/9784230 e/joel.twh@u.nus.edu "
            + "a/Jurong West Street 52 t/colleagues" + NEXT_LINE
            + "n/Rajdeep g/M nat/SG p/9784230 e/rajdeepsh@outlook.com "
            + "a/Pasir ris street 2 t/colleagues" + NEXT_LINE
            + "n/Clara g/F nat/SG p/9784230 e/Clara@example.com "
            + "a/UTown t/colleagues" + NEXT_LINE;


    private static final String GROUP_COMMAND = "n/tut[01] l/e1-11-20 t/ma1301" + NEXT_LINE
            + "n/tut[02] l/e3-11-20 t/ma1301" + NEXT_LINE
            + "n/tut[03] l/e5-11-20 t/ma1301" + NEXT_LINE
            + "n/tut[04] l/e11-11-20 t/ma1301" + NEXT_LINE
            + "n/tut[05] l/s22-11-20 t/ma1301" + NEXT_LINE
            + "n/tut[06] l/as4-11-20 t/ma1301" + NEXT_LINE
            + "n/tut[07] l/e9-3-2 t/ma1301" + NEXT_LINE
            + "n/tut[08] l/e5-1-2 t/ma1301" + NEXT_LINE;

    public static String getAddCommand() {
        return ADD_COMMAND;
    }

    public static String getGroupCommand() {
        return GROUP_COMMAND;
    }
}
