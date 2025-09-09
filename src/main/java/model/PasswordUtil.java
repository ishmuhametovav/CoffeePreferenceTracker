package model;

import org.mindrot.jbcrypt.BCrypt;

public final class PasswordUtil
{
    private static final int BCRYPT_COST = 12;

    private PasswordUtil() throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("Creating PasswordUtil objects is not allowed");
    }

    public static String hash(String plainPassword)
    {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(BCRYPT_COST));
    }
    public static boolean verify(String plainPassword, String hash)
    {
        return BCrypt.checkpw(plainPassword, hash);
    }
}
