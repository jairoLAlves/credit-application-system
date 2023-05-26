package th4mz0.credit.application.system.exception

data class BusinessException(override val message: String?) : RuntimeException (message) {

}
