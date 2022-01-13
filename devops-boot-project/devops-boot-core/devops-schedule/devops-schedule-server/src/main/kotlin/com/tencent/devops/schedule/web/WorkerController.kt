package com.tencent.devops.schedule.web

import com.tencent.devops.api.pojo.Response
import com.tencent.devops.schedule.constants.SERVER_API_V1
import com.tencent.devops.schedule.constants.SERVER_BASE_PATH
import com.tencent.devops.schedule.manager.WorkerManager
import com.tencent.devops.schedule.pojo.page.Page
import com.tencent.devops.schedule.pojo.worker.WorkerGroup
import com.tencent.devops.schedule.pojo.worker.WorkerGroupCreateRequest
import com.tencent.devops.schedule.pojo.worker.WorkerGroupName
import com.tencent.devops.schedule.pojo.worker.WorkerGroupQueryParam
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("$SERVER_BASE_PATH$SERVER_API_V1")
class WorkerController(
    private val workerManager: WorkerManager
) {
    @PostMapping("/worker/group/create")
    fun create(@RequestBody request: WorkerGroupCreateRequest): Response<String> {
        return Response.success(workerManager.createGroup(request))
    }

    @GetMapping("/worker/group/list")
    fun page(param: WorkerGroupQueryParam): Response<Page<WorkerGroup>> {
        val page = workerManager.listGroupPage(param)
        return Response.success(page)
    }

    @GetMapping("/worker/group/names")
    fun listNames(): Response<List<WorkerGroupName>> {
        return Response.success(workerManager.listGroupName())
    }

    @DeleteMapping("/worker/group/delete")
    fun deleteGroup(@RequestParam id: String): Response<Void> {
        workerManager.deleteWorkerGroup(id)
        return Response.success()
    }
}
