package br.com.dv.mzcronn.youthexchange

import com.azure.data.tables.TableClient
import com.azure.data.tables.TableClientBuilder
import com.azure.data.tables.models.TableEntity
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class AzureTableService(
    @Value("\${azure.storage.account-name}") private val accountName: String,
    @Value("\${azure.storage.account-key}") private val accountKey: String,
    @Value("\${azure.storage.table-name}") private val tableName: String
) {
    private val tableClient: TableClient = TableClientBuilder()
        .connectionString("DefaultEndpointsProtocol=https;AccountName=$accountName;AccountKey=$accountKey;EndpointSuffix=core.windows.net")
        .tableName(tableName)
        .buildClient()

    private val defaultAge = 16

    fun insertOrUpdateEntity(data: YouthExchange): TableEntity {
        val partitionKey = data.partitionKey
        val rowKey = data.rowKey

        val entity = TableEntity(partitionKey, rowKey)
            .addProperty("playerName", data.name)
            .addProperty("age", defaultAge)
            .addProperty("nationality", data.country)
            .addProperty("hp", data.hp)
            .addProperty("firstHpSkill", data.firstHpSkill)
            .addProperty("secondHpSkill", data.secondHpSkill)
            .addProperty("lp", data.lp)
            .addProperty("firstLpSkill", data.firstLpSkill)
            .addProperty("secondLpSkill", data.secondLpSkill)
            .addProperty("trainingSpeed", data.trainingSpeed)
            .addProperty("totalSkillBalls", data.totalBalls)
            .addProperty("owner", data.owner)

        data.stats.forEach { (skill, value) ->
            entity.addProperty(skill, value)
        }

        tableClient.upsertEntity(entity)
        return entity
    }
}
