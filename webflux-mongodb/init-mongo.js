db.createUser(
    {
        user: "dev1234",
        pwd: "dev1234",
        roles: [
            {
                role: "readWrite",
                db: "usersdb"
            }
        ]
    }
)
