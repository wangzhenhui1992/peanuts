package com.soaringroad.api;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soaringroad.api.validator.ApiValidator;
import com.soaringroad.common.entity.Entity;
import com.soaringroad.common.query.Query;
import com.soaringroad.common.util.HttpUtils;
/**
 * <pre>
 * Base API class
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/27
 */
public abstract class AbstractBaseApi<T extends Entity, E extends Serializable>
        implements BrowseApi<T, E>, ManageApi<T, E> {

    @Autowired(required = false)
    private ApiValidator<T, E> validator;
    private boolean canGet = true;
    private boolean canPost = true;
    private boolean canPut = true;
    private boolean canDelete = true;
    private boolean canSearch = true;

    @Override
    @RequestMapping(value = { "/{id:^\\d+$}",
            "/{id:^\\d+$}/" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> get(@PathVariable E id) {
        if (!canGet) {
            return HttpUtils.methodNotAllowed();
        }
        if (!validateGet(id)) {
            return HttpUtils.badRequest();
        }
        T entity = doGet(id);
        return HttpUtils.parseToGetResponse(entity);
    }

    @Override
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> post(@RequestBody T entity) {
        if (!canPost) {
            return HttpUtils.methodNotAllowed();
        }
        if (!validatePost(entity)) {
            return HttpUtils.badRequest();
        }
        T entityCreated = doPost(entity);
        return HttpUtils.parseToPostResponse(entityCreated);
    }

    @Override
    @RequestMapping(value = { "/{id:^\\d+$}",
            "/{id:^\\d+$}/" }, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> put(@RequestBody T entity) {
        if (!canPut) {
            return HttpUtils.methodNotAllowed();
        }
        if (!validatePut(entity)) {
            return HttpUtils.badRequest();
        }
        // TODO Get by Id and return NotFound when not found
        T entityUpdated = doPut(entity);
        return HttpUtils.parseToPutResponse(entityUpdated);
    }

    @Override
    @RequestMapping(value = { "/{id:^\\d+$}",
            "/{id:^\\d+$}/" }, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> delete(@PathVariable E id) {
        if (!canDelete) {
            return HttpUtils.methodNotAllowed();
        }
        if (!validateDelete(id)) {
            return HttpUtils.badRequest();
        }
        // TODO Get by Id and return NotFound when not found
        T entity = doDelete(id);
        return HttpUtils.parseToDeleteResponse(entity);
    }

    @Override
    @RequestMapping(value = { "/search",
            "/search/" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<T>> search(Query query) {
        if (!canSearch) {
            return HttpUtils.methodNotAllowed();
        }
        if (!validateSearch(query)) {
            return HttpUtils.badRequest();
        }
        List<T> entity = doSearch(query);
        return HttpUtils.parseToSearchResponse(entity);
    }

    public final void denyGet() {
        canGet = false;
    }

    public final void denyPost() {
        canPost = false;
    }

    public final void denyPut() {
        canPut = false;
    }

    public final void denyDelete() {
        canDelete = false;
    }

    public final void denySearch() {
        canSearch = false;
    }

    protected abstract T doGet(E id);

    protected abstract T doPost(T entity);

    protected abstract T doPut(T entity);

    protected abstract T doDelete(E id);

    protected abstract List<T> doSearch(Query query);

    private boolean validateGet(E id) {
        if (this.validator != null) {
            return this.validator.validateGet(id);
        }
        return true;
    }

    private boolean validatePost(T entity) {
        if (this.validator != null) {
            return this.validator.validatePost(entity);
        }
        return true;
    }

    private boolean validatePut(T entity) {
        if (this.validator != null) {
            return this.validator.validatePut(entity);
        }
        return true;
    }

    private boolean validateDelete(E id) {
        if (this.validator != null) {
            return this.validator.validateDelete(id);
        }
        return true;
    }
    
    private boolean validateSearch(Query query) {
        if (this.validator != null) {
            return this.validator.validateSearch(query);
        }
        return true;
    }
}
