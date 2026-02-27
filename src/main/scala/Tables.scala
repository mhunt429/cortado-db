package 
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends Tables {
  val profile: slick.jdbc.JdbcProfile = slick.jdbc.PostgresProfile
}

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import java.time.Instant
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for
  // tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(AccessLog.schema, AccountBalanceHistory.schema, AccountConnector.schema, AppUser.schema, BaseAuditTable.schema, ConnectionSyncData.schema, FinancialAccount.schema, FlywaySchemaHistory.schema, RecurringTransaction.schema, Token.schema, Transaction.schema, TransactionLineItem.schema, UserAccount.schema, UserMailbox.schema, UserSession.schema, UserTransactionCategory.schema).reduceLeft(_ ++ _)

  /** Entity class storing rows of table AccessLog
   *  @param originalInsert Database column original_insert SqlType(timestamptz)
   *  @param lastUpdate Database column last_update SqlType(timestamptz)
   *  @param appLastChangedBy Database column app_last_changed_by SqlType(int4)
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param accessType Database column access_type SqlType(varchar), Length(40,true), Default(None)
   *  @param accessDate Database column access_date SqlType(timestamptz), Default(None)
   *  @param ipAddress Database column ip_address SqlType(varchar), Length(40,true), Default(None)
   *  @param userAgent Database column user_agent SqlType(varchar), Length(255,true), Default(None)
   *  @param success Database column success SqlType(bool), Default(None) */
  case class AccessLogRow(originalInsert: java.time.Instant, lastUpdate: java.time.Instant, appLastChangedBy: Int, id: Int, userId: Option[Int] = None, accessType: Option[String] = None, accessDate: Option[java.time.Instant] = None, ipAddress: Option[String] = None, userAgent: Option[String] = None, success: Option[Boolean] = None)
  /** GetResult implicit for fetching AccessLogRow objects using plain SQL queries */
  implicit def GetResultAccessLogRow(implicit e0: GR[java.time.Instant], e1: GR[Int], e2: GR[Option[Int]], e3: GR[Option[String]], e4: GR[Option[java.time.Instant]], e5: GR[Option[Boolean]]): GR[AccessLogRow] = GR{
    prs => import prs._
    (AccessLogRow.apply _).tupled((<<[java.time.Instant], <<[java.time.Instant], <<[Int], <<[Int], <<?[Int], <<?[String], <<?[java.time.Instant], <<?[String], <<?[String], <<?[Boolean]))
  }
  /** Table description of table access_log. Objects of this class serve as prototypes for rows in queries. */
  class AccessLog(_tableTag: Tag) extends profile.api.Table[AccessLogRow](_tableTag, "access_log") {
    def * = ((originalInsert, lastUpdate, appLastChangedBy, id, userId, accessType, accessDate, ipAddress, userAgent, success)).mapTo[AccessLogRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(originalInsert), Rep.Some(lastUpdate), Rep.Some(appLastChangedBy), Rep.Some(id), userId, accessType, accessDate, ipAddress, userAgent, success)).shaped.<>({r=>import r._; _1.map(_=> (AccessLogRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7, _8, _9, _10)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column original_insert SqlType(timestamptz) */
    val originalInsert: Rep[java.time.Instant] = column[java.time.Instant]("original_insert")
    /** Database column last_update SqlType(timestamptz) */
    val lastUpdate: Rep[java.time.Instant] = column[java.time.Instant]("last_update")
    /** Database column app_last_changed_by SqlType(int4) */
    val appLastChangedBy: Rep[Int] = column[Int]("app_last_changed_by")
    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column access_type SqlType(varchar), Length(40,true), Default(None) */
    val accessType: Rep[Option[String]] = column[Option[String]]("access_type", O.Length(40,varying=true), O.Default(None))
    /** Database column access_date SqlType(timestamptz), Default(None) */
    val accessDate: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("access_date", O.Default(None))
    /** Database column ip_address SqlType(varchar), Length(40,true), Default(None) */
    val ipAddress: Rep[Option[String]] = column[Option[String]]("ip_address", O.Length(40,varying=true), O.Default(None))
    /** Database column user_agent SqlType(varchar), Length(255,true), Default(None) */
    val userAgent: Rep[Option[String]] = column[Option[String]]("user_agent", O.Length(255,varying=true), O.Default(None))
    /** Database column success SqlType(bool), Default(None) */
    val success: Rep[Option[Boolean]] = column[Option[Boolean]]("success", O.Default(None))

    /** Foreign key referencing AppUser (database name access_log_user_id_fkey) */
    lazy val appUserFk = foreignKey("access_log_user_id_fkey", userId, AppUser)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.SetNull)
  }
  /** Collection-like TableQuery object for table AccessLog */
  lazy val AccessLog = new TableQuery(tag => new AccessLog(tag))

  /** Entity class storing rows of table AccountBalanceHistory
   *  @param originalInsert Database column original_insert SqlType(timestamptz)
   *  @param lastUpdate Database column last_update SqlType(timestamptz)
   *  @param appLastChangedBy Database column app_last_changed_by SqlType(int4)
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param financialAccountId Database column financial_account_id SqlType(int4), Default(None)
   *  @param currentBalance Database column current_balance SqlType(numeric), Default(None)
   *  @param availableBalance Database column available_balance SqlType(numeric), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamptz), Default(None) */
  case class AccountBalanceHistoryRow(originalInsert: java.time.Instant, lastUpdate: java.time.Instant, appLastChangedBy: Int, id: Int, userId: Option[Int] = None, financialAccountId: Option[Int] = None, currentBalance: Option[scala.math.BigDecimal] = None, availableBalance: Option[scala.math.BigDecimal] = None, createdAt: Option[java.time.Instant] = None)
  /** GetResult implicit for fetching AccountBalanceHistoryRow objects using plain SQL queries */
  implicit def GetResultAccountBalanceHistoryRow(implicit e0: GR[java.time.Instant], e1: GR[Int], e2: GR[Option[Int]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[java.time.Instant]]): GR[AccountBalanceHistoryRow] = GR{
    prs => import prs._
    (AccountBalanceHistoryRow.apply _).tupled((<<[java.time.Instant], <<[java.time.Instant], <<[Int], <<[Int], <<?[Int], <<?[Int], <<?[scala.math.BigDecimal], <<?[scala.math.BigDecimal], <<?[java.time.Instant]))
  }
  /** Table description of table account_balance_history. Objects of this class serve as prototypes for rows in queries. */
  class AccountBalanceHistory(_tableTag: Tag) extends profile.api.Table[AccountBalanceHistoryRow](_tableTag, "account_balance_history") {
    def * = ((originalInsert, lastUpdate, appLastChangedBy, id, userId, financialAccountId, currentBalance, availableBalance, createdAt)).mapTo[AccountBalanceHistoryRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(originalInsert), Rep.Some(lastUpdate), Rep.Some(appLastChangedBy), Rep.Some(id), userId, financialAccountId, currentBalance, availableBalance, createdAt)).shaped.<>({r=>import r._; _1.map(_=> (AccountBalanceHistoryRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7, _8, _9)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column original_insert SqlType(timestamptz) */
    val originalInsert: Rep[java.time.Instant] = column[java.time.Instant]("original_insert")
    /** Database column last_update SqlType(timestamptz) */
    val lastUpdate: Rep[java.time.Instant] = column[java.time.Instant]("last_update")
    /** Database column app_last_changed_by SqlType(int4) */
    val appLastChangedBy: Rep[Int] = column[Int]("app_last_changed_by")
    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column financial_account_id SqlType(int4), Default(None) */
    val financialAccountId: Rep[Option[Int]] = column[Option[Int]]("financial_account_id", O.Default(None))
    /** Database column current_balance SqlType(numeric), Default(None) */
    val currentBalance: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("current_balance", O.Default(None))
    /** Database column available_balance SqlType(numeric), Default(None) */
    val availableBalance: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("available_balance", O.Default(None))
    /** Database column created_at SqlType(timestamptz), Default(None) */
    val createdAt: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("created_at", O.Default(None))

    /** Foreign key referencing AppUser (database name account_balance_history_user_id_fkey) */
    lazy val appUserFk = foreignKey("account_balance_history_user_id_fkey", userId, AppUser)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.SetNull)
    /** Foreign key referencing FinancialAccount (database name account_balance_history_financial_account_id_fkey) */
    lazy val financialAccountFk = foreignKey("account_balance_history_financial_account_id_fkey", financialAccountId, FinancialAccount)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.SetNull)
  }
  /** Collection-like TableQuery object for table AccountBalanceHistory */
  lazy val AccountBalanceHistory = new TableQuery(tag => new AccountBalanceHistory(tag))

  /** Entity class storing rows of table AccountConnector
   *  @param originalInsert Database column original_insert SqlType(timestamptz)
   *  @param lastUpdate Database column last_update SqlType(timestamptz)
   *  @param appLastChangedBy Database column app_last_changed_by SqlType(int4)
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param institutionId Database column institution_id SqlType(text), Default(None)
   *  @param institutionName Database column institution_name SqlType(text), Default(None)
   *  @param dateConnected Database column date_connected SqlType(timestamptz), Default(None)
   *  @param encryptedAccessToken Database column encrypted_access_token SqlType(bytea), Default(None)
   *  @param transactionSyncCursor Database column transaction_sync_cursor SqlType(text), Default(None)
   *  @param externalEventId Database column external_event_id SqlType(text), Default(None)
   *  @param disconnectedTs Database column disconnected_ts SqlType(timestamptz), Default(None)
   *  @param requiresReauthentication Database column requires_reauthentication SqlType(bool), Default(Some(false))
   *  @param lastSyncDate Database column last_sync_date SqlType(timestamptz), Default(None)
   *  @param nextSyncDate Database column next_sync_date SqlType(timestamptz), Default(None) */
  case class AccountConnectorRow(originalInsert: java.time.Instant, lastUpdate: java.time.Instant, appLastChangedBy: Int, id: Int, userId: Option[Int] = None, institutionId: Option[String] = None, institutionName: Option[String] = None, dateConnected: Option[java.time.Instant] = None, encryptedAccessToken: Option[Array[Byte]] = None, transactionSyncCursor: Option[String] = None, externalEventId: Option[String] = None, disconnectedTs: Option[java.time.Instant] = None, requiresReauthentication: Option[Boolean] = Some(false), lastSyncDate: Option[java.time.Instant] = None, nextSyncDate: Option[java.time.Instant] = None)
  /** GetResult implicit for fetching AccountConnectorRow objects using plain SQL queries */
  implicit def GetResultAccountConnectorRow(implicit e0: GR[java.time.Instant], e1: GR[Int], e2: GR[Option[Int]], e3: GR[Option[String]], e4: GR[Option[java.time.Instant]], e5: GR[Option[Array[Byte]]], e6: GR[Option[Boolean]]): GR[AccountConnectorRow] = GR{
    prs => import prs._
    (AccountConnectorRow.apply _).tupled((<<[java.time.Instant], <<[java.time.Instant], <<[Int], <<[Int], <<?[Int], <<?[String], <<?[String], <<?[java.time.Instant], <<?[Array[Byte]], <<?[String], <<?[String], <<?[java.time.Instant], <<?[Boolean], <<?[java.time.Instant], <<?[java.time.Instant]))
  }
  /** Table description of table account_connector. Objects of this class serve as prototypes for rows in queries. */
  class AccountConnector(_tableTag: Tag) extends profile.api.Table[AccountConnectorRow](_tableTag, "account_connector") {
    def * = ((originalInsert, lastUpdate, appLastChangedBy, id, userId, institutionId, institutionName, dateConnected, encryptedAccessToken, transactionSyncCursor, externalEventId, disconnectedTs, requiresReauthentication, lastSyncDate, nextSyncDate)).mapTo[AccountConnectorRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(originalInsert), Rep.Some(lastUpdate), Rep.Some(appLastChangedBy), Rep.Some(id), userId, institutionId, institutionName, dateConnected, encryptedAccessToken, transactionSyncCursor, externalEventId, disconnectedTs, requiresReauthentication, lastSyncDate, nextSyncDate)).shaped.<>({r=>import r._; _1.map(_=> (AccountConnectorRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column original_insert SqlType(timestamptz) */
    val originalInsert: Rep[java.time.Instant] = column[java.time.Instant]("original_insert")
    /** Database column last_update SqlType(timestamptz) */
    val lastUpdate: Rep[java.time.Instant] = column[java.time.Instant]("last_update")
    /** Database column app_last_changed_by SqlType(int4) */
    val appLastChangedBy: Rep[Int] = column[Int]("app_last_changed_by")
    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column institution_id SqlType(text), Default(None) */
    val institutionId: Rep[Option[String]] = column[Option[String]]("institution_id", O.Default(None))
    /** Database column institution_name SqlType(text), Default(None) */
    val institutionName: Rep[Option[String]] = column[Option[String]]("institution_name", O.Default(None))
    /** Database column date_connected SqlType(timestamptz), Default(None) */
    val dateConnected: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("date_connected", O.Default(None))
    /** Database column encrypted_access_token SqlType(bytea), Default(None) */
    val encryptedAccessToken: Rep[Option[Array[Byte]]] = column[Option[Array[Byte]]]("encrypted_access_token", O.Default(None))
    /** Database column transaction_sync_cursor SqlType(text), Default(None) */
    val transactionSyncCursor: Rep[Option[String]] = column[Option[String]]("transaction_sync_cursor", O.Default(None))
    /** Database column external_event_id SqlType(text), Default(None) */
    val externalEventId: Rep[Option[String]] = column[Option[String]]("external_event_id", O.Default(None))
    /** Database column disconnected_ts SqlType(timestamptz), Default(None) */
    val disconnectedTs: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("disconnected_ts", O.Default(None))
    /** Database column requires_reauthentication SqlType(bool), Default(Some(false)) */
    val requiresReauthentication: Rep[Option[Boolean]] = column[Option[Boolean]]("requires_reauthentication", O.Default(Some(false)))
    /** Database column last_sync_date SqlType(timestamptz), Default(None) */
    val lastSyncDate: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("last_sync_date", O.Default(None))
    /** Database column next_sync_date SqlType(timestamptz), Default(None) */
    val nextSyncDate: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("next_sync_date", O.Default(None))

    /** Foreign key referencing AppUser (database name account_connector_user_id_fkey) */
    lazy val appUserFk = foreignKey("account_connector_user_id_fkey", userId, AppUser)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.SetNull)
  }
  /** Collection-like TableQuery object for table AccountConnector */
  lazy val AccountConnector = new TableQuery(tag => new AccountConnector(tag))

  /** Entity class storing rows of table AppUser
   *  @param originalInsert Database column original_insert SqlType(timestamptz)
   *  @param lastUpdate Database column last_update SqlType(timestamptz)
   *  @param appLastChangedBy Database column app_last_changed_by SqlType(int4)
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param accountId Database column account_id SqlType(int4), Default(None)
   *  @param createdDate Database column created_date SqlType(timestamptz), Default(None)
   *  @param encryptedEmail Database column encrypted_email SqlType(bytea), Default(None)
   *  @param password Database column password SqlType(text), Default(None)
   *  @param encryptedName Database column encrypted_name SqlType(bytea), Default(None)
   *  @param encryptedPhone Database column encrypted_phone SqlType(bytea), Default(None)
   *  @param lastLoginDate Database column last_login_date SqlType(timestamptz), Default(None)
   *  @param lastLoginIp Database column last_login_ip SqlType(varchar), Length(39,true), Default(None)
   *  @param phoneVerified Database column phone_verified SqlType(bool), Default(None)
   *  @param emailVerified Database column email_verified SqlType(bool), Default(None)
   *  @param emailHash Database column email_hash SqlType(varchar), Length(64,true), Default(None) */
  case class AppUserRow(originalInsert: java.time.Instant, lastUpdate: java.time.Instant, appLastChangedBy: Int, id: Int, accountId: Option[Int] = None, createdDate: Option[java.time.Instant] = None, encryptedEmail: Option[Array[Byte]] = None, password: Option[String] = None, encryptedName: Option[Array[Byte]] = None, encryptedPhone: Option[Array[Byte]] = None, lastLoginDate: Option[java.time.Instant] = None, lastLoginIp: Option[String] = None, phoneVerified: Option[Boolean] = None, emailVerified: Option[Boolean] = None, emailHash: Option[String] = None)
  /** GetResult implicit for fetching AppUserRow objects using plain SQL queries */
  implicit def GetResultAppUserRow(implicit e0: GR[java.time.Instant], e1: GR[Int], e2: GR[Option[Int]], e3: GR[Option[java.time.Instant]], e4: GR[Option[Array[Byte]]], e5: GR[Option[String]], e6: GR[Option[Boolean]]): GR[AppUserRow] = GR{
    prs => import prs._
    (AppUserRow.apply _).tupled((<<[java.time.Instant], <<[java.time.Instant], <<[Int], <<[Int], <<?[Int], <<?[java.time.Instant], <<?[Array[Byte]], <<?[String], <<?[Array[Byte]], <<?[Array[Byte]], <<?[java.time.Instant], <<?[String], <<?[Boolean], <<?[Boolean], <<?[String]))
  }
  /** Table description of table app_user. Objects of this class serve as prototypes for rows in queries. */
  class AppUser(_tableTag: Tag) extends profile.api.Table[AppUserRow](_tableTag, "app_user") {
    def * = ((originalInsert, lastUpdate, appLastChangedBy, id, accountId, createdDate, encryptedEmail, password, encryptedName, encryptedPhone, lastLoginDate, lastLoginIp, phoneVerified, emailVerified, emailHash)).mapTo[AppUserRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(originalInsert), Rep.Some(lastUpdate), Rep.Some(appLastChangedBy), Rep.Some(id), accountId, createdDate, encryptedEmail, password, encryptedName, encryptedPhone, lastLoginDate, lastLoginIp, phoneVerified, emailVerified, emailHash)).shaped.<>({r=>import r._; _1.map(_=> (AppUserRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column original_insert SqlType(timestamptz) */
    val originalInsert: Rep[java.time.Instant] = column[java.time.Instant]("original_insert")
    /** Database column last_update SqlType(timestamptz) */
    val lastUpdate: Rep[java.time.Instant] = column[java.time.Instant]("last_update")
    /** Database column app_last_changed_by SqlType(int4) */
    val appLastChangedBy: Rep[Int] = column[Int]("app_last_changed_by")
    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column account_id SqlType(int4), Default(None) */
    val accountId: Rep[Option[Int]] = column[Option[Int]]("account_id", O.Default(None))
    /** Database column created_date SqlType(timestamptz), Default(None) */
    val createdDate: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("created_date", O.Default(None))
    /** Database column encrypted_email SqlType(bytea), Default(None) */
    val encryptedEmail: Rep[Option[Array[Byte]]] = column[Option[Array[Byte]]]("encrypted_email", O.Default(None))
    /** Database column password SqlType(text), Default(None) */
    val password: Rep[Option[String]] = column[Option[String]]("password", O.Default(None))
    /** Database column encrypted_name SqlType(bytea), Default(None) */
    val encryptedName: Rep[Option[Array[Byte]]] = column[Option[Array[Byte]]]("encrypted_name", O.Default(None))
    /** Database column encrypted_phone SqlType(bytea), Default(None) */
    val encryptedPhone: Rep[Option[Array[Byte]]] = column[Option[Array[Byte]]]("encrypted_phone", O.Default(None))
    /** Database column last_login_date SqlType(timestamptz), Default(None) */
    val lastLoginDate: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("last_login_date", O.Default(None))
    /** Database column last_login_ip SqlType(varchar), Length(39,true), Default(None) */
    val lastLoginIp: Rep[Option[String]] = column[Option[String]]("last_login_ip", O.Length(39,varying=true), O.Default(None))
    /** Database column phone_verified SqlType(bool), Default(None) */
    val phoneVerified: Rep[Option[Boolean]] = column[Option[Boolean]]("phone_verified", O.Default(None))
    /** Database column email_verified SqlType(bool), Default(None) */
    val emailVerified: Rep[Option[Boolean]] = column[Option[Boolean]]("email_verified", O.Default(None))
    /** Database column email_hash SqlType(varchar), Length(64,true), Default(None) */
    val emailHash: Rep[Option[String]] = column[Option[String]]("email_hash", O.Length(64,varying=true), O.Default(None))

    /** Foreign key referencing UserAccount (database name app_user_account_id_fkey) */
    lazy val userAccountFk = foreignKey("app_user_account_id_fkey", accountId, UserAccount)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.SetNull)

    /** Index over (emailHash) (database name au_email_hash_indx) */
    val index1 = index("au_email_hash_indx", emailHash)
  }
  /** Collection-like TableQuery object for table AppUser */
  lazy val AppUser = new TableQuery(tag => new AppUser(tag))

  /** Entity class storing rows of table BaseAuditTable
   *  @param originalInsert Database column original_insert SqlType(timestamptz)
   *  @param lastUpdate Database column last_update SqlType(timestamptz)
   *  @param appLastChangedBy Database column app_last_changed_by SqlType(int4) */
  case class BaseAuditTableRow(originalInsert: java.time.Instant, lastUpdate: java.time.Instant, appLastChangedBy: Int)
  /** GetResult implicit for fetching BaseAuditTableRow objects using plain SQL queries */
  implicit def GetResultBaseAuditTableRow(implicit e0: GR[java.time.Instant], e1: GR[Int]): GR[BaseAuditTableRow] = GR{
    prs => import prs._
    (BaseAuditTableRow.apply _).tupled((<<[java.time.Instant], <<[java.time.Instant], <<[Int]))
  }
  /** Table description of table base_audit_table. Objects of this class serve as prototypes for rows in queries. */
  class BaseAuditTable(_tableTag: Tag) extends profile.api.Table[BaseAuditTableRow](_tableTag, "base_audit_table") {
    def * = ((originalInsert, lastUpdate, appLastChangedBy)).mapTo[BaseAuditTableRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(originalInsert), Rep.Some(lastUpdate), Rep.Some(appLastChangedBy))).shaped.<>({r=>import r._; _1.map(_=> (BaseAuditTableRow.apply _).tupled((_1.get, _2.get, _3.get)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column original_insert SqlType(timestamptz) */
    val originalInsert: Rep[java.time.Instant] = column[java.time.Instant]("original_insert")
    /** Database column last_update SqlType(timestamptz) */
    val lastUpdate: Rep[java.time.Instant] = column[java.time.Instant]("last_update")
    /** Database column app_last_changed_by SqlType(int4) */
    val appLastChangedBy: Rep[Int] = column[Int]("app_last_changed_by")

    /** Foreign key referencing AppUser (database name fk_base_audit_app_user) */
    lazy val appUserFk = foreignKey("fk_base_audit_app_user", appLastChangedBy, AppUser)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table BaseAuditTable */
  lazy val BaseAuditTable = new TableQuery(tag => new BaseAuditTable(tag))

  /** Entity class storing rows of table ConnectionSyncData
   *  @param originalInsert Database column original_insert SqlType(timestamptz)
   *  @param lastUpdate Database column last_update SqlType(timestamptz)
   *  @param appLastChangedBy Database column app_last_changed_by SqlType(int4)
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param syncType Database column sync_type SqlType(varchar), Length(40,true), Default(None)
   *  @param lastSyncDate Database column last_sync_date SqlType(timestamptz), Default(None)
   *  @param nextSyncDate Database column next_sync_date SqlType(timestamptz), Default(None)
   *  @param connectorId Database column connector_id SqlType(int4), Default(None) */
  case class ConnectionSyncDataRow(originalInsert: java.time.Instant, lastUpdate: java.time.Instant, appLastChangedBy: Int, id: Int, userId: Option[Int] = None, syncType: Option[String] = None, lastSyncDate: Option[java.time.Instant] = None, nextSyncDate: Option[java.time.Instant] = None, connectorId: Option[Int] = None)
  /** GetResult implicit for fetching ConnectionSyncDataRow objects using plain SQL queries */
  implicit def GetResultConnectionSyncDataRow(implicit e0: GR[java.time.Instant], e1: GR[Int], e2: GR[Option[Int]], e3: GR[Option[String]], e4: GR[Option[java.time.Instant]]): GR[ConnectionSyncDataRow] = GR{
    prs => import prs._
    (ConnectionSyncDataRow.apply _).tupled((<<[java.time.Instant], <<[java.time.Instant], <<[Int], <<[Int], <<?[Int], <<?[String], <<?[java.time.Instant], <<?[java.time.Instant], <<?[Int]))
  }
  /** Table description of table connection_sync_data. Objects of this class serve as prototypes for rows in queries. */
  class ConnectionSyncData(_tableTag: Tag) extends profile.api.Table[ConnectionSyncDataRow](_tableTag, "connection_sync_data") {
    def * = ((originalInsert, lastUpdate, appLastChangedBy, id, userId, syncType, lastSyncDate, nextSyncDate, connectorId)).mapTo[ConnectionSyncDataRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(originalInsert), Rep.Some(lastUpdate), Rep.Some(appLastChangedBy), Rep.Some(id), userId, syncType, lastSyncDate, nextSyncDate, connectorId)).shaped.<>({r=>import r._; _1.map(_=> (ConnectionSyncDataRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7, _8, _9)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column original_insert SqlType(timestamptz) */
    val originalInsert: Rep[java.time.Instant] = column[java.time.Instant]("original_insert")
    /** Database column last_update SqlType(timestamptz) */
    val lastUpdate: Rep[java.time.Instant] = column[java.time.Instant]("last_update")
    /** Database column app_last_changed_by SqlType(int4) */
    val appLastChangedBy: Rep[Int] = column[Int]("app_last_changed_by")
    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column sync_type SqlType(varchar), Length(40,true), Default(None) */
    val syncType: Rep[Option[String]] = column[Option[String]]("sync_type", O.Length(40,varying=true), O.Default(None))
    /** Database column last_sync_date SqlType(timestamptz), Default(None) */
    val lastSyncDate: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("last_sync_date", O.Default(None))
    /** Database column next_sync_date SqlType(timestamptz), Default(None) */
    val nextSyncDate: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("next_sync_date", O.Default(None))
    /** Database column connector_id SqlType(int4), Default(None) */
    val connectorId: Rep[Option[Int]] = column[Option[Int]]("connector_id", O.Default(None))

    /** Foreign key referencing AccountConnector (database name connection_sync_data_connector_id_fkey) */
    lazy val accountConnectorFk = foreignKey("connection_sync_data_connector_id_fkey", connectorId, AccountConnector)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.SetNull)
    /** Foreign key referencing AppUser (database name connection_sync_data_user_id_fkey) */
    lazy val appUserFk = foreignKey("connection_sync_data_user_id_fkey", userId, AppUser)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ConnectionSyncData */
  lazy val ConnectionSyncData = new TableQuery(tag => new ConnectionSyncData(tag))

  /** Entity class storing rows of table FinancialAccount
   *  @param originalInsert Database column original_insert SqlType(timestamptz)
   *  @param lastUpdate Database column last_update SqlType(timestamptz)
   *  @param appLastChangedBy Database column app_last_changed_by SqlType(int4)
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param connectorId Database column connector_id SqlType(int4), Default(None)
   *  @param externalId Database column external_id SqlType(text), Default(None)
   *  @param currentBalance Database column current_balance SqlType(numeric), Default(None)
   *  @param availableBalance Database column available_balance SqlType(numeric), Default(None)
   *  @param accountMask Database column account_mask SqlType(varchar), Length(16,true), Default(None)
   *  @param displayName Database column display_name SqlType(text), Default(None)
   *  @param officialName Database column official_name SqlType(text), Default(None)
   *  @param subtype Database column subtype SqlType(text), Default(None)
   *  @param isExternalApiImport Database column is_external_api_import SqlType(bool), Default(None)
   *  @param lastApiSyncTime Database column last_api_sync_time SqlType(timestamptz), Default(None) */
  case class FinancialAccountRow(originalInsert: java.time.Instant, lastUpdate: java.time.Instant, appLastChangedBy: Int, id: Int, userId: Option[Int] = None, connectorId: Option[Int] = None, externalId: Option[String] = None, currentBalance: Option[scala.math.BigDecimal] = None, availableBalance: Option[scala.math.BigDecimal] = None, accountMask: Option[String] = None, displayName: Option[String] = None, officialName: Option[String] = None, subtype: Option[String] = None, isExternalApiImport: Option[Boolean] = None, lastApiSyncTime: Option[java.time.Instant] = None)
  /** GetResult implicit for fetching FinancialAccountRow objects using plain SQL queries */
  implicit def GetResultFinancialAccountRow(implicit e0: GR[java.time.Instant], e1: GR[Int], e2: GR[Option[Int]], e3: GR[Option[String]], e4: GR[Option[scala.math.BigDecimal]], e5: GR[Option[Boolean]], e6: GR[Option[java.time.Instant]]): GR[FinancialAccountRow] = GR{
    prs => import prs._
    (FinancialAccountRow.apply _).tupled((<<[java.time.Instant], <<[java.time.Instant], <<[Int], <<[Int], <<?[Int], <<?[Int], <<?[String], <<?[scala.math.BigDecimal], <<?[scala.math.BigDecimal], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Boolean], <<?[java.time.Instant]))
  }
  /** Table description of table financial_account. Objects of this class serve as prototypes for rows in queries. */
  class FinancialAccount(_tableTag: Tag) extends profile.api.Table[FinancialAccountRow](_tableTag, "financial_account") {
    def * = ((originalInsert, lastUpdate, appLastChangedBy, id, userId, connectorId, externalId, currentBalance, availableBalance, accountMask, displayName, officialName, subtype, isExternalApiImport, lastApiSyncTime)).mapTo[FinancialAccountRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(originalInsert), Rep.Some(lastUpdate), Rep.Some(appLastChangedBy), Rep.Some(id), userId, connectorId, externalId, currentBalance, availableBalance, accountMask, displayName, officialName, subtype, isExternalApiImport, lastApiSyncTime)).shaped.<>({r=>import r._; _1.map(_=> (FinancialAccountRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column original_insert SqlType(timestamptz) */
    val originalInsert: Rep[java.time.Instant] = column[java.time.Instant]("original_insert")
    /** Database column last_update SqlType(timestamptz) */
    val lastUpdate: Rep[java.time.Instant] = column[java.time.Instant]("last_update")
    /** Database column app_last_changed_by SqlType(int4) */
    val appLastChangedBy: Rep[Int] = column[Int]("app_last_changed_by")
    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column connector_id SqlType(int4), Default(None) */
    val connectorId: Rep[Option[Int]] = column[Option[Int]]("connector_id", O.Default(None))
    /** Database column external_id SqlType(text), Default(None) */
    val externalId: Rep[Option[String]] = column[Option[String]]("external_id", O.Default(None))
    /** Database column current_balance SqlType(numeric), Default(None) */
    val currentBalance: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("current_balance", O.Default(None))
    /** Database column available_balance SqlType(numeric), Default(None) */
    val availableBalance: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("available_balance", O.Default(None))
    /** Database column account_mask SqlType(varchar), Length(16,true), Default(None) */
    val accountMask: Rep[Option[String]] = column[Option[String]]("account_mask", O.Length(16,varying=true), O.Default(None))
    /** Database column display_name SqlType(text), Default(None) */
    val displayName: Rep[Option[String]] = column[Option[String]]("display_name", O.Default(None))
    /** Database column official_name SqlType(text), Default(None) */
    val officialName: Rep[Option[String]] = column[Option[String]]("official_name", O.Default(None))
    /** Database column subtype SqlType(text), Default(None) */
    val subtype: Rep[Option[String]] = column[Option[String]]("subtype", O.Default(None))
    /** Database column is_external_api_import SqlType(bool), Default(None) */
    val isExternalApiImport: Rep[Option[Boolean]] = column[Option[Boolean]]("is_external_api_import", O.Default(None))
    /** Database column last_api_sync_time SqlType(timestamptz), Default(None) */
    val lastApiSyncTime: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("last_api_sync_time", O.Default(None))

    /** Foreign key referencing AccountConnector (database name financial_account_connector_id_fkey) */
    lazy val accountConnectorFk = foreignKey("financial_account_connector_id_fkey", connectorId, AccountConnector)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.SetNull)
    /** Foreign key referencing AppUser (database name financial_account_user_id_fkey) */
    lazy val appUserFk = foreignKey("financial_account_user_id_fkey", userId, AppUser)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.SetNull)

    /** Index over (externalId) (database name fa_externalid) */
    val index1 = index("fa_externalid", externalId)
  }
  /** Collection-like TableQuery object for table FinancialAccount */
  lazy val FinancialAccount = new TableQuery(tag => new FinancialAccount(tag))

  /** Entity class storing rows of table FlywaySchemaHistory
   *  @param installedRank Database column installed_rank SqlType(int4), PrimaryKey
   *  @param version Database column version SqlType(varchar), Length(50,true), Default(None)
   *  @param description Database column description SqlType(varchar), Length(200,true)
   *  @param `type` Database column type SqlType(varchar), Length(20,true)
   *  @param script Database column script SqlType(varchar), Length(1000,true)
   *  @param checksum Database column checksum SqlType(int4), Default(None)
   *  @param installedBy Database column installed_by SqlType(varchar), Length(100,true)
   *  @param installedOn Database column installed_on SqlType(timestamp)
   *  @param executionTime Database column execution_time SqlType(int4)
   *  @param success Database column success SqlType(bool) */
  case class FlywaySchemaHistoryRow(installedRank: Int, version: Option[String] = None, description: String, `type`: String, script: String, checksum: Option[Int] = None, installedBy: String, installedOn: java.time.Instant, executionTime: Int, success: Boolean)
  /** GetResult implicit for fetching FlywaySchemaHistoryRow objects using plain SQL queries */
  implicit def GetResultFlywaySchemaHistoryRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[String], e3: GR[Option[Int]], e4: GR[java.time.Instant], e5: GR[Boolean]): GR[FlywaySchemaHistoryRow] = GR{
    prs => import prs._
    (FlywaySchemaHistoryRow.apply _).tupled((<<[Int], <<?[String], <<[String], <<[String], <<[String], <<?[Int], <<[String], <<[java.time.Instant], <<[Int], <<[Boolean]))
  }
  /** Table description of table flyway_schema_history. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class FlywaySchemaHistory(_tableTag: Tag) extends profile.api.Table[FlywaySchemaHistoryRow](_tableTag, "flyway_schema_history") {
    def * = ((installedRank, version, description, `type`, script, checksum, installedBy, installedOn, executionTime, success)).mapTo[FlywaySchemaHistoryRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(installedRank), version, Rep.Some(description), Rep.Some(`type`), Rep.Some(script), checksum, Rep.Some(installedBy), Rep.Some(installedOn), Rep.Some(executionTime), Rep.Some(success))).shaped.<>({r=>import r._; _1.map(_=> (FlywaySchemaHistoryRow.apply _).tupled((_1.get, _2, _3.get, _4.get, _5.get, _6, _7.get, _8.get, _9.get, _10.get)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column installed_rank SqlType(int4), PrimaryKey */
    val installedRank: Rep[Int] = column[Int]("installed_rank", O.PrimaryKey)
    /** Database column version SqlType(varchar), Length(50,true), Default(None) */
    val version: Rep[Option[String]] = column[Option[String]]("version", O.Length(50,varying=true), O.Default(None))
    /** Database column description SqlType(varchar), Length(200,true) */
    val description: Rep[String] = column[String]("description", O.Length(200,varying=true))
    /** Database column type SqlType(varchar), Length(20,true)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[String] = column[String]("type", O.Length(20,varying=true))
    /** Database column script SqlType(varchar), Length(1000,true) */
    val script: Rep[String] = column[String]("script", O.Length(1000,varying=true))
    /** Database column checksum SqlType(int4), Default(None) */
    val checksum: Rep[Option[Int]] = column[Option[Int]]("checksum", O.Default(None))
    /** Database column installed_by SqlType(varchar), Length(100,true) */
    val installedBy: Rep[String] = column[String]("installed_by", O.Length(100,varying=true))
    /** Database column installed_on SqlType(timestamp) */
    val installedOn: Rep[java.time.Instant] = column[java.time.Instant]("installed_on")
    /** Database column execution_time SqlType(int4) */
    val executionTime: Rep[Int] = column[Int]("execution_time")
    /** Database column success SqlType(bool) */
    val success: Rep[Boolean] = column[Boolean]("success")

    /** Index over (success) (database name flyway_schema_history_s_idx) */
    val index1 = index("flyway_schema_history_s_idx", success)
  }
  /** Collection-like TableQuery object for table FlywaySchemaHistory */
  lazy val FlywaySchemaHistory = new TableQuery(tag => new FlywaySchemaHistory(tag))

  /** Entity class storing rows of table RecurringTransaction
   *  @param originalInsert Database column original_insert SqlType(timestamptz)
   *  @param lastUpdate Database column last_update SqlType(timestamptz)
   *  @param appLastChangedBy Database column app_last_changed_by SqlType(int4)
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4)
   *  @param accountId Database column account_id SqlType(int4)
   *  @param externalId Database column external_id SqlType(text), Default(None)
   *  @param primaryDescription Database column primary_description SqlType(text), Default(None)
   *  @param detailedDescription Database column detailed_description SqlType(text), Default(None)
   *  @param categoryId Database column category_id SqlType(int4), Default(None)
   *  @param averageAmount Database column average_amount SqlType(numeric), Default(None)
   *  @param lastAmount Database column last_amount SqlType(numeric), Default(None)
   *  @param firstDate Database column first_date SqlType(timestamptz), Default(None)
   *  @param lastDate Database column last_date SqlType(timestamptz), Default(None)
   *  @param predictedNextDate Database column predicted_next_date SqlType(timestamptz), Default(None)
   *  @param frequency Database column frequency SqlType(varchar), Length(30,true), Default(None) */
  case class RecurringTransactionRow(originalInsert: java.time.Instant, lastUpdate: java.time.Instant, appLastChangedBy: Int, id: Int, userId: Int, accountId: Int, externalId: Option[String] = None, primaryDescription: Option[String] = None, detailedDescription: Option[String] = None, categoryId: Option[Int] = None, averageAmount: Option[scala.math.BigDecimal] = None, lastAmount: Option[scala.math.BigDecimal] = None, firstDate: Option[java.time.Instant] = None, lastDate: Option[java.time.Instant] = None, predictedNextDate: Option[java.time.Instant] = None, frequency: Option[String] = None)
  /** GetResult implicit for fetching RecurringTransactionRow objects using plain SQL queries */
  implicit def GetResultRecurringTransactionRow(implicit e0: GR[java.time.Instant], e1: GR[Int], e2: GR[Option[String]], e3: GR[Option[Int]], e4: GR[Option[scala.math.BigDecimal]], e5: GR[Option[java.time.Instant]]): GR[RecurringTransactionRow] = GR{
    prs => import prs._
    (RecurringTransactionRow.apply _).tupled((<<[java.time.Instant], <<[java.time.Instant], <<[Int], <<[Int], <<[Int], <<[Int], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[scala.math.BigDecimal], <<?[scala.math.BigDecimal], <<?[java.time.Instant], <<?[java.time.Instant], <<?[java.time.Instant], <<?[String]))
  }
  /** Table description of table recurring_transaction. Objects of this class serve as prototypes for rows in queries. */
  class RecurringTransaction(_tableTag: Tag) extends profile.api.Table[RecurringTransactionRow](_tableTag, "recurring_transaction") {
    def * = ((originalInsert, lastUpdate, appLastChangedBy, id, userId, accountId, externalId, primaryDescription, detailedDescription, categoryId, averageAmount, lastAmount, firstDate, lastDate, predictedNextDate, frequency)).mapTo[RecurringTransactionRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(originalInsert), Rep.Some(lastUpdate), Rep.Some(appLastChangedBy), Rep.Some(id), Rep.Some(userId), Rep.Some(accountId), externalId, primaryDescription, detailedDescription, categoryId, averageAmount, lastAmount, firstDate, lastDate, predictedNextDate, frequency)).shaped.<>({r=>import r._; _1.map(_=> (RecurringTransactionRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column original_insert SqlType(timestamptz) */
    val originalInsert: Rep[java.time.Instant] = column[java.time.Instant]("original_insert")
    /** Database column last_update SqlType(timestamptz) */
    val lastUpdate: Rep[java.time.Instant] = column[java.time.Instant]("last_update")
    /** Database column app_last_changed_by SqlType(int4) */
    val appLastChangedBy: Rep[Int] = column[Int]("app_last_changed_by")
    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column account_id SqlType(int4) */
    val accountId: Rep[Int] = column[Int]("account_id")
    /** Database column external_id SqlType(text), Default(None) */
    val externalId: Rep[Option[String]] = column[Option[String]]("external_id", O.Default(None))
    /** Database column primary_description SqlType(text), Default(None) */
    val primaryDescription: Rep[Option[String]] = column[Option[String]]("primary_description", O.Default(None))
    /** Database column detailed_description SqlType(text), Default(None) */
    val detailedDescription: Rep[Option[String]] = column[Option[String]]("detailed_description", O.Default(None))
    /** Database column category_id SqlType(int4), Default(None) */
    val categoryId: Rep[Option[Int]] = column[Option[Int]]("category_id", O.Default(None))
    /** Database column average_amount SqlType(numeric), Default(None) */
    val averageAmount: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("average_amount", O.Default(None))
    /** Database column last_amount SqlType(numeric), Default(None) */
    val lastAmount: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("last_amount", O.Default(None))
    /** Database column first_date SqlType(timestamptz), Default(None) */
    val firstDate: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("first_date", O.Default(None))
    /** Database column last_date SqlType(timestamptz), Default(None) */
    val lastDate: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("last_date", O.Default(None))
    /** Database column predicted_next_date SqlType(timestamptz), Default(None) */
    val predictedNextDate: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("predicted_next_date", O.Default(None))
    /** Database column frequency SqlType(varchar), Length(30,true), Default(None) */
    val frequency: Rep[Option[String]] = column[Option[String]]("frequency", O.Length(30,varying=true), O.Default(None))

    /** Foreign key referencing AppUser (database name recurring_transaction_user_id_fkey) */
    lazy val appUserFk = foreignKey("recurring_transaction_user_id_fkey", userId, AppUser)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.SetNull)
    /** Foreign key referencing FinancialAccount (database name recurring_transaction_account_id_fkey) */
    lazy val financialAccountFk = foreignKey("recurring_transaction_account_id_fkey", accountId, FinancialAccount)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing UserTransactionCategory (database name recurring_transaction_category_id_fkey) */
    lazy val userTransactionCategoryFk = foreignKey("recurring_transaction_category_id_fkey", categoryId, UserTransactionCategory)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)

    /** Index over (externalId) (database name recurring_transaction_external_id) */
    val index1 = index("recurring_transaction_external_id", externalId)
  }
  /** Collection-like TableQuery object for table RecurringTransaction */
  lazy val RecurringTransaction = new TableQuery(tag => new RecurringTransaction(tag))

  /** Entity class storing rows of table Token
   *  @param originalInsert Database column original_insert SqlType(timestamptz)
   *  @param lastUpdate Database column last_update SqlType(timestamptz)
   *  @param appLastChangedBy Database column app_last_changed_by SqlType(int4)
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param token Database column token SqlType(varchar), Default(None)
   *  @param tokenType Database column token_type SqlType(varchar), Length(20,true), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamptz), Default(None)
   *  @param expiresAt Database column expires_at SqlType(timestamptz), Default(None) */
  case class TokenRow(originalInsert: java.time.Instant, lastUpdate: java.time.Instant, appLastChangedBy: Int, id: Int, userId: Option[Int] = None, token: Option[String] = None, tokenType: Option[String] = None, createdAt: Option[java.time.Instant] = None, expiresAt: Option[java.time.Instant] = None)
  /** GetResult implicit for fetching TokenRow objects using plain SQL queries */
  implicit def GetResultTokenRow(implicit e0: GR[java.time.Instant], e1: GR[Int], e2: GR[Option[Int]], e3: GR[Option[String]], e4: GR[Option[java.time.Instant]]): GR[TokenRow] = GR{
    prs => import prs._
    (TokenRow.apply _).tupled((<<[java.time.Instant], <<[java.time.Instant], <<[Int], <<[Int], <<?[Int], <<?[String], <<?[String], <<?[java.time.Instant], <<?[java.time.Instant]))
  }
  /** Table description of table token. Objects of this class serve as prototypes for rows in queries. */
  class Token(_tableTag: Tag) extends profile.api.Table[TokenRow](_tableTag, "token") {
    def * = ((originalInsert, lastUpdate, appLastChangedBy, id, userId, token, tokenType, createdAt, expiresAt)).mapTo[TokenRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(originalInsert), Rep.Some(lastUpdate), Rep.Some(appLastChangedBy), Rep.Some(id), userId, token, tokenType, createdAt, expiresAt)).shaped.<>({r=>import r._; _1.map(_=> (TokenRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7, _8, _9)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column original_insert SqlType(timestamptz) */
    val originalInsert: Rep[java.time.Instant] = column[java.time.Instant]("original_insert")
    /** Database column last_update SqlType(timestamptz) */
    val lastUpdate: Rep[java.time.Instant] = column[java.time.Instant]("last_update")
    /** Database column app_last_changed_by SqlType(int4) */
    val appLastChangedBy: Rep[Int] = column[Int]("app_last_changed_by")
    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column token SqlType(varchar), Default(None) */
    val token: Rep[Option[String]] = column[Option[String]]("token", O.Default(None))
    /** Database column token_type SqlType(varchar), Length(20,true), Default(None) */
    val tokenType: Rep[Option[String]] = column[Option[String]]("token_type", O.Length(20,varying=true), O.Default(None))
    /** Database column created_at SqlType(timestamptz), Default(None) */
    val createdAt: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("created_at", O.Default(None))
    /** Database column expires_at SqlType(timestamptz), Default(None) */
    val expiresAt: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("expires_at", O.Default(None))

    /** Foreign key referencing AppUser (database name token_user_id_fkey) */
    lazy val appUserFk = foreignKey("token_user_id_fkey", userId, AppUser)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.SetNull)

    /** Index over (token) (database name token_indx) */
    val index1 = index("token_indx", token)
  }
  /** Collection-like TableQuery object for table Token */
  lazy val Token = new TableQuery(tag => new Token(tag))

  /** Entity class storing rows of table Transaction
   *  @param originalInsert Database column original_insert SqlType(timestamptz)
   *  @param lastUpdate Database column last_update SqlType(timestamptz)
   *  @param appLastChangedBy Database column app_last_changed_by SqlType(int4)
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4)
   *  @param amount Database column amount SqlType(numeric)
   *  @param transactionDate Database column transaction_date SqlType(timestamptz)
   *  @param importedDate Database column imported_date SqlType(timestamptz), Default(None)
   *  @param pending Database column pending SqlType(bool), Default(None)
   *  @param accountId Database column account_id SqlType(int4)
   *  @param merchantName Database column merchant_name SqlType(varchar), Length(100,true), Default(None)
   *  @param transactionName Database column transaction_name SqlType(varchar), Length(100,true), Default(None)
   *  @param externalTransactionId Database column external_transaction_id SqlType(varchar), Length(100,true), Default(None)
   *  @param merchantLogoUrl Database column merchant_logo_url SqlType(varchar), Length(200,true), Default(None)
   *  @param recurringTransactionId Database column recurring_transaction_id SqlType(int4), Default(None) */
  case class TransactionRow(originalInsert: java.time.Instant, lastUpdate: java.time.Instant, appLastChangedBy: Int, id: Int, userId: Int, amount: scala.math.BigDecimal, transactionDate: java.time.Instant, importedDate: Option[java.time.Instant] = None, pending: Option[Boolean] = None, accountId: Int, merchantName: Option[String] = None, transactionName: Option[String] = None, externalTransactionId: Option[String] = None, merchantLogoUrl: Option[String] = None, recurringTransactionId: Option[Int] = None)
  /** GetResult implicit for fetching TransactionRow objects using plain SQL queries */
  implicit def GetResultTransactionRow(implicit e0: GR[java.time.Instant], e1: GR[Int], e2: GR[scala.math.BigDecimal], e3: GR[Option[java.time.Instant]], e4: GR[Option[Boolean]], e5: GR[Option[String]], e6: GR[Option[Int]]): GR[TransactionRow] = GR{
    prs => import prs._
    (TransactionRow.apply _).tupled((<<[java.time.Instant], <<[java.time.Instant], <<[Int], <<[Int], <<[Int], <<[scala.math.BigDecimal], <<[java.time.Instant], <<?[java.time.Instant], <<?[Boolean], <<[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table transaction. Objects of this class serve as prototypes for rows in queries. */
  class Transaction(_tableTag: Tag) extends profile.api.Table[TransactionRow](_tableTag, "transaction") {
    def * = ((originalInsert, lastUpdate, appLastChangedBy, id, userId, amount, transactionDate, importedDate, pending, accountId, merchantName, transactionName, externalTransactionId, merchantLogoUrl, recurringTransactionId)).mapTo[TransactionRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(originalInsert), Rep.Some(lastUpdate), Rep.Some(appLastChangedBy), Rep.Some(id), Rep.Some(userId), Rep.Some(amount), Rep.Some(transactionDate), importedDate, pending, Rep.Some(accountId), merchantName, transactionName, externalTransactionId, merchantLogoUrl, recurringTransactionId)).shaped.<>({r=>import r._; _1.map(_=> (TransactionRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8, _9, _10.get, _11, _12, _13, _14, _15)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column original_insert SqlType(timestamptz) */
    val originalInsert: Rep[java.time.Instant] = column[java.time.Instant]("original_insert")
    /** Database column last_update SqlType(timestamptz) */
    val lastUpdate: Rep[java.time.Instant] = column[java.time.Instant]("last_update")
    /** Database column app_last_changed_by SqlType(int4) */
    val appLastChangedBy: Rep[Int] = column[Int]("app_last_changed_by")
    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column amount SqlType(numeric) */
    val amount: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("amount")
    /** Database column transaction_date SqlType(timestamptz) */
    val transactionDate: Rep[java.time.Instant] = column[java.time.Instant]("transaction_date")
    /** Database column imported_date SqlType(timestamptz), Default(None) */
    val importedDate: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("imported_date", O.Default(None))
    /** Database column pending SqlType(bool), Default(None) */
    val pending: Rep[Option[Boolean]] = column[Option[Boolean]]("pending", O.Default(None))
    /** Database column account_id SqlType(int4) */
    val accountId: Rep[Int] = column[Int]("account_id")
    /** Database column merchant_name SqlType(varchar), Length(100,true), Default(None) */
    val merchantName: Rep[Option[String]] = column[Option[String]]("merchant_name", O.Length(100,varying=true), O.Default(None))
    /** Database column transaction_name SqlType(varchar), Length(100,true), Default(None) */
    val transactionName: Rep[Option[String]] = column[Option[String]]("transaction_name", O.Length(100,varying=true), O.Default(None))
    /** Database column external_transaction_id SqlType(varchar), Length(100,true), Default(None) */
    val externalTransactionId: Rep[Option[String]] = column[Option[String]]("external_transaction_id", O.Length(100,varying=true), O.Default(None))
    /** Database column merchant_logo_url SqlType(varchar), Length(200,true), Default(None) */
    val merchantLogoUrl: Rep[Option[String]] = column[Option[String]]("merchant_logo_url", O.Length(200,varying=true), O.Default(None))
    /** Database column recurring_transaction_id SqlType(int4), Default(None) */
    val recurringTransactionId: Rep[Option[Int]] = column[Option[Int]]("recurring_transaction_id", O.Default(None))

    /** Foreign key referencing AppUser (database name transaction_user_id_fkey) */
    lazy val appUserFk = foreignKey("transaction_user_id_fkey", userId, AppUser)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.SetNull)
    /** Foreign key referencing FinancialAccount (database name transaction_account_id_fkey) */
    lazy val financialAccountFk = foreignKey("transaction_account_id_fkey", accountId, FinancialAccount)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing RecurringTransaction (database name transaction_recurring_transaction_id_fkey) */
    lazy val recurringTransactionFk = foreignKey("transaction_recurring_transaction_id_fkey", recurringTransactionId, RecurringTransaction)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)

    /** Index over (transactionDate) (database name transaction_transaction_date) */
    val index1 = index("transaction_transaction_date", transactionDate)
  }
  /** Collection-like TableQuery object for table Transaction */
  lazy val Transaction = new TableQuery(tag => new Transaction(tag))

  /** Entity class storing rows of table TransactionLineItem
   *  @param originalInsert Database column original_insert SqlType(timestamptz)
   *  @param lastUpdate Database column last_update SqlType(timestamptz)
   *  @param appLastChangedBy Database column app_last_changed_by SqlType(int4)
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param transactionId Database column transaction_id SqlType(int4)
   *  @param description Database column description SqlType(varchar), Default(None)
   *  @param amount Database column amount SqlType(numeric)
   *  @param categoryId Database column category_id SqlType(int4), Default(None) */
  case class TransactionLineItemRow(originalInsert: java.time.Instant, lastUpdate: java.time.Instant, appLastChangedBy: Int, id: Int, transactionId: Int, description: Option[String] = None, amount: scala.math.BigDecimal, categoryId: Option[Int] = None)
  /** GetResult implicit for fetching TransactionLineItemRow objects using plain SQL queries */
  implicit def GetResultTransactionLineItemRow(implicit e0: GR[java.time.Instant], e1: GR[Int], e2: GR[Option[String]], e3: GR[scala.math.BigDecimal], e4: GR[Option[Int]]): GR[TransactionLineItemRow] = GR{
    prs => import prs._
    (TransactionLineItemRow.apply _).tupled((<<[java.time.Instant], <<[java.time.Instant], <<[Int], <<[Int], <<[Int], <<?[String], <<[scala.math.BigDecimal], <<?[Int]))
  }
  /** Table description of table transaction_line_item. Objects of this class serve as prototypes for rows in queries. */
  class TransactionLineItem(_tableTag: Tag) extends profile.api.Table[TransactionLineItemRow](_tableTag, "transaction_line_item") {
    def * = ((originalInsert, lastUpdate, appLastChangedBy, id, transactionId, description, amount, categoryId)).mapTo[TransactionLineItemRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(originalInsert), Rep.Some(lastUpdate), Rep.Some(appLastChangedBy), Rep.Some(id), Rep.Some(transactionId), description, Rep.Some(amount), categoryId)).shaped.<>({r=>import r._; _1.map(_=> (TransactionLineItemRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6, _7.get, _8)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column original_insert SqlType(timestamptz) */
    val originalInsert: Rep[java.time.Instant] = column[java.time.Instant]("original_insert")
    /** Database column last_update SqlType(timestamptz) */
    val lastUpdate: Rep[java.time.Instant] = column[java.time.Instant]("last_update")
    /** Database column app_last_changed_by SqlType(int4) */
    val appLastChangedBy: Rep[Int] = column[Int]("app_last_changed_by")
    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column transaction_id SqlType(int4) */
    val transactionId: Rep[Int] = column[Int]("transaction_id")
    /** Database column description SqlType(varchar), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column amount SqlType(numeric) */
    val amount: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("amount")
    /** Database column category_id SqlType(int4), Default(None) */
    val categoryId: Rep[Option[Int]] = column[Option[Int]]("category_id", O.Default(None))

    /** Foreign key referencing Transaction (database name transaction_line_item_transaction_id_fkey) */
    lazy val transactionFk = foreignKey("transaction_line_item_transaction_id_fkey", transactionId, Transaction)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing UserTransactionCategory (database name transaction_line_item_category_id_fkey) */
    lazy val userTransactionCategoryFk = foreignKey("transaction_line_item_category_id_fkey", categoryId, UserTransactionCategory)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.SetNull)
  }
  /** Collection-like TableQuery object for table TransactionLineItem */
  lazy val TransactionLineItem = new TableQuery(tag => new TransactionLineItem(tag))

  /** Entity class storing rows of table UserAccount
   *  @param originalInsert Database column original_insert SqlType(timestamptz)
   *  @param lastUpdate Database column last_update SqlType(timestamptz)
   *  @param appLastChangedBy Database column app_last_changed_by SqlType(int4)
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param createdOn Database column created_on SqlType(timestamptz), Default(None)
   *  @param accountName Database column account_name SqlType(varchar), Length(20,true), Default(None) */
  case class UserAccountRow(originalInsert: java.time.Instant, lastUpdate: java.time.Instant, appLastChangedBy: Int, id: Int, createdOn: Option[java.time.Instant] = None, accountName: Option[String] = None)
  /** GetResult implicit for fetching UserAccountRow objects using plain SQL queries */
  implicit def GetResultUserAccountRow(implicit e0: GR[java.time.Instant], e1: GR[Int], e2: GR[Option[java.time.Instant]], e3: GR[Option[String]]): GR[UserAccountRow] = GR{
    prs => import prs._
    (UserAccountRow.apply _).tupled((<<[java.time.Instant], <<[java.time.Instant], <<[Int], <<[Int], <<?[java.time.Instant], <<?[String]))
  }
  /** Table description of table user_account. Objects of this class serve as prototypes for rows in queries. */
  class UserAccount(_tableTag: Tag) extends profile.api.Table[UserAccountRow](_tableTag, "user_account") {
    def * = ((originalInsert, lastUpdate, appLastChangedBy, id, createdOn, accountName)).mapTo[UserAccountRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(originalInsert), Rep.Some(lastUpdate), Rep.Some(appLastChangedBy), Rep.Some(id), createdOn, accountName)).shaped.<>({r=>import r._; _1.map(_=> (UserAccountRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5, _6)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column original_insert SqlType(timestamptz) */
    val originalInsert: Rep[java.time.Instant] = column[java.time.Instant]("original_insert")
    /** Database column last_update SqlType(timestamptz) */
    val lastUpdate: Rep[java.time.Instant] = column[java.time.Instant]("last_update")
    /** Database column app_last_changed_by SqlType(int4) */
    val appLastChangedBy: Rep[Int] = column[Int]("app_last_changed_by")
    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column created_on SqlType(timestamptz), Default(None) */
    val createdOn: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("created_on", O.Default(None))
    /** Database column account_name SqlType(varchar), Length(20,true), Default(None) */
    val accountName: Rep[Option[String]] = column[Option[String]]("account_name", O.Length(20,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table UserAccount */
  lazy val UserAccount = new TableQuery(tag => new UserAccount(tag))

  /** Entity class storing rows of table UserMailbox
   *  @param originalInsert Database column original_insert SqlType(timestamptz)
   *  @param lastUpdate Database column last_update SqlType(timestamptz)
   *  @param appLastChangedBy Database column app_last_changed_by SqlType(int4)
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param messageKey Database column message_key SqlType(varchar), Length(100,true)
   *  @param userId Database column user_id SqlType(int4)
   *  @param hasSeen Database column has_seen SqlType(bool)
   *  @param messageBody Database column message_body SqlType(text)
   *  @param actionType Database column action_type SqlType(varchar), Length(20,true)
   *  @param subject Database column subject SqlType(varchar), Length(100,true) */
  case class UserMailboxRow(originalInsert: java.time.Instant, lastUpdate: java.time.Instant, appLastChangedBy: Int, id: Int, messageKey: String, userId: Int, hasSeen: Boolean, messageBody: String, actionType: String, subject: String)
  /** GetResult implicit for fetching UserMailboxRow objects using plain SQL queries */
  implicit def GetResultUserMailboxRow(implicit e0: GR[java.time.Instant], e1: GR[Int], e2: GR[String], e3: GR[Boolean]): GR[UserMailboxRow] = GR{
    prs => import prs._
    (UserMailboxRow.apply _).tupled((<<[java.time.Instant], <<[java.time.Instant], <<[Int], <<[Int], <<[String], <<[Int], <<[Boolean], <<[String], <<[String], <<[String]))
  }
  /** Table description of table user_mailbox. Objects of this class serve as prototypes for rows in queries. */
  class UserMailbox(_tableTag: Tag) extends profile.api.Table[UserMailboxRow](_tableTag, "user_mailbox") {
    def * = ((originalInsert, lastUpdate, appLastChangedBy, id, messageKey, userId, hasSeen, messageBody, actionType, subject)).mapTo[UserMailboxRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(originalInsert), Rep.Some(lastUpdate), Rep.Some(appLastChangedBy), Rep.Some(id), Rep.Some(messageKey), Rep.Some(userId), Rep.Some(hasSeen), Rep.Some(messageBody), Rep.Some(actionType), Rep.Some(subject))).shaped.<>({r=>import r._; _1.map(_=> (UserMailboxRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column original_insert SqlType(timestamptz) */
    val originalInsert: Rep[java.time.Instant] = column[java.time.Instant]("original_insert")
    /** Database column last_update SqlType(timestamptz) */
    val lastUpdate: Rep[java.time.Instant] = column[java.time.Instant]("last_update")
    /** Database column app_last_changed_by SqlType(int4) */
    val appLastChangedBy: Rep[Int] = column[Int]("app_last_changed_by")
    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column message_key SqlType(varchar), Length(100,true) */
    val messageKey: Rep[String] = column[String]("message_key", O.Length(100,varying=true))
    /** Database column user_id SqlType(int4) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column has_seen SqlType(bool) */
    val hasSeen: Rep[Boolean] = column[Boolean]("has_seen")
    /** Database column message_body SqlType(text) */
    val messageBody: Rep[String] = column[String]("message_body")
    /** Database column action_type SqlType(varchar), Length(20,true) */
    val actionType: Rep[String] = column[String]("action_type", O.Length(20,varying=true))
    /** Database column subject SqlType(varchar), Length(100,true) */
    val subject: Rep[String] = column[String]("subject", O.Length(100,varying=true))

    /** Foreign key referencing AppUser (database name user_mailbox_user_id_fkey) */
    lazy val appUserFk = foreignKey("user_mailbox_user_id_fkey", userId, AppUser)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.SetNull)

    /** Index over (messageKey) (database name idx_user_mailbox_message_key) */
    val index1 = index("idx_user_mailbox_message_key", messageKey)
  }
  /** Collection-like TableQuery object for table UserMailbox */
  lazy val UserMailbox = new TableQuery(tag => new UserMailbox(tag))

  /** Entity class storing rows of table UserSession
   *  @param originalInsert Database column original_insert SqlType(timestamptz)
   *  @param lastUpdate Database column last_update SqlType(timestamptz)
   *  @param appLastChangedBy Database column app_last_changed_by SqlType(int4)
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param issuedAt Database column issued_at SqlType(timestamptz), Default(None)
   *  @param expiresAt Database column expires_at SqlType(timestamptz), Default(None) */
  case class UserSessionRow(originalInsert: java.time.Instant, lastUpdate: java.time.Instant, appLastChangedBy: Int, id: java.util.UUID, userId: Option[Int] = None, issuedAt: Option[java.time.Instant] = None, expiresAt: Option[java.time.Instant] = None)
  /** GetResult implicit for fetching UserSessionRow objects using plain SQL queries */
  implicit def GetResultUserSessionRow(implicit e0: GR[java.time.Instant], e1: GR[Int], e2: GR[java.util.UUID], e3: GR[Option[Int]], e4: GR[Option[java.time.Instant]]): GR[UserSessionRow] = GR{
    prs => import prs._
    (UserSessionRow.apply _).tupled((<<[java.time.Instant], <<[java.time.Instant], <<[Int], <<[java.util.UUID], <<?[Int], <<?[java.time.Instant], <<?[java.time.Instant]))
  }
  /** Table description of table user_session. Objects of this class serve as prototypes for rows in queries. */
  class UserSession(_tableTag: Tag) extends profile.api.Table[UserSessionRow](_tableTag, "user_session") {
    def * = ((originalInsert, lastUpdate, appLastChangedBy, id, userId, issuedAt, expiresAt)).mapTo[UserSessionRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(originalInsert), Rep.Some(lastUpdate), Rep.Some(appLastChangedBy), Rep.Some(id), userId, issuedAt, expiresAt)).shaped.<>({r=>import r._; _1.map(_=> (UserSessionRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column original_insert SqlType(timestamptz) */
    val originalInsert: Rep[java.time.Instant] = column[java.time.Instant]("original_insert")
    /** Database column last_update SqlType(timestamptz) */
    val lastUpdate: Rep[java.time.Instant] = column[java.time.Instant]("last_update")
    /** Database column app_last_changed_by SqlType(int4) */
    val appLastChangedBy: Rep[Int] = column[Int]("app_last_changed_by")
    /** Database column id SqlType(uuid), PrimaryKey */
    val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column issued_at SqlType(timestamptz), Default(None) */
    val issuedAt: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("issued_at", O.Default(None))
    /** Database column expires_at SqlType(timestamptz), Default(None) */
    val expiresAt: Rep[Option[java.time.Instant]] = column[Option[java.time.Instant]]("expires_at", O.Default(None))

    /** Foreign key referencing AppUser (database name user_session_user_id_fkey) */
    lazy val appUserFk = foreignKey("user_session_user_id_fkey", userId, AppUser)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.SetNull)
  }
  /** Collection-like TableQuery object for table UserSession */
  lazy val UserSession = new TableQuery(tag => new UserSession(tag))

  /** Entity class storing rows of table UserTransactionCategory
   *  @param originalInsert Database column original_insert SqlType(timestamptz)
   *  @param lastUpdate Database column last_update SqlType(timestamptz)
   *  @param appLastChangedBy Database column app_last_changed_by SqlType(int4)
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4)
   *  @param categoryName Database column category_name SqlType(varchar), Length(50,true) */
  case class UserTransactionCategoryRow(originalInsert: java.time.Instant, lastUpdate: java.time.Instant, appLastChangedBy: Int, id: Int, userId: Int, categoryName: String)
  /** GetResult implicit for fetching UserTransactionCategoryRow objects using plain SQL queries */
  implicit def GetResultUserTransactionCategoryRow(implicit e0: GR[java.time.Instant], e1: GR[Int], e2: GR[String]): GR[UserTransactionCategoryRow] = GR{
    prs => import prs._
    (UserTransactionCategoryRow.apply _).tupled((<<[java.time.Instant], <<[java.time.Instant], <<[Int], <<[Int], <<[Int], <<[String]))
  }
  /** Table description of table user_transaction_category. Objects of this class serve as prototypes for rows in queries. */
  class UserTransactionCategory(_tableTag: Tag) extends profile.api.Table[UserTransactionCategoryRow](_tableTag, "user_transaction_category") {
    def * = ((originalInsert, lastUpdate, appLastChangedBy, id, userId, categoryName)).mapTo[UserTransactionCategoryRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(originalInsert), Rep.Some(lastUpdate), Rep.Some(appLastChangedBy), Rep.Some(id), Rep.Some(userId), Rep.Some(categoryName))).shaped.<>({r=>import r._; _1.map(_=> (UserTransactionCategoryRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column original_insert SqlType(timestamptz) */
    val originalInsert: Rep[java.time.Instant] = column[java.time.Instant]("original_insert")
    /** Database column last_update SqlType(timestamptz) */
    val lastUpdate: Rep[java.time.Instant] = column[java.time.Instant]("last_update")
    /** Database column app_last_changed_by SqlType(int4) */
    val appLastChangedBy: Rep[Int] = column[Int]("app_last_changed_by")
    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column category_name SqlType(varchar), Length(50,true) */
    val categoryName: Rep[String] = column[String]("category_name", O.Length(50,varying=true))

    /** Foreign key referencing AppUser (database name user_transaction_category_user_id_fkey) */
    lazy val appUserFk = foreignKey("user_transaction_category_user_id_fkey", userId, AppUser)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table UserTransactionCategory */
  lazy val UserTransactionCategory = new TableQuery(tag => new UserTransactionCategory(tag))
}
